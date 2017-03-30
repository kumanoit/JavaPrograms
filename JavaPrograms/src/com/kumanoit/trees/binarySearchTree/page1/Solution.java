package com.kumanoit.trees.binarySearchTree.page1;

import java.util.Stack;

import com.kumanoit.trees.utils.Tree;

public class Solution {

	// http://www.geeksforgeeks.org/find-pairs-with-given-sum-such-that-pair-elements-lie-in-different-bsts/
	public static void findPairsWithGivenSum(Tree root1, Tree root2, int sum) {
		if (root1 == null || root2 == null) {
			System.out.println("Trees are empty.");
			return;
		}
		Tree ptr1 = root1;
		Tree ptr2 = root2;
		Stack<Tree> stack1 = new Stack<Tree>();
		Stack<Tree> stack2 = new Stack<Tree>();
		int value1 = 0;
		int value2 = 0;
		boolean flag1 = true;
		boolean flag2 = true;

		while (true) {
			while (flag1) {
				if (ptr1 != null) {
					stack1.push(ptr1);
					ptr1 = ptr1.getLeftChild();
				} else if (stack1.isEmpty()) {
					return;
				} else {
					ptr1 = stack1.pop();
					value1 = ptr1.getData();
					ptr1 = ptr1.getRightChild();
					flag1 = false;
				}
			}
			while (flag2) {
				if (ptr2 != null) {
					stack2.push(ptr2);
					ptr2 = ptr2.getRightChild();
				} else if (stack2.isEmpty()) {
					return;
				} else {
					ptr2 = stack2.pop();
					value2 = ptr2.getData();
					ptr2 = ptr2.getLeftChild();
					flag2 = false;
				}
			}
			int mySum = value1 + value2;
			if (mySum == sum) {
				System.out.println(value1 + " + " + value2 + " = " + sum);
				flag1 = true;
			} else if (mySum > sum) {
				flag2 = true;
			} else {
				flag1 = true;
			}
		}
	}

	// http://www.geeksforgeeks.org/check-if-given-sorted-sub-sequence-exists-in-binary-search-tree/
	private static int index = 0;

	public static void isSubSequencePresent(Tree root, int[] array) {
		index = 0;
		traverseTree(root, array);
		if (index == array.length) {
			System.out.println("Sequence is present");
		} else {
			System.out.println("Sequence is absent");
		}
	}

	private static void traverseTree(Tree root, int[] array) {
		if (root == null || index == array.length) {
			return;
		}
		traverseTree(root.getLeftChild(), array);
		if (root.getData() == array[index]) {
			index++;
		}
		traverseTree(root.getRightChild(), array);
	}

}
