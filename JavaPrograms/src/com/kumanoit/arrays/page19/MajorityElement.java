package com.kumanoit.arrays.page19;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.kumanoit.utils.arrays.ArrayUtility;

import java.util.Optional;

//http://www.geeksforgeeks.org/majority-element/
public class MajorityElement {

	public static void main(String[] args) {
		int[] array1 = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int[] array2 = { 3, 3, 4, 2, 4, 4, 2, 4 };
		callMe(array1);
		callMe(array2);
	}

	private static void callMe(int[] array) {
		System.out.println("Input: ");
		ArrayUtility.printArray(array);
		System.out.println("Via map method");
		System.out.println(getMajorityElementMap(array));
		System.out.println("Via Moore's law");
		System.out.println(getMajorityElementMooresLaw(array));
	}

	private static String getMajorityElementMap(int[] array) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			count.put(array[i], Optional.ofNullable(count.get(array[i])).orElse(0) + 1);
		}
		String majorityElement = "NONE";
		for (Entry<Integer, Integer> entry : count.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (value > array.length / 2) {
				majorityElement = key + "";
			}
		}
		;
		return majorityElement;
	}

	private static String getMajorityElementMooresLaw(int[] array) {
		int count = 0;
		int me = array[0];
		String majorityElement = "NONE";
		for (int i = 1; i < array.length; i++) {
			if (array[i] == me) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				count = 1;
				me = array[i];
			}
		}
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == me) {
				count++;
			}
		}
		if (count > array.length / 2) {
			majorityElement = me + "";
		}
		return majorityElement;
	}
}
