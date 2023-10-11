import java.io.*;
import java.net.*;

public class DownloadWebPageTcpSocket {
    public static void main(String[] args) {
        String path = "http://www.google.com";
        try {
            URL url = new URL(path);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("An IOException occurred");
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
            e.printStackTrace();
        }
    }
}
