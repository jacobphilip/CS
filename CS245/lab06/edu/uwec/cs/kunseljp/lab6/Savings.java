package edu.uwec.cs.kunseljp.lab6;

public class Savings extends Account {
	protected double interestRate = 0;

	public Savings(int aNumber) {
		super(aNumber);
	}

	public Savings(int aNumber, double aRate) {
		super(aNumber, aRate);
		
	}

	public Savings(int aNumber, double aRate, double aBalance) {
		super(aNumber, aBalance);
		interestRate = aRate;
	}

	public String toString() {
		return super.toString() + "\nInterest Rate: " + interestRate;
	}

	public boolean equals(Object obj) {
		Savings s = null;
		boolean result = false;
		try {
			s = (Savings) obj;
			result = (super.equals(s) && (this.interestRate == s.interestRate));
		} catch (Exception e) {

		}
		return result;
	}

	public int compareTo(Object obj) {
		Savings s = null;
		int result = 0;
		try {
			s =(Savings) obj;
			if(super.equals(s)) {
				if(this.interestRate == s.interestRate) {
					result = 0;
				} else if (this.interestRate > s.interestRate) {
					result = 1;
				} else {
					result = -1;
				}
				// If balances from Account are different, use that for primary comparison
			} else {
				result = super.compareTo(s);
			}
		} catch (Exception e) {
			result = super.compareTo(obj);
		}
		return result;
	}
	
	public void addInterest() {
		balance += (balance*interestRate);
	}
}