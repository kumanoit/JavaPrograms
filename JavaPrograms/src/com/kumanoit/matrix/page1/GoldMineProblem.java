package com.kumanoit.matrix.page1;

import com.kumanoit.utils.arrays.ArrayUtility;

public class GoldMineProblem {

	public static void main(String[] args) {
		int[][] goldMatrix = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };
		System.out.println("\nMaximumAmount = " + getMaximumGold(goldMatrix, 3, 3));

		int[][] goldMatrix2 = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		System.out.println("\nMaximumAmount = " + getMaximumGold(goldMatrix2, 4, 4));

		int[][] goldMatrix3 = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		System.out.println("\nMaximumAmount = " + getMaximumGold(goldMatrix3, 4, 4));

		int[][] goldMatrix4 = { { 10, 33, 13, 15 } };
		System.out.println("\nMaximumAmount = " + getMaximumGold(goldMatrix4, 1, 4));

		int[][] goldMatrix5 = { { 10 }, { 33 }, { 13 }, { 15 } };
		System.out.println("\nMaximumAmount = " + getMaximumGold(goldMatrix5, 4, 1));
	}

	private static int getMaximumGold(int[][] matrix, int m, int n) {
		int[][] solMatrix = new int[m][n];
		for (int j = n - 1; j >= 0; j--) {
			for (int i = 0; i < m; i++) {
				if (j == n - 1) {
					solMatrix[i][j] = matrix[i][j];
					continue;
				}
				if (i == 0 && i + 1 < m) {
					solMatrix[i][j] = matrix[i][j] + Math.max(solMatrix[i + 1][j + 1], solMatrix[i][j + 1]);
				} else if (i == m - 1 && i - 1 >= 0) {
					solMatrix[i][j] = matrix[i][j] + Math.max(solMatrix[i - 1][j + 1], solMatrix[i][j + 1]);
				} else if (i + 1 < m && i - 1 >= 0) {
					solMatrix[i][j] = matrix[i][j]
							+ Math.max(solMatrix[i][j + 1], Math.max(solMatrix[i - 1][j + 1], solMatrix[i + 1][j + 1]));
				} else {
					solMatrix[i][j] = matrix[i][j] + solMatrix[i][j + 1];
				}
			}
		}
		ArrayUtility.printMatrix(solMatrix);
		int maxGolds = 0;
		for (int i = 0; i < m; i++) {
			maxGolds = Math.max(maxGolds, solMatrix[i][0]);
		}
		return maxGolds;
	}

}
