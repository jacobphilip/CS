package edu.uwec.cs.ernste.sorting;

public class Main {
	
	//Nested class to handle the thread
	private static class WorkerThread implements Runnable {
		private int[][] ourArray;
		private int[] maxRow;
		private int row;
		
		
		// Note that we aren't making a copy of anything so the array is shared
		// between all threads which is what we want
		public WorkerThread(int row, int[][] ourArray, int[] maxRow) {
			this.row = row;
			this.ourArray = ourArray;
			this.maxRow = maxRow;
		}

		// Find the maximum value in our particular piece of the array
		public void run() {
			int max = Integer.MIN_VALUE;
			for (int k = 0; k < 10; k++)
				max = Math.max(max, ourArray[row][k]);
			maxRow[row] = max;
		}

		//put the thread creation & starting altogether
		public Thread start() {
			Thread th = new Thread(this);
			th.start();
			return th;
		}
	}
	public static void main(String[] args) {
		//create an array of threads
		Thread[] rowThreads = new Thread[10];
		int[][] bigMatrix = getBigHairyMatrix();
		int[] maxRow = new int[10];
		int max = Integer.MIN_VALUE;
		// Give each thread a slice of the matrix to work with
		for (int i=0; i < 10; i++) {
			WorkerThread wt = new WorkerThread(i, bigMatrix, maxRow);
			rowThreads[i] = wt.start();
		}
		// Wait for each thread to finish
		try {
			for (int i=0; i < 10; i++) {
				rowThreads[i].join();
				max = Math.max(max, maxRow[i]);
			}
		}
		catch (InterruptedException e) {
			// fall through
		}
		System.out.println("Maximum value was " + max);
	}	
	
	public static int[][] getBigHairyMatrix() {
		int[][] BHM = new int[10][10];
		for(int i = 0; i < 10; i++) {
			String row = "";
			for(int j = 0; j < 10; j++) {
				double rand = Math.random(); // Get a random double in the range [0.0 ... 1.0)
				int first = ((int) (rand*10));  // Change the range to(-100..100)
				int base = (int) (rand*1000) - first*100;
				int p = base;
				if(first % 2 == 0) p *= -1;
				//System.out.println(rand + "; " + first + "; " + base + "; " + p);
				BHM[i][j] = p;
				row += p + "\t";
			}
			System.out.println(row);
		}
		return BHM;
	}
}
