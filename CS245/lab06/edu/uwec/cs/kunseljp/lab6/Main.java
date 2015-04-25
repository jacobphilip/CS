package edu.uwec.cs.kunseljp.lab6;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Account> bank = new ArrayList<Account>();
		Account one = new Checking(1001, 1000, 100, 1);
		Account two = new Savings(1002, 0.25, 500);
		Account three = new SuperNow(1003, 750, 200, 5, 0.9);
		
		bank.add(one);
		bank.add(two);
		bank.add(three);
		

		ListIterator<Account> firstBankIterator = bank.listIterator();
		while (firstBankIterator.hasNext()) {
			System.out.println(firstBankIterator.next());
		}

		System.out.println("\n********************");

		firstBankIterator = bank.listIterator();
		while (firstBankIterator.hasNext()) {
			Account a = firstBankIterator.next();
			a.withdraw(2);
			firstBankIterator.set(a);
			System.out.println(a);
		}

		System.out.println("\n********************");

		firstBankIterator = bank.listIterator();
		while (firstBankIterator.hasNext()) {
			Account a = firstBankIterator.next();
			a.deposit(5);
			firstBankIterator.set(a);
			System.out.println(a);
		}

		System.out.println("\n********************");
		System.out.println();
		
		firstBankIterator = bank.listIterator();
		while (firstBankIterator.hasNext()) {
			Account a = firstBankIterator.next();
			ListIterator<Account> secondBankIterator = bank.listIterator();
			int equality = 0;
			while (secondBankIterator.hasNext()) {
				Account b = secondBankIterator.next();
				equality = a.compareTo(b);
				if (equality == 0) {
					System.out.println("Account " + a.number + " = " + b.number);
				} else if (equality == -1) {
					System.out.println("Account " + a.number + " < " + b.number);
				} else if (equality == 1) {
					System.out.println("Account " + a.number + " > " + b.number);
				}
			}
		}
	}
}
