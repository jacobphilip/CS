package edu.uwec.cs.kunslejp.lab3;
import java.text.DecimalFormat;
import javax.swing.*;

public class Overload {

	
	public static void main(String[] args) {
		int loanAmount = 3500;
		double annualInterestRate = 0.06;
		int loanTerm = 3;
		int monthlyPayment = 100;
		
		JOptionPane.showMessageDialog
		(null,"The amount of the monthly loan payment is:\n" + cFormat(computeLoan(loanAmount, annualInterestRate, loanTerm)));
		
		JOptionPane.showMessageDialog
		(null,"The loan amount is:\n" + computeLoan(annualInterestRate, monthlyPayment, loanTerm));
		
		JOptionPane.showMessageDialog
		(null,"The total number of payments is:\n" + computeLoan(monthlyPayment, loanAmount, annualInterestRate));
	}
	
	
	//method loan payment with input loan amount, interest rate, and loan term (in years).
	public static double computeLoan(int loanAmount, double annualInterestRate, int loanTerm){
		double monthlyInterestRate = annualInterestRate / 12.0;
		double monthlyPayment = ((loanAmount) * monthlyInterestRate) /
			(1.0 - (1.0 / Math.pow(1.0 + monthlyInterestRate, 12.0 * loanTerm)));
		double loanPaymentValue = monthlyPayment;
		return loanPaymentValue;
	}
	
	
	//method loan amount with input desired payment amount, interest rate, and loan term (in years).
	public static int computeLoan(double annualInterestRate, int monthlyPayment, int loanTerm){
		double monthlyInterestRate = (annualInterestRate / 12.0);
		double loanAmount = (monthlyPayment / monthlyInterestRate) * ( 1 - Math.pow((1 + monthlyInterestRate), (loanTerm * -12 )));
		return (int)loanAmount;
	}
	
	
	//method number of payments with input loan amount, desired payment amount, and interest rate.
	public static int computeLoan( int monthlyPayment, int loanAmount, double annualInterestRate){
		double monthlyInterestRate = annualInterestRate / 12;
		double totalNumberOfPayments = -Math.log(1 - monthlyInterestRate*loanAmount/monthlyPayment)/(Math.log(1 + monthlyInterestRate));
		return (int)totalNumberOfPayments;
	}
	
	
	//method to format number to two decimal places.
	static private String cFormat(double value) {

		DecimalFormat myFormatter = new DecimalFormat("00.00");

		String output = myFormatter.format(value);

		return output;

	}
}
