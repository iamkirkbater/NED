import java.net.*;
import java.io.*;
import java.util.*;

public class Client {

	public static void main(String [] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("TCP Client Started.");
			
			System.out.print("Enter the Server IP address: ");
			String server = scan.nextLine();
			
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
				msg = scan.nextLine();
				if(msg.equals("quit")){
					break;
				}
				post.println(msg);
				post.flush();
				
				System.out.println("TCP Server Returns: "+bin.readLine());

				post.flush();
			}
			
			bin.close();
			scan.close();
			post.close();
			s.close();
			
		} catch(IOException e) {
			System.out.println("IO Error");
			e.printStackTrace();
		}
	}
	
}
