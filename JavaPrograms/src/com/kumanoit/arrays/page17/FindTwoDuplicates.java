package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
public class FindTwoDuplicates {

	public static void main(String[] args) {
		findTwoDuplicates(new int[] { 4, 2, 4, 5, 2, 3, 1 }, 5);
	}

	private static void findTwoDuplicates(int[] array, int n) {
		int xor = 0;
		int x = 0;
		int y = 0;
		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}
		for (int i = 0; i < array.length; i++) {
			xor ^= array[i];
		}
		int mask = xor & ~(xor - 1);
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & mask) == 0) {
				x ^= array[i];
			} else {
				y ^= array[i];
			}
		}
		for (int i = 1; i <= n; i++) {
			if ((i & mask) == 0) {
				x ^= i;
			} else {
				y ^= i;
			}
		}
		System.out.println("Duplicates = " + x + ", " + y);
	}
}
