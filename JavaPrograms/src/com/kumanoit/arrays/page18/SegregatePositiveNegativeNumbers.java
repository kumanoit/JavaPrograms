package com.kumanoit.arrays.page18;

import com.kumanoit.utils.arrays.ArrayUtility;

public class SegregatePositiveNegativeNumbers {

	public static void main(String[] args) {
		segregateNegativePositive(new int[] { -1, 2, -3, 4, 5, 6, -7, 8, 9 });
	}

	/**
	 * @param array
	 * @return starting index of negative numbers
	 */
	public static int segregateNegativePositive(int[] array) {
		int start = 0;
		int end = array.length - 1;
//		ArrayUtility.printArray(array);

		while (start < end) {
			if (array[start] > 0) {
				start++;
			} else if (array[end] < 0) {
				end--;
			} else {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
//		System.out.println("After segregation...");
//		ArrayUtility.printArray(array);
		if (array[end] < 0) {
			return end - 1;
		} else {
			return end;
		}

	}

}
