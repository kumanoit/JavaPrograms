/**
 * 
 * Created by Amit Kumar on 28/01/17.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees.page3;

import java.util.ArrayList;
import java.util.List;

import com.kumanoit.trees.TreeSamples;
import com.kumanoit.trees.utils.TreeData;

public class Test {

	private static void testDiagonalPrint() {
		Solution.printDiagonal(TreeData.root1);
	}

	private static void testSinkOddEven() {
		TreeSamples.root2.display();
		Solution.sinkOddEven(TreeSamples.root2);
		TreeSamples.root2.display();
	}

	public static void main(String[] args) {
		testSinkOddEven();
	}

	public static void main2(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(3);
		list2.add(4);
		list2.add(5);

		printList(list1);
		printList(list2);

		List<List<Integer>> solution = getAllCombination(list1, list2);
		System.out.println("\nSize = " + solution.size());
		for (List<Integer> sol : solution) {
			printList(sol);
		}
	}

	/**
	 * What is the total number of ways to mix-up 2 arrays of size n and m such
	 * that the arrangement of all elements of both arrays remains same? Eg. A =
	 * {1, 2} and B = {3, 4} mix up will have 6 arrays 1 2 3 4 1 3 2 4 1 3 4 2 3 1
	 * 2 4 3 1 4 2 3 4 1 2
	 */

	private static void printList(List<Integer> list) {
		System.out.println();
		list.forEach(item -> System.out.print(item + " "));
	}

	public static List<List<Integer>> getAllCombination(List<Integer> list1, List<Integer> list2) {
		List<List<Integer>> solution = new ArrayList<List<Integer>>();
		List<Integer> miniList = new ArrayList<Integer>();
		getAllCombinationOfList(list1, list2, solution, miniList, 0, 0, 0);
		return solution;
	}

	private static void getAllCombinationOfList(List<Integer> list1, List<Integer> list2,
			List<List<Integer>> solutionList, List<Integer> miniList, int i, int j, int k) {
		if (miniList.size() == list1.size() + list2.size()) {
			solutionList.add(new ArrayList(miniList)); // store a copy of miniList
			return;
		}
		if (list1.size() == i) {
			List<Integer> list = new ArrayList(miniList);
			while (j < list2.size()) {
				list.add(list2.get(j++));
			}
			solutionList.add(list);
		} else if (list2.size() == j) {
			List<Integer> list = new ArrayList(miniList);
			while (i < list1.size()) {
				list.add(list1.get(i++));
			}
			solutionList.add(list);
		} else {
			miniList.add(list1.get(i));
			getAllCombinationOfList(list1, list2, solutionList, miniList, i + 1, j, k + 1);
			miniList.remove(k);
			miniList.add(list2.get(j));
			getAllCombinationOfList(list1, list2, solutionList, miniList, i, j + 1, k + 1);
			miniList.remove(k);
		}
	}
}
