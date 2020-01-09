import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReader extends Thread {

    private ChatClient client;
    private Socket socket;
    private BufferedReader inFromServer;
    private final String username;

    public ClientReader(ChatClient client, Socket socket, String username) {
        this.client = client;
        this.socket = socket;
        this.username = username;
    }

    public void run() {
        try {


            inFromServer = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String serverMessage = readClientMessage();
            System.out.println(serverMessage);

            String message = inFromServer.readLine();
            while (message != null) {


                System.out.println(message);

                message = inFromServer.readLine();


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String readClientMessage() throws IOException {
        String message = inFromServer.readLine();
        return message;
    }

}
