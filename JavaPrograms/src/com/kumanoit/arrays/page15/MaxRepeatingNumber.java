package com.kumanoit.arrays.page15;

//http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
public class MaxRepeatingNumber {
	public static void main(String[] args) {
		System.out.println(getMaximumRepeatingNumber(new int[] { 1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3 }, 10));
		System.out.println(getMaximumRepeatingNumber(new int[] { 2, 3, 3, 5, 3, 4, 1, 7 }, 8));

	}

	public static int getMaximumRepeatingNumber(int[] array, int k) {
		for (int i = 0; i < array.length; i++) {
			int newIndex = array[i] % k;
			array[newIndex] += k;
		}
		int max = -1;
		int maxIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
