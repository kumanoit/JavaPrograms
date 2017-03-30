package com.kumanoit.strings;

public class Combination {

	public static void main(String[] args) {
		String string = "ABCDE";
		printCombination(string.toCharArray(), 3);
	}

	public static void printCombination(char[] array, int k) {
		printCombination(array, array.length, k, new char[k], 0, 0);
	}

	private static void printCombination(char[] array, int size, int k, char[] output, int level, int start) {
		if (k == 0) {
			for (int i = 0; i < level; i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= size - k; i++) {
			output[level] = array[i];
			printCombination(array, size, k - 1, output, level + 1, i + 1);
		}
	}
}
