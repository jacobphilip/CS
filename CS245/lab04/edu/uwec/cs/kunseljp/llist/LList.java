package edu.uwec.cs.kunseljp.llist;

public class LList<T> implements ListIf<T> {

	// Nested helper class
	private class Node {
		// These are private, but LList can see them since Node is a nested
		// class
		private T element;
		private Node next;

		public Node(T o) {
			element = o;
			next = null;
		}
	}

	// LList's instance variables
	private Node first;
	private int size;

	// Default constructor
	public LList() {
		first = null; // empty list
		size = 0;
	}

	// Added to the end
	public void add(T o) {
		add(size, o);
		// the other add we call will increment the size
	}

	// Added to the middle (or start)
	public void add(int index, T o) {

		Node nn = new Node(o);
		size++;
		// Special case for adding to start
		if (index == 0) {
			nn.next = first;
			first = nn;

		} else { // works for middle and end cases

			// Find the node before index
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			nn.next = n.next;
			n.next = nn;
		}
	}

	// Get
	public T get(int index) {

		Node n = first;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.element;
	}

	// Remove
	public T remove(int index) {
		T result = null;
		size--;
		// Special case for adding to start
		if (index == 0) {
			result = first.element;
			first = first.next;

		} else { // works for middle and end cases

			// Find the node before index
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			result = n.next.element;
			n.next = n.next.next;
		}

		return result;
	}

	public boolean remove(T o) {
		Node n = first;
		boolean result = false;
		for (int i = 0; i < size; i++) {
			if (o.equals(n.element)) {
				remove(i);
				i--;
				result = true;
			}
			n = n.next;
		}
		return result;
	}

	// contains method
	public boolean contains(T o) {
		Node n = first;
		boolean result = false;
		boolean matchFound = false;
		int i = 0;
		while ((i < size) && (matchFound == false)) {
			if (o.equals(n.element)) {
				result = true;
				matchFound = true;
			}
			n = n.next;
			i++;
		}
		return result;
	}

	// setter method
	public void set(int index, T o) {
		Node nn = new Node(o);
		Node n = first;
		if (index == 0) {
			first = nn;
			nn.next = n.next;
		} else {
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			Node pn = n;
			n = n.next;
			nn.next = n.next;
			pn.next = nn;
		}
	}

	// size method
	public int size() {
		return size;
	}

	// toString method to display the contents of the linked list
	public String toString() {
		Node n = first;
		String result = n.element.toString();
		for (int i = 0; i < size - 1; i++) {
			n = n.next;
			result += ", " + n.element.toString();
		}
		return result;
	}

	public int indexOf(T o) {
		Node n = first;
		int result = -1;
		for (int i = 0; i < size; i++) {
			if (o.equals(n.element)) {
				result = i;
			}
			n = n.next;
		}
		return result;
	}

}
