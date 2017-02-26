package com.kumanoit.arrays.page16;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
public class SortedSubsequenceOfSize3 {

	public static void main(String[] args) {
		findSortedSubsequence(new int[] { 12, 11, 10, 5, 6, 2, 30 });
		findSortedSubsequence(new int[] { 1, 2, 3, 4 });
		findSortedSubsequence(new int[] { 4, 3, 2, 1 });
	}

	public static void findSortedSubsequence(int[] array) {
		int[] smaller = new int[array.length];
		int[] greater = new int[array.length];
		boolean found = false;
		smaller[0] = array[0];
		System.out.println("For array : ");
		ArrayUtility.printArray(array);
		for (int i = 1; i < array.length; i++) {
			smaller[i] = Math.min(smaller[i - 1], array[i]);
		}
		greater[array.length - 1] = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			greater[i] = Math.max(greater[i + 1], array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] > smaller[i] && array[i] < greater[i]) {
				found = true;
				System.out.println("Triplet found : " + smaller[i] + "\t" + array[i] + "\t" + greater[i]);
			}
		}
		if (!found) {
			System.out.println("Triplet not found");
		}
	}
}
