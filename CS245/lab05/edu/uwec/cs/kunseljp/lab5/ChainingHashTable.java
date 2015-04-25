package edu.uwec.cs.kunseljp.lab5;
import java.util.ArrayList;

public class ChainingHashTable<T> implements HashTable<Foo> {
	
	ArrayList<T> hashTable;

	public ChainingHashTable(int size) {
		this.hashTable = new ArrayList<T>(size);
	}

	public boolean contains(Foo element) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean put(Foo element) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean remove(Foo element) {
		// TODO Auto-generated method stub
		return true;
	}

}
