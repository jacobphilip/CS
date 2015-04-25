package edu.uwec.cs.kunseljp.dpThreading;

import java.util.ArrayList;

public class MatrixMultNew {

	// shared variables
	int[] tempDims;
	int min;
	int[][] optimalMult;

	public MatrixMultNew() {

	}
	
	public int findOptimalMult(int[] dims) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		tempDims = dims;

		// Init the 2D table
		// There is one less matrix than dims
		int n = dims.length - 1;
		optimalMult = new int[n][n];

		// Fill in the base case values
		// This is the middle diagonal
		for (int i = 0; i < n; i++) {
			optimalMult[i][i] = 0;
		}
		// selects the diag col
		for (int diagCol = 1; diagCol < n; diagCol++) { 
			// the number of values in that diag col
			for (int diagNum = 0; diagNum < (n - diagCol); diagNum++) { 
				
				
				// Find the i,j value for the current position
				int i = diagNum;
				int j = diagCol + diagNum;
				// create a new thread for each diagonal
				NewDiag diagonal = new NewDiag(i, j);
				Thread th = new Thread(diagonal);
				th.start();
				threads.add(th);

			}

			// attempt to collect all the results
			for (int i = 0; i < threads.size(); i++) {
				try {
					threads.get(i).join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		// Return upper right
		return optimalMult[0][n - 1];
	}
	
	// class that calculates each diagonal
	public class NewDiag implements Runnable {
		
		int ii;
		int jj;

		public NewDiag(int r, int t) {
			this.ii = r;
			this.jj = t;
		}

		public void run() {
			// does the actual computation for a particular
			// matrix (code was originally in the inner loop)
			min = Integer.MAX_VALUE;
			for (int k = ii; k < jj; k++) {
				// Need to adjust the dims values due to the indices change in
				// the matrices
				int value = optimalMult[ii][k] + optimalMult[k + 1][jj]
						+ (tempDims[ii] * tempDims[k + 1] * tempDims[jj + 1]);
				if (value < min) {
					min = value;
				}
			}
			optimalMult[ii][jj] = min;
		}
	}
	
	public static void main(String[] args) {
		int[] dims = new int[7];
		dims[0] = 5;
		dims[1] = 2;
		dims[2] = 3;
		dims[3] = 4;
		dims[4] = 6;
		dims[5] = 7;
		dims[6] = 8;

		MatrixMult mm = new MatrixMult();
		System.out.println(mm.findOptimalMult(dims));
	}

}
