package com.kumanoit.arrays.page19;

import com.kumanoit.utils.arrays.ArrayUtility;

//http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
public class MergeAnArrayNInMPlusN {

	public static void main(String[] args) {
		int[] a = { 2, -1, -1, 5, -1, 10, 15, 20, 22, -1, -1, 25 };
		int[] b = { 4, 9, 14, 19, 30 };
		int n = b.length;
		int m = a.length - n;
		ArrayUtility.printArray(a);
		ArrayUtility.printArray(b);
		mergeArrays(a, b, m, n);
		System.out.println("After merging");
		ArrayUtility.printArray(a);
	}

	private static void mergeArrays(int[] a, int[] b, int m, int n) {

		for (int i = a.length - 1, last = a.length - 1; last >= n; i--) {
			if (a[i] != -1) {
				int temp = a[i];
				a[i] = a[last];
				a[last] = temp;
				last--;
			}
		}

		ArrayUtility.printArray(a);
		int i = 0;
		int j = n;
		int k = 0;
		while (i < n && j < m) {
			if (a[j] < b[i]) {
				a[k++] = a[j++];
			} else {
				a[k++] = b[i++];
			}
		}
		while (i < n) {
			a[k++] = b[i++];
		}
	}

}
