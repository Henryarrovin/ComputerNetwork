package EchoClient_EchoServer_tcp_socket;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 3500;

        try {
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to the server...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;

            do {
                System.out.print("Client: ");
                inputLine = userInput.readLine();
                writer.println(inputLine); // Send input to the server

                String response = reader.readLine();
                System.out.println("Echo Server Message: " + response);
            } while (!inputLine.equals("bye"));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
