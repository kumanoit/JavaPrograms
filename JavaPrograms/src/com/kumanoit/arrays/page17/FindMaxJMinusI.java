package com.kumanoit.arrays.page17;

//	http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class FindMaxJMinusI {
	public static void main(String[] args) {
		callMe(new int[] { 34, 8, 10, 3, 2, 80, 30, 33, 1 });
		callMe(new int[] { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 });
		callMe(new int[] { 1, 2, 3, 4, 5, 6 });
		callMe(new int[] { 6, 5, 4, 3, 2, 1 });
	}

	private static void callMe(int[] array) {
		System.out.println("Brute force : " + getMaxJMinusIBruteForce(array));
		System.out.println("Simple solution" + getMaxJMinusI(array));
	}

	private static int getMaxJMinusIBruteForce(int[] array) {
		int maxJMinusI = -1;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					maxJMinusI = Math.max(maxJMinusI, j - i);
				}
			}
		}
		return maxJMinusI;
	}

	private static int getMaxJMinusI(int[] array) {
		int[] left = new int[array.length];
		int[] right = new int[array.length];
		left[0] = array[0];
		int max = -1;
		for (int i = 1; i < array.length; i++) {
			left[i] = Math.min(left[i - 1], array[i]);
		}
		right[array.length - 1] = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], array[i]);
		}
		int i = 0;
		int j = 0;
		while (j < array.length && i < array.length) {
			if (left[i] < right[j]) {
				max = Math.max(max, j - i);
				j++;
			} else {
				i++;
			}
		}
		return max;
	}
}
