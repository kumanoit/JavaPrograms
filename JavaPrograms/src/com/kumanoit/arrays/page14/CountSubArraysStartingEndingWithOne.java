package com.kumanoit.arrays.page14;

//http://www.geeksforgeeks.org/given-binary-string-count-number-substrings-start-end-1/
public class CountSubArraysStartingEndingWithOne {

	public static void main(String[] args) {
		System.out.println(getCount("00100101".toCharArray()));
	}

	private static int getCount(char[] array) {
		int len = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1') {
				len++;
			}
		}
		return len * (len - 1) / 2;
	}
}
