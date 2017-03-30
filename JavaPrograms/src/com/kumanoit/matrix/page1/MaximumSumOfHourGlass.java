package com.kumanoit.matrix.page1;

public class MaximumSumOfHourGlass {

	public static void main(String[] args) {
		int[][] matrix1 = { 
				{ 0, 3, 0, 0, 0 },
				{ 0, 1, 0, 0, 0 },
				{ 1, 1, 1, 0, 0 },
				{ 0, 0, 2, 4, 4 },
				{ 0, 3, 0, 2, 4 }
		};
		int[][] matrix2 = { 
				{ 1, 1, 1, 0, 0 },
				{ 0, 1, 0, 0, 0 },
				{ 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }
		};
		System.out.println(getMaxSum(matrix1));
		System.out.println(getMaxSum(matrix2));
	}

	private static int getMaxSum(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int maxSum = 0;
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				maxSum = Math.max(maxSum, matrix[i - 1][j - 1] + matrix[i - 1][j] + matrix[i - 1][j + 1] + matrix[i][j]
						+ matrix[i + 1][j - 1] + matrix[i + 1][j] + matrix[i + 1][j + 1]);
			}
		}
		return maxSum;
	}
}
