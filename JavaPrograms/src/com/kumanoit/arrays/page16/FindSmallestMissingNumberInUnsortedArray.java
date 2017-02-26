package com.kumanoit.arrays.page16;

import com.kumanoit.arrays.page18.SegregatePositiveNegativeNumbers;

//http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
public class FindSmallestMissingNumberInUnsortedArray {

	public static void main(String[] args) {
		System.out.println(findMissingNumber(new int[] { 2, 3, 7, 6, 8, -1, -10, 15 }));
		System.out.println(findMissingNumber(new int[] { 2, 3, -7, 6, 8, 1, -10, 15 }));
		System.out.println(findMissingNumber(new int[] { 1, 1, 0, -1, -2 }));
	}

	public static int findMissingNumber(int[] array) {
		int lastPositiveIndex = SegregatePositiveNegativeNumbers.segregateNegativePositive(array);
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
