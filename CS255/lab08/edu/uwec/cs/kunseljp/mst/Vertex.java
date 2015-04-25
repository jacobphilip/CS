package edu.uwec.cs.kunseljp.mst;

public class Vertex implements Comparable<Vertex> {
	private String name;

	public Vertex(String name) {
		this.name = name;
	}

	public boolean equals(Object o) {
		return this.name.equals(((Vertex)o).name);
	}

	public int hashCode() {
		return name.hashCode();
	}

	public String toString() {
		return ("vertex: " + name.toString());
	}

	public int compareTo(Vertex v) {
		return this.name.compareTo(v.name);
	}
}
