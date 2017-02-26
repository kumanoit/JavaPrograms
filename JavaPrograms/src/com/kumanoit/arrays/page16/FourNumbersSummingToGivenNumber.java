package com.kumanoit.arrays.page16;

import java.util.Arrays;

//http://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/
public class FourNumbersSummingToGivenNumber {

	public static void main(String[] args) {
		callMe(new int[] { 10, 2, 3, 4, 5, 9, 7, 8 }, 23);
	}

	private static void callMe(int[] array, int sum) {
		System.out.println("Naive : ");
		findQuadrupleNaive(array, sum);
		System.out.println("Better : ");
		findQuadrupleBetterSolution(array, sum);
		System.out.println("Best :");
		FindQuadrupleWithGivenSumBestSolution.findQuadruple(array, sum);
	}

	private static void findQuadrupleNaive(int[] array, int sum) {
		int n = array.length;
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				for (int k = j + 1; k < n - 1; k++) {
					for (int l = k + 1; l < n; l++) {
						if (sum == array[i] + array[j] + array[k] + array[l]) {
							System.out.println(array[i] + " + " + array[j] + " + " + array[k] + " + " + array[l] + " = " + sum);
							
						}
					}
				}
			}
		}
	}

	private static void findQuadrupleBetterSolution(int[] array, int sum) {
		Arrays.sort(array);
		int n = array.length;
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				int k = j + 1;
				int l = n - 1;
				while (k < l) {
					int total = array[i] + array[j] + array[k] + array[l];
					if (total == sum) {
						System.out.println(array[i] + " + " + array[j] + " + " + array[k] + " + " + array[l] + " = " + sum);
						k++;
						l--;
					} else if (total < sum) {
						k++;
					} else {
						l--;
					}
				}
			}
		}
	}
}
