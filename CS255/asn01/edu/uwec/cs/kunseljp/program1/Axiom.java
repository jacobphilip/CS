package edu.uwec.cs.kunseljp.program1;

import java.util.ArrayList;

public class Axiom {

	public ArrayList<Literal> Literals = new ArrayList<Literal>(); // Table of terms
																	

	public Axiom(ArrayList<Literal> list) {
		this.Literals = list;
	}

	public Axiom(String clause) {
		String test = clause;
		test = test.toLowerCase(); // make sure case is correct
		Literal temp;
		for (int i = 0; i < test.length(); i++) {
			char c = test.charAt(i);
			if (c == '(' || c == ')' || c == ' ' || c == '\'') { // We ignore these characters in the axiom inputs
			} else {
				if (test.charAt(i + 1) == '\'') { // if a Char is followed by ' it is negative and false
					temp = new Literal(c, false);
					this.Literals.add(temp);
				} else {
					temp = new Literal(c, true); // if no negation is found, char is postive
					this.Literals.add(temp);
				}
			}
		}

	}

	public ArrayList<Axiom> Reduce(Axiom Axiom2) {
		ArrayList<Axiom> returnArray = new ArrayList<Axiom>();
		ArrayList<Literal> tempAList = new ArrayList<Literal>();
		ArrayList<Character> unUsedChar = new ArrayList<Character>();
		boolean noMatch = true;
		Literal or = new Literal('v', true);
		boolean isFirst = true;
		// Goes through first for this or the first axiom
		for (int i = 0; i < this.Literals.size(); i++) {
			if (this.Literals.get(i).charVal == 'v') {
			} else {
				noMatch = true;
				for (int j = 0; j < Axiom2.Literals.size(); j++) {
					if (this.Literals.get(i).charVal == Axiom2.Literals.get(j).charVal) {
						noMatch = false;
						if (this.Literals.get(i).boolVal == Axiom2.Literals
								.get(j).boolVal) {
							if (isFirst) {
								isFirst = false;
							} else if (!isFirst) {
								tempAList.add(or);
							}
							tempAList.add(new Literal(
									this.Literals.get(i).charVal, this.Literals
											.get(i).boolVal));
						} else {
							unUsedChar.add(this.Literals.get(i).charVal);
						}
					}
				}
				if (noMatch) {
					if (isFirst) {
						isFirst = false;
					} else if (!isFirst) {
						tempAList.add(or);
					}
					tempAList.add(new Literal(this.Literals.get(i).charVal,
							this.Literals.get(i).boolVal));

				}
			}
		}

		// Goes through second time for axiom2
		for (int i = 0; i < Axiom2.Literals.size(); i++) {
			if (Axiom2.Literals.get(i).charVal == 'v') {
			} else {
				noMatch = true;
				for (int j = 0; j < this.Literals.size(); j++) {
					if (Axiom2.Literals.get(i).charVal == this.Literals.get(j).charVal) {
						noMatch = false;
						if (Axiom2.Literals.get(i).boolVal == this.Literals
								.get(j).boolVal) {
							boolean inTempArray = false;
							for (int k = 0; k < tempAList.size(); k++) {
								if (tempAList.get(k).charVal == Axiom2.Literals
										.get(i).charVal) {
									inTempArray = true;
								}
							}
							if (inTempArray) {
							} else {
								if (isFirst) {
									isFirst = false;
								} else if (!isFirst) {
									tempAList.add(or);
								}
								tempAList.add(new Literal(Axiom2.Literals
										.get(i).charVal,
										Axiom2.Literals.get(i).boolVal));
							}

						}
					}
				}
				if (noMatch) {
					if (isFirst) {
						isFirst = false;
					} else if (!isFirst) {
						tempAList.add(or);
					}
					tempAList.add(new Literal(
							Axiom2.Literals.get(i).charVal, Axiom2.Literals
									.get(i).boolVal));
				}
			}
		}

		// Creates new axiom from 1 and 2
		if (unUsedChar.size() > 1) {
			// All lits that repeat
			ArrayList<Literal> copiedList = new ArrayList<Literal>(); 
			for (int i = 0; i < tempAList.size(); i++) {
				copiedList.add(tempAList.get(i));
			}

			for (int i = 0; i < unUsedChar.size(); i++) {
				tempAList = new ArrayList<Literal>();

				for (int k = 0; k < copiedList.size(); k++) {
					tempAList.add(copiedList.get(k));
				}
				if (isFirst) {
					isFirst = false;
				} else if (!isFirst) {
					tempAList.add(or);
				}
				tempAList.add(new Literal(unUsedChar.get(i), true));

				if (isFirst) {
					isFirst = false;
				} else if (!isFirst) {
					tempAList.add(or);
				}
				tempAList.add(new Literal(unUsedChar.get(i), false));
				returnArray = setVal(returnArray, new Axiom(tempAList));
			}
		} else {
			returnArray.add(new Axiom(tempAList));
		}
		if (unUsedChar.size() == 0) {
			returnArray = new ArrayList<Axiom>();
		}
		return returnArray;
	}

