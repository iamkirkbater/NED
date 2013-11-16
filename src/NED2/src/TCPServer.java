import java.io.*;
import java.net.*;

public class TCPServer extends Thread {
	
	private int threadId;
	private Socket cs;
	
	public TCPServer(int threadId, Socket cs) {
		this.threadId = threadId;
		this.cs = cs;
	}
	
	public void run() {
		
		String clientMsg;
		
		System.out.println("A new TCP client has connected.  Thread ID: "+threadId);
		
		try {
			BufferedReader in;
			DataOutputStream out;
						
			while(true) {
				if(cs.isOutputShutdown()) {
					System.out.println("TCP Client Disconnected.  Thread ID: "+threadId);
					break;
				}
				
				in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
				clientMsg = in.readLine();
				
				System.out.println("Received TCP Message: "+clientMsg+"  :: Thread ID: "+threadId);
				
				if(clientMsg.equals("quit")) {
					System.out.println("TCP Client Disconnected.  Thread ID: "+threadId);
					break;
				} else {
					out = new DataOutputStream(cs.getOutputStream());
					
					out.writeBytes("Server Received TCP Message: "+clientMsg);
				}
				
			}
			
		} catch(SocketException e) {
			System.out.println("Unexpected Socket Closure.  :: Thread ID: "+threadId);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Thread ID "+threadId+" terminated.");
		}
	}

}
