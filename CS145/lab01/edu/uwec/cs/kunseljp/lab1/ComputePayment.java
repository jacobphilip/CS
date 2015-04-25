package edu.uwec.cs.kunseljp.lab1;

import javax.swing.JOptionPane;

public class ComputePayment {

	public static void main(String[] args) {

		/***********************************************************************/

		/* Program to calculate a loan payment based on a given interest rate, */

		/* loan amount, and number of years to repay */

		/* Created by Joline Morrison, Modified by Jacob Kunselman */

		/* Date last modified: 10/23/2008 */

		/***********************************************************************/

		String inputValue = JOptionPane.showInputDialog(null,

		"Enter the yearly interest rate as a percentage, \nsuch as 6.99:",
				"Interest Rate",

				JOptionPane.QUESTION_MESSAGE);

		// variables representing input yearly interest rate and calculated

		// monthly interest rate

		double annualInterestRate = Double.parseDouble(inputValue) / 100;

		double monthlyInterestRate = annualInterestRate / 12;

		// Message Prompt for number of years

		String numberOfYears = JOptionPane.showInputDialog(null,

		"Enter the number of years, \nsuch as 3.0:", "years",

		JOptionPane.QUESTION_MESSAGE);

		// Message Prompt for number of years

		String loanAmount = JOptionPane.showInputDialog(null,

		"Enter the loan amount, \nsuch as 12000.00:", "loanAmount",

		JOptionPane.QUESTION_MESSAGE);

		// double loanAmount = 12000;

		// calculate the monthly payment

		double monthlyPayment = Double.parseDouble(loanAmount) * monthlyInterestRate /

			(1 - 1 / Math.pow(1 + (monthlyInterestRate), 12.0 * Double.parseDouble(numberOfYears)));

		// format payment to the nearest dollar

		int formattedPaymentAmount = (int) (monthlyPayment * 100);

		monthlyPayment = (double) formattedPaymentAmount / 100;

		// calculate the total amount of interest paid.  total amount paid - the loan amount
		
		double totalAmountPaid = monthlyPayment * Double.parseDouble(numberOfYears) * 12.0;
		
		double totalInterestPaid = totalAmountPaid - Double.parseDouble(loanAmount);
		
		// display monthly payment and total interest paid

		JOptionPane.showMessageDialog(null, "Monthly Payment = $"
				+ monthlyPayment + "\nTotal Interest paid = $" + (int)(totalInterestPaid));
	}

}
