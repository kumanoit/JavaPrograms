package com.kumanoit.arrays.page15;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
public class ArrangeNumbersToFormBiggestNumber {

	public static void main(String[] args) {
		arrangeNumbers(new int[] { 1, 34, 3, 98, 9, 76, 45, 4 });
		arrangeNumbers(new int[] { 54, 546, 548, 60 });
	}

	private static void arrangeNumbers(int[] array) {
		ArrayUtility.printArray(array);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (append(array[j], array[j + 1]) < append(array[j + 1], array[j])) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		ArrayUtility.printArray(array);
	}

	private static int append(int a, int b) {
		return Integer.parseInt(a + "" + b);
	}
}
