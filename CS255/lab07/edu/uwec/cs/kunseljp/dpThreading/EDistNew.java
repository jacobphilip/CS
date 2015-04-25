package edu.uwec.cs.kunseljp.dpThreading;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class EDistNew {
	public int[][] optimalEDist;
	public Semaphore[][] semaphoreTable;

	public EDistNew() {

	}

	public class Foo implements Runnable {

		private int i;
		private int j;
		private String word1;
		private String word2;

		public Foo(int i, int j, String word1, String word2) {
			this.i = i;
			this.j = j;
			this.word1 = word1;
			this.word2 = word2;
		}

		public void process() {

			try {
				semaphoreTable[i - 1][j].acquire(1);
				semaphoreTable[i][j - 1].acquire(1);
				semaphoreTable[i - 1][j - 1].acquire(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int value1 = optimalEDist[i - 1][j - 1];
			if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
				value1++; // +1 if the char are different
				// note we subtracted 1 from the charAt to account for the empty
				// string difference
			}
			int value2 = optimalEDist[i - 1][j] + 1;
			int value3 = optimalEDist[i][j - 1] + 1;

			// Select the min of these values
			int min = Math.min(value1, Math.min(value2, value3));
			optimalEDist[i][j] = min;
			semaphoreTable[i][j].release(3);
		}

		public void run() {
			process();
		}

	}

	public int findEDistThreaded(String word1, String word2) {

		this.semaphoreTable = new Semaphore[word1.length() + 1][word2.length() + 1];
		this.optimalEDist = new int[word1.length() + 1][word2.length() + 1];
		ArrayList<Thread> threads = new ArrayList<Thread>();

		System.out.println(semaphoreTable.length);

		for (int i = 0; i < semaphoreTable.length; i++) {
			for (int j = 0; j < semaphoreTable.length + 1; j++) {
				semaphoreTable[i][j] = new Semaphore(0);
			}
		}

		// Init the 2D table
		// We add +1 for the empty string in position 0
		for (int i = 0; i < word1.length() + 1; i++) {
			optimalEDist[i][0] = i;
			semaphoreTable[i][0].release(3);
		}
		for (int i = 1; i < word2.length() + 1; i++) { // Not 0 since we already
			// set 0,0
			optimalEDist[0][i] = i;
			semaphoreTable[0][i].release(3);
		}

		for (int i = 1; i < word1.length() + 1; i++) {
			for (int j = 1; j < word2.length() + 1; j++) {
				threads.add(new Thread(new Foo(i, j, word1, word2)));
			}

		}

		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
		}

		// Prints out the Table

		for (int i = 0; i < threads.size(); i++) {
			try {
				((Thread) threads.get(i)).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < optimalEDist.length; i++) {
			for (int j = 0; j < optimalEDist.length; j++) {
				System.out.print(optimalEDist[i][j] + "\t");
			}
			System.out.println("");
		}

		// Returns the bottom right hand value
		return optimalEDist[word1.length()][word2.length()];

	}

	public static void main(String[] args) {
		EDistNew ed = new EDistNew();
		System.out.println("\nEdit Distance: " + ed.findEDistThreaded("sort", "sport"));
	}
}
