package com.kumanoit.arrays.miscellaneous;

/**
 * @author kumanoit Dec 17, 2015 AllPossibleSortedArraysFrom2SortedArrays.java
 */
public class AllPossibleSortedArraysFrom2SortedArrays {

	public static void main(String[] args) {
		int[] A = { 10, 15, 25 };
		int[] B = { 1, 5, 20, 30 };
		generate(A, B, 0, 0, true, new int[A.length + B.length], -1);
		System.out.println("\nBySecond method");
		printPath(A, B, 0, 0, -1, new int[A.length + B.length]);
	}

	private static void generate(int[] A, int[] B, int iA, int iB, boolean flag, int[] path, int level) {
		if (flag) {
			if (level > -1) {
				for (int i = 0; i <= level; i++) {
					System.out.print(path[i] + "\t");
				}
				System.out.println();
			}
			for (int i = iA; i < A.length; i++) {
				if (level == -1 || path[level] < A[i]) {
					path[level + 1] = A[i];
					generate(A, B, i + 1, iB, !flag, path, level + 1);
				}
			}
		} else {
			for (int i = iB; i < B.length; i++) {
				if (B[i] > path[level]) {
					path[level + 1] = B[i];
					generate(A, B, iA, i + 1, !flag, path, level + 1);
				}
			}
		}
	}

	private static void printPath(int[] A, int[] B, int iA, int iB, int level, int[] output) {
		if (level > -1) {
			for (int i = 0; i <= level; i++) {
				System.out.print(output[i] + "\t");
			}
			System.out.println();
		}
		for (int i = iA; i < A.length; i++) {
			if (level == -1 || output[level] < A[i]) {
				output[level + 1] = A[i];
				for (int j = iB; j < B.length; j++) {
					if (output[level + 1] < B[j]) {
						output[level + 2] = B[j];
						printPath(A, B, i, j, level + 2, output);
					}
				}
			}
		}
	}

}
