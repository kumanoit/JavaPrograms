package com.kumanoit.arrays.page18;

import java.util.ArrayList;
import java.util.List;

//http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
public class UnionIntersection {

	public static void main(String[] args) {
		int arr1[] = { 1, 3, 4, 5, 7 };
		int arr2[] = { 2, 3, 5, 6 };
		unionIntersection(arr1, arr2);
	}

	public static void unionIntersection(int[] array1, int[] array2) {
		List<Integer> union = new ArrayList<Integer>();
		List<Integer> intersection = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < array1.length && j < array2.length) {
			if (array1[i] == array2[j]) {
				intersection.add(array1[i]);
				union.add(array1[i]);
				i++;
				j++;
			} else if (array1[i] > array2[j]) {
				union.add(array2[j]);
				j++;
			} else {
				union.add(array1[i]);
				i++;
			}
		}
		while (i < array1.length) {
			union.add(array1[i++]);
		}
		while (j < array2.length) {
			union.add(array2[j++]);
		}
		System.out.println("Union: ");
		union.forEach(item -> System.out.print(item + "\t"));
		System.out.println("\nIntersection : ");
		intersection.forEach(item -> System.out.print(item + "\t"));
	}

}
