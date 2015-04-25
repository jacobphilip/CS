package edu.uwec.cs.kunseljp.lab6;

import java.util.*;

public class Coins {

	// Start at the minimum amount of change and work up to the maximum amount
	// of change, 100 sounds good. At each step compute the minimum number of
	// coins to get to that amount of change. This computation is found by
	// looking at previous values in the table.

	ArrayList<Integer> coinsUsed = new ArrayList<Integer>();
	ArrayList<Integer> lastCoin = new ArrayList<Integer>();

	public Coins(int maxChange, List<Integer> setOfCoins) {
		
		// add the initial value of 0 for both lists.
		coinsUsed.add(0, 0);
		lastCoin.add(0, 0);
		
		for(int i = 1; i <= maxChange; i++) {
			int minCoins = i;
			int newCoin = 1;
			for(int j = 0; j < setOfCoins.size(); j++) {
				if(setOfCoins.get(j) > i) {
					continue; // cannot use the coin
				} else if(coinsUsed.get(i - setOfCoins.get(j)) + 1 < minCoins) {
					minCoins = coinsUsed.get(i - setOfCoins.get(j)) + 1;
					newCoin = setOfCoins.get(j);
				}
			}
			coinsUsed.add(i, minCoins);
			lastCoin.add(i, newCoin);
		}
		System.out.println("Coins Used\t:" + coinsUsed);
		System.out.println("Last Coin\t:" + lastCoin);
	}

	// Method that returns a new list that holds the values of the coins used to
	// form the specified amountOfChange. Compute the list of coins by tracing
	// back through the lastAdded table. The amountOfChange requested should be
	// less than or equal to the maxChange amount in the constructor.

	public List<Integer> whichCoins(int amountOfChange) {
		// base case
		if (amountOfChange == 0) {
			return new ArrayList<Integer>();
		} else {
			List<Integer> result = whichCoins(amountOfChange - lastCoin.get(amountOfChange));
			result.add(lastCoin.get(amountOfChange));
			return result;
		}
	}

}
