package edu.uwec.cs.kunseljp.lab5;

import java.util.*;

public class ClosestPair {
	
	public ArrayList<Double> distances = new ArrayList<Double>();;
	
	public double closestPairDistance(List<Point1D> points){
		// performs Collection.sort
		Collections.sort(points);

		// print to console the sorted points
		System.out.println("Collections.sort points: " + points);
		System.out.println();

		// call recursive method
		double closestPairDistance = recursiveClosestPairDistance(points);

		return closestPairDistance;
		
	}

	private double recursiveClosestPairDistance(List<Point1D> sortedPoints){
		// setup variables
		double distance = 0;
		List<Point1D> lefthalf = null;
		List<Point1D> righthalf = null;
		
		// base case
		if (sortedPoints.size() == 1) {
			return -1;
		} else {
			// find mid point
			int mid = 0;
			if (sortedPoints.size() > 1) {
				mid = sortedPoints.size() / 2;
			}

			// sort list into 2 halves
			if (sortedPoints.size() > 1) {
				lefthalf = sortedPoints.subList(0, mid);
				righthalf = sortedPoints.subList(mid, sortedPoints.size());
				System.out.println("lefthalf of list: " + lefthalf);
				System.out.println("righthalf of list: " + righthalf);
			}		
			
			// compute the distance
			if (distance != -1) {

				distance = righthalf.get(0).coordinate - lefthalf.get(0).coordinate;
				distances.add(distance);
				System.out.println("Distance: " + distance);
				System.out.println("Distances: " + distances);
				System.out.println();
				
				
//				for(int i = 0; i > distances.size(); i++) {
//					double tempDistance = 0;
//					if (tempDistance < distance) {
//						distance = tempDistance;
//					}
//				}
				
			}

			
			// compute left side
			recursiveClosestPairDistance(lefthalf);
			// compute right side
			recursiveClosestPairDistance(righthalf);			
			
			
			
			return distance;
		}
	}
}
