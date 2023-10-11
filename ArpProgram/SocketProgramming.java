
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class SocketProgramming {
        public static void main(String[] args) throws Exception {
                Scanner sc = new Scanner(System.in);
                String fileLocation = "hi.csv";
                String fileLine;
                String inputAddress;
                int choice = 0;
                String[] choiceText = { "IP Address", "MAC Address" };
                System.out.println("1.ARP\n2.RARP\n3.Exit");
                choice = sc.nextInt();
                switch (choice) {
                        case 1:
                                System.out.println("Enter the IP Address:");
                                break;
                        case 2:
                                System.out.println("Enter the Mac Address:");
                                break;
                        case 3:
                                System.exit(0);
                        default:
                                System.out.println("Invalid Choice...");
                }
                inputAddress = sc.next();
                try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
                        while ((fileLine = br.readLine()) != null) {
                                String[] address = fileLine.split(",");

                                if (inputAddress.equals(address[choice - 1])) {
                                        System.out.println("\n");
                                        System.out.println(choiceText[choice - 1] + " | "
                                                        + choiceText[((choice - 1) == 0 ? 1 : 0)]);
                                        System.out.println(address[choice - 1] + " | "
                                                        + address[((choice - 1) == 0 ? 1 : 0)] + "\n");
                                        System.exit(0);
                                }
                        }
                        System.out.println(choiceText[choice - 1] + " not Found.");
                }
        }
}
