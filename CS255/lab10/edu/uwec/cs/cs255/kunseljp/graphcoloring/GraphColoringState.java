package edu.uwec.cs.cs255.kunseljp.graphcoloring;

import java.util.List;

public class GraphColoringState implements State {

	// class variables
	private boolean[][] graph;
	private List<String> colors;
	private int nr;
	private int nc;
	private String[] colorsList;
	
	
	public GraphColoringState(boolean[][] graph, List<String> colors) {
		this.graph = graph;
		for (int i = 0; i < graph.length; i++){
			for (int j = 0; i < graph.length; i++) {
				this.graph[i][j] = graph[i][j];
			}
		}
		this.colors = colors;
		colorsList = new String[graph.length];
		for (int i = 0; i < colorsList.length; i++){
			this.colorsList[i] = "\t";
		}
	}
	
	
	public GraphColoringState(GraphColoringState graphColoringState) {
		this.graph = graphColoringState.graph;
		for (int i = 0; i < graphColoringState.graph.length; i++){
			for (int j = 0; i < graphColoringState.graph.length; i++){
				this.graph[i][j] = graphColoringState.graph[i][j];
			}
		}
		this.colors = graphColoringState.colors;
		colorsList = new String[graph.length];
		for (int i = 0; i < colorsList.length; i++){
			this.colorsList[i] = graphColoringState.colorsList[i];
		}
		this.nr = graphColoringState.nr;
		this.nc = graphColoringState.nc;
	}

	
	
	// Tell us if it has more children
	public boolean hasMoreChildren() {
		int n = colors.size();
		return (nr < n);
	}

	// Tell us if it is feasible
	public boolean isFeasible() {
		boolean returnVariable = true;
		
		if (nc > 0){
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
		if (this.isFeasible() && nc == graph.length){
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
			output = output + colorsList[i] + "\t";
		}
		return output;
	}

}
