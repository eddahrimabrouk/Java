import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    //verwendete Portnummer
    private static final int PORT = 9001;

    //anzahl laufender threads
    private int threadCount = 0;

    //liste der client outputstreams
    public static List<DataOutputStream> clientOutList = new ArrayList<DataOutputStream>();
    //liste der client usernames
    public static List<String> clientUsernameList = new ArrayList<>();

    public void runClientServer() {
        try {

            // server und client socket initialisieren
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket clientSocket;
            // konsolenausgabe
            System.out.println("TCP Server is waiting for connection - listening TCP port " +
                    PORT);

            while (true) {
                // auf verbindungsaufbau von client warten
                clientSocket = serverSocket.accept();
                // neuen worker thread für verbundenen client starten
                (new ServerWorker(this, clientSocket, threadCount)).start();
                threadCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.runClientServer();
    }
}
