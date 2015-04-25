package edu.uwec.cs.kunseljp;

public class DocumentGenerator {

	public static void main(String[] args) {
		String fileName = "edu/uwec/cs/kunseljp/nintendoStyle.grm.txt";
		
		// Read in the grammar into data structures
		Grammar g = new Grammar(fileName);
		
		// Generate a random sentence from the grammar
		String sentence = g.generateSentence();
		// Display the sentence
		System.out.println(sentence);
		
	}
}
