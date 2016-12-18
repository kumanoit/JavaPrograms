/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.crackingTheCodingInterview.arraysStrings;

public class ArraysStrings {

	/**
	 * 1.1 Is Unique: Implement an algorithm to determine if a string has all
	 * unique characters. What if you cannot use additional data structures?
	 */

	public static boolean areAllCharactersUnique(String string) {
		boolean[] count = new boolean[26];
		for (int index = 0; index < string.length(); index++) {
			if (count[string.charAt(index) - 'a']) {
				return false;
			}
			count[string.charAt(index) - 'a'] = true;
		}
		return true;
	}

	public static boolean areAllCharactersUniqueWithoutExtraSpace(String string) {
		int flag = 0;
		for (int index = 0; index < string.length(); index++) {
			int newIndex = string.charAt(index) - 'a';
			if ((flag & (1 << newIndex)) > 0) {
				return false;
			}
			flag = flag | (1 << newIndex);
		}
		return true;
	}

	/**
	 * 1.2 Check Permutation: Given two strings, write a method to decide if one
	 * is a permutation of the other.
	 */
	public static boolean arePermutations(String stringA, String stringB) {
		if (stringA.length() != stringB.length()) {
			return false;
		}
		int[] count = new int[26];
		for (int index = 0; index < stringA.length(); index++) {
			count[stringA.charAt(index) - 'a']++;
			count[stringB.charAt(index) - 'a']--;
		}
		for (int index = 0; index < count.length; index++) {
			if (count[index] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 1.3 URLify: Write a method to replace all spaces in a string with '%20'.
	 * You may assume that the string has sufficient space at the end to hold the
	 * additional characters, and that you are given the "true" length of the
	 * string. (Note: If implementing in Java, please use a character array so
	 * that you can perform this operation in place.) EXAMPLE Input: "Mr John
	 * Smith ", 13 Output: "Mr%20John%20Smith"
	 */
	public static void replaceSpace(char[] input) {
		int length = input.length;
		for (int index = length - 1, k = length - 1; index >= 0; index--) {
			if (input[index] == ' ') {
				input[k--] = '0';
				input[k--] = '2';
				input[k--] = '%';
			} else if ((input[index] >= 'a' && input[index] <= 'z') || (input[index] >= 'A' && input[index] >= 'Z')) {
				input[k--] = input[index];
			}
		}
	}

	/**
	 * 1.4 Palindrome Permutation: Given a string, write a function to check if it
	 * is a permutation of a palindrome. A palindrome is a word or phrase that is
	 * the same forwards and backwards. A permutation is a rearrangement of
	 * letters. The palindrome does not need to be limited to just dictionary
	 * words. 1.5 1.6 EXAMPLE Input: Tact Coa Output: True (permutations: "taco
	 * cat", "atco eta", etc.)
	 */

	public static boolean isPermutationOfPalindrome(String string) {
		int num = 0;
		string = string.toLowerCase();
		for (int index = 0; index < string.length(); index++) {
			if (string.charAt(index) >= 'a' && string.charAt(index) <= 'z') {
				int newIndex = string.charAt(index) - 'a';
				num = (num ^ (1 << newIndex));
			}
		}
		return num == 0 || (num & (num - 1)) == 0;
	}

	/**
	 * 1.5
	 * 
	 * One Away: There are three types of edits that can be performed on strings:
	 * insert a character, remove a character, or replace a character. Given two
	 * strings, write a function to check if they are one edit (or zero edits)
	 * away. EXAMPLE pale, ple -> true pales, pale -> true pale, bale -> true
	 * pale, bake -> false
	 */
	public static int getMinEdit(String stringA, String stringB) {
		return getMinEdit(stringA, stringB, stringA.length() - 1, stringB.length() - 1);
	}

	private static int getMinEdit(String stringA, String stringB, int indexA, int indexB) {
		if (indexA < 0 && indexB < 0) {
			return 0;
		}

		if (indexA < 0) {
			return indexB + 1;
		}

		if (indexB < 0) {
			return indexA + 1;
		}

		if (stringA.charAt(indexA) == stringB.charAt(indexB)) {
			return getMinEdit(stringA, stringB, indexA - 1, indexB - 1);
		}
		return 1 + Math.min(
				Math.min(getMinEdit(stringA, stringB, indexA, indexB - 1), getMinEdit(stringA, stringB, indexA - 1, indexB)),
				getMinEdit(stringA, stringB, indexA - 1, indexB - 1));
	}

	public static int getMinEditDP(String stringA, String stringB) {
		int[][] memo = new int[stringA.length() + 1][stringB.length() + 1];
		for (int index = 1; index <= stringB.length(); index++) {
			memo[0][index] = index;
		}
		for (int index = 1; index <= stringA.length(); index++) {
			memo[index][0] = index;
		}
		for (int i = 1; i <= stringA.length(); i++) {
			for (int j = 1; j <= stringB.length(); j++) {
				if (stringA.charAt(i - 1) == stringB.charAt(j - 1)) {
					memo[i][j] = memo[i - 1][j - 1];
				} else {
					memo[i][j] = 1 + Math.min(Math.min(memo[i - 1][j], memo[i][j - 1]), memo[i - 1][j - 1]);
				}
			}
		}
		return memo[stringA.length()][stringB.length()];
	}

	/**
	 * 1.6 String Compression: Implement a method to perform basic string
	 * compression using the counts of repeated characters. For example, the
	 * string aabcccccaaa would become a2blc5a3. If the "compressed" string would
	 * not become smaller than the original string, your method should return the
	 * original string. You can assume the string has only uppercase and lowercase
	 * letters (a - z).
	 */
	public static String compressString(String string) {
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while (index < string.length()) {
			sb.append(string.charAt(index));
			int count = 1;
			while (index + 1 < string.length() && string.charAt(index) == string.charAt(index + 1)) {
				index++;
				count++;
			}
			index++;
			sb.append(count + "");
		}
		return sb.toString();
	}

	/**
	 * 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each
	 * pixel in the image is 4 bytes, write a method to rotate the image by 90
	 * degrees. Can you do this in place?
	 */
	public static void rotateImage(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i <= n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int oldValue = matrix[i][j];
				int oldI = i;
				int oldJ = j;
				int newI = 0;
				int newJ = 0;
				do {
					newI = oldJ;
					newJ = n - oldI - 1;
					System.out.println("(" + oldI + ", " + oldJ + ") -> " + "(" + newI + ", " + newJ + ")");
					int newValue = matrix[newI][newJ];
					matrix[newI][newJ] = oldValue;
					oldI = newI;
					oldJ = newJ;
					oldValue = newValue;
				} while (!(oldI == i && oldJ == j));
			}
		}
	}

	/**
	 * 1.8 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN
	 * matrix is 0, its entire row and column are set to 0.
	 */
	public static void convertAllRowsColumnsElementToZero(int[][] matrix, int m, int n) {

		boolean isFirstRowZero = false;
		boolean isFirstColumnZero = false;
		// checking if there was some 0 entry in first row
		for (int index = 0; index < n; index++) {
			if (matrix[0][index] == 0) {
				isFirstRowZero = true;
				break;
			}
		}

		// checking if there was some 0 entry in first column
		for (int index = 0; index < m; index++) {
			if (matrix[index][0] == 0) {
				isFirstColumnZero = true;
				break;
			}
		}

		// marking indexes for rows and columns in first row and first column
		// if element is zero in any cell
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					// setting column to 0 in first row
					matrix[0][j] = 0;
					// setting row value to 0 in first column
					matrix[i][0] = 0;
				}
			}
		}

		// setting column value to zero if there was 0 in first row
		for (int i = 1; i < n; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < m; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		// setting row value to zero if there was some 0 in first column
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// if first row was not zero then resetting value to 1
		if (isFirstRowZero) {
			for (int index = 0; index < n; index++) {
				matrix[0][index] = 0;
			}
		}

		// if first column was not zero then resetting value to 1
		if (isFirstColumnZero) {
			for (int index = 0; index < m; index++) {
				matrix[index][0] = 0;
			}
		}

	}

	/**
	 * 1.9 String Rotation:Assumeyou have a method isSubstringwhich checks if one
	 * word is a substring of another. Given two strings, sl and s2, write code to
	 * check if s2 is a rotation of sl using only one call to isSubstring (e.g.,
	 * "waterbottle" is a rotation of"erbottlewat").
	 */
	public static boolean isSubstring(String s1, String s2) {
		return s1.length() == s2.length() && (s1 + s1).contains(s2);
	}
}
