package edu.uwec.cs.cs255.kunseljp.graphcoloring;

import java.util.LinkedList;
import java.util.List;

public class BoundingBrackerDepth {

	public State backtrackerIterative(State s) {
		// This is used to keep track of the number of states for which
		// we need to examine
		int numberOfStatesExpanded = 0;

		State bestSolution = null;

		// Initialize the statesToProcess data structure
		List<State> statesToProcess = new LinkedList<State>();

		statesToProcess.add(s);

		// While there are still states to process
		while (!statesToProcess.isEmpty()) {
			// Remove the next state from the data structure

			State currentState = statesToProcess.get(0);
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

				if ((bestSolution == null) || bestSolution.getBound() > currentState.getBound()) {

					while (currentState.hasMoreChildren()) {

						State childState = currentState.nextChild();

						// Add each child that is feasible to
						// the data structure
						if (childState.isFeasible()) {
							statesToProcess.add(0, childState);
						}
					}
				}
			}
		}

		System.out.println(numberOfStatesExpanded);
		return bestSolution;
	}

}
