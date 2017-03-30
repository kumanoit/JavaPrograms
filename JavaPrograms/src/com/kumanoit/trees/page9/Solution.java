package com.kumanoit.trees.page9;

import java.util.LinkedList;
import java.util.Queue;

import com.kumanoit.trees.RefObject;
import com.kumanoit.trees.utils.Tree;

public class Solution {

	/**
	 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	 */
	public static Tree getLowestCommonAncestor(Tree root, int v1, int v2) {
		if (root == null) {
			return null;
		}
		Tree left = getLowestCommonAncestor(root.getLeftChild(), v1, v2);
		Tree right = getLowestCommonAncestor(root.getRightChild(), v1, v2);
		if (root.getData() == v1) {
			return root;
		}
		if (root.getData() == v2) {
			return root;
		}
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	/**
	 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
	 */
	public static int getDistanceBetweenTwoNodes(Tree root, int v1, int v2) {
		int v1Distance = getDistanceFromRoot(root, v1, 0);
		int v2Distance = getDistanceFromRoot(root, v2, 0);
		int lcaDistance = getDistanceFromRoot(root, getLowestCommonAncestor(root, v1, v2).getData(), 0);
		return v1Distance + v2Distance - 2 * lcaDistance;
	}

	public static int getDistanceFromRoot(Tree root, int value, int level) {
		if (root == null) {
			return -1;
		}
		if (root.getData() == value) {
			return level;
		}
		int left = getDistanceFromRoot(root.getLeftChild(), value, level + 1);
		if (left != -1) {
			return left;
		}
		return getDistanceFromRoot(root.getRightChild(), value, level + 1);
	}

	/**
	 * http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
	 */
	public static void printDLL(Tree root) {
		if (root == null) {
			System.out.println("No node in doubly linked list.");
			return;
		}
		Tree ptr = root;
		while (ptr.getLeftChild() != null) {
			ptr = ptr.getLeftChild();
		}
		System.out.println("From left to right");
		while (ptr.getRightChild() != null) {
			System.out.print(ptr.getData() + " >> ");
			ptr = ptr.getRightChild();
		}
		System.out.println(ptr.getData());
		System.out.println("From right to left");
		while (ptr.getLeftChild() != null) {
			System.out.print(ptr.getData() + " << ");
			ptr = ptr.getLeftChild();
		}
		System.out.println(ptr.getData());
	}

	public static Tree convertTreeToDLL1(Tree root) {
		if (root == null) {
			return null;
		}
		if (root.getLeftChild() != null) {
			Tree inPred = convertTreeToDLL1(root.getLeftChild());
			while (inPred.getRightChild() != null) {
				inPred = inPred.getRightChild();
			}
			root.setLeftChild(inPred);
			inPred.setRightChild(root);
		}
		if (root.getRightChild() != null) {
			Tree inSucc = convertTreeToDLL1(root.getRightChild());
			while (inSucc.getLeftChild() != null) {
				inSucc = inSucc.getLeftChild();
			}
			root.setRightChild(inSucc);
			inSucc.setLeftChild(root);
		}
		return root;
	}

	private static Tree prevNode = null;

	public static void convertTreeToDLL2(Tree root) {
		if (root == null) {
			return;
		}
		convertTreeToDLL2(root.getLeftChild());
		if (prevNode != null) {
			prevNode.setRightChild(root);
			root.setLeftChild(prevNode);
		}
		prevNode = root;
		convertTreeToDLL2(root.getRightChild());
	}

	/**
	 * http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
	 */
	public static Tree removeAllPathsWithSumLessThanK(Tree root, int k) {
		return removeAllPathsWithSumLessThanK(root, k, new RefObject(0));
	}

	private static Tree removeAllPathsWithSumLessThanK(Tree root, int k, RefObject value) {
		if (root == null) {
			return null;
		}
		RefObject left = new RefObject(value.getData() + root.getData());
		RefObject right = new RefObject(value.getData() + root.getData());
		root.setLeftChild(removeAllPathsWithSumLessThanK(root.getLeftChild(), k, left));
		root.setRightChild(removeAllPathsWithSumLessThanK(root.getRightChild(), k, right));
		// setting value to maximum of left and right nodes sum
		value.setData(Math.max(left.getData(), right.getData()));
		if (Math.max(left.getData(), right.getData()) < k) {
			root = null;
		}
		return root;
	}

	private static Tree largestBSTRoot = null;
	private static int maxBstSize = -1;

	public static void findLargestBST(Tree root) {
		largestBSTRoot = null;
		maxBstSize = -1;
		findLargestBST(root, new RefObject(Integer.MAX_VALUE), new RefObject(Integer.MIN_VALUE));
		System.out.println("Largest bst size is = " + maxBstSize);
		System.out.println("Root of largest bst = " + largestBSTRoot.getData());
	}

	private static int findLargestBST(Tree root, RefObject minimum, RefObject maximum) {
		if (root == null) {
			return 0;
		}
		RefObject leftMax = new RefObject(Integer.MIN_VALUE);
		RefObject rightMin = new RefObject(Integer.MAX_VALUE);
		int leftSize = findLargestBST(root.getLeftChild(), minimum, leftMax);
		int rightSize = findLargestBST(root.getRightChild(), rightMin, maximum);
		if (root.getData() < minimum.getData()) {
			minimum.setData(root.getData());
		}
		if (root.getData() > maximum.getData()) {
			maximum.setData(root.getData());
		}
		if (leftSize == -1 || rightSize == -1 || leftMax.getData() >= root.getData()
				|| rightMin.getData() <= root.getData()) {
			return -1;
		}
		int bstSize = leftSize + 1 + rightSize;
		if (bstSize > maxBstSize) {
			maxBstSize = bstSize;
			largestBSTRoot = root;
		}
		return bstSize;
	}

	/**
	 * http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
	 */
	public static int getNextRightNode(Tree root, int value) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				Tree ptr = queue.remove();
				if (ptr.getData() == value) {
					if (size == 1) {
						System.out.println("Not found:");
						return Integer.MIN_VALUE;
					}
					return queue.remove().getData();
				}
				if (ptr.getLeftChild() != null) {
					queue.add(ptr.getLeftChild());
				}
				if (ptr.getRightChild() != null) {
					queue.add(ptr.getRightChild());
				}
				size--;
			}
		}
		System.out.println("Given value not present in tree.");
		return Integer.MIN_VALUE;
	}

	/**
	 * http://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
	 */
	private static Tree dllStart = null;

	public static void extractLeavesWrapper(Tree root) {
		System.out.println("Original tree");
		root.display();
		Tree newRoot = extractLeaves(root);
		System.out.println("New tree after extraction of leaves");
		newRoot.display();
		System.out.println("Extracted leaf nodes");
		dllStart.displayDoublyLinkedList();
	}

	private static Tree extractLeaves(Tree root) {
		if (root == null) {
			return null;
		}
		if (root.isLeaf()) {
			if (dllStart == null) {
				dllStart = root;
			} else {
				dllStart.setLeftChild(root);
				root.setRightChild(dllStart);
				dllStart = root;
			}
			return null;
		}
		root.setLeftChild(extractLeaves(root.getLeftChild()));
		root.setRightChild(extractLeaves(root.getRightChild()));
		return root;
	}

	/**
	 * http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
	 */
	public static void sumOfAllNumbersFormedRootToLeaf(Tree root) {
		RefObject sum = new RefObject(0);
		sumNumbers(root, 0, sum);
		System.out.println("The sum of all numbers is = " + sum.getData());
	}

	private static void sumNumbers(Tree root, int number, RefObject sum) {
		if (root == null) {
			return;
		}
		number = number * 10 + root.getData();
		if (root.isLeaf()) {
			System.out.println("number = " + number);
			sum.setData(sum.getData() + number);
			return;
		}
		sumNumbers(root.getLeftChild(), number, sum);
		sumNumbers(root.getRightChild(), number, sum);
	}

	/**
	 * http://www.geeksforgeeks.org/print-left-view-binary-tree/
	 */
	public static void printLeftView(Tree root) {
		printLeftView(root, 0, new RefObject(-1));
	}

	private static void printLeftView(Tree root, int level, RefObject maxLevel) {
		if (root == null) {
			return;
		}
		if (level > maxLevel.getData()) {
			System.out.print(root.getData() + ", ");
			maxLevel.setData(level);
		}
		printLeftView(root.getLeftChild(), level + 1, maxLevel);
		printLeftView(root.getRightChild(), level + 1, maxLevel);
	}

}
