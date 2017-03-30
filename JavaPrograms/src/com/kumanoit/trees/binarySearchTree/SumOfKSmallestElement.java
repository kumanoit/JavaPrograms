package com.kumanoit.trees.binarySearchTree;

import com.kumanoit.trees.RefObject;
import com.kumanoit.trees.bstUtils.BSTSampleTrees;
import com.kumanoit.trees.utils.Tree;

public class SumOfKSmallestElement {

	private static int sum = 0;

	public static void main(String[] args) {
		sum = 0;
		testKthsmallestElement();
		getSumOfKSmallestElements(BSTSampleTrees.root1, new RefObject(4));
		System.out.println(sum);
	}

	public static void getSumOfKSmallestElements(Tree root, RefObject k) {
		if (root == null) {
			return;
		}
		getSumOfKSmallestElements(root.getLeftChild(), k);
		if (k.getData() == 0) {
			return;
		}
		sum += root.getData();
		k.decrement();
		getSumOfKSmallestElements(root.getRightChild(), k);
	}
	
	private static int kthSmallest = -1;

	private static void testKthsmallestElement() {
		kthSmallest = -1;
		getKthSmallestElement(BSTSampleTrees.root1, new RefObject(9));
		System.out.println(kthSmallest);
	}

	public static void getKthSmallestElement(Tree root, RefObject k) {
		if (root == null) {
			return;
		}
		getKthSmallestElement(root.getLeftChild(), k);
		k.decrement();
		if (k.getData() == 0) {
			kthSmallest = root.getData();
			return;
		} else if (k.getData() < 0) {
			return;
		}
		getKthSmallestElement(root.getRightChild(), k);
	}
}
