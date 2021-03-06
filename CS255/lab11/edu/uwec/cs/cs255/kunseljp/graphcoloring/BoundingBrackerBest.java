package edu.uwec.cs.cs255.kunseljp.graphcoloring;

import java.util.Iterator;
import java.util.PriorityQueue;

public class BoundingBrackerBest {
	public State backtrackerIterative(State s) {
		// This is used to keep track of the number of states for which
		// we need to examine
		int numberOfStatesExpanded = 0;

		State bestSolution = null;

		// Initialize the statesToProcess data structure
		PriorityQueue<State> statesToProcess = new PriorityQueue<State>();

		statesToProcess.add(s);

		// While there are still states to process
		while (!statesToProcess.isEmpty()) {
			// Remove the next state from the data structure
			
			Iterator<State> i = statesToProcess.iterator();			
			State currentState = i.next();
			statesToProcess.remove(currentState);
			numberOfStatesExpanded++;
			

			// Check to see if the state is solved
			if (currentState.isSolved()) {
				// Replace the best solution if the current solution is
				// better
				
				if (bestSolution == null) {
					bestSolution = currentState;
				} else if (currentState.getBound() < bestSolution.getBound()) {
					bestSolution = currentState;
				}

			} else { // The state is not solved

				// Check to see if we need to continue expanding the
				// state
				// This is where the bound pruning occurs
				// Recall that we cannot prune until we have a solution
				// to prune against

				if (currentState.hasMoreChildren() || !(bestSolution == null)) {
					// Expand the state by producing all its
					// children
					
					while (currentState.hasMoreChildren()) {

						State childState = currentState.nextChild();

						// Add each child that is feasible to
						// the data structure
						if (childState.isFeasible()) {
							statesToProcess.add(childState);
						}

					}
				}
			}
		}

		System.out.println(numberOfStatesExpanded);
		return bestSolution;

	}
}
