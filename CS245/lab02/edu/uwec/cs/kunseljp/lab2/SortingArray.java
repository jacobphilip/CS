package edu.uwec.cs.kunseljp.lab2;

import javax.swing.JOptionPane;

public class SortingArray {

final static int LISTSIZE = 6;
	
	public static void main(String[] args) {
		String[] list = new String[LISTSIZE];
		getNames(list);
		JOptionPane.showMessageDialog(null, list);
		sortNames(list);
		JOptionPane.showMessageDialog(null, list);
	}
	//method to fill array list
	private static void getNames(String[] list){
		for(int g=0; g<list.length; g++){
			list[g] = JOptionPane.showInputDialog("Please enter a name");
		}
	}
	//sorting method
	private static void sortNames(String[] list){
		//converts all the names to lower case
		for (int l=0; l<list.length; l++){
			list[l] = list[l].toLowerCase();
		}
		//selection sort algorithm
		for (int i=0; i<list.length-1; i++){
			int smallestIndex = i;
			for (int j = i + 1; j<list.length; j++) {
				if(list[j].compareTo(list[smallestIndex]) < 0) {
					smallestIndex = j;
				}
			}
			if(smallestIndex > i) {
				String temp = list[smallestIndex];
				list[smallestIndex] = list[i];
				list[i] = temp;
			}
		}
		
	}
}
