package edu.uwec.cs.kunseljp.lab1;

import java.text.*;

import javax.swing.*;

public class CreditCard {

	public static void main(String[] args) {
		double balance = 2000.0;
		double monthlyInt = .019;
		double suggestedMonthlyPay = 200.00;
		double monthlyPay = 0.0;
		String inputMonthlyPay = "";

		
		try {
			while (monthlyPay < (balance * monthlyInt)) {
				inputMonthlyPay = JOptionPane
						.showInputDialog(null,
								"Please enter the payment amount.",
								suggestedMonthlyPay);
				monthlyPay = Double.parseDouble(inputMonthlyPay);
				if (monthlyPay < ((balance * monthlyInt) + .01)) {
					JOptionPane
							.showMessageDialog(
									null,
									"The number you entered is too low.\nYou will never pay off the debt.\nPlease try again.");
					System.exit(1);
				}
			}

		} catch (NumberFormatException a) {
			JOptionPane.showMessageDialog(null,
					"You did not enter a valid number.  Please try again.");
			System.exit(2);
		} catch (NullPointerException b) {
			JOptionPane.showMessageDialog(null,
					"You did not enter a valid number. Please try again.");
			System.exit(3);
		}
		
		
		System.out.println("Starting Balance: " + balance + "\n\n");
		System.out
				.println("EndOfMonth#\tPayment\t\tInterestPaid\tPrinciplePaid\tBalance");
		
		
		
		int currentMonth = 1;

		while (balance > 0) {
			double currentIntPaid = balance * monthlyInt;
			double currentPrinciplePaid = monthlyPay - currentIntPaid;
			double currentBalance = balance - currentPrinciplePaid;

			NumberFormat nf = NumberFormat.getCurrencyInstance();

			if (balance < monthlyPay) {
				monthlyPay = balance + currentIntPaid;
				currentPrinciplePaid = monthlyPay - currentIntPaid;
				currentBalance = balance - currentPrinciplePaid;
			}

			System.out.println(currentMonth + "\t\t" + nf.format(monthlyPay)
					+ "\t\t" + nf.format(currentIntPaid) + "\t\t"
					+ nf.format(currentPrinciplePaid) + "\t\t"
					+ nf.format(currentBalance));
			currentMonth++;
			balance = currentBalance;
		}
	}
}
