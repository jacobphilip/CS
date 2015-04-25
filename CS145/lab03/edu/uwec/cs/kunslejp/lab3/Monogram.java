package edu.uwec.cs.kunslejp.lab3;
import javax.swing.*;
public class Monogram {

	public static void main(String[] args) {
	String first = JOptionPane.showInputDialog(null, "Enter your first initial:");
	String middle = JOptionPane.showInputDialog(null, "Enter your middle initial:");
	String last = JOptionPane.showInputDialog(null, "Enter your last initial:");
	showMonogramConsole(first, middle, last);
	JOptionPane.showMessageDialog(null,returnSortedMonogram(first, middle, last));

	}

	public static String showMonogramConsole(String first, String middle, String last){
		System.out.println(first + middle + last);
		System.out.println(last + first + middle);
		return "";
	}
	public static String returnSortedMonogram(String first, String middle, String last){
		String output = (last + first + middle);
		return output;
	}
}
