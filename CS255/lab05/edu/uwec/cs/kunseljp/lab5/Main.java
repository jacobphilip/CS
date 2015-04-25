package edu.uwec.cs.kunseljp.lab5;

import java.util.ArrayList;

public class Main {

	/**
	 create a List of Point1Ds,
	 pass List of Point1Ds to closest pair finding algorithms will return the distance of the closest pair of points.
	 Main should print out both the original List and the computed distance.
	 */
	public static void main(String[] args) {
		
		ClosestPair cPair = new ClosestPair();
		
		// [7 4 12 14 2 10 16 6]
		System.out.println("PROBLEM 1:");
		System.out.println();
		ArrayList<Point1D> point1DList = new ArrayList<Point1D>();

		// add values to point1d list
		point1DList.add(new Point1D(7));
		point1DList.add(new Point1D(4));
		point1DList.add(new Point1D(12));
		point1DList.add(new Point1D(14));
		point1DList.add(new Point1D(2));
		point1DList.add(new Point1D(10));
		point1DList.add(new Point1D(16));
		point1DList.add(new Point1D(6));

		System.out.println("Original List: " + point1DList.toString());

		System.out.println("Closest Pair Distance: "
				+ cPair.closestPairDistance(point1DList));
		System.out.println();
		
		// [7 4 12 14 2 10 16 5]
		System.out.println("PROBLEM 2:");
		System.out.println();
		ArrayList<Point1D> point1DList2 = new ArrayList<Point1D>();
		
		// add values to point1d list
		point1DList2.add(new Point1D(7));
		point1DList2.add(new Point1D(4));
		point1DList2.add(new Point1D(12));
		point1DList2.add(new Point1D(14));
		point1DList2.add(new Point1D(2));
		point1DList2.add(new Point1D(10));
		point1DList2.add(new Point1D(16));
		point1DList2.add(new Point1D(5));

		System.out.println("Original List: " + point1DList2.toString());

		System.out.println("Closest Pair Distance: " + cPair.closestPairDistance(point1DList2));
		System.out.println();

		// [14 8 2 6 3 10 12]
		System.out.println("PROBLEM 3:");
		System.out.println();
		ArrayList<Point1D> point1DList3 = new ArrayList<Point1D>();

		// add values to point1d list
		point1DList3.add(new Point1D(14));
		point1DList3.add(new Point1D(8));
		point1DList3.add(new Point1D(2));
		point1DList3.add(new Point1D(6));
		point1DList3.add(new Point1D(3));
		point1DList3.add(new Point1D(10));
		point1DList3.add(new Point1D(12));

		System.out.println("Original List: " + point1DList3.toString());

		System.out.println("Closest Pair Distance: "
				+ cPair.closestPairDistance(point1DList3));
		System.out.println();

	}

}


	/**
	demo examples:
	1.	[7, 4, 12, 14, 2, 10, 16, 6]
	2.	[7, 4, 12, 14, 2, 10, 16, 5]
	3.	[14, 8, 2, 6, 3, 10, 12]
	
	O-(n*log(n)
	Same as mergeSort??
	
	**/


