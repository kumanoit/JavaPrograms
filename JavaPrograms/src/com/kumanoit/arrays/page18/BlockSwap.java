package com.kumanoit.arrays.page18;

import java.util.Arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

public class BlockSwap {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 2;
		callMe(array, d);
	}

	private static void callMe(int[] array, int d) {
		int[] copy1 = Arrays.copyOf(array, array.length);
		int[] copy2 = Arrays.copyOf(array, array.length);
		int[] copy3 = Arrays.copyOf(array, array.length);
		System.out.println("Original array");
		ArrayUtility.printArray(array);
		blockSwapAlgorithm1(array, d);
		System.out.println("From complex algorithm");
		ArrayUtility.printArray(array);

		System.out.println("\nOriginal array");
		ArrayUtility.printArray(copy1);
		System.out.println("Recursive simple algorithm");
		blockSwapAlgorithm2(copy1, d);
		ArrayUtility.printArray(copy1);

		System.out.println("\nOriginal array");
		ArrayUtility.printArray(copy2);
		System.out.println("Iterative simple algorithm");
		blockSwapIterative(copy2, d);
		ArrayUtility.printArray(copy2);

		System.out.println("\nOriginal array");
		ArrayUtility.printArray(copy3);
		System.out.println("Reversing algorithm");
		rotate(copy3, d);
		ArrayUtility.printArray(copy3);

	}

	/**
	 * O(n^2)
	 */
	private static void blockSwapAlgorithm1(int[] array, int d) {
		for (int i = 0; i < d; i++) {
			int temp = array[0];
			for (int j = 1; j < array.length; j++) {
				array[j - 1] = array[j];
			}
			array[array.length - 1] = temp;
		}
	}

	/**
	 * O(n) : Recursive
	 */
	private static void blockSwapAlgorithm2(int[] array, int d) {
		blockSwap(array, d, array[0], 0, 0, 0);
	}

	private static void blockSwap(int[] array, int d, int oldValue, int oldIndex, int start, int count) {
		if (count == array.length) {
			return;
		}
		int newIndex = (oldIndex - d + array.length) % array.length;
		int newValue = array[newIndex];
		array[newIndex] = oldValue;
		if (start == newIndex) {
			return;
		}
		blockSwap(array, d, newValue, newIndex, start, count + 1);
	}

	/**
	 * O(n) : Iterative
	 */
	private static void blockSwapIterative(int[] array, int d) {
		int oldValue = array[0];
		int oldIndex = 0;
		int newIndex = -1;
		int newValue = -1;
		int count = 0;
		while (count < array.length) {
			count++;
			newIndex = (oldIndex - d + array.length) % array.length;
			newValue = array[newIndex];
			array[newIndex] = oldValue;
			oldValue = newValue;
			oldIndex = newIndex;
		}
	}

	/**
	 * O(n) : by reversing
	 */
	private static void rotate(int[] array, int d) {
		reverse(array, 0, d);
		reverse(array, d, array.length);
		reverse(array, 0, array.length);
	}

	private static void reverse(int[] array, int start, int end) {
		for (int i = start, j = end - 1; i < j; i++, j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}
