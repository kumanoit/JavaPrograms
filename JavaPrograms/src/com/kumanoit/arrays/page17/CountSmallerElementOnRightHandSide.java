package com.kumanoit.arrays.page17;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
public class CountSmallerElementOnRightHandSide {

	public static void main(String[] args) {
		countSmallerElementOnRightHandSide(new int[] { 12, 1, 2, 3, 0, 11, 4 });
		countSmallerElementOnRightHandSide(new int[] {5, 4, 3, 2, 1});
		countSmallerElementOnRightHandSide(new int[] {1, 2, 3, 4, 5});
	}

	private static void countSmallerElementOnRightHandSide(int[] array) {
		int[] countSmaller = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					count++;
				}
			}
			countSmaller[i] = count;
		}
		System.out.println("\n\nSolution");
		ArrayUtility.printArray(array);
		ArrayUtility.printArray(countSmaller);
	}
}
