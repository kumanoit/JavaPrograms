package com.kumanoit.arrays.page18;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/move-zeroes-end-array/
public class SegregateZerosToEnd {

	public static void main(String[] args) {
		segregateZerosToEnd(new int[] { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 });
	}

	private static void segregateZerosToEnd(int[] array) {
		int start = 0;
		int end = array.length - 1;
		ArrayUtility.printArray(array);
		while (start < end) {
			if (array[start] != 0) {
				start++;
			} else if (array[end] == 0) {
				end--;
			} else {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
		ArrayUtility.printArray(array);
	}
}
