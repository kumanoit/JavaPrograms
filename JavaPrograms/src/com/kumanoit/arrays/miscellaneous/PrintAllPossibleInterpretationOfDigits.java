package com.kumanoit.arrays.miscellaneous;

/**
 * @author kuma wrote on Dec 10, 2016
 */
public class PrintAllPossibleInterpretationOfDigits {

	public static void main(String[] args) {
		int[] digits = {3, 1, 4};
		String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz"};
		printAllPossibleInterpretation(digits, digits.length, letters, 0,
				new char[digits.length]);
	}

	private static void printAllPossibleInterpretation(int[] digits, int n,
			String[] letters, int level, char[] output) {
		if (level == n) {
			for (int i = 0; i < level; i++) {
				if (output[i] == ' ') {
					continue;
				}
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}
		if (digits[level] == 0 || digits[level] == 1) {
			output[level] = ' ';
			printAllPossibleInterpretation(digits, n, letters, level + 1,
					output);
		} else {
			for (int i = 0; i < letters[digits[level]].length(); i++) {
				output[level] = letters[digits[level]].charAt(i);
				printAllPossibleInterpretation(digits, n, letters, level + 1,
						output);
			}
		}
	}

}