	private ArrayList<Axiom> setVal(ArrayList<Axiom> oldArrayList,
			Axiom toBeAdded) {
		ArrayList<Axiom> returnArray = oldArrayList;
		returnArray.add(toBeAdded);
		return returnArray;

	}

	// Converts Axiom to a string
	public String toString() {
		String returnString = "";
		returnString += "(";
		for (int i = 0; i < Literals.size(); i++) {
			if (Literals.get(i).charVal == '^') {
				returnString += " ) ^ (";
			} else {
				returnString += " " + this.Literals.get(i).charVal;
				if (this.Literals.get(i).boolVal == false) {
					returnString += '\'';
				}
				if ((i != this.Literals.size() - 1)) {
					if (i < Literals.size()) {
						if (Literals.get(i + 1).charVal != '^') {
				}
			}

		}
		}

		}
		returnString += " )";
		return returnString;
	}

	//Negates the proof
	public ArrayList<Axiom> Negation() {
		ArrayList<Literal> negated = this.Literals;
		ArrayList<Literal> tempLits = new ArrayList<Literal>();
		ArrayList<Axiom> tempList = new ArrayList<Axiom>();
		ArrayList<Axiom> oppositeAxiomList = new ArrayList<Axiom>();
		Axiom printAxiom = new Axiom(negated);
		System.out.println(printAxiom.toString());
		boolean carrot = false;
		for(int h = 0; h < negated.size(); h++)
		{
			if(negated.get(h).charVal == '^')
			{
				carrot = true;
			}
		}
		if (carrot) {
			for (int i = 0; i < negated.size(); i++) {
				if (negated.get(i).charVal == '^') {
					oppositeAxiomList.add(new Axiom(tempLits));					
					tempLits = new ArrayList<Literal>();
				} else {
					if(!(negated.get(i).charVal == 'v')){
					tempLits.add(negated.get(i));
					}
				}
			}
			oppositeAxiomList.add(new Axiom(tempLits));	
			tempLits = new ArrayList<Literal>(3);
			tempLits.add(new Literal('-',true));
			tempLits.add(new Literal('-',true));
			tempLits.add(new Literal('-',true));
				
				System.out.println(oppositeAxiomList.size());
				
				for (int j = 0; j < oppositeAxiomList.get(0).Literals.size(); j++) {
					tempLits.set(0, new Literal(oppositeAxiomList.get(0).Literals.get(j).charVal, false));
							for (int l = 0; l < oppositeAxiomList.get(0).Literals.size(); l++) {
								tempLits.set(1, new Literal(oppositeAxiomList.get(1).Literals.get(l).charVal, false));

							for (int m = 0; m < oppositeAxiomList.get(0).Literals.size(); m++) {
								tempLits.set(2, new Literal(oppositeAxiomList.get(2).Literals.get(m).charVal, false));

						} 
						tempList.add(new Axiom(tempLits));
						tempLits = new ArrayList<Literal>(3);
						tempLits.add(new Literal('-',true));
						tempLits.add(new Literal('-',true));
						tempLits.add(new Literal('-',true));
								
				}
				}
		} else {

			for (int i = 0; i < negated.size(); i++) {
				if (negated.get(i).charVal == '^') {
				} else if (negated.get(i).charVal == 'v') {
					tempList = new ArrayList<Axiom>();
					tempList.add(new Axiom(tempLits));
					tempLits = new ArrayList<Literal>();
				} else if (this.Literals.get(i).boolVal) {
					Literal tempLit = new Literal(this.Literals.get(i).charVal, false);
					negated.set(i, tempLit);
					tempLits.add(negated.get(i));
				} else if (!this.Literals.get(i).boolVal) {
					Literal tempLit = new Literal(this.Literals.get(i).charVal, true);
					negated.set(i, tempLit);
					tempLits.add(negated.get(i));
				}
			}
			tempList.add(new Axiom(tempLits));
		}

		
		return tempList;

	}

}
