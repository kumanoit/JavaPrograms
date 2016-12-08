package com.kumanoit.matrix;

public class FindInverse {

	public static void main(String[] args) {
		double[][] mat = {
		        {1,2,3},
		        {9,2,1},
		        {4,6,7}
			};
		double[][] matA = {
				{ 3, 2, 3, 8}, 
				{ 4, 5, 6, 8},
				{ 6, 1, 6, 8},
				{ 7, 8, 9, 2}
			};
		double[][] sol = new double[mat.length][mat.length];
		initializeSol(sol);
		printMatrix(mat);
		printMatrix(sol);
		getInverse(mat, sol);
		printMatrix(mat);
		printMatrix(sol);
		multiply(matA, sol);
	}

	private static void getInverse(double[][] matrix, double[][] solution) {
		int rows = matrix.length;
		int cols = matrix.length;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				if (i == j) {
					if(matrix[i][j] != 1) {
						double divisor = matrix[i][j];
						if (divisor == 0) {
							System.out.println("Inverse doesn't exist.");
							return;
						}
						for (int k = 0; k < rows; k++) {
							matrix[k][j] = matrix[k][j] /divisor;
							solution[k][j] = solution[k][j] / divisor;
						}
					}
				} else {
					if (matrix[i][j] == 0) {
						continue;
					}
					double multiplier = matrix[i][j];
					for (int k = 0; k < rows; k++) {
						matrix[k][j] =  matrix[k][i] * multiplier - matrix[k][j];
						solution[k][j] = solution[k][i] * multiplier - solution[k][j];
					}
				}
			}
		}

		System.out.println("Solutin");
		printMatrix(solution);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				if (matrix[i][j] == 0) {
					continue;
				}
				double multiplier = matrix[i][j];
				for (int k = 0; k < rows; k++) {
					matrix[k][j] = matrix[k][j] - matrix[k][i] * multiplier;
					solution[k][j] = solution[k][j] - solution[k][i] * multiplier;
				}
			}
		}
	}

	private static void initializeSol(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = i == j ? 1 : 0;
			}
		}
	}

	private static void printMatrix(double[][] matrix) {
		System.out.println("\n");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				if (Math.abs(matrix[i][j]) < .00000000001) {
					matrix[i][j] = 0;
				}
				System.out.print(matrix[i][j] + "  ");
			}
		}
	}

	private static void multiply(double[][] a, double b[][]) {
		int rowA = a.length;
		int colA = a[0].length;
		int rowB = b.length;
		int colB = b[0].length;

		if (colA != rowB) {
			System.out.println("Incompatible matrix.");
			return;
		}
		double[][] product = new double[rowA][colB];
		for (int i = 0; i < rowA; i++) {
			for (int j = 0; j < colB; j++) {
				double total = 0;
				for (int k = 0; k < rowB; k++) {
					total += a[i][k] * b[k][j];
				}
				product[i][j] = total;
			}
		}
		
		System.out.println("\nOriginal matrix");
		printMatrix(a);
		System.out.println("\nInverse matrix");
		printMatrix(b);
		System.out.println("\nProduct");
		printMatrix(product);
	}
}
