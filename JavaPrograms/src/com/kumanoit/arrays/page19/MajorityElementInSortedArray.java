package com.kumanoit.arrays.page19;

public class MajorityElementInSortedArray {

	public static void main(String[] args) {
		System.out.println(findMajorityNumberInSortedArray(new int[] { 1, 2, 3, 3, 3, 3, 10 }));
	}

	public static String findMajorityNumberInSortedArray(int[] array) {
		int majorityElementCandidate = array[array.length / 2];
		int leftIndex = getLeftIndex(array, majorityElementCandidate, 0, array.length / 2);
		if (array[leftIndex + array.length / 2] == majorityElementCandidate) {
			return majorityElementCandidate + "";
		}
		return "NONE";
	}

	private static int getLeftIndex(int[] array, int key, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (array[mid] == key) {
			if (mid == 0 || array[mid - 1] != key) {
				return mid;
			} else {
				return getLeftIndex(array, key, low, mid - 1);
			}
		} else if (array[mid] > key) {
			return getLeftIndex(array, key, low, mid - 1);
		}
		return getLeftIndex(array, key, mid + 1, high);
	}
}
