package edu.uwec.cs255.kunseljp.closure;

public class ShortestPath {

	final static int X = Integer.MAX_VALUE; //Don't change this value
	int[][] w;  // optimal table
	
	public ShortestPath(int[][] adj) {
		// Your code here:
		// for k = 1 to n
		// for i = 1 to n
		// for j = 1 to n
		// wij = wij v (wik ^ wkj)
		
		w = adj;
		
		int i, j, k;
		int n = w.length; // number of nodes
		
		for (k = 0; k < n; ++k){
			for (i = 0; i < n; ++i){
				for(j = 0; j < n; ++j){
					if (adj[i][k] + adj[k][j] >=0){
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					} else {
						adj[i][j] = adj[i][j];
					}
				}
			}
		}
	
		
	}
	
	public String toString() {
		String result = "";
		int n = w.length;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				result += w[i][j] + "\t";
			}
			result += "\n";
		}
		return result;
	}
	
	public int shortestDist(int index1, int index2) {
		return w[index1][index2];
	}
	
		
	public static void main(String[] args) {
		// adj(i,i) has cost of 0
			// if no path then cost of infinity
		int[][] adj = {{0, 3, 8, X, 4},
					   {X, 0, X, 1, 7},
			           {X, 4, 0, X, X},
			           {2, X, 5, 0, X},
				       {X, X, X, 6, 0}};
	
		ShortestPath sp = new ShortestPath(adj);
		System.out.println(sp);
		/* Should produce:
		0   3   8   4   4 
		3	0	6	1	7	
		7	4	0	5	11	
		2	5	5	0	6	
		8	11	11	6	0	
		 */
		
		int s = sp.shortestDist(0, 3);
		System.out.println(s);
	}
}
