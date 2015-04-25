package edu.uwec.cs.kunseljp.llist;

public class Tester {

	public static void main(String[] args) {

		// ListIf<String> l = new LList<String>();
		ListIf<String> l = new DLList<String>();

		l.add("cat");
		l.add("dog");
		l.add("goat");
		l.add("cow");
		l.add("sheep");
		l.add("rabbit");
		l.add("pig");
		l.add("horse");

		// displays the original list
		System.out.println(l);

		// replaces cat with FIRST and horse with LAST
		l.set(0, "FIRST");
		l.set(7, "LAST");
		System.out.println(l);

		// Displays FIRST
		System.out.println(l.get(0));
		// Displays sheep
		System.out.println(l.get(4));
		// Displays LAST
		System.out.println(l.get(7));

		// Adds to the beginning of the List
		l.add(0, "START");
		// Adds to the seconds index of the list
		l.add(1, "NEXT");
		System.out.println(l);

		// Removes START
		l.remove(0);
		// Removes thing at index 3 which is goat
		l.remove(3);
		// Removes LAST regardless of what index it is at
		l.remove("LAST");
		System.out.println(l);

		System.out.println(l.indexOf("sheep"));
		System.out.println(l.indexOf("pig"));

		System.out.println(l.contains("sheep"));
		System.out.println(l.contains("elephant"));

		System.out.println(l.size());
		System.out.println(l);
	}

}
