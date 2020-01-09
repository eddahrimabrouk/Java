import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private final int PORT = 9001;
    private String username;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;
    private String serverMessage;

    public ChatClient() {

    }

    public void runClient() {
        try {

            Socket clientSocket = new Socket("localhost", PORT);

            // streams initialisieren
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            //ckeck for valid username
            enterValidUsername();

            //reader und writer threads starten
            (new ClientReader(this, clientSocket, username)).start();
            (new ClientWriter(this, clientSocket, username)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        client.runClient();


    }

    private String readServerMessage() throws IOException {
        serverMessage = inFromServer.readLine();
        return serverMessage;
    }

    private void writeMessage(String message) throws IOException {
        outToServer.writeBytes(message + '\r' + '\n');
    }

    private void enterValidUsername() throws IOException {
        do{
            readServerMessage();
        } while (!serverMessage.equals("ENTERNAME"));
        System.out.println("Enter username: ");
        Scanner input = new Scanner(System.in);
        username = input.nextLine();
        writeMessage(username);
        while (!readServerMessage().equals("ACCEPTED")) {
            System.out.println(serverMessage);
            username = input.nextLine();
            writeMessage(username);
        }
        System.out.println("Username accepted");
    }


}
