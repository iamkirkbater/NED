import java.io.*;
import java.net.*;

/*
 * TCP Client Class
 * Child of the Client class.  Created when Client spins up
 * a new TCP Client.
 */
public class TCPClient {
	
	public static void main(String argv[])  throws Exception
	{

		String serverIP;
		int serverPort;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter TCP/IP Server IP Address (default is localhost): ");
		serverIP = in.readLine();
		
		Socket server = new Socket(serverIP, 60500);
		BufferedReader serverReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		System.out.println("Connected to server at "+serverIP+" on port 60500");
		
		DataOutputStream out = new DataOutputStream(server.getOutputStream());
		out.writeBytes("hello");
		
		serverPort = Integer.parseInt(serverReader.readLine());
		server.close();
		
		server = new Socket(serverIP, serverPort);
		serverReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		out = new DataOutputStream(server.getOutputStream());
		
		String message;
		
		System.out.print("Send Message: ");
		message = in.readLine();
		
		System.out.println("Sending Message.");	
		out.writeBytes(message);
		
		System.out.println("Ending Communication with server "+serverIP);
		server.close();
		
	}
}
