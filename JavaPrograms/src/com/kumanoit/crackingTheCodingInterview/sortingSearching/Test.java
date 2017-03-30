package com.kumanoit.crackingTheCodingInterview.sortingSearching;

import java.util.ArrayList;
import java.util.List;

import com.kumanoit.utils.arrays.ArrayUtility;

public class Test {

	public static void testMergeTwoArrays() {
		int[] arrayA = { 1, 5, 8, 12, 15, 18, -1, -1, -1, -1 };
		int[] arrayB = { 2, 7, 11, 19 };
		int sizeA = arrayA.length - arrayB.length;
		ArrayUtility.printArray(arrayA);
		Solution.sortArray(arrayA, arrayB, sizeA);
		ArrayUtility.printArray(arrayB);
		ArrayUtility.printArray(arrayA);
	}

	public static void testCollectingAnagrams() {
		List<String> wordList = new ArrayList<String>();
		wordList.add("cat"); wordList.add("tame"); wordList.add("emit");
		wordList.add("mate"); wordList.add("mite"); wordList.add("tac");
		wordList.add("time"); wordList.add("act"); wordList.add("meat");
		Solution.groupAllAnagramsTogether(wordList);
	}

	public static void main(String[] args) {
		testCollectingAnagrams();
	}
}
