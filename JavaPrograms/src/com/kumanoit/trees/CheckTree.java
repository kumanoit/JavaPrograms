package com.kumanoit.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.kumanoit.trees.utils.Tree;

public class CheckTree {

	// http://www.geeksforgeeks.org/check-if-leaf-traversal-of-two-binary-trees-is-same/
	public static boolean isLeafTraversalIsSame(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		Tree ptr1 = root1;
		Tree ptr2 = root2;
		int value1 = 0;
		int value2 = 0;
		Stack<Tree> stack1 = new Stack<Tree>();
		Stack<Tree> stack2 = new Stack<Tree>();
		boolean flag1 = true;
		boolean flag2 = true;
		while (true) {
			while (flag1) {
				if (ptr1 != null) {
					stack1.push(ptr1);
					ptr1 = ptr1.getLeftChild();
				} else if (stack1.isEmpty()) {
					value1 = Integer.MAX_VALUE;
					break;
				} else {
					ptr1 = stack1.pop();
					value1 = ptr1.getData();
					if (ptr1.isLeaf()) {
						flag1 = false;
					}
					ptr1 = ptr1.getRightChild();
					if (!flag1) {
						System.out.println("#### " + value1);
						break;
					}
				}
			}
			while (flag2) {
				if (ptr2 != null) {
					stack2.push(ptr2);
					ptr2 = ptr2.getLeftChild();
				} else if (stack2.isEmpty()) {
					value2 = Integer.MAX_VALUE;
					break;
				} else {
					ptr2 = stack2.pop();
					value2 = ptr2.getData();
					if (ptr2.isLeaf()) {
						flag2 = false;
					}
					ptr2 = ptr2.getRightChild();
					if (!flag2) {
						System.out.println(">>>> " + value2);
						break;
					}
				}
			}
			if (value1 == Integer.MAX_VALUE && value2 == Integer.MAX_VALUE) {
				return true;
			}
			System.out.println("$$$$ " + value1 + "\t" + value2);
			if (value1 != value2) {
				return false;
			}
			flag1 = true;
			flag2 = true;
		}
	}

	// checks if all leaf nodes are present at same level
	private static int leafLevel = -1;

	public static void areAllLeafAtSameLevel(Tree root) {
		if (areAllLeafAtSameLevel(root, 0)) {
			System.out.println("All leaf nodes are same level.");
		} else {
			System.out.println("No, all leaf nodes are not at same level.");
		}
	}

	private static boolean areAllLeafAtSameLevel(Tree root, int level) {
		if (root == null) {
			return true;
		}
		if (root.isLeaf()) {
			if (leafLevel == -1) {
				leafLevel = level;
			}
			return leafLevel == level;
		}
		return areAllLeafAtSameLevel(root.getLeftChild(), level + 1)
				&& areAllLeafAtSameLevel(root.getRightChild(), level + 1);
	}

