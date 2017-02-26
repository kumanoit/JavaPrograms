package com.kumanoit.arrays.page16;

import java.util.Arrays;

public class TripletWithGivenSum {

	public static void main(String[] args) {
		findTriplet(new int[] { 1, 4, 45, 6, 10, 8 }, 22);
		findTriplet(new int[] { 1, 4, 45, 6, 10, 8 }, 13);
		findTriplet(new int[] { 1, 4, 45, 6, 10, 8 }, 18);
		findTriplet(new int[] { 1, 4, 45, 6, 10, 8 }, 61);
	}

	private static void findTriplet(int[] array, int sum) {
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			int j = i + 1;
			int k = array.length - 1;
			while (j < k) {
				int total = array[i] + array[j] + array[k];
				if (sum > total) {
					j++;
				} else if (sum < total) {
					k--;
				} else {
					System.out.println("Triplet found " + array[i] + " + " + array[j] + " + " + array[k] + " = " + total);
					j++;
				}
			}
		}
	}
}
