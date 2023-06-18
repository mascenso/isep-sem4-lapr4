package shareboardHttpServer;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SBPClient {
    static InetAddress serverIP;
    static Socket socket;
    static  DataOutputStream outputStream;
    static DataInputStream inputStream;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Server IPv4/IPv6 address or DNS name is required as an argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + args[0]);
            System.exit(1);
        }


        try {
            socket = new Socket(serverIP, Integer.parseInt(args[1]));

        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }

        System.out.println("Established connection with TCP server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         outputStream = new DataOutputStream(socket.getOutputStream());
         inputStream = new DataInputStream(socket.getInputStream());

        //send a test request (COMMTEST)
        sendRequest(0,new byte[0]);
        int num =0;


        /*teste AUTH
        String message = "Admi";
        byte[] messageData = message.getBytes(StandardCharsets.UTF_8);
        sendRequest(4,messageData);
        String message2 = "Password1";
        byte[] messageData2 = message2.getBytes(StandardCharsets.UTF_8);
        sendRequest(4,messageData2);
        */

        //Read and process until close the client side
        //while(!socket.isClosed()){

          //  ReadDataOfMessage();
       // }

    }

    public static byte[] ReadDataOfMessage() throws IOException {
        //Read message
        int version = inputStream.readUnsignedByte();
        int code = inputStream.readUnsignedByte();
        int dataLength1 = inputStream.readUnsignedByte();
        int dataLength2 = inputStream.readUnsignedByte();

        //this codes dont have data
        if(code == 3 || code == 5 ){
            //read all data
            byte [] data = new byte[dataLength1 + 256 * dataLength2];
            inputStream.readFully(data);
            //response
            responseProcess(code,data,socket);
            return data;
        }

        responseProcess(code,new byte[0],socket);
        return new byte[0];
    }

    private static void responseProcess(int code, byte[] data, Socket socket) throws IOException {
        switch (code){
            case 0:
                COMMIT_Response();
                break;
            case 1:
                DISCONN_Response(socket);
                break;
            case 2:
                ACK_Response();
                break;
            case 3:
                ERR_Response(data);
                break;
            case 4:
                AUTH_Response(data);
            default:
                SendErrorInvalidCode(data);
        }
    }

    private static void SendErrorInvalidCode(byte[] data) {
        System.out.println("\n***************************************************\nMessage from TCP\n");
        System.out.println("An invalid code was received \n***************************************************\n");
    }

    private static void AUTH_Response(byte[] data) {
        System.out.println("\n***************************************************\nMessage from TCP");
        System.out.println("AUTH received \n***************************************************\n");
    }

    private static void ERR_Response(byte[] data) {
        String messageReceived = new String(data, StandardCharsets.UTF_8);
        System.out.println("\n***************************************************\nMessage from TCP");
        System.out.println(messageReceived+ "\n***************************************************\n");
    }

    private static void ACK_Response() {
        System.out.println("\n***************************************************\nMessage from TCP");
        System.out.println("The request was successfully received by the server\n***************************************************\n");
    }

    private static void DISCONN_Response(Socket socket) throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n***************************************************\nMessage from TCP");
        System.out.println("The server has been shut down, the client connection will be disconnected.\n***************************************************\n");
        SBPClient.socket.close();
    }

    private static void COMMIT_Response() {
        System.out.println("\n***************************************************\nMessage from TCP");
        System.out.println("Test Request received\n***************************************************\n");
    }

    public static void sendRequest(int code, byte[] data) throws IOException {
        if(code <0 || code >91){
            System.out.println("This code dont exist, please insert a valid one");
        }else {
            outputStream.writeByte(1);
            outputStream.writeByte(code);
            outputStream.writeByte(data.length % 256);
            outputStream.writeByte(data.length / 256);
            outputStream.write(data);
            outputStream.flush();

            if (code == 1) {
                System.out.println("\n***************************************************\nMessage from TCP");
                System.out.println("disconnect.\n***************************************************\n");

                SBPClient.socket.close();
            }
        }
    }
    public static boolean saveBoard(Object board) throws IOException {
        //We were supposed to send a serialized object to the tcp server to persist in the DB but it's not being possible to serialize
        //and we decided not to send the object and leave it for a future improvement
        //just send request and receive the answer
        sendRequest(5,new byte[0]);
        return true;
    }

    public static boolean saveNotification(Object object) throws IOException {
        //We were supposed to send a serialized object to the tcp server to persist in the DB but it's not being possible to serialize
        //and we decided not to send the object and leave it for a future improvement
        //just send request and receive the answer
        sendRequest(6,new byte[0]);
        return true;
    }

    public static void findAllNotification() throws IOException {
        //We were supposed to send a serialized object to the tcp server to persist in the DB but it's not being possible to serialize
        //and we decided not to send the object and leave it for a future improvement
        //just send request and receive the answer
        sendRequest(7, new byte[0]);
    }

    public static void findAllUsers() throws IOException {
        //We were supposed to send a serialized object to the tcp server to persist in the DB but it's not being possible to serialize
        //and we decided not to send the object and leave it for a future improvement
        //just send request and receive the answer
        sendRequest(8,new byte[0]);
    }

    public static void findAllBoardsByUser(Object identity) throws IOException {
        //We were supposed to send a serialized object to the tcp server to persist in the DB but it's not being possible to serialize
        //and we decided not to send the object and leave it for a future improvement
        //just send request and receive the answer
        sendRequest(9,new byte[0]);
    }
}
