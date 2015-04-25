package edu.uwec.cs.kunseljp.lab2;

import java.util.ArrayList;

public class QuineMcCluskey {

	public static void main(String[] args) {

		// term0
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(0);
		a.add(1);
		a.add(1);
		Term t0 = new Term(a, 0);

		// term1
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(0);
		a1.add(1);
		a1.add(0);
		Term t1 = new Term(a1, 0);

		// term2
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(0);
		a2.add(1);
		a2.add(1);
		a2.add(0);
		Term t2 = new Term(a2, 0);

		// term3
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(0);
		a3.add(1);
		a3.add(0);
		a3.add(1);
		Term t3 = new Term(a3, 0);

		// term4
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(0);
		a4.add(0);
		a4.add(1);
		a4.add(1);
		Term t4 = new Term(a4, 0);

		// term5
		ArrayList<Integer> a5 = new ArrayList<Integer>();
		a5.add(0);
		a5.add(0);
		a5.add(1);
		a5.add(0);
		Term t5 = new Term(a5, 0);

		// term6
		ArrayList<Integer> a6 = new ArrayList<Integer>();
		a6.add(0);
		a6.add(0);
		a6.add(0);
		a6.add(1);
		Term t6 = new Term(a6, 0);

		// term7
		ArrayList<Integer> a7 = new ArrayList<Integer>();
		a7.add(0);
		a7.add(0);
		a7.add(0);
		a7.add(0);
		Term t7 = new Term(a7, 0);

		
		
		if (t0.isReducible(t1)) {
			System.out.println("is reducible");
			Term tReduced = new Term(t0, t1);
		} else {
			System.out.println("is not reducible");
		}
		
		System.out.println();
		
		System.out.println("t0" + t0);
		System.out.println("t1" + t1);
		System.out.println("t2" + t2);
		System.out.println("t3" + t3);
		System.out.println("t4" + t4);
		System.out.println("t5" + t5);
		System.out.println("t6" + t6);
		System.out.println("t7" + t7);
		

		TermTable termTable = new TermTable();
		
		termTable.reduce();
	}
}
