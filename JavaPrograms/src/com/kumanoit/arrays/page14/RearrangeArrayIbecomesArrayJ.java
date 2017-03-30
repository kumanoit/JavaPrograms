package com.kumanoit.arrays.page14;

import com.kumanoit.utils.arrays.ArrayUtility;

public class RearrangeArrayIbecomesArrayJ {

	public static void main(String[] args) {
		callMe(new int[] { 1, 3, 0, 2 });
		callMe(new int[] { 2, 0, 1, 4, 5, 3 });
		callMe(new int[] { 0, 1, 2, 3 });
		callMe(new int[] { 3, 2, 1, 0 });
	}

	private static void callMe(int[] array) {
		rearrangeUsingTemp(array);
	}

	public static void rearrangeUsingTemp(int[] array) {
		int[] temp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int j = array[i];
			temp[j] = i;
		}
		ArrayUtility.printArray(temp);
	}

	public static void betterSolution(int[] array) {
		int start = 0;
		int oldValue = -array[0];
		int index = 0;
	}
}
