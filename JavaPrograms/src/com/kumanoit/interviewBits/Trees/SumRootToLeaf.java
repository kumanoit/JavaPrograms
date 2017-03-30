package com.kumanoit.interviewBits.Trees;

import com.kumanoit.trees.TreeSamples;
import com.kumanoit.trees.utils.Tree;

/**
 * https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
 * 
 * @author kuma Given a binary tree containing digits from 0-9 only, each
 *         root-to-leaf path could represent a number.
 * 
 *         An example is the root-to-leaf path 1->2->3 which represents the
 *         number 123.
 * 
 *         Find the total sum of all root-to-leaf numbers % 1003.
 */
public class SumRootToLeaf {

	public static void main(String[] args) {
		sumNumbers(TreeSamples.root1);
	}

	private static int totalSum = 0;

	public static int sumNumbers(Tree a) {
		getSum(a, 0);
		return totalSum;
	}

	private static void getSum(Tree root, int sum) {
		if (root == null) {
			return;
		}
		sum = sum * 10 + root.getData();
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			totalSum = (totalSum + sum) % 1003;
			return;
		}
		getSum(root.getLeftChild(), sum);
		getSum(root.getRightChild(), sum);
	}
}
