import java.util.*;

public class Client {

	public static void main(String [] args) {
		/*
		 * Run the Client process.  Takes no args from the command line,
		 * as this program asks for all of the input.  Spins up either
		 * a TCP/IP Client or UDP Client.
		 */

		Scanner scan = new Scanner(System.in);
		
		// Get server address from user.
		System.out.print("Enter the Server IP address: ");		
		String server = scan.nextLine();
		
		String type;	
		boolean accept = false;
		
		do {
			System.out.print("Enter \"TCP\" to start a TCP/IP client or \"UDP\" for a UDP Client: ");
			//Listen for the answer to the question, and convert their answer to lowercase
			//so we don't have to have 5 million case statements for all possible permutations of
			//the string.
			type = scan.nextLine();
			type = type.toLowerCase();
			
			switch(type) {
			  case "tcp": case "\"tcp\"":
			  case "\"tcp": case "tcp\"":
				  // if it's tcp (with or without quotes for all the smartasses out there ;)
				  // reset type to TCP and break out of the loop.
				  type = "TCP";
				  accept=true;
				  break;
			  case "udp": case "\"udp\"":
			  case "\"udp": case "udp\"":
				  //Same thing as TCP, but with UDP.
				  type = "UDP";
				  accept=true;
				  break;
			}
			
			if(!accept) { // If it wasn't a usable choice
				System.out.println("Unacceptable choice.  Please try again.");
			}
			
		} while (!accept); // Do it at least once, and more if they don't choose from the correct options
				
		if (type.equals("TCP")) { // If they selected a TCP Client,
			TCPClient client = new TCPClient(server);
			client.run();
			//Start the TCP Client Process
		} else if (type.equals("UDP")) { // Otherwise if they selected a UDP Client
			UDPClient client = new UDPClient(server);
			client.run();
			//Start the UDP Client process
		}
		
		//Close our scanner.
		scan.close();
	}
	
}
