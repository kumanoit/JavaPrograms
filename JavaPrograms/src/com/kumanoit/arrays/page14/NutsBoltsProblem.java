package com.kumanoit.arrays.page14;

import com.kumanoit.utils.arrays.ArrayUtility;

public class NutsBoltsProblem {

	public static void main(String[] args) {
		// int nuts[] = { '@', '#', '$', '%', '^', '&' };
		// int bolts[] = { '$', '%', '&', '^', '@', '#' };
//		int nuts[] = { 1, 4, 2, 6, 5, 3 };
//		int bolts[] = { 2, 6, 3, 5, 1, 4 };
		int[] nuts = { 1, 2, 3, 4, 5 };
		int[] bolts = { 5, 4, 3, 2, 1 };
		getSolution(nuts, bolts, 0, nuts.length - 1);
		ArrayUtility.printArray(nuts);
		ArrayUtility.printArray(bolts);
	}

	private static void getSolution(int[] nuts, int[] bolts, int low, int high) {
		if (low < high) {
			System.out.println(low + ", " + high);
			int pivot = partition(nuts, low, high, bolts[high]);
			partition(bolts, low, high, nuts[pivot]);
			System.out.println("bolts : ");
			ArrayUtility.printArray(bolts);
			System.out.println("nuts : ");
			ArrayUtility.printArray(nuts);
			System.out.println("pivot = " + pivot + "\n\n");
			getSolution(nuts, bolts, low, pivot - 1);
			getSolution(nuts, bolts, pivot + 1, high);
		}
	}

	private static int partition(int[] array, int start, int end, int value) {
		int j = start;
		int i = start;
		// ArrayUtility.printArray(array);
		// System.out.println(" key = " + value);
		while (i < end) {
			if (array[i] < value) {
				swap(array, i, j);
				j++;
			} else if (array[i] == value) {
				swap(array, i, end);
				i--;
			}
			i++;
		}
		swap(array, j, end);
		// ArrayUtility.printArray(array);
		// System.out.println("\n\n\n");
		return j;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
