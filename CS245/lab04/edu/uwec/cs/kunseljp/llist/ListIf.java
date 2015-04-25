package edu.uwec.cs.kunseljp.llist;

public interface ListIf<T> {
	
	// add to the end
	public void add(T o); 
	// add at index
	public void add(int index, T o); 
	// get the value at index
	public T get(int index); 
	// change the value at index
	public void set(int index, T o); 
	// remove value at index and return it
	public T remove(int index); 
	// remove the object if found (return true if found, false if not)
	public boolean remove(T o); 
	// returns the size
	public int size(); 
	// returns true if the list contains the object
	public boolean contains(T o); 
	// returns the index of the object, -1 if it doesn't exist
	public int indexOf(T o); 
}
