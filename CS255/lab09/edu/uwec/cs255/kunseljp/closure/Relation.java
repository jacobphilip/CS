package edu.uwec.cs255.kunseljp.closure;

import java.util.*;

public class Relation {
	
	// Inner class to represent an ordered pair
	class Pair {
		private Object one;
		private Object two;
		
		public Pair(Object one, Object two) {
			this.one = one;
			this.two = two;
		}
		
		public Object getOne() {
			return this.one;
		}
		
		public Object getTwo() {
			return this.two;
		}
		
		public boolean equals(Object o) {
			Pair p = (Pair)o;
			return (this.one.equals(p.one) && this.two.equals(p.two));
		}
		
		public int hashCode() {
			return one.hashCode() * two.hashCode();
		}
		
		public String toString() {
			return "(" + one + "," + two + ")";
		}
	}
	
	// Instance variables
	private Set<Object> theSet;
	private Set<Pair> orderedPairs;
	
	public Relation(Set<Object> theSet) {
		this.theSet = theSet;
		orderedPairs = new HashSet<Pair>();
	}

	public Relation(Relation theRelation) {
		theSet = new HashSet<Object>(theRelation.theSet);
		orderedPairs = new HashSet<Pair>(theRelation.orderedPairs);
	}
	
	public void addOrderedPair(Object one, Object two) {
		orderedPairs.add(new Pair(one, two));
	}
	
	public Relation reflexiveClosure() {
		// Your code here:
		Relation temp = new Relation(theSet);
		Iterator<Pair> it = orderedPairs.iterator();
		while (it.hasNext()) {
			Pair currentP = it.next();
			Pair tempP = new Pair(currentP.getOne(), currentP.getOne());
			if (!orderedPairs.contains(tempP)){
				temp.addOrderedPair(currentP.getOne(), currentP.getOne());
			}
		}
		Iterator<Pair> it2 = orderedPairs.iterator();
		while (it2.hasNext()) {
			Pair currentP = it2.next();
			Pair tempP = new Pair(currentP.getTwo(), currentP.getTwo());
			if (!orderedPairs.contains(tempP)) {
				temp.addOrderedPair(currentP.getTwo(), currentP.getTwo());
			}
		}
		
		return temp;
	}
	
	public Relation symmetricClosure() {
		// Your code here:
		Relation temp = new Relation(theSet);
		Iterator<Pair> it = orderedPairs.iterator();
		while (it.hasNext()) {
			Pair currentP = it.next();
			Pair tempP = new Pair(currentP.getTwo(), currentP.getOne());
			if (!orderedPairs.contains(tempP)) {
				temp.addOrderedPair(currentP.getTwo(), currentP.getOne());
			}
		}
		return temp;
	}
	
	public Relation transitiveClosure() {
		// Your code here:
		Relation temp = new Relation(theSet);
		
//		int[][] b = null;
//		
//		Iterator<Pair> it = orderedPairs.iterator();
//		while (it.hasNext()){
//			
//		}
//		
//		ShortestPath sp = new ShortestPath(b);
		
		return temp;
	}

	public String toString() {
		return orderedPairs.toString();
	}
	
	
    public static void main(String[] args) {
		
    	// Example 1 with ints
    	
		// Build the Set of Objects
		Set<Object> a = new HashSet<Object>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		
		// Relation on set A
		Relation r = new Relation(a);
		r.addOrderedPair(1, 1);
		r.addOrderedPair(1, 2);
		r.addOrderedPair(2, 3);
		r.addOrderedPair(2, 1);
		r.addOrderedPair(3, 4);
		System.out.println(r);		
		
		Relation rC = r.reflexiveClosure();
		System.out.println(rC);
		// adds: (2, 2), (3, 3), (4, 4)
		
		Relation sC = r.symmetricClosure();
		System.out.println(sC);
		// adds: (3, 2), (4, 3)
		
		Relation tC = r.transitiveClosure();
		System.out.println(tC);
		// adds: (2, 2), (1, 3), (2, 4) and (1, 4)
		
		
		
		// Example 2 with Strings
		
		// Build the Set of Objects
		Set<Object> b = new HashSet<Object>();
		b.add("a");
		b.add("b");
		b.add("c");
		b.add("d");
		
		// Relation on set B
		Relation r2 = new Relation(b);
		r2.addOrderedPair("a", "a");
		r2.addOrderedPair("a", "b");
		r2.addOrderedPair("b", "c");
		r2.addOrderedPair("b", "a");
		r2.addOrderedPair("c", "d");
		System.out.println(r2);		
		
		Relation rC2 = r2.reflexiveClosure();
		System.out.println(rC2);
		// adds: (b, b), (c, c), (d, d)
		
		Relation sC2 = r2.symmetricClosure();
		System.out.println(sC2);
		// adds: (c, b), (d, c)
		
		Relation tC2 = r2.transitiveClosure();
		System.out.println(tC2);
		// adds: (b, b), (a, c), (b, d) and (a, d)
	}
}
