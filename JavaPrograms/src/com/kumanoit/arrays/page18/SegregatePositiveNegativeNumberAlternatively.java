package com.kumanoit.arrays.page18;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
public class SegregatePositiveNegativeNumberAlternatively {

	public static void main(String[] args) {
		segregatePositiveNegativeAlternately(new int[] { -1, 2, -3, 4, 5, 6, -7, 8, 9 });
		segregatePositiveNegativeAlternately(new int[] { -1, 2, -3, 4, 5, 6, -7 });
		segregatePositiveNegativeAlternately(new int[] { -1, 2, -3, 4, 5, 6, -7, -8, -9 });
	}

	public static void segregatePositiveNegativeAlternately(int[] array) {
		ArrayUtility.printArray(array);
		int negativeIndex = SegregatePositiveNegativeNumbers.segregateNegativePositive(array) + 1;
		ArrayUtility.printArray(array);
		int i = 1;
		int j = negativeIndex;
		while (i < array.length && j < array.length && i < j && array[i] > 0) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			j++;
			i += 2;
		}
		ArrayUtility.printArray(array);
		System.out.println("\n\n");
	}
}
