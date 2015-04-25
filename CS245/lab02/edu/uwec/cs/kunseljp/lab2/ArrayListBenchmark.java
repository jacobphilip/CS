package edu.uwec.cs.kunseljp.lab2;

import java.util.*;

public class ArrayListBenchmark {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		long startTime;
		long endTime;
		long arrayListCreationTime;
		long arrayListTime;
		long arrayListPrimCreationTime;
		long arrayListPrimTime;
		long arrayListIntTime;
		long arrayListIntCreationTime;
		long arrayListGenericTime;
		long arrayListGenericCreationTime;

		// Array List
		startTime = System.currentTimeMillis();
		ArrayList arrayList = new ArrayList(1000000);
		endTime = System.currentTimeMillis();
		arrayListCreationTime = endTime - startTime;

		startTime = System.currentTimeMillis();
		fillArrayList(arrayList);
		endTime = System.currentTimeMillis();
		arrayListTime = endTime - startTime;

		// Array List of Primitives
		startTime = System.currentTimeMillis();
		int[] arrayListPrimitives = new int[1000000];
		endTime = System.currentTimeMillis();
		arrayListPrimCreationTime = endTime - startTime;

		startTime = System.currentTimeMillis();
		fillArrayPrim(arrayListPrimitives);
		endTime = System.currentTimeMillis();
		arrayListPrimTime = endTime - startTime;
		
		// Array List of Integers
		startTime = System.currentTimeMillis();
		Integer[] arrayListIntegers = new Integer[1000000];
		endTime = System.currentTimeMillis();
		arrayListIntCreationTime = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		fillArray(arrayListIntegers);
		endTime = System.currentTimeMillis();
		arrayListIntTime = endTime - startTime;
		
		// Array Lists of Generics
		startTime = System.currentTimeMillis();
		ArrayList<Integer> ints = new ArrayList<Integer>(1000000);
		endTime = System.currentTimeMillis();
		arrayListGenericCreationTime = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		fillArrayListGen(ints);
		endTime = System.currentTimeMillis();
		arrayListGenericTime = endTime - startTime;

		// Results
		System.out.println("Array list creation time : " + arrayListCreationTime + "ms.");
		System.out.println("Array list fill time : " + arrayListTime + "ms.\n");
		
		System.out.println("Array list of primatives creation time : " + arrayListPrimCreationTime+ "ms.");
		System.out.println("Array list of primatives fill time : " + arrayListPrimTime + "ms.\n");
		
		System.out.println("Array list of Integers creation time : " + arrayListIntCreationTime + "ms");
		System.out.println("Array list of Integers fill time : " + arrayListIntTime + "ms\n");
		
		System.out.println("Array List of Generics creation time: " + arrayListGenericCreationTime + "ms");
		System.out.println("Array List of Generics fill time: " + arrayListGenericTime + "ms\n");
		
		
}
	
	@SuppressWarnings("unchecked")
	public static void fillArrayList(ArrayList list) {
		for (int i = 0; i < 1000000; i++) {
			list.add(new Integer(i));
		}
	}
	public static void fillArrayPrim(int[] list) {
		for (int i = 0; i < 1000000; i++) {
			list[i] = i;
		}
	}
	public static void fillArray(Integer[] list) {
		for (int i = 0; i < 1000000; i++) {
			list[i] = i;
		}
	}
	public static void fillArrayListGen(ArrayList<Integer> list) {
		for (int i = 0; i < 1000000; i++) {
			list.add(new Integer(i));
		}
	}
}
