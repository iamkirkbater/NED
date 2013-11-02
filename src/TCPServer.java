/**
 * @author Kirk Bater
 * @version
 * 
 *
 */

import java.net.*;
import java.io.*;

public class TCPServer extends Thread {
	
	ServerSocket socket;
	
	/*
	 * TCP Server Constructor
	 * @param - Takes a single int as a port number
	 */
	public TCPServer(int port) throws Exception {
		this.socket = new ServerSocket(port);
		Socket cSocket = socket.accept();
		
		InputStreamReader inReader = new InputStreamReader(cSocket.getInputStream());
		BufferedReader in = new BufferedReader(inReader);
		
		DataOutputStream output = new DataOutputStream(cSocket.getOutputStream());
		
		super.printMsg("Received: " + in.readLine());
		output.writeBytes("Received your message.");
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
