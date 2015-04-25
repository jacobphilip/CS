package edu.uwec.cs.kunseljp.proof;

import java.math.BigInteger;

public class Proof {

	public static void main(String[] args) {
		// problem1();
		// problem2();
		problem3();
		problem4();
	}

	public static void problem1() {

		// First we pick two values p and q
		int p = (int) (Math.random() * 100);
		int q = (int) (Math.random() * 100);

		// Next we want to make sure p+q is divisible by 2
		while ((p + q) % 2 != 0) {
			p = (int) (Math.random() * 100);
			q = (int) (Math.random() * 100);
			/*
			 * This loop will make sure that p and q will either both be even or
			 * both be odd.
			 */
		}

		// Next we want to do some processing
		if ((p % 2) == (q % 2)) {

			/*
			 * We know that and even number is divisible by 2 and any odd number
			 * divided by 2 has a remainder of 1.
			 * 
			 * This section of code will aways execute because p%2 and q%2 will
			 * aways be equal because either both p and q are even or both p and
			 * q are odd. When p is even it will have a remainder of 0 and when
			 * q is even it will have a remainder of 0. When p is odd it will
			 * have a remainder of 1 and when q is odd it will aways have a
			 * remainder of 1.
			 */

		} else {

			/* This section of code is unreachable. */

			System.out.println("else");
		}
	}

	public static void problem2() {

		// First we pick an n value
		int n = (int) (Math.random() * 1000);

		int result = n * (n + 1) * (n + 2);

		if ((result % 3) == 0) {
			/*
			 * This section of code will always be reachable because when
			 * multiplying three consequtive numbers (n, n+1, n+2) one of them
			 * must be a multiple of 3. We know that 3 times any number will
			 * always be divisible by 3, so there will be no else case.
			 */
		} else {

			/* This section of code is unreachable. */

			System.out.println("else");
		}
	}

	public static void problem3() {
		int n = 10000000; // 10Million

		long start = System.currentTimeMillis();

		BigInteger result = new BigInteger("0");
		BigInteger two = new BigInteger("2");
		for (int i = 1; i <= n; i++) {
			BigInteger term = two.multiply(new BigInteger(i + ""));
			result = result.add(term);
		}

		long end = System.currentTimeMillis();
		long elapsed = end - start;
		System.out.println("Result: " + result + " completed in " + elapsed + " ms");

		// Time the closed form version below:
		start = System.currentTimeMillis();
		BigInteger number = new BigInteger("10000000");
		BigInteger closedResult = number.pow(2).add(number);

		// result = n^2 + n;

		end = System.currentTimeMillis();
		elapsed = end - start;
		System.out.println("Result: " + closedResult + " completed in " + elapsed + " ms");

	}

	public static void problem4() {
		int n = 10000000; // 10Million

		long start = System.currentTimeMillis();

		BigInteger result = new BigInteger("0");
		for (int i = 1; i <= n; i++) {
			BigInteger I = new BigInteger(i + "");
			BigInteger term = I.multiply(I);
			result = result.add(term);
		}

		long end = System.currentTimeMillis();
		long elapsed = end - start;
		System.out.println("Result: " + result + " completed in " + elapsed + " ms");

		// Time the closed form version below:
		start = System.currentTimeMillis();
		BigInteger number = new BigInteger("10000000");
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger three = new BigInteger("3");
		BigInteger closedResult = (one.multiply(number.pow(3)).add(two.multiply(number.pow(2))).add(number))
				.divide(three);

		// result = (2n^3 + 2n^2) + n / 3

		end = System.currentTimeMillis();
		elapsed = end - start;
		System.out.println("Result: " + closedResult + " completed in " + elapsed + " ms");

	}

}

/*
 * M-ary trees can have m^h leaves == true.
 * 
 * Anything^0 will be 1, and there is 1 leaf at the root node level. m^1 will be
 * m, and at height one, there can be at most m nodes, obviously. Thinking about
 * trees.. for each additional level, the maximum number of leaf nodes increase
 * by a multiple of m. Therefore, by adding 1 to height.. m^h+1.. is the same as
 * increasing my a multiple of m.... (m^h)*m. So this equation is consistent
 * with what a tree does.
 * 
 * 1. m^0 == 1. Always 1 root node at height 0. 2. m^1 == m. Always a maximum m
 * leafs at height 1 in an m-ary tree, obviously. 3. m^1 * m == m^2. Multiply
 * number of current leaf nodes by m, assuming all of them branch out to their
 * maximum. This is m^2. 4. m^n * m == m^n+1 == m^h. Repeating step 3 for n
 * number of nodes.
 */
