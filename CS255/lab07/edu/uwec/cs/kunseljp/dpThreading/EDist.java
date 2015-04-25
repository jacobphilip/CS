package edu.uwec.cs.kunseljp.dpThreading;

// This is a working EDist single threaded implementation

public class EDist {

	public EDist() {
		
	}
	
	public int findEDist(String word1, String word2) {
		
		// Init the 2D table
		// We add +1 for the empty string in position 0
		int[][] optimalEDist = new int[word1.length()+1][word2.length()+1];
		
		// Fill in the base case values
		// First row and first col
		for (int i=0; i<word1.length()+1; i++) {
			optimalEDist[i][0] = i;
		}
		for (int i=1; i<word2.length()+1; i++) {  // Not 0 since we already set 0,0
			optimalEDist[0][i] = i;
		}	
		
		// We are trying to get to the lower right
		// For each position we need the one above it, the one to the left,
		// and the one to the upper left of it
		// So one approach is to simply fill in the values row by row
		for (int i=1; i<word1.length()+1; i++) {
			for (int j=1; j<word2.length()+1; j++) {
				
				int value1 = optimalEDist[i-1][j-1];
				if (word1.charAt(i-1) != word2.charAt(j-1)) {
					value1++;  // +1 if the char are different
					// note we subtracted 1 from the charAt to account for the empty string difference
				}
				int value2 = optimalEDist[i-1][j] + 1;
				int value3 = optimalEDist[i][j-1] + 1;
				
				// Select the min of these values
				int min = Math.min(value1, Math.min(value2, value3));
				optimalEDist[i][j] = min;
			}
			
		}
		
		// Return the lower right value
		return optimalEDist[word1.length()][word2.length()];
	}
	
	
	public static void main(String[] args) {
		EDist ed = new EDist();
		System.out.println(ed.findEDist("sort", "sport"));

	}

}
