package edu.uwec.cs.kunseljp.dpThreading;

// This is the single threaded implementation of chained MatrixMult

// Note that in the ppt we are indexing the matrices at 1, but here
// we are indexing them starting at 0.
// However, the dims array is the same as in the ppt
// We also don't create a second table to use to traceback and determine
// the optimal paren of the matrix.

public class MatrixMult {
	
	public MatrixMult() {
		
	}
	
	public int findOptimalMult(int[] dims) {
		
		// Init the 2D table
		// There is one less matrix than dims
		int n = dims.length-1;
		int[][] optimalMult = new int[n][n];
		
		// Fill in the base case values
		// This is the middle diagonal
		for (int i=0; i<n; i++) {
			optimalMult[i][i] = 0;			
		}
		
		// Trying to get to the upper right corner
		// Each position requires all the values to the left and below it
		// Thus we fill in diagonal by diagonal
		
		for (int dia=1; dia<n; dia++) {  // selects the diag col
			for (int i=0; i<(n-dia); i++) {  // the number of values in that diag col
				
				// Find the j value for the current position
				int j=dia+i;
				
				// Setup for a running min for each position
				int minM = Integer.MAX_VALUE;
				for (int k=i; k<j; k++) {
					
					// Need to adjust the dims values due to the indices change in the matrices
					int Mijk = optimalMult[i][k] + optimalMult[k+1][j] + (dims[i] * dims[k+1] * dims[j+1]);
					
					if (Mijk < minM) {
						minM = Mijk;
					}
				}
				optimalMult[i][j] = minM;
			}
		}
		
		// Return upper right
		return optimalMult[0][n-1];
	}

	public static void main(String[] args) {
		// Create the dimensions array that represents the dimensions of
		// the matrices we are about to multiply
		// Example from ppt -- 6 matrices
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
