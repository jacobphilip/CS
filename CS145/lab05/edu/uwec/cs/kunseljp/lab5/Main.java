package edu.uwec.cs.kunseljp.lab5;

public class Main {

	public static void main(String[] args) {
		Rational r1 = new Rational (3,2);
		Rational r2 = new Rational (1,2);
		
		System.out.println("Are r1 and r2 equal?");
		System.out.println(r1.equals(r2));
		
		//Displays r1 and r2 on their own lines
		System.out.println();
		System.out.println("The two numbers:");
		System.out.println(r1);
		System.out.println(r2.toString());
		System.out.println();
		
		//Displays r1 + r2
		System.out.println("Addition of the two numbers:");
		System.out.println(r1.add(r2));
		System.out.println();
		
		//Displays r1 - r2
		System.out.println("Subtraction of the two numbers:");
		System.out.println(r1.subtract(r2));
		System.out.println();
		
		//Displays r1 * r2
		System.out.println("Multiplication of the two numbers:");
		System.out.println(r1.multiply(r2));
		System.out.println();
		
		//Displays r1 / r2
		System.out.println("Division of the two numbers:");
		System.out.println(r1.divide(r2));
		System.out.println();
		
		Rational r3 = r1.clone(r1);
		System.out.println(r3);	//Prints 3/2
		r1.square();
		System.out.println(r1); //Prints 9/4
		System.out.println(r3); //Prints 3/2

	}

}
