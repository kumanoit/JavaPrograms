package com.kumanoit.arrays.miscellaneous;

public class PrintAllSubSets {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		printAllSubsets(arr, 0, new int[arr.length], 0);
	}

	public static void printAllSubsets(int[] array, int index, int[] output, int oi) {
		if (index == array.length) {
			for (int i = 0; i < oi; i++) {
				System.out.print(output[i]);
				if (i != oi - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
			return;
		}
		output[oi] = array[index];
		printAllSubsets(array, index + 1, output, oi + 1);
		printAllSubsets(array, index + 1, output, oi);
	}
}
