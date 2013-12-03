import java.io.*;
import java.net.*;
import java.util.Scanner;


public class UDPClient {

	String server;
	
	public UDPClient(String server) {
		/*
		 * Starts a new UDP Client as a subprocess of the Client class
		 */
		this.server = server;
	}
	
	public void run() {
		//Get the message to send to the server from the user
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your Message: ");
		String clientMsg = scan.nextLine();
		
		try {
			byte [] data = clientMsg.getBytes();
			//"Cast" the string of the server name to an InetAddress
			InetAddress addr = InetAddress.getByName(server);
			
			//Create the packet and socket
			DatagramPacket pack = new DatagramPacket(data, data.length, addr, 35050);
			DatagramSocket ds = new DatagramSocket();
			
			//Send the packet to the server
			ds.send(pack);			
			System.out.println("Message Sent.");
			
			//Close our resources
			ds.close();
			scan.close();
		} catch (IOException e) {
			System.out.println("Unexpected IOException in the UDP Client.");
			//e.printStackTrace();
		}
	}
	
}
