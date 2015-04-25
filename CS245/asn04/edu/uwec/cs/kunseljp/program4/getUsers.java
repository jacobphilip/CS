
package edu.uwec.cs.kunseljp.program4;

import java.io.*;
import java.net.*;
import java.util.*;

public class getUsers implements Runnable {

	public Socket s;
	public static Object o;

	@SuppressWarnings("unchecked")
	public void run() {
		try {

			// waits for updated data
			while (true) {
				try {
					// Create an input stream to read in objects.
					InputStream is = s.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					o = ois.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				// find out what kind of object that is being sent in and then
				// adds it to the panel
				if (o.getClass().equals(ArrayList.class)) {
					ArrayList temp = (ArrayList) o;

					// users
					if (temp.get(0).getClass().equals(String.class)) {
						Painter.fillUsers(temp);

						// chat data
					} else if (temp.get(0).getClass().equals(ChatData.class)) {
						Painter.fillChat(temp);

						// primitives
					} else {
						for (int i = 0; i < temp.size(); i++) {
							Painter.middle.addPrimitive((PaintingPrimitive) temp.get(i));
						}
					}
					// painting primitive
				} else {
					PaintingPrimitive pp1 = (PaintingPrimitive) o;
					Painter.middle.addPrimitive(pp1);
				}

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public getUsers(Socket is) {
		s = is;
	}

}
