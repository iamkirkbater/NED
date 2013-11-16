import java.net.*;
import java.io.*;


public class UDPServer implements Runnable {
	
	DatagramSocket s;
	
	public UDPServer(DatagramSocket s) {
		this.s = s;
	}
	
	public void run() {
		
		try {
			DatagramPacket p;
			
			while(true) {
				p = new DatagramPacket(new byte [1024], 1024);
				
				s.receive(p);
				
				String msg = new String(p.getData());
				
				System.out.println("Received UDP Datagram: "+msg);
				
			}
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
