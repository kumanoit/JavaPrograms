package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
public class FindMultipleDuplicates {

	public static void main(String[] args) {
		findDuplicates(new int[] { 1, 2, 3, 1, 3, 6, 6 });
	}

	private static void findDuplicates(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int newIndex = (array[i] > 0 ? array[i] : -array[i]) - 1;
			if (array[newIndex] < 0) {
				System.out.print((newIndex + 1) + "\t");
			} else {
				array[newIndex] = -array[newIndex];
			}
		}
	}
}
