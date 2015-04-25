package edu.uwec.cs.kunseljp.lab6;

public class Checking extends Account {
	protected double minBalance;
	protected double perUseCharge;

	public Checking(int aNumber) {
		super(aNumber);
	}

	public Checking(int aNumber, double aBalance, double aMinBal, double aCharge) {
		super(aNumber, aBalance);
		minBalance = aMinBal;
		perUseCharge = aCharge;
	}

	public String toString() {
		return super.toString() + "\nMin Balance: " + minBalance
				+ "\nPer Use Charge: " + perUseCharge;
	}

	public boolean equals(Object obj) {
		Checking c = null;
		boolean result = false;
		try {
			c = (Checking) obj;
			result = (super.equals(c) && (this.minBalance == c.minBalance) && (this.perUseCharge == c.perUseCharge));
		} catch (Exception e) {

		}
		return result;
	}

	public int compareTo(Object obj) {
		Checking c = null;
		int result = 0;
		try {
			c = (Checking) obj;
			if (super.equals(c)) {
				// If minimum balances are equal, compare the per use charges
				if (this.minBalance == c.minBalance) {
					if (this.perUseCharge > c.perUseCharge) {
						result = 1;
					} else if (this.perUseCharge < c.perUseCharge) {
						result = -1;
					} else {
						result = 0;
					}
					// If minimum balances are different, use them for
					// comparison
				} else if (this.minBalance >= c.minBalance) {
					result = 1;
				} else {
					result = -1;
				}
				// If balances from Account are different, use that for primary
				// comparison
			} else {
				result = super.compareTo(c);
			}
		} catch (Exception e) {
			result = super.compareTo(obj);
		}
		return result;
	}

	public void withdraw(double amt) {
		amt += perUseCharge;
		if ((balance - amt) >= minBalance) {
			balance -= amt;
		} else {
			System.out.println("There is not enough money in the acount.");
		}
	}
}