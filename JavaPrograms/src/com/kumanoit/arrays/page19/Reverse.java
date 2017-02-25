package com.kumanoit.arrays.page19;

import java.util.Arrays;

//http://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
public class Reverse {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.asList(array));
		reverse(array);
		System.out.println(Arrays.asList(array));
	}

	private static <T> void reverse(T[] array) {
		for (int i = 0, j = array.length - 1; i < j; i++, j--) {
			T temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}
