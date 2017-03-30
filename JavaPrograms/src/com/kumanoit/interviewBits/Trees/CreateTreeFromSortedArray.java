package com.kumanoit.interviewBits.Trees;

import java.util.Arrays;
import java.util.List;

import com.kumanoit.trees.utils.Tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
 */
public class CreateTreeFromSortedArray {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3 };
		Tree root = createTreeFromSortedArray(Arrays.asList(array), array.length);
		root.display();
	}

	private static int index = 0;

	public static Tree createTreeFromSortedArray(List<Integer> array, int size) {
		if (size <= 0) {
			return null;
		}
		Tree left = createTreeFromSortedArray(array, size / 2);
		Tree root = new Tree(array.get(index++));
		Tree right = createTreeFromSortedArray(array, size - size / 2 - 1);
		root.setLeftChild(left);
		root.setRightChild(right);
		return root;
	}

}
