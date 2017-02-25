package com.kumanoit.arrays.page18;

//http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
public class MaxSumNoElementConsecutive {

	public static void main(String[] args) {
		System.out.println(getMaxSum(new int[] { 5, 5, 10, 100, 10, 5 }));
		System.out.println(getMaxSum(new int[] { 1, 2, 3 }));
		System.out.println(getMaxSum(new int[] { 1, 20, 3 }));
	}

	private static int getMaxSum(int[] array) {
		int inclusive = array[0];
		int exclusive = 0;
		for (int i = 1; i < array.length; i++) {
			int newExclusive = Math.max(inclusive, exclusive);
			inclusive = exclusive + array[i];
			exclusive = newExclusive;
		}
		return Math.max(inclusive, exclusive);
	}
}
