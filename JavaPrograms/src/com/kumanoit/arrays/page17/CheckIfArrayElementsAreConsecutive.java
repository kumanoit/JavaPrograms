package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/
public class CheckIfArrayElementsAreConsecutive {

	public static void main(String[] args) {
		System.out.println(areArrayElementsConsecutive(new int[] { 5, 2, 3, 1, 4 }));
		System.out.println(areArrayElementsConsecutive(new int[] { 83, 78, 80, 81, 79, 82 }));
		System.out.println(areArrayElementsConsecutive(new int[] { 34, 23, 52, 12, 3 }));
		System.out.println(areArrayElementsConsecutive(new int[] { 7, 6, 5, 5, 3, 4 }));
	}

	private static boolean areArrayElementsConsecutive(int[] array) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			max = Math.max(array[i], max);
			min = Math.min(array[i], min);
		}
		if (max - min + 1 != array.length) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			int j = (array[i] > 0 ? array[i] : -array[i]) - min;
			if (array[j] < 0) {
				return false;
			} else {
				array[j] = -array[j];
			}
		}
		return true;
	}
}
