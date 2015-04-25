package edu.uwec.cs.kunseljp.llist;

public class DLList<T> implements ListIf<T> {

	private class Node {
		private T element;
		private Node next;
		private Node prev;

		public Node(T o) {
			element = o;
			next = null;
			prev = null;
		}
	}
	
	private Node first;
	private Node last;
	private int size;
	
	public DLList() {
		first = null;
		last = null;
		size = 0;
	}
	
	//Add to the end.
	public void add(T o) {
		add(size, o);
	}
	
	//Size 
	public int size() {
		return size;
	}
	
	//Add into the middle or start
	public void add(int index, T o) {

		Node nn = new Node(o);
		size++;
		//add to start
		if (index == 0) {
			nn.next = first;
			nn.prev = null;
			first = nn;
			if(size == 1) {
				last = nn;
			}
		} else if (index < (size-1)){ //add to middle
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			nn.next = n.next;
			nn.prev = n;
			n.next = nn;
			n = nn.next;
			n.prev = nn;
		} else { // works for end case
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			nn.next = n.next;
			nn.prev = n;
			n.next = nn;
			last = nn;
		}
	}
	
	public void set(int index, T o) {
		Node nn = new Node(o);
		Node n = first;
		//start
		if (index == 0) {
			first = nn;
			nn.next = n.next;
			nn.prev = null;
			n = nn.next;
			n.prev = nn;
			if(size == 1) {
				last = nn;
			}
		//works for the middle
		} else if(index < (size-1)) {
			for (int i = 0; i < index-1; i++) {
				n = n.next;
			}
			Node pn = n;
			n = n.next;
			Node an = n;
			an = an.next;

			an.prev = nn;
			nn.next = n.next;
			nn.prev = n.prev;
			pn.next = nn;
		//works for the last cases
		} else {
			n = last;
			Node p = n.prev;
			nn.next = n.next;
			nn.prev = n.prev;
			p.next = nn;
			last = nn;
		}
	}
	
	public T remove(int index) {
		T result = null;
		size--;
		//start
		if (index == 0) {
			result = first.element;
			first = first.next;
			first.prev = null;

		} else if(index < (size-1)) { // works for middle case
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			result = n.next.element;
			n.next.next.prev = n;
			n.next = n.next.next;
		} else { // works for end case
			Node n = last;
			result = n.element;
			n = n.prev;
			last = n;
			n.next = null;
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
	
	// Get Method,  does it backwards if the index is in the second half of the list
	public T get(int index) {
		if(index < (size/2)) {
			Node n = first;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			return n.element;
		}
		Node l = last;
		index = (size-1) - index;
		for (int i = 0; i < index; i++) {
			l = l.prev;
		}
		return l.element;
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
	
	public boolean contains(T o) {
//		Node n = first;
//		boolean result = false;
//		
//		int i = 0;
//		while((i < size) ) {
//			if (o.equals(n.element)) {
//				result = true;
//				
//			}
//			n = n.next;
//			i++;
//		}
//		return result;
		
		return (indexOf(o) != -1);
	}
	
	public String toString() {
		Node n = first;
		String result = n.element.toString();
		for(int i=0; i<size-1; i++) {
			n = n.next;
			result += ", " + n.element.toString();
		}
		return result;
	}
}
