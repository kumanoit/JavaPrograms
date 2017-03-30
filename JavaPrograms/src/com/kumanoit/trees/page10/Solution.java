package com.kumanoit.trees.page10;

public class Solution {

	// 2. http://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
	public static void printPostorder(int[] inorder, int[] preorder) {
		printPostorder(inorder, preorder, 0, 0, inorder.length);
	}

	private static void printPostorder(int[] inorder, int[] preorder, int inStart, int preStart, int size) {
		if (size <= 0) {
			return;
		}
		int i = 0;
		for (i = inStart; inorder[i] != preorder[preStart]; i++)
			;
		int leftSize = i - inStart;
		int rightSize = size - leftSize - 1;
		printPostorder(inorder, preorder, inStart, preStart + 1, leftSize);
		printPostorder(inorder, preorder, i + 1, preStart + leftSize + 1, rightSize);
		System.out.print(preorder[preStart] + "\t");
	}
}
