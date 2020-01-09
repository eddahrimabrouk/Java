import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriter extends Thread {

    private ChatClient client;
    private Socket socket;
    private DataOutputStream outToServer;
    private final String username;
    String message;

    public ClientWriter(ChatClient client, Socket socket, String username) {
        this.client = client;
        this.socket = socket;
        this.username = username;
    }

    public void run() {
        try {
            outToServer = new DataOutputStream(socket.getOutputStream());

            Scanner input = new Scanner(System.in);
            message = input.nextLine();

            while (!message.equals("quit")) {

                writeMessage(message);
                message = input.nextLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writeMessage(username + " left the chatroom!");
                writeMessage("quit");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    private void writeMessage(String message) throws IOException {
        outToServer.writeBytes(message + '\r' + '\n');
    }


}
