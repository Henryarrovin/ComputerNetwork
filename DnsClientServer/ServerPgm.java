package DnsClientServer;

import java.net.*;

class ServerPgm {
    public static void main(String args[]) {
        DatagramSocket server = null;
        try {
            server = new DatagramSocket(1309);
            while (true) {
                byte[] sendbyte = new byte[1024];
                byte[] receivebyte = new byte[1024];
                DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
                server.receive(receiver);
                String str = new String(receiver.getData());
                String s = str.trim();
                InetAddress addr = receiver.getAddress();
                int port = receiver.getPort();
                String ip[] = { "165.165.80.80", "165.165.79.1" };
                String name[] = { "www.aptitudeguru.com", "www.downloadcyclone.blogspot.com" };
                for (int i = 0; i < ip.length; i++) {
                    if (s.equals(ip[i])) {
                        sendbyte = name[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        break;
                    } else if (s.equals(name[i])) {
                        sendbyte = ip[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, port);
                        server.send(sender);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (server != null && !server.isClosed()) {
                server.close();
            }
        }
    }
}
