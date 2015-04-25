package edu.uwec.cs.kunseljp.lab6;

public abstract class Account implements Comparable<Object> { 
	protected int number;
	protected double balance;
	
	public Account(int aNumber) {
		number = aNumber;
	}
	
	public Account(int aNumber, double aBalance) {
		number = aNumber;
		balance = aBalance;
	}
	
	public String toString() {
		return "\nAccount number: " + number +"\nBalance: " + balance;
	}
	
	public boolean equals(Object obj) {
		Account a = null;
		boolean result = false;
		try {
		a = (Account) obj;
		result = ((this.number == a.number) && (this.balance == a.balance));
		} catch (Exception e) {
			
		}
		return result;
	}
	
	public int compareTo(Object obj) {
		Account a = null;
		int result = 0;
		try {
			a = (Account) obj;

			// If balances are equal, compare the account numbers
			if(this.balance == a.balance) {
				if(this.number > a.number) {
					result = 1;
				} else if (this.number < a.number) {
					result = -1;
				} else {
					result = 0;
				}
				// If balances are different, use them for comparison
			} else if(this.balance > a.balance) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {

		}
		return result;
	}

	public void deposit(double amt) {
			balance += amt;
	}

	public void withdraw(double amt) {
			if ((balance - amt) >= 0) {
				balance -= amt;
			} else {
				System.out.println("There is not enough money in the acount.");
			}
	}

}
