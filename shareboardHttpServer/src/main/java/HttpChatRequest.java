import java.io.*;
import java.net.*;

/**
 * Responsável por tratar as requisições HTTP feitas ao servidor.
 */
public class HttpChatRequest extends Thread {
    String baseFolder; //guarda o nome da pasta base onde os arquivos do servidor estão armazenado.
    Socket sock; //conexão entre o servidor e o cliente(browser) --> enviar e receber dados.
    DataInputStream inS; //lê os dados (como a requisição HTTP) que chega do cliente.
    DataOutputStream outS; //envia dados (como a resposta HTTP) de volta para o cliente.

    public HttpChatRequest(Socket s, String f) {
        baseFolder = f;
        sock = s;
    }

    @Override
    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Thread error on data streams creation");
        }
        try {
            HTTPmessage request = new HTTPmessage(inS);  //requisição HTTP enviada pelo cliente, criada apartir dod dados lidos do DataInputStream.
            HTTPmessage response = new HTTPmessage(); //constroi a resposta HTTP que será enviada de volta para o cliente.
            response.setResponseStatus("200 Ok");

            if (request.getMethod().equals("GET")) { //se o cliente estiver a solicitar algum recurso do servidor.
                if (request.getURI().startsWith("/messages/")) { //URI começa com "/messages/". Trata requisições específicas relacionadas com as mensagens de chat.
                    int msgNum;
                    try {
                        msgNum = Integer.parseInt(request.getURI().substring(10));
                    } catch (NumberFormatException ne) {
                        msgNum = -1;
                    }
                    if (msgNum < 0) {
                        response.setContentFromString(
                                "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                                "text/html");
                        response.setResponseStatus("405 Method Not Allowed");
                    } else {
                        String msg = HttpServerChat.getMsg(msgNum); //Obtém a mensagem do chat com base no número na URI.
                        // if msgNum doesn't yet exist, the getMsg() method waits
                        // until it does. So the HTTP request was received, but the
                        // HTTP response is sent only when there's a message
                        response.setContentFromString(msg, "text/plain"); //define o conteúdo da resposta HTTP --> msg.
                    }
                } else { // NOT GET /messages/ , THEN IT MUST BE A FILE
                    String fullname = baseFolder + "/";
                    if (request.getURI().equals("/")) fullname = fullname + "index.html";
                    else fullname = fullname + request.getURI();
                    if (!response.setContentFromFile(fullname)) {
                        response.setContentFromString(
                                "<html><body><h1>404 File not found</h1></body></html>",
                                "text/html");
                        response.setResponseStatus("404 Not Found");
                    }
                }
            } else { // NOT GET, must be POST
                if (request.getMethod().equals("POST") //Envia ao servidor.
                        && request.getURI().equals("/messages")) { //adiciona uma nova mensagem ao chat.
                    HttpServerChat.addMsg(request.getContentAsString());
                    response.setResponseStatus("200 Ok"); //operaçao bem sucedida.
                } else {
                    response.setContentFromString(
                            "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                            "text/html");
                    response.setResponseStatus("405 Method Not Allowed");
                }
            }
            response.send(outS); // SEND THE HTTP RESPONSE TO THE CLIENT.
        } catch (IOException ex) {
            System.out.println("Thread I/O error on request/response");
        }
        try {
            sock.close(); //fecha a conexão.
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }
}


