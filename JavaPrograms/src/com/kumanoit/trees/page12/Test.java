package com.kumanoit.trees.page12;

import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class Test {

	private static Tree root1 = TreeUtils.createTree(
			new Integer[] { 1, 2, 3, 4, 5, 6, 7, null, 8, 9, null, null, 10, 11, 12, 13, null, null, null, 14, 15 });

	private static void testPrintNodesAtDistanceK() {
		Solution.printAllNodesAtDistanceK(root1, 6, 3);
	}

	private static void testPrintBottomView() {
		Solution.printBottomView(root1);
	}

	public static void main(String[] args) {
		testPrintBottomView();
	}

}
