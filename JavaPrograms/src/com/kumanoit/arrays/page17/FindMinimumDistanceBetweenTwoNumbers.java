package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
public class FindMinimumDistanceBetweenTwoNumbers {

	public static void main(String[] args) {
		callMe(new int[] { 1, 2 }, 1, 2);
		callMe(new int[] { 3, 4, 5 }, 3, 5);
		callMe(new int[] { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 }, 3, 6);
		callMe(new int[] { 2, 5, 3, 5, 4, 4, 2, 3 }, 3, 2);
	}

	private static void callMe(int[] array, int x, int y) {
		System.out.println(getMinDistanceBetweenTwoNumbers(array, x, y));
		System.out.println(getMinDistanceBetweenXandY(array, x, y));
	}

	private static int getMinDistanceBetweenTwoNumbers(int[] array, int x, int y) {
		int xIndex = -1;
		int yIndex = -1;
		int minDistance = array.length;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				xIndex = i;
			} else if (array[i] == y) {
				yIndex = i;
			}
			if (xIndex != -1 && yIndex != -1) {
				minDistance = Math.min(minDistance, Math.abs(xIndex - yIndex));
			}
		}
		return minDistance;
	}

	private static int getMinDistanceBetweenXandY(int[] array, int x, int y) {
		int foundIndex = 0;
		int minDistance = array.length;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x || array[i] == y) {
				if (foundIndex != -1 && array[i] != array[foundIndex]) {
					minDistance = Math.min(minDistance, i - foundIndex);
				}
				foundIndex = i;
			}
		}
		return minDistance;
	}
}
