package com.kumanoit.arrays.page16;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
public class FindSmallestMissingNumberInUnsortedArray {

	public static void main(String[] args) {
		System.out.println(findMissingNumber(new int[] { 2, 3, 7, 6, 8, -1, -10, 15 }));
		System.out.println(findMissingNumber(new int[] { 2, 3, -7, 6, 8, 1, -10, 15 }));
		System.out.println(findMissingNumber(new int[] { 1, 1, 0, -1, -2 }));
	}

	private static int segregateNegativePositive(int[] array) {
		int start = 0;
		int end = array.length - 1;
		ArrayUtility.printArray(array);

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
		ArrayUtility.printArray(array);
		if (array[end] < 0) {
			return end - 1;
		} else {
			return end;
		}

	}

	private static int findMissingNumber(int[] array) {
		int lastPositiveIndex = segregateNegativePositive(array);
		int missingNumber = lastPositiveIndex + 1;
		for (int i = 0; i <= lastPositiveIndex; i++) {
			int newIndex = (array[i] < 0 ? -array[i] : array[i]) - 1;
			if (newIndex >= 0 && newIndex <= lastPositiveIndex && array[newIndex] > 0) {
				array[newIndex] = -array[newIndex];
			}
		}
		for (int i = 0; i <= lastPositiveIndex; i++) {
			if (array[i] >= 0) {
				missingNumber = i + 1;
				break;
			}
		}
		return missingNumber;
	}
}
