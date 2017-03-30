package com.kumanoit.interviewBits.Trees;

import com.kumanoit.trees.TreeSamples;
import com.kumanoit.trees.utils.Tree;

/**
 * https://www.interviewbit.com/problems/balanced-binary-tree/
 * 
 * @author kuma
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		isBalanced(TreeSamples.heightBalanced);
		System.out.println(isBal);
	}

	private static int isBal = 1; // assuming it to be balanced at beginning

	public static int isBalanced(Tree a) {
		balanceCheck(a);
		return isBal;
	}

	private static int balanceCheck(Tree root) {
		if (root == null) {
			return 0;
		}
		int lh = balanceCheck(root.getLeftChild());
		if (lh == -1) {
			return -1;
		}
		int rh = balanceCheck(root.getRightChild());
		if (rh == -1) {
			return -1;
		}
		if (Math.abs(lh - rh) > 1) {
			isBal = 0;
			return -1;
		}
		return Math.max(lh, rh) + 1;
	}
}
