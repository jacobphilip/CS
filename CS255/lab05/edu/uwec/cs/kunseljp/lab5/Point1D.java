package edu.uwec.cs.kunseljp.lab5;

//	class to define a 1D point.

public class Point1D implements Comparable<Point1D>{
	double coordinate;
	
	public Point1D(double x){
//		Constructs a new Point1D given the 1 coordinate
		this.coordinate = x;
	}
	
	public double distance(Point1D p){
//		returns the distance between the Point1d and the given Point1D, p.
		double distance;
		
		if (p.coordinate > this.coordinate) {
			distance = p.coordinate - this.coordinate;
		} else {
			distance = this.coordinate - p.coordinate;
		}

		return distance;
	}
	
	public String toString(){
//		returns a String representation of the Point1D so it can be printed nicely for debugging purposes
		String returnString = "";

		double d = this.coordinate;

		returnString = Double.toString(d);

		return returnString;
	}
	
	public int compareTo(Point1D point){
		Point1D that;
		that = (Point1D) point;

		if (this.coordinate < that.coordinate)
			return -1;
		if (this.coordinate > that.coordinate)
			return 1;

		return 0;
	}

}
