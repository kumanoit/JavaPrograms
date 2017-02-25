package com.kumanoit.arrays.page18;

//http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class LargestDifference {

	public static void main(String[] args) {
		System.out.println(getLargestDifference(new int[] { 2, 3, 10, 6, 4, 8, 1 }));
		System.out.println(getLargestDifference(new int[] { 7, 9, 5, 6, 3, 2 }));
		System.out.println(getLargestDifference(new int[] { 80, 2, 6, 3, 100 }));
	}

	public static int getLargestDifference(int[] array) {
		int min = array[0];
		int maxDifference = -1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			} else {
				maxDifference = Math.max(maxDifference, array[i] - min);
			}
		}
		return maxDifference;
	}
}
