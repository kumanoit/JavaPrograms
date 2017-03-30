package com.kumanoit.interviewBits.Trees;

import com.kumanoit.trees.utils.Tree;

/**
 * https://www.interviewbit.com/problems/least-common-ancestor/
 * 
 * @author kuma You are given 2 values. Find the lowest common ancestor of the
 *         two nodes represented by val1 and val2 No guarantee that val1 and
 *         val2 exist in the tree. If one value doesn’t exist in the tree then
 *         return -1. There are no duplicate values. You can use extra memory,
 *         helper functions, and can modify the node struct but, you can’t add a
 *         parent pointer.
 */
public class LeastCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static boolean val1Exist = false;
	private static boolean val2Exist = false;

	public int lca(Tree a, int val1, int val2) {
		Tree lcaNode = getLca(a, val1, val2);
		if (val1Exist && val2Exist && lcaNode != null) {
			return lcaNode.getData();
		}
		return -1;
	}

	private Tree getLca(Tree a, int val1, int val2) {
		if (a == null) {
			return null;
		}
		Tree left = getLca(a.getLeftChild(), val1, val2);
		Tree right = getLca(a.getRightChild(), val1, val2);
		if (a.getData() == val1) {
			val1Exist = true;
			return a;
		}
		if (a.getData() == val2) {
			val2Exist = true;
			return a;
		}
		if (left != null && right != null) {
			return a;
		}
		return (left == null ? right : left);
	}
}