package edu.uwec.cs.kunseljp.program2;

import java.awt.geom.Point2D;
import java.util.List;

public class MergeHull implements ConvexHullFinder {

	@Override
	public List<Point2D> computeHull(List<Point2D> points) {
		
		// If the list is null, return null
		
		
		// Sort the points from leftmost to rightmost
		// Use Collections.sort
		
		
		// Call the recursive method with sorted points
		return recursiveMergeHull(points);
	}

	private List<Point2D> recursiveMergeHull(List<Point2D> points){
		
		// Base Case: if only one point, return that point.
		
		// Divide the list into two equal parts
		
		// using recursion, find the hull of each half
		
		// Combine the two hulls
		
			// Find the rightmost point in the left hull and the leftmost point in the right hull
		
			// Connect these points together
		
			// Now walk it down until it is the lower tangent line.
				
				// See pseudo code in handout
		
			// Now walk it up
		
		// Return the list of hulls
		
		return null;
	}
	
}
