package com.kumanoit.trees.binarySearchTree.page1;

import com.kumanoit.trees.bstUtils.BSTUtils;
import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class Test {

	public static void testPairSum() {
		Tree root1 = TreeUtils.createBinarySearchTree(new int[] { 8, 3, 10, 1, 6, 14, 5, 7, 13 });
		Tree root2 = TreeUtils.createBinarySearchTree(new int[] { 5, 2, 18, 1, 3, 4 });
		Solution.findPairsWithGivenSum(root1, root2, 10);
	}

	public static void testSubsequencePresent() {
		Tree root1 = TreeUtils.createBinarySearchTree(new int[] { 8, 3, 10, 1, 6, 14, 5, 7, 13 });
		Solution.isSubSequencePresent(root1, new int[] {1,3,5,14});
		Solution.isSubSequencePresent(root1, new int[] {1,6,7,14});
		Solution.isSubSequencePresent(root1, new int[] {1,6,78,14});
	}

	public static void main(String[] args) {
//		testSubsequencePresent();
		int[] array = { 18, 36, 9, 6, 12, 10, 1, 8 };
		BSTUtils.createBST(array).display();;
	}
}
