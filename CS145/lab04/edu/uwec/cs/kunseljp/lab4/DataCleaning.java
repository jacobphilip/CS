package edu.uwec.cs.kunseljp.lab4;

public class DataCleaning {
	public static void main(String[] args) {
		int dirtyDataArray[] = { 1, 0, 3, 0, 5, 6, 7, 4, 0, 0, 2 };
		
		System.out.println("Given Array");
		printArray(dirtyDataArray);
		System.out.println();
		
		System.out.println("Shuffle Left");
		shuffleLeft(dirtyDataArray);
		printArray(dirtyDataArray);
		int reallyDirtyData[] = { 0, 23, 42, 67, 19, 13, 0, 11, 0, 0 };
		shuffleLeft(reallyDirtyData);
		printArray(reallyDirtyData);
		System.out.println();

		System.out.println("Copy Over");
		int dirtyDataArray1[] = { 1, 0, 3, 0, 5, 6, 7, 4, 0, 0, 2 };
		copyOver(dirtyDataArray1);
		printArray(dirtyDataArray1);
		int reallyDirtyData1[] = { 0, 23, 42, 67, 19, 13, 0, 11, 0, 0 };
		copyOver(reallyDirtyData1);
		printArray(reallyDirtyData1);
		System.out.println();

		System.out.println("Converging Pointers");
		int dirtyDataArray2[] = { 1, 0, 3, 0, 5, 6, 7, 4, 0, 0, 2 };
		convergingPointers(dirtyDataArray2);
		printArray(dirtyDataArray2);
		int reallyDirtyData2[] = { 22, 0, 30, 0, 37, 0, 0, 54, 32, 34 };
		convergingPointers(reallyDirtyData2);
		printArray(reallyDirtyData2);

	}

	// method to print original array.
	public static void printArray(int inputArray[]) {
		System.out.print("(");
		for (int i = 0; i < inputArray.length; i++) {
			String output = "";
			output += inputArray[i] + ", ";
			System.out.print(output);
		}
		System.out.print(")\n");
	}

	// method of the shuffle-left algorithm
	public static void shuffleLeft(int inputArray[]) {
		int N = inputArray.length;
		int SP = 0;
		int RE = N - 1;
		int count = 0;
		while (SP <= RE) {
			if (inputArray[SP] != 0) {
				SP++;
			} else {

				int SPPrev = SP;
				int SPNext = SP + 1;
				while (SPNext <= RE) {
					inputArray[SPPrev] = inputArray[SPNext];
					SPNext++;
					SPPrev++;
					count++;
				}
				RE--;

			}
		}
		System.out.println(count);
	}

	// method of the copy-over algorithm
	public static void copyOver(int inputArray[]) {
		int left = 0;
		int newLeft = 0;
		int length;
		int count = 0;
		int newArray[] = new int[inputArray.length];
		while (left < inputArray.length) {
			if (inputArray[left] != 0) {
				newArray[newLeft] = inputArray[left];
				newLeft++;
			}
			left++;
			count++;
		}
		if (newLeft == 0) {
			length = 0;
		} else {
			length = newArray.length;
			left = 0;
			while (left < length) {
				inputArray[left] = newArray[left];
				left++;
			}
		}
		System.out.println(count);
	}

	// method of the converging-pointers algorithm
	public static void convergingPointers(int inputArray[]) {
		int RE = inputArray.length;
		int SP = 0;
		int count = 0;

		while (SP < RE - 1) {
			if (inputArray[SP] == 0) {
				inputArray[SP] = inputArray[RE - 1];
				RE = RE - 1;
				count++;
			} else {
				SP++;
			}
		}
		if (inputArray[RE - 1] == 0) {
			RE--;
			count++;
		}
		System.out.println(count);
	}
}