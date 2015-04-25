package edu.uwec.cs.kunseljp.lab2;

public class FiniteRepresentation {

	public static void main(String[] args) {
		final double TOL = 0.00001;
		// keep going until x is within TOL of zero
		for (double x = 10;Math.abs(x) > TOL; x = (x - 0.2)){
			System.out.println(x);}
		}
	}