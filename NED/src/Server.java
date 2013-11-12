/**
 * @author Kirk Bater
 * @version
 * 
 * $Log
 * 
 * $Id
 *
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class Server extends Thread {

	/**
	 * @param args
	 */
	
	public int TCPHandOffPort = 30500;
	public int UDPHandOffPort = 30500;
	
	public void newTCPServer() throws Exception{
		TCPServer newServer = new TCPServer(TCPHandOffPort);
		TCPHandOffPort++;
		newServer.start();
	}
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("Server Started at IP Address: "+InetAddress.getLocalHost()+".");
		
		//Start threading
		Thread init = new Thread();
		
		//Start Default TCP Server
		TCPServer tcpServer = new TCPServer(60500);
		
		tcpServer.start();
		
		//UDP Server

	}
}
