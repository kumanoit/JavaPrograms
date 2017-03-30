/**
 * 
 * Created by Amit Kumar on 29/01/17.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees.page2;

import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class Test {

	private static Tree root1 = TreeUtils.createTree(new Integer[] { 10, 11, 9, 13, 12, 13, 8 });
	private static Tree root2 = TreeUtils
			.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });

	private static Tree mirrorTree = TreeUtils.createTree(new Integer[] { 1, 2, 2, 4, 5, 5, 4, null, 8, 4, 3, 3, 4, 8 });

	private static int[] inorder = { 2, 7, 1, 8, 4, 3, 9 };
	private static int[] postorder = { 7, 2, 8, 4, 9, 3, 1 };

	private static void testBTDoublyLinkedList() {
		Solution.convertBinaryTreeToDoublyLinkedList(root1);
	}

	private static void testMinimumStepsCount() {
		System.out.println(Solution.getMinSteps(0));
		System.out.println(Solution.getMinSteps(10));
		System.out.println(Solution.getMinSteps(13));
	}

	private static void testPrintExtremeNodesAtEachLevel() {
		Solution.printExtremeNodesInBinaryTree(root1);
		Solution.printExtremeNodesInBinaryTree(root2);
	}

	private static void testPrintSiblings() {
		Solution.printAllSiblings(root2, 6);
		Solution.printAllSiblings(root2, 10);
	}

	private static void testIfTreesAreIdentical() {
		System.out.println(Solution.areTreesIdenticalIterative(root1, root1));
		System.out.println(Solution.areTreesIdenticalIterative(root2, root2));
		System.out.println(Solution.areTreesIdenticalIterative(root1, root2));
	}

	private static void testIfTreesAreMirror() {
		System.out.println(Solution.areTreesMirror(root1));
		System.out.println(Solution.areTreesMirror(root2));
		System.out.println(Solution.areTreesMirror(mirrorTree));
	}

	private static void testConstructTreeFromInorderPostorder() {
		Solution.constructTreeFromInorderPostorder(inorder, postorder).display();;
	}

	public static void main(String[] args) {
		testMinimumStepsCount();
	}

}
