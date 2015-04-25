package edu.uwec.cs.kunslejp.lab3;
import javax.swing.*;
public class ScopeSwap {
//main method that shows the original numbers, calls swap, and then shows the values after the method.
	public static void main(String[] args) {
		int numberOne = 1;
		int numberTwo = 2;
		JOptionPane.showMessageDialog(null, 
				"The original numbers before the swap are:\n" 
				+ numberOne 
				+ "\n" 
				+ numberTwo);
		
		swap(numberOne, numberTwo);
		
		JOptionPane.showMessageDialog(null,
				"The new values of are:\n"
				+ numberOne
				+ "\n"
				+ numberTwo);
		
	}
//method that swaps the values of numberOne and numberTwo and returns nothing.
	public static String swap(int numberOne, int numberTwo){
		int temp = 13;
		temp = numberOne;
		numberOne = numberTwo;
		numberTwo = temp;
		JOptionPane.showMessageDialog(null,
				"The swapped numbers are:\n"
				+ numberOne
				+ "\n"
				+ numberTwo);
		return "";
		
		
	}
}
