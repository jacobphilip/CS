
package edu.uwec.cs.kunseljp.program4;

import java.io.*;
import java.net.*;
import java.util.*;

public class sendUserList implements Runnable {

	public Socket s;
	public Object sendData;

	@SuppressWarnings("unchecked")
	public sendUserList(Socket s, String username, ArrayList data) {
		this.s = s;
		this.sendData = data;
	}

	@SuppressWarnings("unchecked")
	public synchronized void updateSendData(ArrayList data) {
		this.sendData = data;

	}

	public synchronized void updateSendData(PaintingPrimitive pp) {
		this.sendData = pp;

	}

	// Creates a new thread for sending out data
	public void run() {
		try {
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(sendData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
