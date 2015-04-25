package edu.uwec.cs.kunseljp.lab5;

public class Foo implements Comparable<Foo>{

	private int i;

	public Foo (int i){
		this.i = i;
	}
	
	// copy constructor
	public Foo(Foo f) {
		this.i = (f.i);
	}

	// toString
	public String toString() {
		return "i";
	}

	// equals
	public boolean equals(Object o) {
		Foo i = (Foo) o;
		boolean result = false;
		if (i.equals(this.i)) {
			result = true;
		}
		return result;
	}

	// compareTo
	public int compareTo(Foo f) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
		
	    int result = 0;
		if (this.i == f.i) {
			result = EQUAL;
		} else if (this.i > f.i) {
			result = AFTER;
		} else {
			result = BEFORE;
		}
		return result;
	}

	// hashCode
	public int hashCode(){
		return i/10;
	}
}
