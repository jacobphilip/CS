package edu.uwec.cs.kunseljp.lab2;

import java.util.*;

public class Term {

	private List<Integer> values;

	public Term(List<Integer> values, int coverIndex) {
		this.values = values;

	}

	public Term(Term t1, Term t2) {
		ArrayList<Object> newTerm = new ArrayList<Object>();

		String str1;
		String str2;

		for (int x = 0; x < t1.values.size(); x++) {
			str1 = t2.values.get(x).toString();
			str2 = t1.values.get(x).toString();
			if (str1.compareToIgnoreCase(str2) < 0) {
				newTerm.add(x, "X");
			} else {
				newTerm.add(x, t1.values.get(x));
			}
		}

		System.out.println(newTerm);
	}

	
	public boolean isReducible(Term t) {
		System.out.println(this + " & " + t);
		String str1;
		String str2;
		int errors = 0;

		for (int x = 0; x < this.values.size(); x++) {
			str1 = t.values.get(x).toString();
			str2 = this.values.get(x).toString();
			if (str1.compareToIgnoreCase(str2) < 0) {
				errors++;
			}
		}
		if (errors > 1) {
			return false;
		}
		return true;
	}


	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}


	public String toString() {
		return values.toString();
	}

}
