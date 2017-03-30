package com.kumanoit.trees.page15;

import com.kumanoit.trees.utils.Tree;

public class Solution {

	/**
	 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
	 */
	public static int getSizeOfTree(Tree root) {
		if (root == null) {
			return 0;
		}
		return getSizeOfTree(root.getLeftChild()) + 1 + getSizeOfTree(root.getRightChild());
	}

}
