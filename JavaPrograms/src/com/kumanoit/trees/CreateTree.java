/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

import com.kumanoit.trees.utils.Tree;

public class CreateTree {

	// creating a binary tree from inorder and preorder traversal
	public static Tree createBinaryTreeInorderPreorder(Integer[] in, Integer[] pre, int n, int inptr,
			int preptr) {
		if (n == 0) {
			return null;
		}
		Tree root = new Tree(pre[preptr]);
		int index = inptr;
		while (in[index] != pre[preptr]) {
			index++;
		}
		root.setLeftChild(createBinaryTreeInorderPreorder(in, pre, index - inptr, inptr, preptr + 1));
		root.setRightChild(createBinaryTreeInorderPreorder(in, pre, n - (index - inptr) - 1, index + 1,
				preptr + (index - inptr) + 1));
		return root;
	}

	// creating a binary tree from inorder and postorder traversal
	public static Tree createBinaryTreeInorderPostorder(Integer[] in, Integer[] post, int n, int inptr,
			int postptr) {
		if (n == 0) {
			return null;
		}
		Tree root = new Tree(post[postptr + n - 1]);
		int index = inptr;
		while (in[index] != post[postptr + n - 1]) {
			index++;
		}
		root.setLeftChild(createBinaryTreeInorderPostorder(in, post, index - inptr, inptr, postptr));
		root.setRightChild(createBinaryTreeInorderPostorder(in, post, n - (index - inptr) - 1, index + 1,
				postptr + (index - inptr)));
		return root;
	}

	// creating a binary tree from inorder and level order traversal
	public static Tree createTreeFromInorderLevelorder(Integer[] in, Integer[] level, int n, int inptr) {
		if (n == 0) {
			return null;
		}
		Tree root = new Tree(level[0]);
		int index = inptr;
		while (in[index] != level[0]) {
			index++;
		}
		Integer[] leftNodes = new Integer[index];
		Integer[] rightNodes = new Integer[n - (index - inptr) - 1];
		int k = 0;
		int m = 0;
		for (int j = 1; j < n; j++) {
			int i = 0;
			for (i = 0; i < index; i++) {
				if (level[j] == in[i]) {
					leftNodes[k++] = level[j];
					break;
				}
			}
			if (i == index) {
				rightNodes[m++] = level[j];
			}
		}
		root.setLeftChild(createTreeFromInorderLevelorder(in, leftNodes, (index - inptr), inptr));
		root.setRightChild(createTreeFromInorderLevelorder(in, rightNodes, n - (index - inptr) - 1, index + 1));
		return root;
	}

	// transforms a tree so that value of nodes becomes equal to sum of values of
	// its left and right child node values
	public static int createSumTree(Tree root) {
		if (root == null) {
			return 0;
		}
		if (root.isLeaf()) {
			return root.getData();
		}
		int leftValue = createSumTree(root.getLeftChild());
		int rightValue = createSumTree(root.getRightChild());
		int temp = root.getData();
		root.setData(leftValue + rightValue);
		return temp;
	}
}
