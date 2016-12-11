/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Miscellaneous {

	private static int leafLevel = -1;

	// difference between odd and even level nodes
	public static int getDifference(Tree root) {
		if (root == null) {
			return 0;
		}
		return root.getData() - (getDifference(root.getLeftChild()) + getDifference(root.getRightChild()));
	}

	// height of tree
	public static int getHeight(Tree tree) {
		if (tree == null) {
			return 0;
		}
		int leftHeight = getHeight(tree.getLeftChild());
		int rightHeight = getHeight(tree.getRightChild());
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// print ancestors of all leaf nodes in a tree
	public static void printAncestors(Tree root, List<Tree> list) {
		if (root == null) {
			return;
		}
		if (root.isLeaf()) {
			System.out.print("Ancestors of " + root.getData() + " : ");
			list.forEach(item -> System.out.print(item.getData() + " "));
			System.out.println();
			return;
		}
		list.add(root);
		printAncestors(root.getLeftChild(), list);
		printAncestors(root.getRightChild(), list);
		list.remove(root);
	}

	// checks if all leaf nodes are present at same level
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

	// prints all paths b/w any two nodes lying in same path from root to leaf
	// with given sum
	public static void printPathWithSumK(Tree root, int k) {
		System.out.println("Via O(n^2) : ");
		printPathWithSumK(root, k, new ArrayList<Tree>(), 0);
		System.out.println("Via O(n) : ");
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		printPathWithSumK(root, k, 0, new ArrayList<Tree>(), map, 0);
	}

	// prints all paths b/w any two nodes lying in same path from root to leaf
	// with given sum
	// O(n^2)
	public static void printPathWithSumK(Tree root, int k, List<Tree> path, int sum) {
		if (root == null) {
			return;
		}
		sum += root.getData();
		path.add(root);
		if (sum >= k) {
			int temp = sum;
			int index = 0;
			while (temp > k && index < path.size()) {
				temp -= path.get(index).getData();
				index++;
			}
			if (temp == k) {
				while (index < path.size()) {
					System.out.print(path.get(index).getData() + "\t");
					index++;
				}
				System.out.println();
			}
		}
		printPathWithSumK(root.getLeftChild(), k, path, sum);
		printPathWithSumK(root.getRightChild(), k, path, sum);
		path.remove(root);
	}

	// prints all paths b/w any two nodes lying in same path from root to leaf
	// with given sum
	// O(n)
	public static void printPathWithSumK(Tree root, int k, int sum, List<Tree> paths, Map<Integer, Integer> sumIndexMap,
			int index) {
		if (root == null) {
			return;
		}
		sum += root.getData();
		paths.add(root);
		sumIndexMap.put(sum, index);
		if (sum >= k) {
			if (sumIndexMap.keySet().contains(sum - k)) {
				int lastIndex = sumIndexMap.get(sum - k) + 1;
				for (int i = lastIndex; i <= index; i++) {
					System.out.print(paths.get(i).getData() + "\t");
				}
				System.out.println();
			}
		}
		printPathWithSumK(root.getLeftChild(), k, sum, paths, sumIndexMap, index + 1);
		printPathWithSumK(root.getRightChild(), k, sum, paths, sumIndexMap, index + 1);
		paths.remove(root);
		sumIndexMap.remove(sum);
	}

	// counts total paths b/w any two nodes in lying in same path from root to
	// leaf with given sum
	public static int countTotalPathsGivingSum(Tree root, int k) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		return countTotalPathsGivingSum(root, k, set, new ArrayList<Tree>(), 0, 0);
	}

	public static int countTotalPathsGivingSum(Tree root, int k, Set<Integer> set, ArrayList<Tree> paths, int sum,
			int level) {
		if (root == null) {
			return 0;
		}
		sum += root.getData();
		paths.add(root);
		set.add(sum);
		int total = countTotalPathsGivingSum(root.getLeftChild(), k, set, paths, sum, level + 1)
				+ countTotalPathsGivingSum(root.getRightChild(), k, set, paths, sum, level + 1);
		if (set.contains(sum - k)) {
			total++;
		}
		paths.remove(root);
		set.remove(sum);
		sum -= root.getData();
		return total;
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

	// total number of nodes in a tree
	public static int getSizeOfTree(Tree root) {
		if (root == null) {
			return 0;
		}
		return 1 + getSizeOfTree(root.getLeftChild()) + getSizeOfTree(root.getRightChild());
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

	// convert a tree to its mirror form
	public static void convertToMirrorTree(Tree root) {
		if (root == null) {
			return;
		}
		convertToMirrorTree(root.getLeftChild());
		convertToMirrorTree(root.getRightChild());
		Tree leftSubTree = root.getLeftChild();
		Tree rightSubTree = root.getRightChild();
		root.setLeftChild(rightSubTree);
		root.setRightChild(leftSubTree);
	}

	private static int maxSum = 0;

	public static int getMaxSumFromRootToLeaf(Tree root) {
		maxSum = 0;
		getMaxSumFromRootToLeaf(root, 0);
		return maxSum;
	}

	private static void getMaxSumFromRootToLeaf(Tree root, int sum) {
		if (root == null) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		sum += root.getData();
		getMaxSumFromRootToLeaf(root.getLeftChild(), sum);
		getMaxSumFromRootToLeaf(root.getRightChild(), sum);
	}
}
