import java.net.*;
import java.io.*;

public class myserver {
	public myserver(int port) {
        try {
    		// start server
    		ServerSocket server = new ServerSocket(port);
	    	System.out.println("Starting server");

    		System.out.println("Waiting on client..");

    		Socket socket = server.accept();
	    	System.out.println("Client accepted");

		    String line = "";

            BufferedReader clientIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            try {
                System.out.println("hey something connected");
                line = clientIn.readLine();
                System.out.println(line);
            } catch (IOException i) {
                System.out.println(i);
            }
            System.out.println("Closing connection");
            socket.close();
            clientIn.close();

        } catch (IOException e) {
            System.out.println(e);
        }
	}

    public static void main(String[] args) {
        myserver serv = new myserver(8000);    
    }
}
