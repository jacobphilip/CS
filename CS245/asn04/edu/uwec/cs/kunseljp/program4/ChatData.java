
package edu.uwec.cs.kunseljp.program4;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ChatData implements Serializable {

	protected String userName;
	protected String message;

	public ChatData(String userName, String message) {
		this.userName = userName;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getUsername() {
		return userName;
	}
}
