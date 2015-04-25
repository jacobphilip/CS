package edu.uwec.cs.kunseljp.lab1;

import java.io.*;

import javax.swing.*;

public class PhoneBook {
	private static final String fileName = "edu/uwec/cs/kunseljp/lab1/listings.txt";

	public static void main(String[] args) {
		String[][] phoneBook = new String[2][100];
		int numberEntries = initializePhoneBook(phoneBook);
		displayEntriesToConsole(phoneBook, numberEntries);
		lookUpEntries(phoneBook, numberEntries);
	}

	private static void displayEntriesToConsole(String[][] book,
			int numberEntries) {
		for (int y = 0; y < numberEntries; y++) {
			System.out.println(book[0][y] + "\t" + book[1][y]);
		}
	}

	private static void lookUpEntries(String[][] book, int numberEntries) {
		String nameSearch = "default";
		while(!nameSearch.equals("")) {
			try {
				nameSearch = JOptionPane.showInputDialog("Enter the name you're looking for");
				nameSearch = nameSearch.toUpperCase();
			} catch (NullPointerException e) {
				System.exit(0);
			}
			
			String name = "";
			boolean foundMatch = false;
			
			for(int x=0; x<book[0].length && book[0][x] != null; x++) {
				name = book[0][x];
				name = name.toUpperCase();
				if(nameSearch.equals(name)) {
					JOptionPane.showMessageDialog(null, name + ": " + book[1][x]);
					foundMatch = true;
				}
			}
			
			if (!foundMatch && !nameSearch.equals("")) {
				JOptionPane.showMessageDialog(null, "Did not find " + nameSearch + " in the phone book.");
			}
		}
	}

	private static int initializePhoneBook(String[][] book) {
		int entryNumber = 0;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String nextLine = br.readLine();
			while (nextLine != null) {
				String[] splitter = nextLine.split(":");
				
				book[0][entryNumber] = splitter[0];
				book[1][entryNumber] = splitter[1];
				
				nextLine = br.readLine();
				entryNumber++;	
			}
			
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		return entryNumber;
	}
}
