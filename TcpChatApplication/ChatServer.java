package TcpChatApplication;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 3500;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Chat Server is running on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;

            do {
                System.out.print("Client: ");
                inputLine = userInput.readLine();
                writer.println(inputLine); // Send input to the client

                String response = reader.readLine();
                System.out.println("Client Message: " + response);
            } while (!inputLine.equals("bye"));

            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
