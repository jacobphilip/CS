package edu.uwec.cs.cs255.kunseljp.graphcoloring;

import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
//		BoundingBrackerDepth bt = new BoundingBrackerDepth();
		BoundingBrackerBreadth bt2 = new BoundingBrackerBreadth();
//		BoundingBrackerBest bt3 = new BoundingBrackerBest();
		
		// Define the graph from the ppt
		boolean[][] graph = { 
				{ false, true, true }, 
				{ true, false, true },
				{ true, true, false } };
		
		// Define the colors used in the ppt
		List<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
		colors.add("Yellow");
		
		// Define the weights used in the ppt
		List<Integer> weights = new ArrayList<Integer>();
		weights.add(2);
		weights.add(3);
		weights.add(5);
		weights.add(2);
		
		State s = new GraphColoringState(graph, colors, weights);
		
//		System.out.println("depth"); //19
//		State result = bt.backtrackerIterative(s);
//		System.out.println(result);
		
		System.out.println("breadth"); //41
		State result2 = bt2.backtrackerIterative(s);
		System.out.println(result2);
		
		// Not Completed
//		System.out.println("best");
//		State result3 = bt3.backtrackerIterative(s);
//		System.out.println(result3);
		
	}

}
