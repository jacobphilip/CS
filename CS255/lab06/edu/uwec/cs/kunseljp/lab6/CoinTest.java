package edu.uwec.cs.kunseljp.lab6;

import java.util.*;

public class CoinTest {

	// Class to perform testing of the Coin class. Test the result for 29, 49,
	// and 63 with and without the 12 Coin.

	public static void main(String[] args) {

		ArrayList<Integer> coins = new ArrayList<Integer>();

		coins.add(1);
		coins.add(5);
		coins.add(10);
		coins.add(12);
		coins.add(25);

		Coins newCoins = new Coins(100, coins);

		System.out.println(newCoins.whichCoins(29));
		System.out.println(newCoins.whichCoins(49));
		System.out.println(newCoins.whichCoins(63));

	}

}
