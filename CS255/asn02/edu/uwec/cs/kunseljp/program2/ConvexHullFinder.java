 package edu.uwec.cs.kunseljp.program2;

import java.awt.geom.Point2D;
import java.util.*;

public interface ConvexHullFinder {
	
	//interface to be used for both QuickHull and MergeHull
	
	public List<Point2D> computeHull(List<Point2D> points);

}
