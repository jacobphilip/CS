package edu.uwec.cs.kunseljp.mst;

public class MSTTest {
	
	// This is the graph from the ppt
	public static Graph setupGraph() {
		Graph g = new Graph();
		
		g.addAdjacency(new Vertex("A"), new Vertex("B"), new Weight(1));
		g.addAdjacency(new Vertex("A"), new Vertex("C"), new Weight(2));
		
		g.addAdjacency(new Vertex("B"), new Vertex("C"), new Weight(3));
		g.addAdjacency(new Vertex("B"), new Vertex("D"), new Weight(6));
		
		g.addAdjacency(new Vertex("C"), new Vertex("D"), new Weight(4));
		g.addAdjacency(new Vertex("C"), new Vertex("E"), new Weight(2));
		
		g.addAdjacency(new Vertex("D"), new Vertex("E"), new Weight(5));
	
		return g;
	}

	public static void main(String[] args) {
		
		Graph g = setupGraph();
		System.out.println(g);
		
		// Prim's method
		Prim p = new Prim();
		Graph gPrimMST = p.findMinimalSpanningTree(g);
		System.out.println(gPrimMST);
	
	}
}
