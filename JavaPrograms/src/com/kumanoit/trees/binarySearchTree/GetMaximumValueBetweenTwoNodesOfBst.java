package com.kumanoit.trees.binarySearchTree;

import com.kumanoit.trees.bstUtils.BSTUtils;
import com.kumanoit.trees.utils.Tree;

public class GetMaximumValueBetweenTwoNodesOfBst {

	public static void main(String[] args) {
		int[] arr = { 18, 36, 9, 6, 12, 10, 1, 8 };
		Tree root = BSTUtils.createBST(arr);
		System.out.println(getMaximumValueBetweenNodes(root, 1, 10));
	}

	public static Tree getLCA(Tree root, int a, int b) {
		if (root == null) {
			return null;
		}
		Tree left = getLCA(root.getLeftChild(), a, b);
		Tree right = getLCA(root.getRightChild(), a, b);
		if (root.getData() == a) {
			return root;
		}
		if (root.getData() == b) {
			return root;
		}
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	public static int getMaximumValueBetweenNodes(Tree root, int a, int b) {
		Tree lca = getLCA(root, a, b);
		int maxA = getMaxValue(lca, a);
		int maxB = getMaxValue(lca, b);
		return Math.max(maxA, maxB);
	}

	private static int getMaxValue(Tree root, int value) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.getData() == value) {
			return Integer.MIN_VALUE;
		} else if (root.getData() > value) {
			return Math.max(root.getData(), getMaxValue(root.getLeftChild(), value));
		}
		return Math.max(root.getData(), getMaxValue(root.getRightChild(), value));
	}
}
