package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/find-the-first-missing-number//
public class GetSmallestMissingNumber {

	public static void main(String[] args) {
		callMe(new int[] { 0, 1, 2, 6, 9 }, 5, 10);
		callMe(new int[] { 4, 5, 10, 11 }, 4, 12);
		callMe(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 10 }, 9, 11);
		callMe(new int[] { 0, 1, 2, 3, 4, 5, 6, 7}, 8, 11);
		callMe(new int[] { 0, 1, 2, 3, 4, 5, 6, 7}, 8, 11);
	}

	private static void callMe(int[] array, int n, int m) {
		System.out.println("Linear solution : " + getSmallestMissingNumberBruteForce(array, m, n));
		System.out.println("Binary search : " + getSmallestMissing(array, 0, n - 1));
	}

	private static int getSmallestMissingNumberBruteForce(int[] array, int m, int n) {
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] != k) {
				break;
			}
			k++;
		}
		return k;
	}

	private static int getSmallestMissing(int[] array, int start, int end) {
		if (start > end) {
			return start;
		}
		int mid = start + (end - start) / 2;
		if (array[mid] == mid) {
			return getSmallestMissing(array, mid + 1, end);
		}
		return getSmallestMissing(array, start, mid - 1);
	}
}
