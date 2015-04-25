package edu.uwec.cs.cs255.kunseljp.graphcoloring;

import java.util.List;

public class GraphColoringState implements State {

	// class variables
	private boolean[][] graph;
	private List<String> colors;
	private int nr;
	private int nc;
	private String[] colorsList = { "a", "a", "a" };
	private List<Integer> weightList;
	private int prevBound;
	
	
	public GraphColoringState(boolean[][] graph, List<String> colors, List<Integer> weights) {
		this.graph = graph;
		this.colors = colors;
		this.weightList = weights;
	}
	
	
	public GraphColoringState(GraphColoringState graphColoringState) {
		this.graph = graphColoringState.graph;
		this.colors = graphColoringState.colors;
		this.nr = graphColoringState.nr;
		this.nc = graphColoringState.nc;
		this.weightList = graphColoringState.weightList;
		this.prevBound = graphColoringState.prevBound + weightList.get(nr);
		
		this.colorsList = new String[graphColoringState.colorsList.length];
		for (int i = 0; i < graphColoringState.colorsList.length; i++){
			this.colorsList[i] = graphColoringState.colorsList[i];
		}
	}

	
	
	// Tell us if it has more children
	public boolean hasMoreChildren() {
		int n = colors.size();
		return (nr < n);
	}

	// Tell us if it is feasible
	public boolean isFeasible() {
		boolean returnVariable = true;
		
		if (nc > 0) {
			for (int i = 0; i < graph.length; i++){
				if (graph[nc -1][i]){
					if (colorsList[nc - 1].compareTo(colorsList[i]) == 0 && (nc > i)){
						returnVariable = false;
					}
				}
			}
		}
		return returnVariable;
	}

	// Tells us if the problem is solved
	public boolean isSolved() {
		if (this.isFeasible() && nc == colorsList.length){
			return true;
		} else {
			return false;
		}
	}

	// Produce the next Child
	public State nextChild() {
		GraphColoringState child = new GraphColoringState(this);
		// modify board
		child.colorsList[nc] = colors.get(nr);
		// setup to produce more children
		this.nr++;
		// setup child to produce more children
		child.nc++;
		child.nr = 0;
		
		return child;
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < colorsList.length; i++){
			output = output + "\t" + colorsList[i];
		}
		return output;
	}

	public int getBound() {
		int nodesToColor = 0;
		for (int i = 0; i < colorsList.length; i++) {

			if (colorsList[i].compareTo("a") == 0) {
				nodesToColor = nodesToColor + 1;
			}
		}

		int minWeight = Integer.MAX_VALUE;
		for (int i = 0; i < weightList.size(); i++) {
			if (weightList.get(i) < minWeight) {
				minWeight = weightList.get(i);
			}
		}

		int bound = prevBound + (nodesToColor * minWeight);
		System.out.println(prevBound + "\t" + nodesToColor);
		return bound;
	}

}
