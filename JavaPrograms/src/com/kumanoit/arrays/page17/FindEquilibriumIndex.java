package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
public class FindEquilibriumIndex {

	public static void main(String[] args) {
		System.out.println(getEquilibriumIndex(new int[] { -7, 1, 5, 2, -4, 3, 0 }));
	}

	private static int getEquilibriumIndex(int[] array) {
		int leftSum = array[0];
		int totalSum = 0;
		for (int i = 0; i < array.length; i++) {
			totalSum += array[i];
		}
		for (int i = 1; i < array.length; i++) {
			if (leftSum == totalSum - leftSum - array[i]) {
				System.out.println(i);
				return i;
			}
			leftSum += array[i];
		}
		return -1;
	}
}
