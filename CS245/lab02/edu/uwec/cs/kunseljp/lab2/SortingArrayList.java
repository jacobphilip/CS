package edu.uwec.cs.kunseljp.lab2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SortingArrayList {
	final static int LISTSIZE = 6;

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		getNames(list);		
		JOptionPane.showMessageDialog(null, list);
		sortNames(list);
		JOptionPane.showMessageDialog(null, list);	
	}
	//method to fill array list
	private static void getNames(ArrayList<String> list) {
		for(int g=0; g<LISTSIZE; g++){
			String name = JOptionPane.showInputDialog("Please enter a name");
			list.add(name);
		}
	}
	//sorting method
	private static void sortNames(ArrayList<String> list) {
		//converts strings to lower case
		for (int l=0; l<list.size(); l++){
			list.set(l, list.get(l).toLowerCase());
		}
		//selection sort algorithm
		for (int i=0; i<list.size()-1; i++){
			int smallestIndex = i;
			for (int j = i + 1; j<list.size(); j++) {
				if(list.get(j).compareTo(list.get(smallestIndex)) < 0) {
					smallestIndex = j;
				}
			}
			if(smallestIndex > i) {
				String temp = list.get(smallestIndex);
				list.set(smallestIndex, list.get(i));
				list.set(i, temp);
			}
		}
	}
}
