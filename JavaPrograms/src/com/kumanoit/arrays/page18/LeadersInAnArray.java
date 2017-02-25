package com.kumanoit.arrays.page18;

import java.util.ArrayList;
import java.util.List;

//http://www.geeksforgeeks.org/leaders-in-an-array/
public class LeadersInAnArray {

	public static void main(String[] args) {
		int[] array = {16, 17, 4, 3, 5, 2};
		printLeadersInAnArray(array);
	}

	public static void printLeadersInAnArray(int[] array) {
		List<Integer> leaders = new ArrayList<Integer>();
		int max = array[array.length - 1];
		leaders.add(max);
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > max) {
				max = array[i];
				leaders.add(max);
			}
		}
		System.out.println("Leaders in array are ");
		leaders.forEach(item -> System.out.print(item + "\t"));
	}
}
