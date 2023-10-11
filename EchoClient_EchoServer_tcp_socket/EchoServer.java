package EchoClient_EchoServer_tcp_socket;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int port = 3500;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Echo Server is running on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                writer.println(inputLine); // Echo back to the client
            }

            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
