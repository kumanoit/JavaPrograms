package com.kumanoit.arrays.page19;

//http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
public class FindNumberOccurringOddNumberOfTimes {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 3, 1, 3 };
		System.out.println(findNumberOccurringOddNumberOfTimes(array));
		System.out.println(findNumberOccurringOddNumberOfTimes(new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 }));
	}

	private static int findNumberOccurringOddNumberOfTimes(int[] array) {
		int x = 0;
		for (int i = 0; i < array.length; i++) {
			x ^= array[i];
		}
		return x;
	}
}
