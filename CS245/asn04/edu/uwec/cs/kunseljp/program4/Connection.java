
package edu.uwec.cs.kunseljp.program4;

import java.io.*;
import java.net.*;

public class Connection {

	public Connection() {
		try {
			ServerSocket ss = new ServerSocket(1337);

			// waits for new clients then creates a new thread
			while (true) {
				Socket s = ss.accept();
				ServerThread st = new ServerThread(s);
				Thread th = new Thread(st);
				th.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Server is running.");
		new Connection();
	}

}
