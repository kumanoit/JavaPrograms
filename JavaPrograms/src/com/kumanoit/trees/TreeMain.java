/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

import com.kumanoit.trees.utils.Constants;
import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class TreeMain {

	private static Tree root1;
	private static Tree root2;
	private static Tree root3;
	private static Tree root4; // unbalanced tree
	private static Tree root6;
	private static Tree leftSkewed;
	private static Tree rightSkewed;
	private static Tree bstRoot;
	private static Tree sumTreeRoot;
	private static Tree completeTree;

	static {
		root1 = TreeUtils.createTree(Constants.array1);
		root2 = TreeUtils.createTree(Constants.array2);
		root3 = TreeUtils.createTree(Constants.array3);
		root4 = TreeUtils.createTree(Constants.array5);
		root6 = TreeUtils.createTree(Constants.array6);
		leftSkewed = TreeUtils.createTree(Constants.leftSkewed);
		rightSkewed = TreeUtils.createTree(Constants.rightSkewed);
		bstRoot = TreeUtils.createTree(Constants.bstArray);
		sumTreeRoot = TreeUtils.createTree(Constants.sumTree);
		completeTree = TreeUtils.createTree(Constants.completeTree);
	}

	public static void testCreateBinaryTree() {
		int k = 1;
		for (int i = 1; i < 9; i++) {
			k += i;
			System.out.println("\n\nSum = " + k);
			PrintTrees.printPathWithSumK(root1, k);
			System.out.println(Miscellaneous.getTotalPathsGivingSum(root1, k));
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
		System.out.println("Is sum tree " + CheckTree.isSumTree(sumTreeRoot));
		System.out.println("Is sum tree " + CheckTree.isSumTree(bstRoot));
	}

	public static void testCreateSumTree() {
		root1.display();
		CreateTree.createSumTree(root1);
		root1.display();
	}

	public static void testIsBstHasOneChild() {
		int[] preorder = { 100, 40, 75, 60, 50, 55 };
		System.out.println(CheckTree.isBstHasOneChild(preorder, preorder.length));
		int array1[] = { 50, 30, 60, 22, 38, 55, 94, 35, 59, 98 };
		System.out.println(CheckTree.isBstHasOneChild(array1, array1.length));
	}

	public static void testIfTreesAreIdentical() {
		System.out.println(CheckTree.areTreesIdentical(root1, root2));
		System.out.println(CheckTree.areTreesIdentical(root1, root1));
	}

	public static void testConvertToMirrorTree() {
		root1.display();
		ManipulateTree.convertToMirrorTree(root1);
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
		PrintTrees.printSumLevelWise(root1);
		PrintTrees.printSumLevelWise(bstRoot);
	}

	public static void testConvertToCSP() {
		root6.printLevelOrder();
		ManipulateTree.convertToCSP(root6);
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
		// TreeTraversal.printVerticalOrder(root1);
		System.out.println("\nVia level order");
		TreeTraversal.printVerticalOrderLevelOrder(root1);
	}

	public static void testPrintAllRootToLeafPath() {
		PrintTrees.printAllPathFromRootToLeaf(root1);
	}

	public static void testWidthOfTree() {
		System.out.println(Miscellaneous.getWidthOfTree(root1));
		System.out.println(Miscellaneous.getWidthOfTree(root2));
		System.out.println(Miscellaneous.getWidthOfTree(root3));
		System.out.println(Miscellaneous.getWidthOfTree(root4));

		System.out.println(Miscellaneous.getWidthOfTreeViaMap(root1));
		System.out.println(Miscellaneous.getWidthOfTreeViaMap(root2));
		System.out.println(Miscellaneous.getWidthOfTreeViaMap(root3));
		System.out.println(Miscellaneous.getWidthOfTreeViaMap(root4));
	}

	public static void testDoubleTree() {
		root1.display();
		ManipulateTree.convertTreeToDoubleTree(root1);
		root1.display();
	}

	public static void testPrintNodesWithKLeaves() {
		PrintTrees.printNodesWithKLeaves(root2, 2);
		System.out.println();
		PrintTrees.printNodesWithKLeaves(leftSkewed, 1);
		System.out.println();
		PrintTrees.printNodesWithKLeaves(root2, 5);
	}

	public static void testMaxSumInLevel() {
		System.out.println(Miscellaneous.getMaxSumLevel(root3));
		System.out.println(Miscellaneous.getMaxSumLevel(root4));
	}

	public static void testGetCountOfTreeWithSameHeight() {
		Miscellaneous.getCountOfTreeWithSameHeight(root1);
		System.out.println();
		Miscellaneous.getCountOfTreeWithSameHeight(root4);
	}

	public static void testIfTreeIsContinuous() {
		System.out.println(CheckTree.isContinuousTree(root1));
		Tree continuousTree = TreeUtils.createTree(new Integer[] { 3, 2, 4, 1, 3, null, 5 });
		continuousTree.display();
		System.out.println(CheckTree.isContinuousTree(continuousTree));
	}

	public static void testIsPairExistWithSumOfRoot() {
		System.out.println(CheckTree.isPairExistWithSumOfRoot(root1));
		System.out.println(CheckTree.isPairExistWithSumOfRoot(root2));
		System.out.println(CheckTree.isPairExistWithSumOfRoot(root4));
	}

	public static void testIfPathExist() {
		System.out.println(CheckTree.isPathExist(root2, new int[] { 11, 2, 4 }));
		System.out.println(CheckTree.isPathExist(root2, new int[] { 11, 2, 4, 8 }));
		System.out.println(CheckTree.isPathExist(root2, new int[] { 11, 2, 4, 8, 9 }));
		System.out.println(CheckTree.isPathExist(root2, new int[] { 11, 4, 6 }));
	}

	public static void testSwapNodesEveryKLevel() {
		ManipulateTree.swapNodesEveryKLevel(root2, 1);
		root2.display();
	}

	public static void testMaxContinuousTreeLength() {
		System.out.println(Miscellaneous.getMaxContinuousLength(root1));
		Tree root = TreeUtils.createTree(new Integer[] { 6, null, 9, 7, 10, null, null, null, 11 });
		System.out.println(Miscellaneous.getMaxContinuousLength(root));
		Tree root_1 = TreeUtils.createTree(new Integer[] { 1, 2, 4, 3, null, 5, 6, null, null, null, null, 7 });
		System.out.println(Miscellaneous.getMaxContinuousLength(root_1));
		Tree root_2 = TreeUtils.createTree(new Integer[] { 10, 11, 9, 13, 12, 13, 8 });
		System.out.println(Miscellaneous.getMaxContinuousLength(root_2));
		Tree root_3 = TreeUtils.createTree(new Integer[] { 5, 8, 11, 9, null, null, 10, 6, null, 15 });
		System.out.println(Miscellaneous.getMaxContinuousLength(root_3));
	}

	public static void testFlipTree() {
		Tree root = TreeUtils.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		ManipulateTree.flipTree(root).display();
	}

	public static void testConvertToDoublyLinkedList() {
		System.out.println("Present tree.");
		root1.display();
		Tree dll = ManipulateTree.convertTreeToDoublyLinkedList(root1);
		System.out.println("\nAfter tree is converted to doubly linked list");
		while (dll != null) {
			System.out.print(dll.getData() + "\t");
			dll = dll.getRightChild();
		}
	}

	public static void testConvertToDoublyLinkedList2() {
		System.out.println("Present tree.");
		root1.display();
		Tree dll = ManipulateTree.convertTreeToDoublyLinkedList2(root1);
		System.out.println("\nAfter tree is converted to doubly linked list by method 2");
		while (dll != null) {
			System.out.print(dll.getData() + "\t");
			dll = dll.getRightChild();
		}
	}

	public static void testMinSteps() {
		System.out.println(Miscellaneous.getMinSteps(10));
		System.out.println(Miscellaneous.getMinSteps(13));
	}

	public static void testPrintExtremeNodes() {
		PrintTrees.printExtremeNodesAlternateOrder(completeTree);
	}

	public static void testLeafTraversal() {
		Tree root1 = TreeUtils.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		Tree root2 = TreeUtils.createTree(new Integer[] { 1, 8, 9, 3, 5, 12, 7, 4, null, null, null, null, 6, 90 });
		System.out.println(CheckTree.isLeafTraversalIsSame(root1, root2));
	}

	public static void testMultiplicationOfLeavesAtSameLevel() {
		System.out.println(Miscellaneous.getMultiplicationOfLeavesAtSameLevel(root1));
		System.out.println(Miscellaneous.getMultiplicationOfLeavesAtSameLevel(root2));
	}

	public static void testIfArrayPreorderRepresentBst() {
		System.out.println("Expected true  : " + CheckTree.isPreorderOfBst(new int[] {40, 30, 35, 80, 100}));
		System.out.println("Expected false : " + CheckTree.isPreorderOfBst(new int[] {40, 30, 35, 20, 80, 100}));
	}

	public static void main(String[] args) {
		testIfArrayPreorderRepresentBst();
	}

}
