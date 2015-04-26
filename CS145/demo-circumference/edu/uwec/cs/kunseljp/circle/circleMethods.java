package edu.uwec.cs.kunseljp.circle;
import javax.swing.*;
public class circleMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final double PI = Math.PI;							//Declare the value of PI
		double R = 15.0;									//Declare the value of R
		double Circumference = PI*R*2.0;					//Calculate the value of Circumference
		JOptionPane.showMessageDialog(null,"The circumference of a circle with the diameter of 15 is " + Circumference + ".");	//Display the value of Circumference
	}

} 
