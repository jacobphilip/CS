
package edu.uwec.cs.kunseljp.program4;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread implements Runnable {

	@SuppressWarnings("unchecked")
	public static ArrayList sendData = new ArrayList();
	public static ArrayList<String> userNames = new ArrayList<String>();
	public static ArrayList<ChatData> chatInfo = new ArrayList<ChatData>();
	public static ArrayList<String> incoming = new ArrayList<String>();
	public static ArrayList<sendUserList> openStreams = new ArrayList<sendUserList>();
	public static ArrayList<PaintingPrimitive> ppList = new ArrayList<PaintingPrimitive>();
	public static int chatSize = 0;
	public static int ppSize = 0;
	private Socket s;

	public ServerThread(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			// input and output streams
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			// Reads in the username
			String username = null;
			try {
				username = (String) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// Adds the username
			userNames.add(username);
			System.out.println("User connected: " + username);
			oos.writeObject(userNames);
			sendUserList ul = new sendUserList(s, username, userNames);
			openStreams.add(ul);

			// send out new data to clients
			if (chatSize > 0) {
				sendToAll(chatInfo);
			}

			// send out user information
			sendToAll(userNames);

			// send out updated graphics to all clients
			if (ppSize > 0) {
				sendToAll(ppList);
			}

			// everything should be sent out now just have the server wait for
			// new information to be sent in.
			boolean connected = true;
			while (connected) {
				try {
					// new input stream.
					InputStream is2 = s.getInputStream();
					ObjectInputStream ois2 = new ObjectInputStream(is2);
					Object incoming = null;

					try {
						// reads in new object
						incoming = ois2.readObject();

						// determine what is sent in and then send it to the
						// clients
						if (incoming.getClass().equals(ChatData.class)) {
							ChatData incoming2 = (ChatData) incoming;
							chatInfo.add(incoming2);
							chatSize++;
							sendToAll(chatInfo);
						} else {
							PaintingPrimitive incoming2 = (PaintingPrimitive) incoming;
							ppList.add(incoming2);
							ppSize++;
							sendToAll(incoming2);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

					// disconnect
				} catch (SocketException e) {
					// prints the service status
					System.out.println("User Disconnected: " + username);
					connected = false;

					// remove user from socket list
					for (int i = 0; i < openStreams.size(); i++) {
						if (openStreams.get(i).equals(ul)) {
							openStreams.remove(i);
						}
					}

					// remove user from list of usernames
					for (int i = 0; i < userNames.size(); i++) {
						if (userNames.get(i).equals(username)) {
							userNames.remove(i);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// A method for sending out Arrays to all connected clients.
	@SuppressWarnings("unchecked")
	public synchronized void sendToAll(ArrayList o) {
		for (int i = 0; i < openStreams.size(); i++) {
			openStreams.get(i).updateSendData(o);
		}

		for (int i = 0; i < openStreams.size(); i++) {
			Thread ult = new Thread(openStreams.get(i));
			ult.start();
		}
	}

	// A method for sending out Graphics to all connected clients.
	public synchronized void sendToAll(PaintingPrimitive o) {
		for (int i = 0; i < openStreams.size(); i++) {
			openStreams.get(i).updateSendData(o);
		}

		for (int i = 0; i < openStreams.size(); i++) {
			Thread ult = new Thread(openStreams.get(i));
			ult.start();
		}
	}
}
