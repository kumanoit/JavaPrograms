/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

public class TreeMain {

	private static Tree root1;
	private static Tree root2;
	private static Tree root3;
	private static Tree root4; // unbalanced tree
	private static Tree root6;
	private static Tree bstRoot;
	private static Tree sumTreeRoot;

	static {
		root1 = TreeUtils.createTree(Constants.array1);
		root2 = TreeUtils.createTree(Constants.array2);
		root3 = TreeUtils.createTree(Constants.array3);
		root4 = TreeUtils.createTree(Constants.array5);
		root6 = TreeUtils.createTree(Constants.array6);
		bstRoot = TreeUtils.createTree(Constants.bstArray);
		sumTreeRoot = TreeUtils.createTree(Constants.sumTree);
	}

	public static void testCreateBinaryTree() {
		int k = 1;
		for (int i = 1; i < 9; i++) {
			k += i;
			System.out.println("\n\nSum = " + k);
			Miscellaneous.printPathWithSumK(root1, k);
			System.out.println(Miscellaneous.countTotalPathsGivingSum(root1, k));
		}
	}

	public static void testDoesSumExistInBst() {
		BinarySearchTree.doesSumExistInABst(bstRoot, 22 + 98);
		BinarySearchTree.doesSumExistInABst(bstRoot, 30 + 59);
		BinarySearchTree.doesSumExistInABst(bstRoot, 30 + 22);
		BinarySearchTree.doesSumExistInABst(bstRoot, 60 + 59);
		BinarySearchTree.doesSumExistInABst(bstRoot, 50 + 98);
		BinarySearchTree.doesSumExistInABst(bstRoot, 150 + 98);
	}

	public static void testConvertBinaryTreeSumOfAllGreaterNodesIsAddedToTree() {
		bstRoot.display();
		BinarySearchTree.convertBinaryTreeSumOfAllGreaterNodesIsAddedToTree(bstRoot);
		bstRoot.display();
	}

	public static void testConvertBinaryTreeSumOfAllLesserNodesIsAddedToTree() {
		bstRoot.display();
		BinarySearchTree.convertBinaryTreeSumOfAllLesserNodesIsAddedToTree(bstRoot);
		bstRoot.display();
	}

	public static void testGetFloor() {
		System.out.println("Floor value for 75 is " + BinarySearchTree.getFloor(bstRoot, 75));
		System.out.println("Floor value for 20 is " + BinarySearchTree.getFloor(bstRoot, 20));
		System.out.println("Floor value for 98 is " + BinarySearchTree.getFloor(bstRoot, 98));
		System.out.println("Floor value for 59 is " + BinarySearchTree.getFloor(bstRoot, 59));
		System.out.println("Floor value for 40 is " + BinarySearchTree.getFloor(bstRoot, 40));
		System.out.println("Floor value for 100 is " + BinarySearchTree.getFloor(bstRoot, 100));
	}

	public static void testGetCeil() {
		System.out.println("Ceil value for 75 is " + BinarySearchTree.getCeil(bstRoot, 75));
		System.out.println("Ceil value for 20 is " + BinarySearchTree.getCeil(bstRoot, 20));
		System.out.println("Ceil value for 98 is " + BinarySearchTree.getCeil(bstRoot, 98));
		System.out.println("Ceil value for 59 is " + BinarySearchTree.getCeil(bstRoot, 59));
		System.out.println("Ceil value for 40 is " + BinarySearchTree.getCeil(bstRoot, 40));
		System.out.println("Ceil value for 100 is " + BinarySearchTree.getCeil(bstRoot, 100));
	}

	public static void testCreateBinarySearchFromPreorderTraversal() {
		int[] bstPreorder = { 50, 30, 22, 38, 35, 60, 55, 59, 94, 98 };
		BinarySearchTree.createBinarySearchTreeFromPreorder(bstPreorder, bstPreorder.length, 0).display();
		bstRoot.display();
	}

	public static void checkIfTreeIsSumTree() {
		System.out.println("Is sum tree " + Miscellaneous.isSumTree(sumTreeRoot));
		System.out.println("Is sum tree " + Miscellaneous.isSumTree(bstRoot));
	}

	public static void testCreateSumTree() {
		root1.display();
		CreateTree.createSumTree(root1);
		root1.display();
	}

	public static void testIsBstHasOneChild() {
		int[] preorder = { 100, 40, 75, 60, 50, 55 };
		System.out.println(Miscellaneous.isBstHasOneChild(preorder, preorder.length));
		int array1[] = { 50, 30, 60, 22, 38, 55, 94, 35, 59, 98 };
		System.out.println(Miscellaneous.isBstHasOneChild(array1, array1.length));
	}

	public static void testIfTreesAreIdentical() {
		System.out.println(Miscellaneous.areTreesIdentical(root1, root2));
		System.out.println(Miscellaneous.areTreesIdentical(root1, root1));
	}

	public static void testConvertToMirrorTree() {
		root1.display();
		Miscellaneous.convertToMirrorTree(root1);
		root1.display();
	}

	public static void testGetMaxSumFromRootToLeaf() {
		System.out.println(Miscellaneous.getMaxSumFromRootToLeaf(root1));
		System.out.println(Miscellaneous.getMaxSumFromRootToLeaf(bstRoot));
	}

	public static void testPrintTopView() {
		TreeView.printTopViewOfTree(root1);
		TreeView.printTopViewOfTree(root2);
		TreeView.printTopViewOfTree(bstRoot);
	}

	public static void testPrintBottomView() {
		TreeView.printBottomViewOfTree(root1);
		TreeView.printBottomViewOfTree(root2);
		TreeView.printBottomViewOfTree(bstRoot);
	}

	public static void testPrintSumLevelWise() {
		Miscellaneous.printSumLevelWise(root1);
		Miscellaneous.printSumLevelWise(bstRoot);
	}

	public static void testConvertToCSP() {
		root6.printLevelOrder();
		Miscellaneous.convertToCSP(root6);
		System.out.println("\n");
		root6.printLevelOrder();

	}

	public static void testCreateBinarySearchTree() {
		int[] array = { 6, 0, 3, 5, 8, 7, 1, 4, 2, 3 };
		TreeUtils.createBinarySearchTree(array).display();
	}

	public static void testGetEdit() {
		String stringA = "";
		String stringB = "";
	}

	public static void testPrintVerticalOrder() {
		TreeTraversal.printVerticalOrder(root1);
	}

	public static void main(String[] args) {
		testPrintVerticalOrder();
	}

}
