package edu.uwec.cs.kunseljp.lab2;

import java.util.*;

import javax.swing.*;

public class WordCount {

	public static void main(String[] args) {
		//input string
		String allText;
		allText = JOptionPane.showInputDialog("Please enter some words.");
		//new array of words that have been split
		String[] splitText = allText.split("[\\s]");
		
		//creates new array lists to be used in the sorting method
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> words = new ArrayList<String>();
		
		//method to check the words for duplicates
		wordCheck(splitText, words, count);
		//method to print results
		printResults(words, count);
	}
	//method that checks how many times each word occurs
	public static void wordCheck(String[] splitTextArray,ArrayList<String> words, ArrayList<Integer> count) {
		String word = "";
		count.add(0);
		words.add(splitTextArray[0]);
		//sets the word to be checked
		for (int i = 0; i < splitTextArray.length; i++) {
			word = splitTextArray[i];

			//checks the array list for the word
			boolean match = false;
			//loops goes until it runs out of words to check with or it makes it to the end of the list
			for (int x = 0; ((x < (words.size()) && ((match) == false))); x++) {
				if (word.equals(words.get(x))) {
					int counter = count.get(x);
					counter++;
					count.set(x, counter);
					match = true;
				}
			}
			//
			if (match == false) {
				words.add(word);
				count.add(1);
				match = true;
			}
		}
	}
	//method to print the results of the word check
	public static void printResults(ArrayList<String> words, ArrayList<Integer> count) {
		for (int i = 0; i < words.size(); i++) {
			System.out.print(words.get(i) + " - ");
			System.out.print(count.get(i) + "\n");
		}
	}

}
