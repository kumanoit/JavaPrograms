/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

import java.util.Stack;

public class BinarySearchTree {

	private static int localSum = 0;

	// remove all nodes which doesn't lie in given range
	public static Tree removeBinarySearchTreeOutsideGivenRange(Tree root, int lower, int higher) {
		if (root == null) {
			return root;
		}
		root.setLeftChild(removeBinarySearchTreeOutsideGivenRange(root.getLeftChild(), lower, higher));
		root.setRightChild(removeBinarySearchTreeOutsideGivenRange(root.getRightChild(), lower, higher));

		if (root.getData() < lower) {
			return root.getRightChild();
		}
		if (root.getData() > higher) {
			return root.getLeftChild();
		}
		return root;
	}

	// Miscellaneous.createBalancedBinarySearchTree(Constants.array2, 0,
	// Constants.array2.length - 1).display();;
	public static Tree createBalancedBinarySearchTree(Integer[] array, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		Tree root = new Tree(array[mid]);
		root.setLeftChild(createBalancedBinarySearchTree(array, low, mid - 1));
		root.setRightChild(createBalancedBinarySearchTree(array, mid + 1, high));
		return root;
	}

	// checks if there exist a pair of nodes with given sum
	public static void doesSumExistInABst(Tree root, int sum) {
		if (!checkForSumExistence(root, sum)) {
			System.out.println("Sum not found");
		}
	}

	public static boolean checkForSumExistence(Tree root, int sum) {
		Tree ptr1 = root;
		Tree ptr2 = root;
		Stack<Tree> stack1 = new Stack<Tree>();
		Stack<Tree> stack2 = new Stack<Tree>();
		int value1 = 0;
		int value2 = 0;
		boolean leftSearch = true;
		boolean rightSearch = true;
		while (true) {
			while (leftSearch) {
				if (ptr1 != null) {
					stack1.push(ptr1);
					ptr1 = ptr1.getLeftChild();
				} else if (stack1.isEmpty()) {
					return false;
				} else {
					ptr1 = stack1.pop();
					value1 = ptr1.getData();
					ptr1 = ptr1.getRightChild();
					leftSearch = false;
				}
			}
			while (rightSearch) {
				if (ptr2 != null) {
					stack2.push(ptr2);
					ptr2 = ptr2.getRightChild();
				} else if (stack2.isEmpty()) {
					return false;
				} else {
					ptr2 = stack2.pop();
					value2 = ptr2.getData();
					ptr2 = ptr2.getLeftChild();
					rightSearch = false;
				}
			}
			if (value1 >= value2) {
				return false;
			} else {
				int localSum = value1 + value2;
				if (localSum < sum) {
					leftSearch = true;
				} else if (localSum > sum) {
					rightSearch = true;
				} else {
					System.out.println("Nodes are " + value1 + " " + value2 + " = " + sum);
					break;
				}
			}
		}
		return true;
	}

	// updates values in a bst such that a value is replaced by sum of all nodes
	// which is greater than current node
	public static void convertBinaryTreeSumOfAllGreaterNodesIsAddedToTree(Tree root) {
		if (root == null) {
			return;
		}
		convertBinaryTreeSumOfAllGreaterNodesIsAddedToTree(root.getRightChild());
		localSum += root.getData();
		root.setData(localSum);
		convertBinaryTreeSumOfAllGreaterNodesIsAddedToTree(root.getLeftChild());
	}

	// updates values in a bst such that a value is replaced by sum of all nodes
	// which is greater than current node
	public static void convertBinaryTreeSumOfAllLesserNodesIsAddedToTree(Tree root) {
		if (root == null) {
			return;
		}
		convertBinaryTreeSumOfAllLesserNodesIsAddedToTree(root.getLeftChild());
		localSum += root.getData();
		root.setData(localSum);
		convertBinaryTreeSumOfAllLesserNodesIsAddedToTree(root.getRightChild());
	}

	// finds floor value in bst for given key if exists else returns maximum
	// integer value
	public static int getFloor(Tree root, int key) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		if (root.getData() == key) {
			return key;
		}
		if (root.getData() > key) {
			return getFloor(root.getLeftChild(), key);
		}
		int temp = getFloor(root.getRightChild(), key);
		return temp <= key ? temp : root.getData();
	}

	// finds ceil value in bst for given key if exists else returns minimum
	// integer value
	public static int getCeil(Tree root, int key) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.getData() == key) {
			return key;
		}
		if (root.getData() < key) {
			return getCeil(root.getRightChild(), key);
		}
		int temp = getCeil(root.getLeftChild(), key);
		return temp >= key ? temp : root.getData();
	}

	// create a bst from a given preorder traversal
	public static Tree createBinarySearchTreeFromPreorder(int[] preorder, int size, int start) {
		if (size == 0) {
			return null;
		}
		int index = start + 1;
		while(index < size && preorder[start] < preorder[index]) {
			index++;
		}
		Tree root = new Tree(preorder[start]);
		root.setLeftChild(createBinarySearchTreeFromPreorder(preorder, index - start - 1, start + 1));
		root.setRightChild(createBinarySearchTreeFromPreorder(preorder, size - (index - start), index));
		return root;
	}

}
