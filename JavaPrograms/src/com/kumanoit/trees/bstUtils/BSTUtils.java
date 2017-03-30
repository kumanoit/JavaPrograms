package com.kumanoit.trees.bstUtils;

import com.kumanoit.trees.utils.Tree;

public class BSTUtils {

	public static Tree createBST(int[] array) {
		Tree root = new Tree(array[0]);
		for (int i = 1; i < array.length; i++) {
			insertIntoBst(root, array[i]);
		}
		return root;
	}

	public static Tree insertIntoBst(Tree root, int value) {
		if (root == null) {
			root = new Tree(value);
			return root;
		}
		if (root.getData() < value) {
			root.setRightChild(insertIntoBst(root.getRightChild(), value));
		} else if (root.getData() > value) {
			root.setLeftChild(insertIntoBst(root.getLeftChild(), value));
		} else {
			System.out.println(value + "Already present");
		}
		return root;
	}
}
