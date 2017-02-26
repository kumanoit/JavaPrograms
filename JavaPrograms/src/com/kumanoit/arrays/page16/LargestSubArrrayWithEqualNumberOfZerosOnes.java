package com.kumanoit.arrays.page16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
public class LargestSubArrrayWithEqualNumberOfZerosOnes {

	public static void main(String[] args) {
		print(new int[] { 1, 0, 1, 1, 1, 0, 0 });
		print(new int[] { 1, 1, 1, 1 });
		print(new int[] { 0, 0, 1, 1, 0 });
	}

	private static void print(int[] array) {
		int start = 0;
		int end = 0;
		int maxLength = -1;
		int temp[] = new int[array.length];
		temp = Arrays.copyOf(array, array.length);
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i] == 1 ? 1 : -1;
		}
		for (int i = 1; i < temp.length; i++) {
			temp[i] = temp[i] + temp[i - 1];
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 0) {
				start = 0;
				end = i - 1;
			}
			if (!map.keySet().contains(temp[i])) {
				map.put(temp[i], i);
			} else {
				if (i - map.get(temp[i]) > maxLength) {
					maxLength = i - map.get(temp[i]);
					start = map.get(temp[i]);
					end = i - 1;
				}
			}
		}
		if (maxLength > 0) {
			System.out.println("Max length = " + maxLength + " starting from " + (start + 1) + " ending at " + (end + 1));
			for (int i = start; i <= end; i++) {
				System.out.print(array[i] + "\t");
			}
		} else {
			System.out.println("No such subarray");
		}
		System.out.println();
	}
}
