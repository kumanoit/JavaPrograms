package com.kumanoit.arrays.page16;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 6, -3, -10, 0, 2 }));
		System.out.println(maxProduct(new int[] { -1, -3, -10, 0, 60 }));
		System.out.println(maxProduct(new int[] { -2, -3, 0, -2, -40 }));
	}

	private static int maxProduct(int[] array) {
		int max = 1;
		int min = 1;
		int maxProd = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				max = min = 1;
			} else if (array[i] > 0) {
				max *= array[i];
				min *= array[i];
			} else {
				int temp = max;
				max = Math.max(min * array[i], 1);
				min = temp * array[i];
			}
			maxProd = Math.max(max, maxProd);
		}
		return maxProd;
	}
}
