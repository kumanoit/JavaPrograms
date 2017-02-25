package com.kumanoit.arrays.page18;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/a-product-array-puzzle/
public class ProductArrayPuzzle {

	public static void main(String[] args) {
		int[] array = {10, 3, 5, 6, 2};
		productArray(array);
	}

	public static void productArray(int[] array) {
		int[] left = new int[array.length];
		int[] right = new int[array.length];
		int[] result = new int[array.length];
		left[0] = 1;
		for (int i = 1; i < array.length; i++) {
			left[i] = left[i - 1] * array[i - 1];
		}
		right[array.length - 1] = 1;
		for (int i = array.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * array[i + 1];
		}
		for (int i = 0; i < array.length; i++) {
			result[i] = left[i] * right[i];
		}
		ArrayUtility.printArray(result);
	}
}
