package com.kumanoit.arrays.page14;

//http://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
public class LongestContinuousSequence {

	public static void main(String[] args) {
		replaceZero(new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, 1);
		replaceZero(new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, 2);
	}

	public static void replaceZero(int[] array, int zeroCount) {
		int start = 0;
		int maxLength = -1;
		int end = 0;
		while (end < array.length) {
			if (array[end] == 0) {
				zeroCount--;
			}
			if (zeroCount < 0) {
				while (start < end && array[start] == 1) {
					start++;
				}
				start++;
				zeroCount++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
			end++;
		}
		System.out.println("Max Length = " + maxLength);
		for (int i = start; i < end; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
}
