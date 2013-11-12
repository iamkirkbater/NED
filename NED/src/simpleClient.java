
import java.io.*;
import java.net.*;


public class simpleClient {
	
	BufferedReader bin = null;
	PrintWriter pout = null;
	
	try {
		Socket s = new Socket( ipAddress, PORT );
		
		bin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		pout = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

		pout.println( args[1]);
		pout.flush();
		
		System.out.println(args[1]+" <==> " + bin.readLine());
		bin.close();
		pout.close();
		s.close();
		
	} catch (IOException ioe) {
		System.out.println("IO Error");
	}

}
