package com.kumanoit.crackingTheCodingInterview.sortingSearching;

import com.kumanoit.utils.arrays.ArrayUtility;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr1 = { 4, 2, 6, 8, 3, 5, 9, 1, 6, 2 };
		insertionSort(arr1);
		int[] arr2 = { 1, 2, 3, 4, 5 };
		insertionSort(arr2);
		int[] arr3 = { 5, 4, 3, 2, 1 };
		insertionSort(arr3);
	}

	private static void insertionSort(int[] array) {
		ArrayUtility.printArray(array);
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
		ArrayUtility.printArray(array);
	}

}
