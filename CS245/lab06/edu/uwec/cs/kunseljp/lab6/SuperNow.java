package edu.uwec.cs.kunseljp.lab6;

public class SuperNow extends Checking {
	protected double interestRate = 0;

	public SuperNow(int aNumber) {
		super(aNumber);
	}

	public SuperNow(int aNumber, double aRate) {
		super(aNumber);
		interestRate = aRate;
	}

	public SuperNow(int aNumber, double aBalance, double aMinBal, double aCharge, double aRate) {
		super(aNumber, aBalance, aMinBal, aCharge);
		interestRate = aRate;
	}

	public String toString() {
		return super.toString() + "\nInterest Rate: " + interestRate;
	}

	public boolean equals(Object obj) {
		SuperNow s = null;
		boolean result = false;
		try {
			s = (SuperNow) obj;
			result = (super.equals(s) && (this.interestRate == s.interestRate));
		} catch (Exception e) {

		}
		return result;
	}

	public int compareTo(Object obj) {
		SuperNow s = null;
		int result = 0;
		try {
			s = (SuperNow) obj;
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