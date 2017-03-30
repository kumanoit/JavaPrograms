package com.kumanoit.arrays.page14;

//http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
public class LongestContiguousSubarray {

	public static void main(String[] args) {

		largestSubarrayWithContiguousSubarray(new int[] { 10, 12, 11 });
		largestSubarrayWithContiguousSubarray(new int[] { 14, 12, 11, 20 });
		largestSubarrayWithContiguousSubarray(new int[] { 1, 56, 58, 57, 90, 92, 94, 93, 91, 45 });
	}

	public static void largestSubarrayWithContiguousSubarray(int[] array) {
		int maxLength = 1;
		int start = 0;
		int end = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			int max = array[i];
			for (int j = i + 1; j < array.length; j++) {
				min = Math.min(min, array[j]);
				max = Math.max(max, array[j]);
				if (max - min == j - i) {
					if (maxLength < max - min + 1) {
						maxLength = max - min + 1;
						start = i;
						end = j;
					}
				}
			}
		}
		for (int i = start; i <= end; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println("\nMaxLength = " + maxLength);
	}
}