	// checks if two trees have same structure
	public static boolean areTreesIsomorphic(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.getData() != root2.getData()) {
			return false;
		}
		return areTreesIsomorphic(root1.getLeftChild(), root2.getLeftChild())
				&& areTreesIsomorphic(root1.getRightChild(), root2.getRightChild())
				|| areTreesIsomorphic(root1.getLeftChild(), root2.getRightChild())
						&& areTreesIsomorphic(root1.getRightChild(), root2.getLeftChild());
	}

	// checks if given tree is a binary search tree
	private static Tree lastVisitedNode = null;

	public static boolean isBinarySearchTree(Tree root) {
		if (root == null) {
			return true;
		}
		if (!isBinarySearchTree(root.getLeftChild())) {
			return false;
		}
		if (lastVisitedNode != null && lastVisitedNode.getData() >= root.getData()) {
			return false;
		}
		lastVisitedNode = root;
		return true;
	}

	// checks if given tree is a balanced tree or not
	public static boolean isBalanced(Tree root) {
		return isBalancedTree(root) != -1;
	}

	public static int isBalancedTree(Tree root) {
		if (root == null) {
			return 0;
		}

		int lh = isBalancedTree(root.getLeftChild());
		if (lh == -1) {
			return -1;
		}

		int rh = isBalancedTree(root.getRightChild());
		if (rh == -1) {
			return -1;
		}

		if (Math.abs(lh - rh) > 1) {
			return -1;
		}
		return Math.max(lh, rh) + 1;
	}

	// checks if given bst has only child for non-leaf nodes given in form of
	// preorder
	public static boolean isBstHasOneChild(int preorder[], int size) {
		if (size == 0) {
			return true;
		}
		int max = Math.max(preorder[size - 1], preorder[size - 2]);
		int min = preorder[size - 1] + preorder[size - 2] - max;
		for (int index = size - 3; index >= 0; index--) {
			if (preorder[index] < min) {
				min = preorder[index];
			} else if (preorder[index] > max) {
				max = preorder[index];
			} else {
				return false;
			}
		}
		return true;
	}

	// checks if trees are identical
	// http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
	public static boolean areTreesIdentical(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.getData() != root2.getData()) {
			return false;
		}
		return areTreesIdentical(root1.getLeftChild(), root2.getLeftChild())
				&& areTreesIdentical(root1.getRightChild(), root2.getRightChild());
	}

	// http://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
	public static boolean isMirrorTree(Tree root) {
		return isMirrorTree(root.getLeftChild(), root.getRightChild());
	}

	private static boolean isMirrorTree(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return true;
		}
		if (root2.getData() != root2.getData()) {
			return false;
		}
		return isMirrorTree(root1.getLeftChild(), root2.getRightChild())
				&& isMirrorTree(root1.getRightChild(), root2.getLeftChild());
	}

	// http://www.geeksforgeeks.org/continuous-tree/
	public static boolean isContinuousTree(Tree root) {
		if (root == null || root.isLeaf()) {
			return true;
		}
		if (root.getLeftChild() != null && Math.abs(root.getLeftChild().getData() - root.getData()) != 1) {
			return false;
		}
		if (root.getRightChild() != null && Math.abs(root.getRightChild().getData() - root.getData()) != 1) {
			return false;
		}
		return isContinuousTree(root.getLeftChild()) && isContinuousTree(root.getRightChild());
	}

	// http://www.geeksforgeeks.org/find-pair-root-leaf-path-sum-equals-roots-data/
	public static boolean isPairExistWithSumOfRoot(Tree root) {
		if (root == null) {
			return false;
		}
		return isPairExistWithSumOfRoot(root, new ArrayList<Integer>(), root.getData());
	}

	private static boolean isPairExistWithSumOfRoot(Tree root, List<Integer> list, int sum) {
		if (root == null) {
			return false;
		}
		if (list.contains(sum - root.getData())) {
			return true;
		}
		list.add(root.getData());
		if (isPairExistWithSumOfRoot(root.getLeftChild(), list, sum)
				|| isPairExistWithSumOfRoot(root.getRightChild(), list, sum)) {
			list.remove(root.getData());
			return true;
		}
		return false;
	}

	// http://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
	public static boolean isPathExist(Tree root, int[] array) {
		return isPathExist(root, array, 0);
	}

	private static boolean isPathExist(Tree root, int[] array, int level) {
		if (level == array.length) {
			return true;
		}
		if (root == null) {
			return false;
		}
		if (root.getData() != array[level]) {
			return false;
		}
		return isPathExist(root.getLeftChild(), array, level + 1) || isPathExist(root.getRightChild(), array, level + 1);
	}

	// checks if a tree is a sum tree. where sum tree is a tree in which all
	// non-leaf nodes has value equal to sum of left subtree nodes and right
	// subtree nodes
	public static boolean isSumTree(Tree root) {
		return isSumTreeCheck(root) != -1;
	}

	private static int isSumTreeCheck(Tree root) {
		if (root == null) {
			return 0;
		}
		if (root.isLeaf()) {
			return root.getData();
		}
		int leftSubtreeSum = isSumTreeCheck(root.getLeftChild());
		if (leftSubtreeSum == -1) {
			return -1;
		}
		int rightSubtreeSum = isSumTreeCheck(root.getRightChild());
		if (rightSubtreeSum == -1) {
			return -1;
		}
		if (leftSubtreeSum + rightSubtreeSum != root.getData()) {
			return -1;
		}
		return 2 * root.getData();
	}

	// http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
	/**
	 * O(n^2) solution
	 */
	public static boolean isPreorderOfBst(int[] array) {
		return isPreorderOfBst(array, 0, array.length - 1);
	}

	public static boolean isPreorderOfBst(int[] array, int low, int high) {
		if (low > high) {
			return true;
		}
		int index = low;
		for (index = low; index <= high; index++) {
			if (array[low] < array[index]) {
				break;
			}
		}
		for (int j = index + 1; j <= high; j++) {
			if (array[j] < array[low]) {
				return false;
			}
		}
		return isPreorderOfBst(array, low + 1, index - 1) && isPreorderOfBst(array, index, high);
	}
}
