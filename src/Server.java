import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Server {
	
	private ServerSocket ss;
	private List<TCPServer> tcpServers;
	
	public static void main(String [] args) {
		/*
		 * When the program is run, just start a single new Server,
		 * and it will take care of the rest.
		 */
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
			
			//Start the UDP Server in it's own thread
			//so that we can continue starting up our
			//tcp server.
			UDPServer udp = new UDPServer();
			udp.start();
				
			//Wait for Connections
			while(true) {
				System.out.println("Awaiting Connections on port 35050.");
				/*
				 * Program waits here for an incoming connection, then
				 * starts a new TCP Server, runs it in it's own thread,
				 * and then adds it to the thread array for future
				 * scaleablility.
				 */
				Socket cs = ss.accept();
				TCPServer server = new TCPServer(threadCount++, cs);
				server.start();
				tcpServers.add(server);
			}
			
		}catch (IOException e) { // Catch any exceptions gracefully
			System.out.println("There was an error, and an IOException was thrown.");
			//e.printStackTrace();
		}finally {
			System.out.println("Shutting Down Server.......");
		}
	}

}
