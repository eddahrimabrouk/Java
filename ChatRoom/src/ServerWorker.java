import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerWorker extends Thread {
    private ChatServer server;
    private Socket socket;
    private int threadID;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private String username;

    //constructor
    public ServerWorker(ChatServer server, Socket socket, int threadID) {
        this.server = server;
        this.socket = socket;
        this.threadID = threadID;
    }

    public void run() {
        try {
            // streams initialisieren
            inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outToClient = new DataOutputStream(socket.getOutputStream());
            // benutzernamen des clients anfordern
            writeMessage("ENTERNAME", outToClient);
            username = readClientMessage();
            while (ChatServer.clientUsernameList.contains(username)) {
                writeMessage("Username already taken, please choose another username: ", outToClient);
                username = readClientMessage();
            }
            //benutzernamen in username list aufnehmen
            ChatServer.clientUsernameList.add(username);
            // outputstream in liste aufnehmen
            ChatServer.clientOutList.add(outToClient);
            // client über akzeptieren des usernames informieren
            writeMessage("ACCEPTED", outToClient);

            //alle clients über neuen benutzer im raum benachrichtigen
            for (DataOutputStream out : ChatServer.clientOutList) {
                if (out != this.outToClient) {
                    writeMessage(username + " joined the chatroom", out);
                }
            }

            String message;
            //nachrichten von client empfangen und an alle anderen clients weiterleiten
            while (true) {
                message = readClientMessage();
                //wenn client "quit" schreibt verlässt er den chatroom
                if (message.equals("quit")){
                    writeMessage("You left the Chatroom!", outToClient);
                    break;
                }
                // leite nachricht an alle anderen clients weiter
                for (DataOutputStream out : ChatServer.clientOutList) {
                    if (out != this.outToClient) {
                        out.writeBytes(username + ": " + message + '\r' + '\n');
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //client aus listen entfernen
            ChatServer.clientOutList.remove(this.outToClient);
            ChatServer.clientUsernameList.remove(this.username);
        }
        try {
            // socket schließen
            socket.close();
        } catch (IOException e) {
        }
    }


    private String readClientMessage() throws IOException {
        String message = inFromClient.readLine();
        return message;
    }

    private void writeMessage(String message, DataOutputStream out) throws IOException {
        out.writeBytes(message + '\r' + '\n');
    }
}








