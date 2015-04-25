package edu.uwec.cs.cs255.kunseljp.graphcoloring;

import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		Backtracker bt = new Backtracker();
		
		// Define the graph from the ppt
		boolean[][] graph = 
			{{false,  true, false, false, false,  true},
			 { true, false,  true, false, false,  true},
			 {false,  true, false,  true,  true, false},
			 {false, false,  true, false,  true, false},
			 {false, false,  true,  true, false,  true},
			 { true,  true, false, false,  true, false}};
		
		// Define the colors used in the ppt
		List<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
		
		
		State s = new GraphColoringState(graph, colors);
		
		State result = bt.backtrack(s);
		System.out.println(result);
	}

}
