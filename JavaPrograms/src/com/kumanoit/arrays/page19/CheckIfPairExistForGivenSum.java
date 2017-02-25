package com.kumanoit.arrays.page19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
public class CheckIfPairExistForGivenSum {

	public static void main(String[] args) {
		int[] array = { 1, 4, 45, 6, 10, -8 };
		int x = 16;
		callMe(array, x);
	}

	private static void callMe(int[] array, int x) {
		checkPairExistsAfterSort(array, x);
		checkPairExistsHashing(array, x);
	}

	private static void checkPairExistsAfterSort(int[] array, int x) {
		Arrays.sort(array);
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			int sum = array[i] + array[j];
			if (sum < x) {
				i++;
			} else if (sum > x) {
				j--;
			} else {
				System.out.println("The pair exists : " + array[i] + " and " + array[j]);
				return;
			}
		}
		System.out.println("No such pair exists");
	}

	private static void checkPairExistsHashing(int[] array, int x) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (set.contains(x - array[i])) {
				System.out.println("Pair exists : " + array[i] + " and " + (x - array[i]));
				return;
			}
			set.add(array[i]);
		}
		System.out.println("No such pair exists");

	}
}
