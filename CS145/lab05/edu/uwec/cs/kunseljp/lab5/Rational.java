package edu.uwec.cs.kunseljp.lab5;

public class Rational {
	int n;			//Represents this rational number's numerator
	int d;			//Represents this rational number's denominator
	
	public Rational(){
	
	}
	public Rational(int num, int denom){
		n = num;
		d = denom;
	}
	public Rational(int num){
		n = num;
		d = 1;
	}
	//method to test if r1 and r2 are equal.
	public boolean equals(Rational aRational){
		if ((n * aRational.d) == (d * aRational.n)){
			return true;
		} else {
			return false;
		}
	}
	//method to square the rational number
	public void square(){
		n = n * n;
		d = d * d;
	}
	//method to multiply rational numbers n1 * n2 / d1 * d2
	public Rational multiply(Rational aRational){
		int newNum = n * aRational.n;
		int newDenom = d * aRational.d;
		return (new Rational(newNum, newDenom));
	}
	//method to divide rational numbers n1/d1 / n2/d2
	public Rational divide(Rational aRational){
		int newNum = n * aRational.d;
		int newDenom = d * aRational.n;
		return (new Rational(newNum, newDenom));
	}
	//method to add rational numbers
	public Rational add(Rational aRational){
		int newNum1 = n * aRational.d;
		int newNum2 = d * aRational.n;
		int newNum = newNum1 + newNum2;
		int newDenom = d * aRational.d;
		return (new Rational(newNum, newDenom));
	}
	//method to subtract rational numbers
	public Rational subtract(Rational aRational){
		int newNum1 = n * aRational.d;
		int newNum2 = d * aRational.n;
		int newNum = newNum1 - newNum2;
		int newDenom = d * aRational.d;
		return (new Rational(newNum, newDenom));
	}
	//method to convert a Rational number to a String
	public String toString(){
		return (new String(n + "/" + d));
	}
	//method to convert a Rational number to a decimal approximation
	public double doubleValue(){
		return ((double)n / (double)d);
	}
	//Clone Method
	public Rational clone(Rational aRational){
		return (new Rational(aRational.n, aRational.d));
	}
	//setRational
	public void setRational(int newnum, int newden){
		n = newnum;
		d = newden;
	}
}
