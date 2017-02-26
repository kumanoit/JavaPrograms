package com.kumanoit.arrays.page15;

import java.util.Arrays;

//http://www.geeksforgeeks.org/find-number-of-triangles-possible/
public class CountPossibleTriangles {

	public static void main(String[] args) {
		System.out.println(getTotalNumberOfTrianglesPossible(new int[] { 4, 6, 3, 7 }));
		System.out.println(getTotalNumberOfTrianglesPossible(new int[] { 10, 21, 22, 100, 101, 200, 300 }));
	}

	public static int getTotalNumberOfTrianglesPossible(int[] array) {
		Arrays.sort(array);
		int count = 0;
		for (int i = 0; i < array.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < array.length; j++) {
				int total = array[i] + array[j];
				while (k < array.length && total > array[k]) {
					System.out.println(array[i] + ", " + array[j] + ", " + array[k]);
					k++;
				}
				count += k - j - 1;
			}
		}
		return count;
	}
}
