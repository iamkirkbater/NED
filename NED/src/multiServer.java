import java.net.*;
import java.io.*;


public class multiServer {
	
	//start serversocket
	Socket cs = null;
	
	while (true) {
		cs = ss.accept();
		ThreadServer ths = new ThreadServer(cs);
		ths.start();
	}
	

}


class ThreadServer extends Thread {
	Socket cs;
	public ThreadServer (Socket cs) {
		this.cs = cs;
	}
	
	public void run() {
		// Same as SimpleServer
	}
}