package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
public class FindTwoNumberWithOddOccurrence {

	public static void main(String[] args) {
		findTwoNumbersWithOddOccurrence(new int[] { 12, 23, 34, 12, 12, 23, 12, 45 });
		findTwoNumbersWithOddOccurrence(new int[] { 4, 4, 100, 5000, 4, 4, 4, 4, 100, 100 });
		findTwoNumbersWithOddOccurrence(new int[] { 10, 20 });
	}

	public static void findTwoNumbersWithOddOccurrence(int[] array) {
		int xor = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < array.length; i++) {
			xor ^= array[i];
		}
		int mask = xor & ~(xor - 1);
		for (int i = 0; i < array.length; i++) {
			if ((mask & array[i]) == 0) {
				x ^= array[i];
			} else {
				y ^= array[i];
			}
		}
		System.out.println("Duplicates found = " + x + "\t" + y);
	}
}
