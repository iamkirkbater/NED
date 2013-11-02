/**
 * @author Kirk Bater
 * @version
 * 
 * $Log
 * 
 * $Id
 *
 */

import java.net.InetAddress;
import java.util.*;

public class Server {

	/**
	 * @param args
	 */
	
	String message = "";
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("Server Started at IP Address: "+InetAddress.getLocalHost()+".");
		
		//Randomly select a port between 3001 and 27050 as starting point
		// I chose 27050 because that leaves plenty of ports above the last one to work with.
		Random gen = new Random();
		int handOffStartPort = 0;
		
		while(handOffStartPort > 3001 || handOffStartPort < 27050) {
			handOffStartPort = gen.nextInt();
		}
		
		//Start threading
		Thread init = new Thread();
		
		
		TCPServer tcpServer = new TCPServer(60500);
		
		while(true) {
			
			
		}

	}
	
	public boolean printMsg(String s) {
		System.out.println(s);
		return true;
	}

}
