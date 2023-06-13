package tcpCliSrv;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SBPServer {
    private ServerSocket serverSocket;
    private Map<String, String> userCredentials = new HashMap<>();

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

            userCredentials.put("admin", "Password1");
            userCredentials.put("teacher", "Password2");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new SharedBoardServerThread(clientSocket)).start();
            }
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }
    }

    class SharedBoardServerThread implements Runnable {
        private Socket socket;
        private DataOutputStream outStream;
        private DataInputStream inputStream;

        public SharedBoardServerThread(Socket clientSocket) {
            socket = clientSocket;
        }

        public void run() {
            InetAddress clientIP = socket.getInetAddress();
            System.out.println("New client connection from " + clientIP.getHostAddress() +
                    ", port number " + socket.getPort());

            try {
                outStream = new DataOutputStream(socket.getOutputStream());
                inputStream = new DataInputStream(socket.getInputStream());

                while (true) {

                    byte[] request = new byte[5]; // um para cada field (version, data, d_length, ...)
                    inputStream.readFully(request);

                    // Parse the request
                    int requestCode = request[1] & 0xFF; // Convert the byte to an unsigned integer
                    int requestData = (request[4] << 24) | (request[5] << 16) | (request[6] << 8) | (request[7]);

                    // Process the request and prepare the response
                    byte[] response = new byte[8]; // um para cada field (version, data, d_length, byte mais significativo,...)

                    if (requestCode == 0) {
                        // COMMTEST, responde com o ACK = 2;
                        response[1] = 2;
                    } else if (requestCode == 1) {
                        // DISCONN request, responde com o ACK = 2 e fecha a conecção
                        response[1] = 2;
                        socket.close();
                        System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() +
                                " disconnected");
                        break; // Para fechar a thread
                    } else if (requestCode == 4) {

                        byte[] usernameBytes = new byte[request[2]];
                        byte[] passwordBytes = new byte[request[3]];
                        System.arraycopy(request, 4, usernameBytes, 0, request[2]);
                        System.arraycopy(request, 4 + request[2], passwordBytes, 0, request[3]);
                        String username = new String(usernameBytes, StandardCharsets.US_ASCII);
                        String password = new String(passwordBytes, StandardCharsets.US_ASCII);

                        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                            response[1] = 2; // ACK - Autenticação bem-sucedida
                        } else {
                            response[1] = 3; // ERR - Autenticação falhou
                            response[4] = 'A'; // Example error message, first character
                            response[5] = 'U'; // Example error message, second character
                        }
                    }

                    // Send the response
                    outStream.write(response);
                }
            } catch (IOException ex) {
                System.out.println("IOException");
            }
        }
    }
}


