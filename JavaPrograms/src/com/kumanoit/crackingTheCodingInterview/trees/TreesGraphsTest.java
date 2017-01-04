package com.kumanoit.crackingTheCodingInterview.trees;

import com.kumanoit.trees.utils.Constants;
import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class TreesGraphsTest {

	private static Tree root1;
	private static Tree root2;
	private static Tree root3;
	// superTree of root1 contains root1 in left subtree
	private static Tree root4;
	// superTree of root1 contains root1 in right subtree
	private static Tree root5; // unbalanced tree
	private static Tree bstRoot;

	static {
		root1 = TreeUtils.createTree(Constants.array1);
		root2 = TreeUtils.createTree(Constants.array2);
		root3 = TreeUtils.createTree(Constants.array3);
		root4 = TreeUtils.createTree(Constants.array4);
		root5 = TreeUtils.createTree(Constants.array5);
		bstRoot = TreeUtils.createTree(Constants.bstArray);
	}

	public static void testCreateBalancedBstFromArray() {
		TreesGraphs.createBalancedBstFromSortedArray(Constants.array1).display();
	}

	public static void testIsBalanced() {
		System.out.println(TreesGraphs.isBalanced(bstRoot));
		System.out.println(TreesGraphs.isBalanced(root1));
		System.out.println(TreesGraphs.isBalanced(root5));
	}

	public static void testIsBstCheck() {
		System.out.println(TreesGraphs.isBinarySearchTree(root1));
		System.out.println(TreesGraphs.isBinarySearchTree(root2));
		System.out.println(TreesGraphs.isBinarySearchTree(bstRoot));
	}

	public static void testLeastCommonAncestors() {
		// when both nodes are present in same path value1 is parent of value2 : 8
		System.out.println(TreesGraphs.getLeastCommonAncestor(root5, 8, 13).getData());

		// when both nodes are present in same path value2 is parent of value1 : 4
		System.out.println(TreesGraphs.getLeastCommonAncestor(root5, 8, 4).getData());

		// when both nodes are in different paths : 2
		System.out.println(TreesGraphs.getLeastCommonAncestor(root5, 8, 9).getData());

		// when both nodes are in different sub-trees : 1
		System.out.println(TreesGraphs.getLeastCommonAncestor(root5, 5, 11).getData());
	}

	public static void testTotalPathsWithKSumWithValues() {
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSumWithValues(root2, 7));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSumWithValues(root2, 1));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSumWithValues(root2, 6));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSumWithValues(root2, 3));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSumWithValues(root2, 9));
	}

	public static void testTotalPathsWithKSum() {
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSum(root2, 7));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSum(root2, 1));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSum(root2, 6));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSum(root2, 3));
		System.out.println("Total Paths : " + TreesGraphs.getTotalNumberOfPathsWithKSum(root2, 9));
	}

	public static void testIsSubTree() {
		System.out.println(TreesGraphs.isSubTree(root3, root1, 1));
		System.out.println(TreesGraphs.isSubTree(root4, root1, 1));
	}

	public static void testInorderSuccessor() {
		root2.printInorder();
		for (int index = 0; index < Constants.array2.length; index++) {
			int key = Constants.array2[index];
			Tree root = TreesGraphs.getInorderSuccessor(root2, key);
			System.out.print("\nKey = " + key + " Successor : ");
			System.out.print(root == null ? root : root.getData());
		}
	}

	public static void testInorderPredecessor() {
		root2.printInorder();
		for (int index = 0; index < Constants.array2.length; index++) {
			int key = Constants.array2[index];
			TreesGraphs.lastVisitedNode = null;
			Tree root = TreesGraphs.getInorderPredecessor(root2, key);
			System.out.print("\nKey = " + key + " Predecessor : ");
			System.out.print(root == null ? root : root.getData());
		}
	}

	public static void testDoesPathExist() {
		int[][] matrix = {
				{0, 1, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{0, 0, 0, 0, 1},
				{1, 0, 0, 1, 0}
		};
		System.out.println(TreesGraphs.doesPathExist(matrix, 0, 3));
		System.out.println(TreesGraphs.doesPathExist(matrix, 1, 4));
		System.out.println(TreesGraphs.doesPathExist(matrix, 2, 3));
		System.out.println(TreesGraphs.doesPathExist(matrix, 3, 2));
	}

	public static void main(String[] args) {
		testDoesPathExist();
	}

}
