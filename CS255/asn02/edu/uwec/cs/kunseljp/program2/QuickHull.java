package edu.uwec.cs.kunseljp.program2;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class QuickHull implements ConvexHullFinder {

	public List<Point2D> computeHull(List<Point2D> points) {

		// if the list is null return null

		if ((points == null) || (points.size() == 0)) {

			return null;
		}

		
		// Find the leftmost and rightmost points
		// initialize to the first point in the list

		Point2D leftmost = points.get(0);
		Point2D rightmost = points.get(0);

		// Go through each of the points in the list
		for (Point2D pt1 : points) {
			// if x is lower, then it is to the left
			if (pt1.getX() < leftmost.getX()) {
				leftmost = pt1;
			} else if (pt1.getX() > rightmost.getX()) {
				// if x is higher, then it is to the right
				rightmost = pt1;
			}
		}

		// Create line from leftmost to rightmost point

		Line2D baseline = new Line2D.Double(leftmost, rightmost);

		// Divide the points into two sets, above and below the line.

		List<Point2D> aboveLine = new ArrayList<Point2D>();
		List<Point2D> belowLine = new ArrayList<Point2D>();

		for (Point2D pt1 : points) {

			if (baseline.relativeCCW(pt1) == 1) {
				// 1 is CounterClockWise, above the line
				aboveLine.add(pt1);
			} else if (baseline.relativeCCW(pt1) == -1) {
				// -1 is ClockWise, below the line
				belowLine.add(pt1);
			}
		}

		// Call the recursive method for the top and create the top of the hull

		List<Point2D> topHalf = recursiveQuickHull(baseline, aboveLine);

		// Call the recursive method, for the bottom and create the bottom of the hull

		Line2D reversedLine = new Line2D.Double(baseline.getP2(), baseline
				.getP1());

		List<Point2D> bottomHalf = recursiveQuickHull(reversedLine, belowLine);

		// Once the two halves are created, put them together.

		List<Point2D> hullFound = topHalf;
		if (bottomHalf != null) {
			for (Point2D point1 : bottomHalf) {
				topHalf.add(point1);
			}
		}

		return hullFound;

	}

	private List<Point2D> recursiveQuickHull(Line2D lnAB,
			List<Point2D> ptsAB) {

		List<Point2D> returnList = new ArrayList<Point2D>();

		// base case

		if ((ptsAB == null) || (ptsAB.size() == 0)) {
			// if no points above the line, return endpoint
			returnList.add(lnAB.getP2());
			return returnList;
		}

		// Given a baseline (lineAB) and a set of points above, and a 
		// list of points above the line (pointsAB), find the pointC that is 
		// farthest away from the line.

		// start at first point in list
		Point2D ptC = ptsAB.get(0);
		double tempDistance = lnAB.ptLineDist(ptC);

		// go through each point in the list
		for (Point2D pt1 : ptsAB) {
			double currentDistance = lnAB.ptLineDist(pt1);
			if (currentDistance > tempDistance) {
				// if the current point is farther, it becomes the new point c
				ptC = pt1;
				tempDistance = currentDistance;
			}
		}

		// The next few steps divide the large problem of finding the half-hull
		// of the ptAB into 2 problems of finding the half-hulls of the ptsAC and ptsCB
		
		// create a line from A to C (lnAC)
		Point2D ptA = lnAB.getP1();
		Line2D lnAC = new Line2D.Double(ptA, ptC);

		
		// select all the points to the left of this line (ptsAC)
		List<Point2D> ptsAC = new ArrayList<Point2D>();

		for (Point2D pt1 : ptsAB) {
			if (lnAC.relativeCCW(pt1) == 1) {
				ptsAC.add(pt1);
			}
		}

		// make a line from C to B (lnCB)
		Point2D ptB = lnAB.getP2();
		Line2D lnCB = new Line2D.Double(ptC, ptB);

		// select all points right of this line (ptsCB)

		List<Point2D> ptsCB = new ArrayList<Point2D>();

		for (Point2D pt1 : ptsAB) {
			if (lnCB.relativeCCW(pt1) == 1) {
				ptsCB.add(pt1);
			}
		}

		// Call the recursive methods

		List<Point2D> leftHalfHull = recursiveQuickHull(lnAC, ptsAC);
		List<Point2D> rightHalfHull = recursiveQuickHull(lnCB, ptsCB);

		// This returns two half-hulls
		
		// Next combine the two half-hulls together

		List<Point2D> wholeHull = rightHalfHull;
		// add right points first, then the left points
		if (leftHalfHull != null) {
			for (Point2D point1 : leftHalfHull) {
				wholeHull.add(point1);
			}
		}
		return wholeHull;

	}
	
}
