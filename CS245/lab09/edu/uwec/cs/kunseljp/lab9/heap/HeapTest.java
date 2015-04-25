
package edu.uwec.cs.kunseljp.lab9.heap;

public class HeapTest {

	public static void main(String[] args) {

		// Create heap using values from ppt
		int[] heapvalues = { 63, 30, 40, 10, 25, 8, 38, 5, 3, 18 };
		Heap h = new Heap(15, heapvalues);
		h.displayHeap();

		// Insert 50 just like in ppt
		h.insert(50);
		h.displayHeap();

		// Reset heap to original starting values
		h = new Heap(15, heapvalues);
		h.displayHeap();

		// Remove the top just like in ppt
		System.out.println(h.removeMax());
		h.displayHeap();

		// Remove all the elements from the heap
		for (int i = 0; i < heapvalues.length - 1; i++) {
			System.out.println(h.removeMax());
			h.displayHeap();
		}
	}
}
