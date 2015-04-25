package edu.uwec.cs.kunseljp;

import java.util.*;

public class Rule {

	private String name = "";
	Production production;
	ArrayList<Production> prods = new ArrayList<Production>();

	
	//creates a list with the name of the string it is pasted
	public Rule(String nextLine) {
		this.name = nextLine;
		
	}

	//add method
	public void add(Production newProduction) {
		this.production = newProduction;
		prods.add(newProduction);
		
	}
	
	public String toString(){
		return name;
		
	}

}
