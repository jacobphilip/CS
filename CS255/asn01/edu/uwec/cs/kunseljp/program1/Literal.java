package edu.uwec.cs.kunseljp.program1;

public class Literal {
	//Can't be used
	char charVal = '-'; 
	//Needs to be true or ' will appear
	boolean boolVal = true;

	public Literal(char ch, boolean bool) {
		this.charVal = ch;
		this.boolVal = bool;
	}

	public String toSting() {
		String returnString = " ";
		returnString += this.charVal + " ";
		if (this.boolVal) {
			returnString += "true";
		} else
			returnString += "false";
		return returnString;
	}
}
