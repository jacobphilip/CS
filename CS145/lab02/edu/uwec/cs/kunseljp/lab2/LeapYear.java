package edu.uwec.cs.kunseljp.lab2;

import javax.swing.*;

public class LeapYear {

	public static void main(String[] args) {
		String s = "";
		int startYear = 1800;
		int endYear = 2100;
		int count=0;

		for (int year = startYear; year <= endYear; year++) {
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					s = s + " " + year;
					count++;
					if ( count == 5 ){
						s = s + "\n";
						count = 0;
					}
				}
		}
		JOptionPane.showMessageDialog(null, s);
	}

}