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
		String messageOut;
		String messageIn;
		String serverIP;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter TCP/IP Server IP Address (default is localhost): ");
		serverIP = in.readLine();
		
		Socket server = new Socket(serverIP, 60500);
		BufferedReader serverReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		System.out.println("Connected to server at "+serverIP+" on port 60500");
		
			
		
		
	}
}
