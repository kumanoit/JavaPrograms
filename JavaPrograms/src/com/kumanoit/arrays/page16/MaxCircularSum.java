package com.kumanoit.arrays.page16;

//http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
public class MaxCircularSum {

	public static void main(String[] args) {
		System.out.println(getMaxSumCircular(new int[] { 8, -8, 9, -9, 10, -11, 12 }));
		System.out.println(getMaxSumCircular(new int[] { 10, -3, -4, 7, 6, 5, -4, -1 }));
		System.out.println(getMaxSumCircular(new int[] { -1, 40, -14, 7, 6, 5, -4, -1 }));

	}

	private static int getMaxSumKadanesAlgorithm(int[] array) {
		int maxSum = 0;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum < 0) {
				sum = 0;
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	private static int getMaxSumCircular(int[] array) {
		int regularSum = getMaxSumKadanesAlgorithm(array);
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			array[i] = -array[i];
		}
		int circularSum = getMaxSumKadanesAlgorithm(array);
		return Math.max(regularSum, sum + circularSum);
	}
}
