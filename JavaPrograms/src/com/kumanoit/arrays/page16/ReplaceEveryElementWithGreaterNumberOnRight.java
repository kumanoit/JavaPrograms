package com.kumanoit.arrays.page16;

import com.kumanoit.utils.arrays.ArrayUtility;

public class ReplaceEveryElementWithGreaterNumberOnRight {

	public static void main(String[] args) {
		replaceEveryElementWithGreatestElement(new int[] { 16, 17, 4, 3, 5, 2 });
	}

	private static void replaceEveryElementWithGreatestElement(int[] array) {
		int max = -1;
		ArrayUtility.printArray(array);
		for (int i = array.length - 1; i >= 0; i--) {
			int newMax = Math.max(max, array[i]);
			array[i] = max;
			max = newMax;
		}
		ArrayUtility.printArray(array);
	}
}
