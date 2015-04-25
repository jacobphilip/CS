package edu.uwec.cs.kunseljp;

import java.io.*;
import java.util.*;

public class Grammar {

	

	ArrayList<Rule> Rules = new ArrayList<Rule>();

	
	
	// Constructor that reads in the file and stores the information into
	// instance variables
	public Grammar(String fileName) {

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String nextLine = "";
			nextLine = br.readLine();

			while (nextLine != null && !nextLine.equals("")) {

				Rule newRule = new Rule(nextLine);
				Rules.add(newRule);
				nextLine = br.readLine();

				while (nextLine != null && !nextLine.equals("")) {

					Production newProduction = new Production(nextLine);
					newProduction.add(nextLine);
					newRule.add(newProduction);
					nextLine = br.readLine();

				}
				nextLine = br.readLine();
			}
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	
	// generateSentence method that will produce a new random sentence from the
	// grammar each time it is called
	public String generateSentence() {
		String newSentence = "";
		String finalSentence = "";
		String tmpString = "";
		int counter = 0;
		// gets the production under the start rule
		Production p = Rules.get(0).production;

		// convert the start production to a string.
		String sentence = p.toString();

		// builds an array to put the individual words into
		String[] words = sentence.split("\\s");

		// go through each word in the string
		while (counter <= 6) {
			for (int i = 0; i < words.length; i++) {
				// if word DOES NOT contain < , save it to the new string
				if (!words[i].contains("<")) {
					newSentence += words[i] + " ";

				}
				// if word DOES contain <,
				if (words[i].contains("<")) {
					// loop through the Rules
					for (int j = 1; j < Rules.size(); j++) {
						// match the word to the correct rule
						if ((Rules.get(j).toString()).equals(words[i])) {
							tmpString = (getRandom(Rules.get(j))).toString();

							// i need to go through the tmpString to see if
							// there is another production
							if (tmpString.contains(("<"))) {
								// if found a new production, get a random production from the rule
								tmpString += (getRandom(Rules.get(j)))
										.toString();
								
								//splits the returned production at any '<'
								tmpString = tmpString.substring(0, tmpString
										.indexOf("<"));
								
								//since relative contains a possessive noun, i need to remove it
								if (tmpString.contains("'")) {
									tmpString = tmpString.substring(0,
											tmpString.indexOf("'"));
								}

							}

						}
					}
					//if went through once, then we know we are adding to final sentence
					if (counter > 0) {
						finalSentence += tmpString;
					//adds the production to sentence
					} else {
						newSentence += tmpString + " ";
					}
					finalSentence = newSentence;
				}

			}
			words = newSentence.split("\\s");
			counter++;
		}

		return finalSentence;
	}

	
	// random production generator
	public Production getRandom(Rule rule) {
		Random generator = new Random();
		int rand = generator.nextInt(rule.prods.size());
		return rule.prods.get(rand);

	}
}
