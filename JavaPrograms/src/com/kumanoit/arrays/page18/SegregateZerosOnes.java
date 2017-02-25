package com.kumanoit.arrays.page18;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
public class SegregateZerosOnes {

	public static void main(String[] args) {
		segregateZerosOnes(new int[] { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 });
	}

	public static void segregateZerosOnes(int[] array) {
		int start = 0;
		int end = array.length - 1;
		ArrayUtility.printArray(array);
		while (start < end) {
			if (array[start] == 0) {
				start++;
			} else if (array[end] == 1) {
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
