package com.kumanoit.arrays.page18;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
public class SegregateEvenOdd {

	public static void main(String[] args) {
		int[] array = {12, 34, 45, 9, 8, 90, 3};
		segregateEvenOddNumbers(array);
	}

	public static void segregateEvenOddNumbers(int[] array) {
		int start = 0;
		int end = array.length - 1;
		ArrayUtility.printArray(array);
		while (start < end) {
			if (array[start] % 2 == 0) {
				start++;
			} else if (array[end] % 2 == 1) {
				end--;
			} else {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}
		ArrayUtility.printArray(array);
	}
}
