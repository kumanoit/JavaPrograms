package com.kumanoit.generics.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.kumanoit.generics.utils.trees.Constants;
import com.kumanoit.generics.utils.trees.TreeNode;
import com.kumanoit.generics.utils.trees.TreeUtility;
import com.kumanoit.utils.arrays.ArrayUtility;

public class Main {

	private static TreeNode<String> root1 = TreeUtility.createBinaryTree(Constants.array1);

	public static void testExpressionEvaluator() {
		root1.display();
		System.out.println(Problems.evaluateExpression(root1));
	}

	public static void main(String[] args) {

		int[] nuts = { 1, 2, 3, 4, 5 };
		int[] bolts = { 5, 4, 3, 2, 1 };
		ArrayUtility.printArray(nuts);
		ArrayUtility.printArray(bolts);
		sol(nuts, bolts, 0, nuts.length - 1);
		ArrayUtility.printArray(nuts);
		ArrayUtility.printArray(bolts);
//
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		ArrayList<Integer> list = new ArrayList<>();
//		for (int i = 0; i < array.length; i++) {
//			list.add(array[i]);
//		}
//		list.forEach(x -> System.out.print(x + ", "));
//		for (int i = 0; i < 4; i++) {
//			shuffler(list);
//		}
		// Random rand = new Random(1000);
		// int count = 10;
		// while (count > 0) {
		// System.out.println(rand.nextInt() % 100);
		// count--;
		// }
		// testExpressionEvaluator();
	}

	private static void sol(int[] nuts, int[] bolts, int low, int high) {
		if (low >= high) {
			return;
		}
		int pivot = getCorrectIndex(nuts, low, high, bolts[high]);
		getCorrectIndex(bolts, low, high, nuts[pivot]);
		sol(nuts, bolts, low, pivot - 1);
		sol(nuts, bolts, pivot + 1, high);
	}

	private static int getCorrectIndex(int[] array, int low, int high, int key) {
		int start = low;
		for (int i = low; i < high; i++) {
			if (array[i] == key) {
				swap(array, i, high);
				i--;
			} else if (array[i] < key) {
				swap(array, i, start);
				start++;
			}
		}
		swap(array, start, high);
		return start;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void shuffler(List<Integer> list) {
		Random rand = new Random();
		System.out.println();
		// list.forEach(x -> System.out.print(x + ", "));
		// System.out.println("\nRandom ordered");
		for (int i = list.size(); i > 1; i--) {
			int index = Math.abs(rand.nextInt()) % i;
			int temp = list.get(index);
			list.set(index, list.get(i - 1));
			list.set(i - 1, temp);
		}
		list.forEach(x -> System.out.print(x + ", "));
	}

}
