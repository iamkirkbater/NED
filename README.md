NED
===

Client/Server Networking Project using TCP/IP and UDP connections and threading.

===
INSTALLATION:

Please read each step thoroughly before attempting the step.

Steps 1, 2, and 3 may already be taken care of on the Lab computers.

Step 1: Make sure you have a Java SDK.  This has been tested on both 7u5 and 7u45.  You can currently download 
        (as of 12-2-2013) Java JDK 7u45 from http://www.oracle.com/technetwork/java/javase/downloads/index.html.
        Follow any on-screen instructions to install the JDK.  Make note of the installation directory of the JDK,
        because you will be needing this in the next step.  For additional assistance, consult Java Documentation.

Step 2: Find wherever you installed the JDK (Windows defaults to:
        C:\Program Files\Java\jdk.7.X_XX\, or C:\Program Files (x86)\Java\jdk.7.X_XX for 32 bit versions, where the
        X's are replaced by version numbers.  Again, this has only been tested on Java 7.
        
Step 3: Open up a command prompt.  Navigate to where you unzipped this folder, and then type:
        set path=C:\path\to\your\java\jdk.7.X_XX\bin
        
        Make sure you add \bin at the end of your jdk path.  This lets your command line know to check the jdk folder
        for any programs (javac) that will be called later.
        
Step 4: Compile both the Server and the Client by running the following commands, one after another:

        javac Server.java
        
        javac Client.java
        
Step 5: As long as there are no errors in compiling (be sure to check the MD5 hash of the files if they don't compile)
        and your command line has been set up to find your java compiler, you should be able to run the server and client
        at this point, by issuing the commands:
        
        java Server
        
        and
        
        java Client
        
        respectively.  You will only be able to start one instance of the Server, which spools up both TCP and UDP
        server threads for all successive connections.  This server, in theory, should be able to take as many clients
        as you want to throw at it, however, hardware and memory restrictions may limit this.  I have tested this with
        up to 10 TCP clients all connected at once, and as many UDP clients as you want.
