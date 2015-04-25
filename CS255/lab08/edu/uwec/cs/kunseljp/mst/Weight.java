package edu.uwec.cs.kunseljp.mst;

public class Weight implements Comparable<Weight> {
	private int value;

	public Weight(int value) {
		this.value = value;
	}

	public boolean equals(Object o) {
		return (this.value == ((Weight)o).value);
	}

	public int hashCode() {
		return value;
	}

	public String toString() {
		return ("weight: " + value);
	}

	public int compareTo(Weight w) {
		return (this.value - w.value);
	}
}
