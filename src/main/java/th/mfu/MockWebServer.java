package th.mfu;

import java.io.*;
import java.net.*;

public class MockWebServer implements Runnable {

    private int port;

    public MockWebServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        // TODO Create a server socket bound to specified port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            
            System.out.println("Mock Web Server running on port " + port + "...");
    
            while (true) {
                // TODO Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                // TODO Create input and output streams for the client socket
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // TODO: Read the request from the client using BufferedReader
                String inputLine;
                while(!(inputLine = in.readLine()).equals("")) {
                    System.out.println("Received from client: " + inputLine);
                    // out.println("Client says: " + inputLine);
                }
                // TODO: send a response to the client
                String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n" + "<html><body>Hello, Web! on Port " + port + "</body></html>";
                out.println(response);
                // TODO: Close the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Thread server1 = new Thread(new MockWebServer(8080));
        server1.start();

        Thread server2 = new Thread(new MockWebServer(8081));
        server2.start();

        // type any key to stop the server
        // Wait for any key press to stop the mock web server
        System.out.println("Press any key to stop the server...");
        try {
            System.in.read();

            // Stop the mock web server
            server1.stop();
            server1.interrupt();
            server2.stop();
            server2.interrupt();
            System.out.println("Mock web server stopped.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
