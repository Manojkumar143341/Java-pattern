import java.io.*;
import java.net.*;

public class SimpleHTTPServer {

    public static void main(String[] args) {
        int port = 8080; // localhost:8080

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started at http://localhost:" + port);

            while (true) {
                try (
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    // Read the request (we'll just print the first line)
                    String requestLine = in.readLine();
                    System.out.println("Received: " + requestLine);

                    // Send a basic HTTP response
                    String httpResponse = "HTTP/1.1 200 OK\r\n" +
                                          "Content-Type: text/html\r\n" +
                                          "\r\n" +
                                          "<html><body><h1>Hello from Java Server!</h1></body></html>";

                    out.println(httpResponse);

                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }
}
