import java.net.*;
import java.io.*;


public class UDPServer extends Thread {
	
	DatagramSocket s;
	
	public UDPServer() {
		/*
		 * Creates a new UDP Server.  Because UDP Servers only deal with single packets,
		 * we really don't have to worry about multi-threading it, so we can just run it
		 * in a single thread, so that we can thread as many TCP servers as we need to.
		 */
		try {
			// Create a new Datagram Socket on port 35050
			s = new DatagramSocket(35050);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		System.out.println("UDP Server Started Successfully.");
	}
	
	public void run() {
		
		
		try {
			DatagramPacket p;
			
			while(true) { // Run Until the program needs to close
				
				System.out.println("Awaiting UDP Datagrams.");
				
				p = new DatagramPacket(new byte [1024], 1024);
				//Create a new Packet, and wait here until you receive a
				//new packet over the socket.
				s.receive(p);
				
				//Get and Display the data from the packet.
				String msg = new String(p.getData());				
				System.out.println("Received UDP Datagram: "+msg);
				
			}
		
		} catch(IOException e) { // Fail Gracefully
			System.out.println("There was an IOException thrown in the UDP Server.");
			//e.printStackTrace();
		}
		
	}

}
