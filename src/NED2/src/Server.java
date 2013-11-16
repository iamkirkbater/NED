import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Server {
	
	private ServerSocket ss;
	private List<TCPServer> tcpServers;
	
	public static void main(String [] args) {
		new Server();
	}
	
	public Server() {
		
		try {
			
			//Start the server and let the user know what our inetAddress is.
			ss = new ServerSocket(35050);
			System.out.println("Server started on port 35050 at " + InetAddress.getLocalHost());
			
			//Set up the list we can add the threads to, and start the counter at 0
			tcpServers = new ArrayList<TCPServer>();
			int threadCount = 1;
			
			//Start the UDP Server
			DatagramSocket udpSocket = new DatagramSocket();			
			new Thread(new UDPServer(udpSocket));
			
			
			//Run the TCP Server
			
			//Wait for Connections
			while(true) {
				System.out.println("Awaiting Connections...");
				Socket cs = ss.accept();
				TCPServer server = new TCPServer(threadCount++, cs);
				server.start();
				tcpServers.add(server);
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Shutting Down Server.......");
		}
	}

}
