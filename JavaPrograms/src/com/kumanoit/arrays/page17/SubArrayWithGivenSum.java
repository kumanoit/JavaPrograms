package com.kumanoit.arrays.page17;

//http://www.geeksforgeeks.org/find-subarray-with-given-sum/
public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 20, 3, 10, 5 };
		int sum = 33;
		callMe(arr, sum);
		callMe(arr, 1);
		callMe(arr, 20);
		callMe(arr, 5);
		callMe(arr, 18);
		callMe(arr, 43);
		callMe(new int[] { 1, 4, 0, 0, 3, 10, 5 }, 7);
		callMe(new int[] { 1, 4 }, 0);
	}

	private static void callMe(int[] array, int sum) {
		findSubArrayWithGivenSum(array, sum);
		findSubArrayWithGivenSum2(array, sum);
	}

	private static void findSubArrayWithGivenSum(int[] array, int sum) {
		int start = 0;
		int end = 0;
		int total = array[0];
		while (end < array.length) {
			if (total < sum) {
				total += array[++end];
			} else if (total > sum) {
				total -= array[start++];
			} else {
				if (start > end) {
					continue;
				}
				System.out.print("\nSum = " + sum + " found : {");
				for (int i = start; i <= end; i++) {
					System.out.print(array[i] + "\t");
				}
				System.out.print("}");
				return;
			}
		}
		System.out.println("\nSum = " + sum + " not found");
	}

	private static void findSubArrayWithGivenSum2(int[] array, int sum) {
		int total = 0;
		int i = 0;
		int j = 0;
		for (i = 0; i < array.length; i++) {
			total = array[i];
			if (total == sum) {
				j = i;
				System.out.print("\nSum = " + sum + " found : {" + array[i] + "}");
				return;
			}
			for (j = i + 1; j < array.length; j++) {
				total += array[j];
				if (total > sum) {
					break;
				} else if (total == sum) {
					System.out.print("\nSum  = " + sum + " found : {");
					for (int k = i; k <= j; k++) {
						System.out.print(array[k] + "\t");
					}
					System.out.print("}");
					return;
				}
			}
		}
		System.out.println("\nSum = " + sum + " not found.\n\n\n");
	}
}
