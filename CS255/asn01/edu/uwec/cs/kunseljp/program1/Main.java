package edu.uwec.cs.kunseljp.program1;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static ArrayList<Axiom> axiomList = new ArrayList<Axiom>(); 

	public static void main(String[] args) {
		
		boolean notNumber = true;
		String inputNumber = "";
		Boolean second = false;
		
		//Asks for the number of axioms and if a !integer is put in, asks again for the number
		while (notNumber) {
			if (!second) {
				inputNumber = JOptionPane.showInputDialog(null, "How many axioms are there?");
			} else {
				inputNumber = JOptionPane.showInputDialog(null, "How many axioms are there?\nPlease give an integer as input.");
			}

			// Terminates program if null
			if (inputNumber == null) {
				System.exit(0);
			}

			//Makes sure input is an integer
			try {
				Integer.parseInt(inputNumber);
				notNumber = false;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				second = true;
				notNumber = true;
			}

		}
				
		int numberOf = Integer.parseInt(inputNumber);	
		//asks for axioms until it reaches the number of specified
		for(int i = 0; i < numberOf; i++) {
			String inputAxiom = JOptionPane.showInputDialog(null, "Enter axiom here.\nEx:  a v b' ");
			if (!inputAxiom.contains(")")) {
				inputAxiom += ")";
			}
			axiomList.add(new Axiom(inputAxiom));
		}
		
		//Enter the resolvent to prove
		String inputProve = JOptionPane.showInputDialog(null, "Enter what you want to prove.\nEx:  a v b' ");
		if (!inputProve.contains(")")) {
			inputProve += ")";
		}

		Axiom prove = new Axiom(inputProve);
		ArrayList<Axiom> negatedAxioms = prove.Negation();
		
		for(int i = 0; i < negatedAxioms.size(); i++)
		{
			axiomList.add(negatedAxioms.get(i));
		}
	
		
		printList(axiomList);
		Boolean answer = run(axiomList);
		if(answer){ 
			JOptionPane.showMessageDialog(null, "The theorem is TRUE.");
		} else {
			JOptionPane.showMessageDialog(null, "The theorem is FALSE or could not be proved.");
		}
	}
	//Prints the list of axioms to the screen
	public static void printList(ArrayList<Axiom> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	//Runs the program
	public static boolean run(ArrayList<Axiom> list) {
		int count = 0;
		ArrayList<Axiom> testList = list;
		boolean returnBool = false;
		while(!returnBool){
		for (int i = 0; i < testList.size(); i++) {
			for (int j = 0; j < testList.size(); j++) {
				count++;
				if(j == i || testList.get(j) == null || testList.get(i) == null){}else{
					
				ArrayList<Axiom> copiedArray = testList.get(i).Reduce(testList.get(j));

				if (copiedArray.size() == 0) {
				} else {
					for (int k = 0; k < copiedArray.size(); k++) {
						testList.add(copiedArray.get(k));
						
						System.out.println(copiedArray.get(k).toString());
						if(copiedArray.get(k).Literals.size()==0)
						{
							returnBool = true;
						}
					}
				}
			}
				if(count >= list.size()*list.size())
				break;
			}
			if(count >= list.size()*list.size())
			break;
		}
		if(count >= list.size()*list.size())
		break;
		}
		return returnBool;
	}

}
