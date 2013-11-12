
import java.net.*;
import java.io.*;


public class MultiServer {
	
	BufferedReader br;
	PrintWriter opw;
	
	try{
		ServerSocket ss = new ServerSocket( 30500);
		
		while(true) {
			
			Socket cs = ss.accept();
			br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			
			opw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
			
			String clientMsg = br.readLine();
			
			opw.println(clientMsg);
			
			opw.flush();
		}
	}
	catch (IOException ioe) {
		ioe.printStackTrace();
	}

}
