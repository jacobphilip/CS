package edu.uwec.cs.kunseljp.game;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {

	int maxLevel = 0;
	
	// constructor
	public MiniMax(int maxLevel){
		this.maxLevel = maxLevel;
	}
	
	
	public TwoPlayerGameBoard generateNextMove(TwoPlayerGameBoard currentProblem){
		List<TwoPlayerGameBoard> children = new ArrayList<TwoPlayerGameBoard>();
		while (currentProblem.hasMoreChildren()) {
			children.add(currentProblem.nextChild());
		}
		TwoPlayerGameBoard child = null;
		ArrayList<TwoPlayerGameBoard> ties = new ArrayList<TwoPlayerGameBoard>();
		double highest = Integer.MIN_VALUE;
		for (TwoPlayerGameBoard cChild : children) {
			if (cChild != null) {
				double temp = recursiveMiniMaxAlphaBeta(cChild, 1,
						Integer.MIN_VALUE, Integer.MAX_VALUE);
				if (temp > highest) {
					ties.clear();
					ties.add(cChild);
					highest = temp;
					child = cChild;
				} else if(temp == highest) {
					ties.add(cChild);
				}
			}
		}
		int rand = (int)(Math.random() * ties.size());
		System.out.println(rand);
		child = ties.get(rand);
		child.reset();
		return child;
	}
	
	private double recursiveMiniMaxAlphaBeta(TwoPlayerGameBoard currentProblem, int currentLevel,
			double alpha, double beta){
		
		if (!currentProblem.hasMoreChildren()
				|| currentProblem.evaluateValue() != 0 || currentLevel == this.maxLevel) {
			return currentProblem.evaluateValue();
		}
		
//		If level is a minimizing level:
//			As long as we have more children and alpha is still smaller than beta
//				Evaluate the next child, passing it the current alpha and beta
//				If the value returned from the child is smaller than beta, replace beta
//			Return beta as our cost
//		If level is a maximizing level:
//			As long as we have more children and alpha is still smaller than beta
//				Evaluate the next child, passing it the current alpha and beta
//				If the value returned from the child is larger than alpha, replace alpha
//			Return alpha as our cost

		if (currentLevel % 2 == 0) {
			// Maximizing level
			while (currentProblem.hasMoreChildren() && alpha < beta) {
				TwoPlayerGameBoard child = currentProblem.nextChild();
				if (child != null) {
					double temp = recursiveMiniMaxAlphaBeta(child,
							currentLevel + 1, alpha, beta);
					if (temp > alpha) {
						alpha = temp;
					}
				}
			}
			return alpha;
		} else {
			// Minimizing level
			while (currentProblem.hasMoreChildren() && alpha < beta) {
				TwoPlayerGameBoard child = currentProblem.nextChild();
				if (child != null) {
					double temp = recursiveMiniMaxAlphaBeta(child,
							currentLevel + 1, alpha, beta);
					if (temp < beta) {
						beta = temp;
					}
				}
			}
			return beta;
		}
	}
}
