package com.kumanoit.arrays.page14;

public class CommonElementThreeSortedArrays {

	public static void main(String[] args) {
		int ar1[] = {1, 5, 10, 20, 40, 80};
		int ar2[] = {6, 7, 20, 80, 100};
		int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		getSolution(ar1, ar2, ar3);
	}

	private static void getSolution(int[] array1, int[] array2, int[] array3) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < array1.length && j < array2.length && k < array3.length) {
			if (array1[i] < array2[j]) {
				i++;
			} else if (array2[j] < array3[k]) {
				j++;
			} else if (array3[k] < array1[i]) {
				k++;
			} else {
				System.out.println(array1[i]);
				i++;
				j++;
				k++;
			}
		}
	}
}
