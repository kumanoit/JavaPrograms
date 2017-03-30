package com.kumanoit.trees.page4;

import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class Test {

	private static Tree perfectBT = TreeUtils
			.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
	private static Tree root1 = TreeUtils.createTree(new Integer[] { 1, 2, 3, null, 4, 5, 6, null, null, 7, 8 });
	private static Tree sumCoveredUncovered = TreeUtils
			.createTree(new Integer[] { 8, 3, 10, 1, 6, null, 14, null, null, 36, 7, 13 });
	private static Tree root4 = TreeUtils.createTree(new Integer[] { 8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13 });

	private static void testPrintReverseLevelOrderSpecial() {
		Solution.printReverseLevelSpecial(perfectBT);
	}

	private static void testSumNodesTreeVerticalOrder() {
		root1.display();
		System.out.println();
		Solution.sumNodesTreeVerticalOrder(root1);
	}

	private static void testBorderNodesPerLevelPrinter() {
		Solution.printBorderNodesPerLevel(root1);
	}

	private static void testIfTreeIsBisectable() {
		System.out.println(Solution.ifRemovingEdgeDivides(root1));
	}

	private static void testSumCoveredUncovered() {
		System.out.println(Solution.checkSumCoveredUncoveredNodes(root1));
		System.out.println(Solution.checkSumCoveredUncoveredNodes(sumCoveredUncovered));
	}

	private static void testMaxDifferenceBetweenNodeAndAncestor() {
		System.out.println(Solution.getMaxDifference(root4));
	}

	private static void testConstructBSTFromPostorder() {
		int[] postorder1 = { 1, 7, 5, 50, 40, 10 };
		Solution.getBST(postorder1, 0, postorder1.length).display();
		int[] postorder2 = { 1, 2, 3, 4, 5 };
		Solution.getBST(postorder2, 0, postorder2.length).display();
		int[] postorder3 = { 5, 4, 3, 2, 1 };
		Solution.getBST(postorder3, 0, postorder3.length).display();
	}

	private static void testCreateTreeFromAncestorMatrix() {
		int[][] matrix = { { 0, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int[][] matrix2 = { { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0 },

		};
//		Solution.createTreeAncestorMatrix(matrix).display();
		Solution.createTreeAncestorMatrix(matrix2).display();
	}

	public static void main(String[] args) {
		testCreateTreeFromAncestorMatrix();
	}
}
