package com.kumanoit.trees.page9;

import com.kumanoit.trees.TreeSamples;
import com.kumanoit.trees.utils.Tree;

public class Test {

	private static void lowestCommonAncestorTest() {
		try {
			System.out.println(Solution.getLowestCommonAncestor(TreeSamples.root1, 6, 12).getData()); // 3
			System.out.println(Solution.getLowestCommonAncestor(TreeSamples.root1, 8, 9).getData()); // 2
			System.out.println(Solution.getLowestCommonAncestor(TreeSamples.root1, 13, 15).getData()); // 1
			System.out.println(Solution.getLowestCommonAncestor(TreeSamples.root1, 8, 2).getData()); // 2
			System.out.println(Solution.getLowestCommonAncestor(TreeSamples.root1, 3, 11).getData()); // 3
			System.out.println(Solution.getLowestCommonAncestor(TreeSamples.root1, 300, 110).getData()); // null
		} catch (NullPointerException e) {
			System.out.println("Caught NPE");
		}
	}

	private static void getDistanceBetweenTwoNodes() {
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 4, 5)); // 2
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 4, 6)); // 4
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 3, 4)); // 3
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 2, 4)); // 1
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 8, 5)); // 5
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 4, 8)); // 5
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 1, 1)); // 0
		System.out.println(Solution.getDistanceBetweenTwoNodes(TreeSamples.root2, 3, 8)); // 2
	}

	private static void convertTreeToDLLTest() {
		TreeSamples.root3.display();
		// System.out.println("\n\nMethod 1");
		// Solution.printDLL(Solution.convertTreeToDLL1(TreeSamples.root3));
		System.out.println("\n\nMethod 2");
		Solution.convertTreeToDLL2(TreeSamples.root3);
		Solution.printDLL(TreeSamples.root3);
	}

	private static void removeAllNodesOnPathWithSumLessThanKTest() {
		Tree root = TreeSamples.root4;
		root.display();
		Solution.removeAllPathsWithSumLessThanK(root, 20);
		root.display();
		Solution.removeAllPathsWithSumLessThanK(root, 45);
		root.display();
	}

	private static void getNextRightNodeTest() {
		System.out.println(Solution.getNextRightNode(TreeSamples.root4, 1));
		System.out.println(Solution.getNextRightNode(TreeSamples.root4, 2));
		System.out.println(Solution.getNextRightNode(TreeSamples.root4, 3));
		System.out.println(Solution.getNextRightNode(TreeSamples.root4, 14));
		System.out.println(Solution.getNextRightNode(TreeSamples.root4, 15));
	}

	private static void findLargestBstTest() {
		TreeSamples.largestBst.display();
		Solution.findLargestBST(TreeSamples.largestBst);
	}

	private static void extractLeavesTest() {
		Solution.extractLeavesWrapper(TreeSamples.root2);
	}

	private static void sumOfNumbersInTree() {
		Solution.sumOfAllNumbersFormedRootToLeaf(TreeSamples.root2);
	}

	private static void printLeftViewOfTreeTest() {
		Solution.printLeftView(TreeSamples.largestBst);
	}

	public static void main(String[] args) {
		printLeftViewOfTreeTest();
	}
}
