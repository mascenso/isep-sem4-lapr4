package shareboardHttpServer;



import com.google.gson.Gson;
import eCourse.domain.ECoursePasswordPolicy;
import eCourse.domain.Notification;
import eCourse.domain.SharedBoard;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static eapli.framework.infrastructure.authz.application.AuthzRegistry.authenticationService;



public final class SBPServer  {
    private ServerSocket serverSocket;
    private Map<String, String> userCredentials = new HashMap<>();

    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static Socket socket;

    private AuthenticationService authenticationService = authenticationService();
    public static void main(String[] args) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new ECoursePasswordPolicy(),
                new PlainTextEncoder());

        if (args.length != 1) {
            System.out.println("Port number is required as an argument");
            System.exit(1);
        }

        try {
            int port = Integer.parseInt(args[0]);
            SBPServer server = new SBPServer();
            server.startServer(port);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid port number: " + args[0]);
            System.exit(1);
        }
    }

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started and listening on port " + port);


            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(() -> new SharedBoardServerThread(clientSocket));
                clientThread.start();
            }
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }
    }



    class SharedBoardServerThread {

        public SharedBoardServerThread(Socket clientSocket) {
            try {
                inputStream = new DataInputStream(clientSocket.getInputStream());
                outputStream = new DataOutputStream(clientSocket.getOutputStream());

                //First response
                byte [] data = readMessageData(clientSocket, false);

                while (!clientSocket.isClosed()) {

                     data = readMessageData(clientSocket, false);


                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("An error occurred while receiving the data, please contact the administrator.");
                throw new RuntimeException(e);
            } finally {
                try {
                    //close the conection with client
                    clientSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private byte[] readMessageData(Socket clientSocket, boolean isPassword) throws IOException, ClassNotFoundException {
        //read mensage
        int version = inputStream.readUnsignedByte();
        int code = inputStream.readUnsignedByte();
        int dataLength1 = inputStream.readUnsignedByte();
        int dataLength2 = inputStream.readUnsignedByte();

        //create a array of bytes as it says in the protocol
        //read Data
        byte[] data = new byte[dataLength1 + 256 * dataLength2];
        inputStream.readFully(data);
        if(!isPassword) {
            //processar o pedido e gerar uma resposta
            byte[] response = ResponseGenerator(code, data, clientSocket);
        }
        return data;
    }

    private byte[] ResponseGenerator(int code, byte[] data, Socket clientSocket) throws IOException, ClassNotFoundException {
        switch (code){
            case 0:
                COMMIT_Response(clientSocket);
                break;
            case 1:
                DISCONN_Response(clientSocket);
                break;
            case 2:
                SUCESS_Response();
                break;
            case 3:
                ERR_Response(data);
                break;
            case 4:
                AUTH_Response(data,clientSocket);
                break;
            case 5:
                Save_Board(data);
                break;
            case 6:
                Save_Notification(data);
                break;
            case 7:
                findAllNotification();
                break;
            case 8:
                findAllUSers();
                break;
            case 9:
                findAllBoardsByUSer();
                break;
            default:
                SendErrorInvalidCode();
        }
        return data;
    }

    private void findAllBoardsByUSer() throws IOException {
        System.out.println("\n==============================================\n A request to return all boards by user was received.\n==============================================\n");
        sendRequest(2,new byte[0]);
    }

    private void findAllUSers() throws IOException {
        System.out.println("\n==============================================\n A request to return all users was received.\n==============================================\n");
        sendRequest(2,new byte[0]);
    }

    private void findAllNotification() throws IOException {
        System.out.println("\n==============================================\n A request so show all notification was received\n==============================================\n");
        sendRequest(2,new byte[0]);
    }

    private void Save_Notification(byte[] data) throws IOException {
        System.out.println("\n==============================================\n A notification was received to be saved in the DB\n==============================================\n");
        sendRequest(2,new byte[0]);
    }

    private void Save_Board(byte[] data) throws IOException {
        System.out.println("\n==============================================\n A Board was received to be saved in the DB\n==============================================\n");
        sendRequest(2,new byte[0]);
    }

    private Object deserializeObject(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(data);
        ObjectInputStream ObjectOutput = new ObjectInputStream(byteInputStream);
        Object object = ObjectOutput.readObject();
        ObjectOutput.close();
        byteInputStream.close();
        return object;
    }

    private void REQUEST_Response(byte[] data) throws IOException {
        //ACK
        sendRequest(2,new byte[0]);

        //decode the message from bytes to String
        String messageReceived = new String(data, StandardCharsets.UTF_8);

        System.out.println("Recebi um pedido, " + messageReceived +" vou processar a resposta");
    }

    private void SendErrorInvalidCode() {
        System.out.println("\n==============================================\n An invalid code was received \n==============================================\n");
    }

    private void AUTH_Response(byte[] data, Socket clientSocket) throws IOException {

        sendRequest(2,new byte[0]);
        String username = new String(data, StandardCharsets.UTF_8);

        // TODO: 17/06/2023  adicionar forma de validar a password
        //data = readMessageData(clientSocket,true);
        //String password = new String(data, StandardCharsets.UTF_8);

        //If user exist show the user who has just entered and send ACK
        if (validateIfUserExist(username)) {
            sendRequest(2,new byte[0]);
            System.out.println("Recebi um AUTH com o user "+ username);
        } else {
            //show error on server
            System.out.printf("\n==============================================\nWrong username or password. The client will be disconnected\n==============================================\n");

            //send error to client
            String errorMessage = "\n==============================================\nCould not connect, user or password is wrong\nThe connection will be disconnected.\n==============================================\n";
            byte[] messageData = errorMessage.getBytes(StandardCharsets.UTF_8);
            sendRequest(3,messageData);
            //close conection
            sendRequest(1,new byte[0]);
            clientSocket.close();
        }


    }

    private boolean validateIfUserExist(String username) {
        List <SystemUser> listUsers = (List<SystemUser>) PersistenceContext.repositories().users().findAll();
        for (int i = 0; i < listUsers.size(); i++) {
            if(listUsers.get(i).username().toString().equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
    }

    private void ERR_Response(byte[] data) throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n==============================================\n"+data+ "\n==============================================\n");
    }

    private void SUCESS_Response() {
        System.out.println("Recebi um sucess");
    }

    private void DISCONN_Response(Socket clientSocket) throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n==============================================\n The client" + clientSocket.getInetAddress() + " disconnect.\n==============================================\n");
        clientSocket.close();
    }

    private void COMMIT_Response(Socket clientSocket) throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n==============================================\nI started connection with" + clientSocket.getInetAddress()+  "\n==============================================\n");
    }

    public static void sendRequest(int code, byte[] data) throws IOException {
        outputStream.writeByte(1);
        outputStream.writeByte(code);
        outputStream.writeByte(data.length % 256);
        outputStream.writeByte(data.length / 256);
        outputStream.write(data);
        outputStream.flush();
    }
}


