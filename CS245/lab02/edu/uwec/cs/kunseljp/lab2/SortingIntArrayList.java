package edu.uwec.cs.kunseljp.lab2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SortingIntArrayList {
	final static int LISTSIZE = 6;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		getNumbers(list);		
		JOptionPane.showMessageDialog(null, list);
		sortNumbers(list);
		JOptionPane.showMessageDialog(null, list);	
	}
	//method to get input Integers with try and catch
	private static void getNumbers(ArrayList<Integer> list) {
		for(int g=0; g<LISTSIZE; g++){
			try{
				String stringInteger = JOptionPane.showInputDialog("Please enter a number");
				int number = Integer.parseInt(stringInteger);
				list.add(new Integer(number));
			} catch (NullPointerException e){
				System.exit(1);
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Please enter a valid integer!");
				g--;
			}
			
		}
	}
	//sort method
	private static void sortNumbers(ArrayList<Integer> list) {
		for (int i=0; i<list.size()-1; i++){
			int smallestIndex = i;
			//modified selection sort algorithm to work with Integers 
			for (int j = i + 1; j<list.size(); j++) {
				if(list.get(j).intValue() < list.get(smallestIndex).intValue()){
					smallestIndex = j;
				}
			}
			if(smallestIndex > i) {
				int temp = list.get(smallestIndex).intValue();
				list.set(smallestIndex, new Integer(list.get(i).intValue()));
				list.set(i, new Integer(temp));
			}
		}
	}

}
