package edu.uwec.cs.kunseljp.lab2;

public class Overflow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		{

			int old = 1;
			int current = 1;
			int next;
			System.out.println(0);
			System.out.println(current);
			
			while (current > 0) {
				System.out.println(current);
				next = current + old;
				old = current;
				current = next;
			}
			System.out.println("Overflow Error");
		}

	}

}
