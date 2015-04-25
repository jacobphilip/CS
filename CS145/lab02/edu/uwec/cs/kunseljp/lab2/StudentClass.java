package edu.uwec.cs.kunseljp.lab2;
import javax.swing.*;

public class StudentClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	String inputCredits= JOptionPane.showInputDialog(null,
		"Enter the total number of college credits\nyou have earned, such as 34:", "Interest Rate",
		JOptionPane.QUESTION_MESSAGE);
	double credits = Double.parseDouble(inputCredits);
	if (credits < 0)
		{
		JOptionPane.showMessageDialog(null,
			"The input number must be positive");
	}	else if (credits <= 29 && credits > 0)
		{
		JOptionPane.showMessageDialog(null, "Freshman");
		}
		else if (credits <= 59 && credits > 29 )
		{
		JOptionPane.showMessageDialog(null, "Sophomore");
		}
		else if (credits <= 99 && credits > 59)
		{
		JOptionPane.showMessageDialog(null, "Junior");
		}
		else if (credits > 99)
		{
		JOptionPane.showMessageDialog(null, "Senior");
		}
	}

}
