package tcpCliSrv;

import eCourse.domain.Course;
import eCourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SBPServer {
    private ServerSocket serverSocket;
    private Map<String, String> userCredentials = new HashMap<>();

    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static Socket socket;

    public static void main(String[] args) {
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

                while (!clientSocket.isClosed()) {

                    byte [] data = readMessageData(clientSocket, false);


                }

            } catch (IOException e) {
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

    private byte[] readMessageData(Socket clientSocket, boolean isPassword) throws IOException {
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

    private byte[] ResponseGenerator(int code, byte[] data, Socket clientSocket) throws IOException {
        switch (code){
            case 0:
                COMMIT_Response();
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
                REQUEST_Response(data);
                break;
            default:
                SendErrorInvalidCode();
        }
        return data;
    }

    private void REQUEST_Response(byte[] data) throws IOException {
        //ACK
        sendRequest(2,new byte[0]);

        //decode the message from bytes to String
        String messageReceived = new String(data, StandardCharsets.UTF_8);

        System.out.println("Recebi um pedido, " + messageReceived +" vou processar a resposta");
    }

    private void SendErrorInvalidCode() {
        System.out.println("\n=======================\n An invalid code was received \n=======================\n");
    }

    private void AUTH_Response(byte[] data, Socket clientSocket) throws IOException {
        sendRequest(2,new byte[0]);
        String username = new String(data, StandardCharsets.UTF_8);

        data = readMessageData(clientSocket,true);
        String password = new String(data, StandardCharsets.UTF_8);

        PersistenceContext.repositories().courses().findAll();
        System.out.println("Recebi um AUTH com o user"+ username + "e palavra pass" + password);
    }

    private void ERR_Response(byte[] data) throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n=======================\n"+data+ "\n=======================\n");
    }

    private void SUCESS_Response() {
        System.out.println("Recebi um sucess");
    }

    private void DISCONN_Response(Socket clientSocket) throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n=======================\n The client" + clientSocket.getInetAddress() + " disconnect.\n=======================\n");
        clientSocket.close();
    }

    private void COMMIT_Response() throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n=======================\nThe request was successfully received by the client\n=======================\n");
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


