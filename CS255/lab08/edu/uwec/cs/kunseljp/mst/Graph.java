package edu.uwec.cs.kunseljp.mst;

import java.util.*;

public class Graph {

	// Only used internally, so it is nested
	class VertexPair implements Comparable<VertexPair> {
		private Vertex v1;
		private Vertex v2;

		// We need to force this into canonical form
		VertexPair(Vertex v1, Vertex v2) {
			if (v1.compareTo(v2) < 0) {
				this.v1 = v1;
				this.v2 = v2;
			} else {
				this.v1 = v2;
				this.v2 = v1;
			}
		}

		public boolean equals(Object o) {
			VertexPair vp = (VertexPair) o;
			return (v1.equals(vp.v1) && v2.equals(vp.v2));
		}

		public int hashCode() {
			return v1.hashCode() + v2.hashCode();
		}

		public int compareTo(VertexPair vp) {

			int result = v1.compareTo(vp.v1);
			if (result == 0) {
				result = v2.compareTo(vp.v2);
			}

			return result;
		}
	}

	private Map<Vertex, Set<Vertex>> adjacencies;
	private Map<VertexPair, Weight> weights;

	public Graph() {
		adjacencies = new TreeMap<Vertex, Set<Vertex>>();
		weights = new TreeMap<VertexPair, Weight>();
	}

	// Add an adjacency with a given Weight.  The adjacency should be undirectional.
	public void addAdjacency(Vertex v1, Vertex v2, Weight w) {
		Set<Vertex> v1Set;
		Set<Vertex> v2Set;

		// Check to see if we already have an entry for vertex1
		if (adjacencies.containsKey(v1)) {
			// We add vertex2 to the Set associated with the key
			v1Set = adjacencies.get(v1);
		} else {
			// Otherwise we add a new key,value pair to the Map
			v1Set = new TreeSet<Vertex>();
		}
		v1Set.add(v2); // Won't add if it is a duplicate
		adjacencies.put(v1, v1Set); // This replaces the old value if there was one

		// Now we need to put in the edge the other direction
		// Check to see if we already have an entry for vertex1
		if (adjacencies.containsKey(v2)) {
			// We add vertex1 to the Set associated with the key
			v2Set = adjacencies.get(v2);
		} else {
			// Otherwise we add a new key,value pair to the Map
			v2Set = new TreeSet<Vertex>();
		}
		v2Set.add(v1); // Won't add if it is a duplicate
		adjacencies.put(v2, v2Set); // This replaces the old value if there was one

		// Add an entry to the weights map
		weights.put(new VertexPair(v1, v2), w);
	}

	// Returns the Set of Vertices adjacent to the given key Vertex
	public Set<Vertex> getAdjacent(Vertex key) {
		Set<Vertex> result;
		if (adjacencies.containsKey(key)) {
			result = adjacencies.get(key);
		} else { // None found
			result = new TreeSet<Vertex>();
		}
		return result;
	}

	// Returns the Weight between the two given Vertices
	public Weight getWeight(Vertex v1, Vertex v2) {
		Weight result;
		VertexPair vp = new VertexPair(v1, v2);
		if (weights.containsKey(vp)) {
			result = weights.get(vp);
		} else { // Pair not found
			result = null;
		}
		return result;
	}

	// Returns an iterator of all the Vertices
	public Iterator<Vertex> vertices() {
		return adjacencies.keySet().iterator();
	}
	
	public String toString() {
		String result = "Graph:\n";
		
		Iterator<Vertex> it = vertices();
		while (it.hasNext()) {
			Vertex v1 = it.next();
			
			Set<Vertex> adj = adjacencies.get(v1);
			Iterator<Vertex> adjIt = adj.iterator();
			while (adjIt.hasNext()) {
				
				Vertex v2 = adjIt.next();
				result += "\t" + v1 + " --> " + v2 + " with " + weights.get(new VertexPair(v1, v2)) + "\n";
			}
		
		}
		
		return result;
	}
}
