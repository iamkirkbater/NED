import java.io.*;
import java.net.*;

public class TCPServer extends Thread {
	
	private int threadId;
	private Socket cs;
	
	public TCPServer(int threadId, Socket cs) {
		//Start a new threaded TCP Server
		this.threadId = threadId;
		this.cs = cs;
		System.out.println("TCP/IP Server Started Successfully.");
	}
	
	public void run() {
		
		String clientMsg;
		
		System.out.println("A new TCP client has connected from TCP/IP address "+cs.getInetAddress().toString()+" on Port "+cs.getLocalPort()+" Thread ID: "+threadId);
		
		try {
			BufferedReader in;
						
			while(true) { // Run until the client sends the "quit" message.
				if(cs.isOutputShutdown()) {
					// If the client disconnects.
					System.out.println("TCP Client Disconnected Unexpectedly.  Thread ID: "+threadId);
					break;
				}
				
				//Get message from the client
				in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
				clientMsg = in.readLine();
								
				//Check to see if the client is letting you know it quit.
				if(clientMsg.equalsIgnoreCase("quit")) {
					System.out.println("TCP Client Disconnected from TCP/IP address "+cs.getInetAddress().toString()+".  Thread ID: "+threadId);
					break;
				} else {
					//If the client didn't quit, then receive the message and let the client know you
					//received it.
					System.out.println("Received TCP Message: "+clientMsg+"  :: Thread ID: "+threadId);
					PrintWriter out = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
					
					out.println("Server Received TCP Message: "+clientMsg);
					out.flush();
					//Then flush the pipes.
				}
				
			}
			
		} catch(SocketException e) { // Fail Gracefully
			System.out.println("Unexpected Socket Closure.  :: Thread ID: "+threadId);
		} catch(IOException e) {
			System.out.println("Unexpected IO Error.  :: Thread ID: "+threadId);
			//e.printStackTrace();
		} finally { // And when it's all said and done.
			System.out.println("Thread ID "+threadId+" terminated.");
		}
	}

}
