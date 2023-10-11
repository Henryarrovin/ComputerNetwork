
import java.util.*;
import java.io.*;

class Clientarp {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String file = "hi.csv";
		String line = "";
		String splitBy = ",";
		System.out.println("Enter IP address");
		String ipAddr = in.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] ip = line.split(splitBy);
				if (ipAddr.equals(ip[0])) {
					System.out.println("IP Adderss   |  MAC Address");
					System.out.println(ip[0] + "  |  " + ip[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
