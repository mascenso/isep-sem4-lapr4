package tcpCliSrv;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SBPClient {
    static InetAddress serverIP;
    static Socket sock;

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
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
            sock = new Socket(serverIP, Integer.parseInt(args[0]));
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        DataInputStream inputStream = new DataInputStream(sock.getInputStream());


        String phrase;
        int num;

        System.out.print("Enter username: ");
        String username = in.readLine();
        System.out.print("Enter password: ");
        String password = in.readLine();
        int usernameLength = username.length();
        int passwordLength = password.length();

        do {
            num = -1;
            while (num < 0) {
                System.out.print("Enter a positive integer to SUM (zero to terminate): ");
                phrase = in.readLine();
                try {
                    num = Integer.parseInt(phrase);
                } catch (NumberFormatException ex) {
                    num = -1;
                }
                if (num < 0)
                    System.out.println("Invalid number");
            }

            byte[] sbpMessage = new byte[8]; // Um para cada field (version, data, d_length, byte mais significativo,...)

            // Calcula o comprimento total do campo DATA
            int dataLength = usernameLength + passwordLength;

            byte dLength1 = (byte) (dataLength % 256);
            byte dLength2 = (byte) (dataLength / 256);

            sbpMessage[0] = 1; // VERSION
            sbpMessage[1] = 0; // CODE
            sbpMessage[2] = dLength1; // D_LENGTH_1
            sbpMessage[3] = dLength2; // D_LENGTH_2

            byte[] usernameBytes = username.getBytes(StandardCharsets.US_ASCII);
            byte[] passwordBytes = password.getBytes(StandardCharsets.US_ASCII);

            System.arraycopy(usernameBytes, 0, sbpMessage, 4, usernameLength);
            System.arraycopy(passwordBytes, 0, sbpMessage, 4 + usernameLength, passwordLength);

            // DATA
            // Converte o num em um array de bytes (com deslocamentos à direita) e armazena no index 4 a 7 do sbpMessage.
            sbpMessage[4] = (byte) (num >>> 24); //3 bytes
            sbpMessage[5] = (byte) (num >>> 16); //2 bytes
            sbpMessage[6] = (byte) (num >>> 8); //1 byte
            sbpMessage[7] = (byte) num;

            // Envia a msg
            sOut.write(sbpMessage);

            // Recebe a resposta e processa a mesma
            byte[] response = new byte[5];  // um para cada field (version, data, d_length, ...)
            inputStream.readFully(response);

            // Parse da resposta
            int responseCode = response[1] & 0xFF; // Converte o 2º byte do array response num inteiro sem sinal (unsigned). O & garante que o resultado é sempre um inteiro sem sinal compreendido entre 0 a 255.
            int responseData = ((response[1] & 0xFF) << 24) | ((response[2] & 0xFF) << 16) | ((response[3] & 0xFF) << 8) | (response[4] & 0xFF); //Combina os bytes 2, 3, 4 e 5 do array response para obter um inteiro.

            if (responseCode == 2) {
                //Autenticação bem sucedida
                System.out.println("SUM RESULT = " + responseData);
            } else if (responseCode == 3) {// ERR – Error response message
                if (response[4] == 65 && response[5] == 85) {
                    System.out.println("Authentication failed: Invalid username or password");
                } else {
                    System.out.println("Error: " + new String(response, 2, 2));
                }
            }

        } while (num != 0);

        sock.close();
    }
}
