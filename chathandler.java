import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private List<ClientHandler> clients;
    private ObjectOutputStream out;
    private String name;

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void run() {
        try (
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ) {
            out = new ObjectOutputStream(socket.getOutputStream());
            name = (String) in.readObject();
            sendToAll(name + " joined the chat!");

            Object obj;
            while ((obj = in.readObject()) != null) {
                String message = "[" + name + "]: " + obj;
                Logger.getInstance().log(message);
                sendToAll(message);
                MessageHistory.save(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            Logger.getInstance().log(name + " disconnected.");
        } finally {
            clients.remove(this);
            sendToAll(name + " left the chat.");
        }
    }

    private void sendToAll(String message) {
        for (ClientHandler client : clients) {
            try {
                client.out.writeObject(message);
                client.out.flush();
            } catch (IOException ignored) {}
        }
    }
}
