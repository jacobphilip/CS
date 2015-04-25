package edu.uwec.cs.kunseljp;

public class Production {

	// Constructor that takes in the line thats read from the file and does the
	// breaking/creating of terminals/non-terminals. This will allow the code
	// for the Grammar constructor to be simplified.
	private String string = "";
	
	public Production(String nextLine) {
		this.string = nextLine;
	}

	public void add(String nextLine) {
		this.string = nextLine;
		
	}
	
	public String toString() {
		return string;
	}
}
