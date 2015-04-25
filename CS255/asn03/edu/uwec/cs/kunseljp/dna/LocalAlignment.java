package edu.uwec.cs.kunseljp.dna;

import javax.swing.JTextField;
import javax.swing.text.Caret;

// class that glues the final alignment information together.  An alignment can’t be 
// returned as a simple String, because an alignment involves two strings.

public class LocalAlignment {

	// variables
	private String string1;
	private String string2;
	private int string1MatchStart;
	private int string2MatchStart;
	private int matchLength;
	
	// Where string1 and string2 are the full strings, complete with matched
	// subsections. That is, junk prefixes, matched sections (complete with
	// gaps), and junk suffixes. The ints simply record where the actual
	// matching substrings start and end.
	public LocalAlignment(String string1, String string2,
			int string1MatchStart, int string2MatchStart, int matchLength) {
		this.string1 = string1;
		this.string2 = string2;
		this.string1MatchStart = string1MatchStart;
		this.string2MatchStart = string2MatchStart;
		this.matchLength = matchLength;

	}

	// Since we don’t really want the GUI to reach into this class and grab its
	// pieces to display the output, we will instead provide a method that the
	// GUI will call to get the final alignment displayed in the JTextFields it
	// has created.
	public void showAlignment(JTextField string1Field, JTextField string2Field) {
		// counter to keep track of how many movements
		int move = 0;
		
		for (int i = 0; i < (string1MatchStart - string2MatchStart); i++) {
			string2 = " " + string2;
			move++;
		}

		// setText on the JTextFields
		string1Field.setText(string1);
		string2Field.setText(string2);

		// create and get carets
		Caret c;
		Caret c2;
		c = string1Field.getCaret();
		c2 = string2Field.getCaret();

		// highlight selected text
		c.setDot(string1MatchStart);
		c.moveDot(string1MatchStart + matchLength);
		c2.setDot(string2MatchStart + move);
		c2.moveDot(string2MatchStart + matchLength + move);

		c.setSelectionVisible(true);
		c2.setSelectionVisible(true);

		// set up caret
		string1Field.setCaret(c);
		string2Field.setCaret(c2);
	}

}
