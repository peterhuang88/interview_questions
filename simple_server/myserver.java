import java.net.*;
import java.io.*;

public class myserver {
	public myserver(int port) {
		// start server
		server = new ServerSocket(port);
		System.out.println("Starting server");

		System.out.println("Waiting on client..");

		socket = server.accept();
		System.out.println("Client accepted");

		String line = "";

		while (!line.equals("Over")) {
			try {
				line = in.readUTF();
			}
		}
	}
}