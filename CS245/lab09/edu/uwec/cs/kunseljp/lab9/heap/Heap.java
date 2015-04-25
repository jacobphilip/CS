
package edu.uwec.cs.kunseljp.lab9.heap;

// A max heap class
public class Heap {

	private int n;
	private int size;
	private int[] values;

	// Create an empty heap that can hold N elements
	public Heap(int n) {
		this.n = n; // max size of the heap
		this.size = 0; // nothing added to the heap
		this.values = new int[n]; // heap values
	}

	// Create a heap from an array
	public Heap(int n, int[] values) {
		this.n = n; // max size of the heap
		this.size = values.length; // heap has values in it already
		this.values = new int[n]; // heap values
		for (int i = 0; i < size; i++) {
			this.values[i] = values[i];
		}
	}

	public void insert(int value) {

		if (size == n) {
			System.out.println("Heap is full");
		} else {
			// Insert at the last position
			int current = size;
			values[current] = value;

			// Filter up
			int parent = (current - 1) / 2;
			// Parent must be bigger than its child (current), otherwise we keep
			// filtering
			while ((values[parent] < values[current])) {
				// Swap values
				int temp = values[parent];
				values[parent] = values[current];
				values[current] = temp;

				// Move up
				current = parent;
				parent = (current - 1) / 2;
			}
			size++;
		}
	}

	public int removeMax() {
		int result = values[0];

		// Swap max value with most recent
		int temp = values[size - 1];
		values[size - 1] = values[0];
		values[0] = temp;
		size--;

		filterDown(0);

		return result;
	}

	public void filterDown(int i) {
		int index = i;
		int first = (index * 2) + 1;
		int second = first + 1;
		if (first <= size) {
			if (second <= size) {
				if (values[first] >= values[second] && (values[first] > values[index])) {
					int temp = values[index];
					values[index] = values[first];
					values[first] = temp;
					filterDown(first);
				} else if (values[second] > values[first] && (values[second] > values[index])) {
					int temp = values[index];
					values[index] = values[second];
					values[second] = temp;
					filterDown(second);
				}
			} else {
				if (values[first] > values[index]) {
					int temp = values[index];
					values[index] = values[first];
					values[first] = temp;
				}
			}
		}
	}

	public void displayHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.print("\n");
	}
}
