import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class TCPClient {

	String server;
	Scanner scanner = new Scanner(System.in);
	
	public TCPClient(String server) {
		//Creates a new TCPClient instance.
		this.server = server;
	}
	
	public void run() {
		try {
			
			System.out.println("TCP Client Started Successfully.  To exit, type \"quit\".");
			
			//Make a connection
			Socket s = new Socket(server, 35050);
			
			//Open input from server
			InputStream in = s.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			
			//Open Output to server
			OutputStream out = s.getOutputStream();
			PrintWriter post = new PrintWriter(new OutputStreamWriter(out));
			
			while(true) {
				System.out.print("Enter a message: ");
				String msg = "";
				msg = this.scanner.nextLine();
				//Get message to be sent to the server
				
				
				//Send the message to the server.
				post.println(msg);
				post.flush();
				
				
				//If they want to quit
				if(msg.equalsIgnoreCase("quit")){
					break;
				}
				
				//Print out what the server returns and flush the pipe.
				System.out.println("TCP Server Returns: "+bin.readLine());
				post.flush();
			}
			
			//Close all the resources
			bin.close();
			this.scanner.close();
			post.close();
			s.close();
			
		} catch(IOException e) { //Gracefully fail if there's an error.
			System.out.println("IO Error");
			//e.printStackTrace();
		}
	}	
	
}
