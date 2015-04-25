package edu.uwec.cs.cs255.kunseljp.graphcoloring;

public class Backtracker {
	
	// Takes in root state, returns solved state (if any)
	// Assumes s is feasible
	public State backtrack(State s) {
		
		System.out.println(s);
		
		State result = null;
		
		// Base case
		if (s.isSolved()) {
			result = s;
		} else {    // Recursive case
			
			// Bail out when we find a single solution
			while (s.hasMoreChildren() && (result == null)) {
				State child = s.nextChild();
				
				System.out.println("-->" + child);
				
				if (child.isFeasible()) {
					result = backtrack(child);
				}
			}
		}
		
		return result;
	}

}
