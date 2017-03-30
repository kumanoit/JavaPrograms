package com.kumanoit.trees.page15;

import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class Test {

	private static Tree root1 = TreeUtils.createTree(new Integer[] { 1, 2, 3, null, 4, 5, 6, null, null, 7, 8 });
	private static Tree root2 = TreeUtils.createTree(new Integer[] { 8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13 });

	private static void testSizeOfTree() {
		System.out.println(Solution.getSizeOfTree(root1));
		System.out.println(Solution.getSizeOfTree(root2));
	}

	public static void main(String[] args) {
		testSizeOfTree();
	}

}
