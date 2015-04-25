package edu.uwec.cs.kunseljp.lab1;

import javax.swing.JOptionPane;

public class ComputeLoanAmount {

	public static void main(String[] args) {

		/** ******************************************************************** */

		/*
		 * Program to calculate a loan amount based on a given interest
		 * rate(6.9),
		 */

		/* payment amount($60 a month, and number of years(3) to repay */

		/* Created by Jacob Kunselman */

		/* Date last modified: 10/23/2008 */

		/* ******************************************************************** */

		// variables representing input interest rate
		String inputAnnualInterestRate= JOptionPane.showInputDialog(null,
				"Enter the annual interest rate as a percentage, \nsuch as 7.5:", "Interest Rate",
				JOptionPane.QUESTION_MESSAGE);
		double monthlyInterestRate = Double.parseDouble(inputAnnualInterestRate)/12/100;
		
		// variables representing length of loan in years and months
		String inputAnnualLengthOfLoan= JOptionPane.showInputDialog(null,	
				"Enter the annual length of the loan, \nsuch as 4.0:" , "Loan Length" ,
				JOptionPane.QUESTION_MESSAGE);
		double annualLengthOfLoan = Double.parseDouble(inputAnnualLengthOfLoan);
		double totalMonthlyPayments = annualLengthOfLoan * 12;
		
		// variable representing payment amount
		String inputMonthlyPaymentAmount= JOptionPane.showInputDialog(null,
				"Enter the monthly payment amount, \nsuch as 75.0:" , "Monthly Payment" ,
				JOptionPane.QUESTION_MESSAGE);
		double monthlyPaymentAmount = Double.parseDouble(inputMonthlyPaymentAmount);
		
		// calculate the loan amount
		double loanAmount = (monthlyPaymentAmount/monthlyInterestRate) * 
			(1 - Math.pow(1 + monthlyInterestRate , -totalMonthlyPayments));
		
		// format loan amount to the nearest dollar
		double rndLoanAmount = (int)loanAmount;
		
		// display loan amount in a dialog box
		JOptionPane.showMessageDialog(null,"The amount of the loan I can afford = $" + rndLoanAmount);
	}

}
