/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.crackingTheCodingInterview.arraysStrings;

import com.kumanoit.utils.arrays.ArrayUtility;

public class ArraysStringsTest {

	private static void testUniqueCharacters() {
		String data1 = "abcdefghijklmnopqrstuvwxyz";
		String data2 = "abcdefghijklmnopzrstuvwxyz";
		System.out.println("Using extra space");
		System.out.println(ArraysStrings.areAllCharactersUnique(data1));
		System.out.println(ArraysStrings.areAllCharactersUnique(data2));
		System.out.println("Without using extra space");
		System.out.println(ArraysStrings.areAllCharactersUniqueWithoutExtraSpace(data1));
		System.out.println(ArraysStrings.areAllCharactersUniqueWithoutExtraSpace(data2));
	}

	private static void testIfStringsArePermutations() {
		System.out.println(ArraysStrings.arePermutations("teacher", "cheater"));
		System.out.println(ArraysStrings.arePermutations("amit", "kumar"));
		System.out.println(ArraysStrings.arePermutations("malyalam", "malyalam"));
	}

	private static void testReplaceString() {
		String string = "amit kumar$$";
		char[] newString = string.toCharArray();
		ArraysStrings.replaceSpace(newString);
		System.out.println(new String(newString));
	}

	private static void testIfPermutationOfPalindrome() {
		System.out.println(ArraysStrings.isPermutationOfPalindrome("taco cat"));
		System.out.println(ArraysStrings.isPermutationOfPalindrome("nitin"));
		System.out.println(ArraysStrings.isPermutationOfPalindrome("abcded"));
	}

	private static void testGetMinEdit() {
		System.out.println("Without DP");
		System.out.println(ArraysStrings.getMinEdit("pale", "ple"));
		System.out.println(ArraysStrings.getMinEdit("pale", "bale"));
		System.out.println(ArraysStrings.getMinEdit("pale", "pales"));
		System.out.println(ArraysStrings.getMinEdit("pale", "bake"));
		System.out.println("With DP");
		System.out.println(ArraysStrings.getMinEditDP("pale", "ple"));
		System.out.println(ArraysStrings.getMinEditDP("pale", "bale"));
		System.out.println(ArraysStrings.getMinEditDP("pale", "pales"));
		System.out.println(ArraysStrings.getMinEditDP("pale", "bake"));
	}

	private static void testIfSubstring() {
		System.out.println(ArraysStrings.isSubstring("amit", "mita"));
		System.out.println(ArraysStrings.isSubstring("amit", "amit"));
	}

	public static void testRowColumnToZero() {
		int[][] matrix = { { 0, 1, 1 }, // 1,1,1,1},
				{ 1, 0, 1 }, // 1,1,1,1},
				{ 1, 1, 1 }// ,1,1,1,1},
				// {1,0,1,1,1,1,1},
				// {1,1,1,1,0,1,1},
				// {1,1,0,1,1,1,1},
				// {1,1,1,1,1,1,1},
				// {1,0,1,1,0,0,1}
		};
		ArrayUtility.printMatrix(matrix);
		System.out.println("\nAfter conversion");
		ArraysStrings.convertAllRowsColumnsElementToZero(matrix, matrix.length, matrix[0].length);
		ArrayUtility.printMatrix(matrix);
	}

	public static void testStringCompression() {
		System.out.println(ArraysStrings.compressString("abcdjsdfs"));
		System.out.println(ArraysStrings.compressString("aabbccddee"));
		System.out.println(ArraysStrings.compressString("amitkuamsdfdd"));
		System.out.println(ArraysStrings.compressString("ababba"));
	}

	public static void testRotateImage() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		ArrayUtility.printMatrix(matrix);
		ArraysStrings.rotateImage(matrix);
		ArrayUtility.printMatrix(matrix);
	}

	public static void main(String[] args) {
		testRotateImage();
	}

}
