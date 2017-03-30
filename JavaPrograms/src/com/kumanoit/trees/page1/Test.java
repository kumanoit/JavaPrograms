/**
 * 
 * Created by Amit Kumar on 28/01/17.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees.page1;

import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class Test {

	private static Tree root1 = TreeUtils.createTree(
			new Integer[] { 50, 30, 75, 100, 42, 81, 32, null, 20, 90, null, 63, -25, 0, 81, null, null, 32, 41 });
	private static Tree root2 = TreeUtils.createTree(new Integer[] { 1, 2, 3, 1, null, 4, 5 });
	private static Tree root3 = TreeUtils
			.createTree(new Integer[] { 1, 2, 3, 8, 5, 4, null, null, null, 6, null, 9, 5, null, null, null, null, 6 });
	private static Tree continousTree = TreeUtils.createTree(new Integer[] { 3, 2, 4, 1, 3, null, 5 });
	private static Tree root4 = TreeUtils.createTree(new Integer[] { 10, 11, 9, 13, 12, 13, 8 });

	private static void testGetAllNodesWithKLeafNodes() {
		System.out.println();
		Solution.getAllNodesWithKLeafNodes(root1, 2).forEach(item -> System.out.print(item.getData() + "\t"));
		System.out.println();
		Solution.getAllNodesWithKLeafNodes(root1, 1).forEach(item -> System.out.print(item.getData() + "\t"));
	}

	private static void testSumNoAdjacent() {
		// System.out.println(Solution.getMaximumSumWrapper(root1));
		System.out.println(Solution.getMaximumSumWrapper(root2));
	}

	private static void testGetMaxSumLevel() {
		System.out.println(Solution.getLevelWithMaximumSum(root1));
		System.out.println(Solution.getLevelWithMaximumSum2(root1));
		System.out.println(Solution.getLevelWithMaximumSum(root2));
		System.out.println(Solution.getLevelWithMaximumSum2(root2));
	}

	private static void testGetEqualLengthPathCount() {
		Solution.getEqualLengthPathCount(root1);
		Solution.getEqualLengthPathCount(root2);
	}

	private static void testIfTreeIsContinuous() {
		System.out.println("Is tree continous? " + Solution.isContinuousTree(root1));
		System.out.println("Is tree continous? " + Solution.isContinuousTree(continousTree));
	}

	private static void testPairSummingToRoot() {
		Solution.printPairWithSumOfRoot(root1);
	}

	private static void testIsPathPresent() {
		root1.display();
		System.out.println(Solution.isPathPresent(root1, new int[] { 75, 81, 63 }));
		System.out.println(Solution.isPathPresent(root1, new int[] { 50, 75, 32 }));
		System.out.println(Solution.isPathPresent(root1, new int[] { 42, 90, 41 }));
		System.out.println(Solution.isPathPresent(root1, new int[] { 81, 75, 32 }));
	}

	private static void testLongestConsecutiveLength() {
		System.out.println(Solution.getLongestConsecutiveSequence(root1));
		System.out.println(Solution.getLongestConsecutiveSequence(root2));
		System.out.println(Solution.getLongestConsecutiveSequence(root3));
		System.out.println(Solution.getLongestConsecutiveSequence(root4));
	}

	public static void main(String[] args) {
		testIsPathPresent();
	}

}
