package tcpCliSrv;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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

        //Read and process until close the client side
        while(!socket.isClosed()){
            ReadDataOfMessage();
        }

    }

    private static byte[] ReadDataOfMessage() throws IOException {
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
            case 5:
                REQUEST_Response(data);
                break;
            default:
                SendErrorInvalidCode(data);
        }
    }

    private static void SendErrorInvalidCode(byte[] data) {
        System.out.println("\n=======================\n An invalid code was received \n=======================\n");
    }

    private static void REQUEST_Response(byte[] data) {
        System.out.println("Recebido um pedido do servidor, fazer o processamento aqui");
    }

    private static void AUTH_Response(byte[] data) {
        System.out.println("\n=======================\n AUTH received \n=======================\n");
    }

    private static void ERR_Response(byte[] data) {
        System.out.println("\n=======================\n"+data+ "\n=======================\n");
    }

    private static void ACK_Response() {
        System.out.println("The request was successfully received by the server");
    }

    private static void DISCONN_Response(Socket socket) throws IOException {
        sendRequest(2,new byte[0]);
        System.out.println("\n=======================\nThe server has been shut down, the client connection will be disconnected.\n=======================\n");
        SBPClient.socket.close();
    }

    private static void COMMIT_Response() {
        System.out.println("\n=======================\nTest Request received\n=======================\n");
    }

    public static void sendRequest(int code, byte[] data) throws IOException {
        if(code <0 || code >5){
            System.out.println("This code dont exist, please insert a valid one");
        }else {
            outputStream.writeByte(1);
            outputStream.writeByte(code);
            outputStream.writeByte(data.length % 256);
            outputStream.writeByte(data.length / 256);
            outputStream.write(data);
            outputStream.flush();

            if (code == 1) {
                System.out.println("\n=======================\n disconnect.\n=======================\n");
                SBPClient.socket.close();
            }
        }
    }
}
