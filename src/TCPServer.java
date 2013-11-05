/**
 * @author Kirk Bater
 * @version
 * 
 *
 */

import java.net.*;
import java.io.*;

public class TCPServer extends Server {
	
	ServerSocket socket;
	int portNumber;
	
	/*
	 * TCP Server Constructor
	 * @param - Takes a single int as a port number
	 */
	public TCPServer(int port) throws Exception {
		this.portNumber = port;
		this.socket = new ServerSocket(port);
		System.out.println("New TCP/IP Server started, listening on port: "+portNumber);
	}

	public void run() {
		try {
		Socket cSocket = socket.accept();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
		
		DataOutputStream output = new DataOutputStream(cSocket.getOutputStream());
		
		String inFromClient = in.readLine();
		
		while(true){
			if(portNumber == 60500) {
				if(inFromClient == "hello") {
					System.out.println("Received incoming TCP/IP transmission from client.  Initiating port handoff.");
					try {
						super.newTCPServer();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("Received: " + in.readLine() + " from TCP/IP on port "+portNumber);
				output.writeBytes("Successfully received your message.");
			}
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
