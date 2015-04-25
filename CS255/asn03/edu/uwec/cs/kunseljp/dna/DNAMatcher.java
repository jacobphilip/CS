package edu.uwec.cs.kunseljp.dna;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class DNAMatcher {

	// class variables
	private String string1, word2;
	private int highScore;
	private Map<String, Integer> matchCost;
	private int[][] optimalCost;
	private int[][] traceBack;
	private int matchLength;
	private int string1MatchStart, string2MatchStart;
	private int iHigh = 0;
	private int jHigh = 0;
	private Semaphore[][] semaphoreTable;

	// constructor that takes in a Map of the individual matching
	// costs. It is the GUIs job to gather this information from the GUI and
	// create the Map that is sent to this constructor.
	public DNAMatcher(Map<String, Integer> matchCost) {
		this.matchCost = matchCost;
	}

	// takes 2 strings and matches them, returning the result in a
	// LocalAlignment object. To complete the alignment task, this method needs
	// to perform two main tasks: compute the local alignment tables and
	// generate the actual alignment from those tables this is done using 2
	// private helper methods.
	public LocalAlignment findLocalAlignment(String string1, String string2) {
		this.string1 = string1;
		this.word2 = string2;

		// compute tables
		computeOptimalAlignmentTable();

		// align tables
		generateAlignmentFromTable();

		// return new object
		// pass it the setup class variables
		return new LocalAlignment(string1, word2, string1MatchStart,
				string2MatchStart, matchLength);
	}

	private void computeOptimalAlignmentTable() {

		// create an arraylist to hold the threads
		ArrayList<Thread> threads = new ArrayList<Thread>();

		// add 1 for the empty string in position 0
		optimalCost = new int[string1.length() + 1][word2.length() + 1];
		traceBack = new int[string1.length()][word2.length()];
		semaphoreTable = new Semaphore[string1.length() + 1][word2.length() + 1];

		// go through the table and add semaphores
		for (int i = 0; i < string1.length() + 1; i++) {
			for (int j = 0; j < word2.length() + 1; j++) {
				semaphoreTable[i][j] = new Semaphore(0);
			}
		}

		for (int i = 0; i < string1.length() + 1; i++) {
			semaphoreTable[i][0].release(3);
		}
		for (int i = 1; i < word2.length() + 1; i++) {
			semaphoreTable[0][i].release(3);
		}

		// go to the bottom right by filling in the values row by row
		for (int i = 1; i < string1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {
				threads.add(new Thread(new Matcher(i, j, string1, word2)));
			}
		}

		// start the threads
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}

		// attempt to join the threads
		for (int i = 0; i < threads.size(); i++) {
			try {
				((Thread) threads.get(i)).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void generateAlignmentFromTable() {
		// find the highest score and store it. Store the highest i and j values
		// also.
		for (int i = 0; i < string1.length() + 1; i++) {
			for (int j = 0; j < word2.length() + 1; j++) {
				int tempHighScore = optimalCost[i][j];
				if (tempHighScore > highScore) {
					iHigh = i;
					jHigh = j;
					highScore = tempHighScore;
				}
			}
		}

		// set the match length to the highest j
		matchLength = jHigh;

		int temp = 1;
		int currIndex = word2.length();

		// certain cases for tracing back
		while (temp != 0) {
			temp = traceBack[iHigh - 1][jHigh - 1];

			if (temp == 1) {
				iHigh = iHigh - 1;
				jHigh = jHigh - 1;
				currIndex--;
			} else {
				if (temp == 3) {
					word2 = word2.substring(0, currIndex) + "-"
							+ word2.substring(currIndex, word2.length());
					iHigh = iHigh - 1;
					currIndex--;
				} else {
					if (temp == 2) {
						string1 = string1.substring(0, currIndex)
								+ "-"
								+ string1
										.substring(currIndex, string1.length());
						jHigh = jHigh - 1;
						currIndex--;
					}
				}

			}

		}

		// setting up the positions to start for passing to local alignment
		string1MatchStart = iHigh;
		string2MatchStart = jHigh;

	}

	public class Matcher implements Runnable {

		// class variables
		private int i;
		private int j;
		private String string1;
		private String string2;

		// default constructor
		public Matcher(int i, int j, String string1, String string2) {
			this.i = i;
			this.j = j;
			this.string1 = string1;
			this.string2 = string2;
		}

		public void process() {

			// try to acquire
			try {
				semaphoreTable[i - 1][j].acquire(1);
				semaphoreTable[i][j - 1].acquire(1);
				semaphoreTable[i - 1][j - 1].acquire(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// tempStrings to hold found strings
			String tempString1 = "" + string1.charAt(i - 1);
			String tempString2 = "" + string2.charAt(j - 1);

			String tempS1 = tempString1 + tempString2;
			String tempS2 = tempString2 + "-";
			String tempS3 = "-" + tempString2;

			int value1 = (optimalCost[i - 1][j - 1]) + (matchCost.get(tempS1));
			int value2 = (optimalCost[i - 1][j]) + (matchCost.get(tempS2));
			int value3 = (optimalCost[i][j - 1]) + (matchCost.get(tempS3));

			int max = 0;
			int traceNum = 0;

			// cases for the trace back table
			if (value1 > max) {
				max = value1;
				traceNum = 1;
			}
			if (value2 > max) {
				max = value2;
				traceNum = 3;
			}
			if (value3 > max) {
				max = value3;
				traceNum = 2;
			}

			// add max to tables
			if (max >= 0) {
				optimalCost[i][j] = max;
				traceBack[i - 1][j - 1] = traceNum;
				semaphoreTable[i][j].release(3);
			}

		}

		public void run() {
			process();

		}

	}
}