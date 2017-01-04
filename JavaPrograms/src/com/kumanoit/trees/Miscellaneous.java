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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.kumanoit.trees.utils.Tree;

import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Miscellaneous {

	// difference between odd and even level nodes
	public static int getDifference(Tree root) {
		if (root == null) {
			return 0;
		}
		return root.getData() - (getDifference(root.getLeftChild()) + getDifference(root.getRightChild()));
	}

	// height of tree
	// http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
	public static int getHeight(Tree tree) {
		if (tree == null) {
			return 0;
		}
		int leftHeight = getHeight(tree.getLeftChild());
		int rightHeight = getHeight(tree.getRightChild());
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// counts total paths b/w any two nodes in lying in same path from root to
	// leaf with given sum
	public static int getTotalPathsGivingSum(Tree root, int k) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		return getTotalPathsGivingSum(root, k, set, new ArrayList<Tree>(), 0, 0);
	}

	public static int getTotalPathsGivingSum(Tree root, int k, Set<Integer> set, ArrayList<Tree> paths, int sum,
			int level) {
		if (root == null) {
			return 0;
		}
		sum += root.getData();
		paths.add(root);
		set.add(sum);
		int total = getTotalPathsGivingSum(root.getLeftChild(), k, set, paths, sum, level + 1)
				+ getTotalPathsGivingSum(root.getRightChild(), k, set, paths, sum, level + 1);
		if (set.contains(sum - k)) {
			total++;
		}
		paths.remove(root);
		set.remove(sum);
		sum -= root.getData();
		return total;
	}

	// total number of nodes in a tree :
	// http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
	public static int getSizeOfTree(Tree root) {
		if (root == null) {
			return 0;
		}
		return 1 + getSizeOfTree(root.getLeftChild()) + getSizeOfTree(root.getRightChild());
	}

	// print maximum from root to leaf
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

	// http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
	public static int getWidthOfTree(Tree root) {
		if (root == null) {
			return 0;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		int maxWidth = 0;
		while (!queue.isEmpty()) {
			int count = queue.size();
			maxWidth = Math.max(maxWidth, count);
			while (count > 0) {
				Tree ptr = queue.remove();
				count--;
				if (ptr.getLeftChild() != null) {
					queue.add(ptr.getLeftChild());
				}
				if (ptr.getRightChild() != null) {
					queue.add(ptr.getRightChild());
				}
			}
		}
		return maxWidth;
	}

	public static int getWidthOfTreeViaMap(Tree root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		getWidthOfTreeViaMap(root, map, 0);
		int maxWidth = 0;
		int maxWidthLevel = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxWidth) {
				maxWidth = entry.getValue();
				maxWidthLevel = entry.getKey();
			}
		}
		System.out.println("Maximum width is at level = " + maxWidthLevel);
		return maxWidth;
	}

	private static void getWidthOfTreeViaMap(Tree root, Map<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}
		if (map.keySet().contains(level)) {
			map.put(level, map.get(level) + 1);
		} else {
			map.put(level, 1);
		}
		getWidthOfTreeViaMap(root.getLeftChild(), map, level + 1);
		getWidthOfTreeViaMap(root.getRightChild(), map, level + 1);
	}

	// http://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
	public static int getMaxSumLevel(Tree root) {
		if (root == null) {
			return 0;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		int maxSum = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int sum = 0;
			while (size > 0) {
				Tree ptr = queue.remove();
				size--;
				sum += ptr.getData();
				if (ptr.getLeftChild() != null) {
					queue.add(ptr.getLeftChild());
				}
				if (ptr.getRightChild() != null) {
					queue.add(ptr.getRightChild());
				}
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	// http://www.geeksforgeeks.org/root-leaf-paths-equal-lengths-binary-tree/
	public static void getCountOfTreeWithSameHeight(Tree root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		getCountOfTreeWithSameHeight(root, 0, map);
		map.forEach((k, v) -> {
			System.out.println(v + " paths are of length " + k);
		});
	}

	private static void getCountOfTreeWithSameHeight(Tree root, int level, Map<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		level++;
		if (root.isLeaf()) {
			if (map.keySet().contains(level)) {
				map.put(level, map.get(level) + 1);
			} else {
				map.put(level, 1);
			}
			return;
		}
		getCountOfTreeWithSameHeight(root.getLeftChild(), level, map);
		getCountOfTreeWithSameHeight(root.getRightChild(), level, map);
	}

	// http://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/
	private static int maxContinuousLength = 0;

	public static int getMaxContinuousLength(Tree root) {
		maxContinuousLength = 0;
		getMaxContinuousLength(root, 0, null);
		return maxContinuousLength;
	}

	private static void getMaxContinuousLength(Tree root, int maxLengthSoFar, Tree lastNode) {
		if (root == null) {
			return;
		}
		if (lastNode == null || root.getData() == lastNode.getData() + 1) {
			maxLengthSoFar++;
			maxContinuousLength = Math.max(maxLengthSoFar, maxContinuousLength);
		} else {
			maxLengthSoFar = 1;
		}
		getMaxContinuousLength(root.getLeftChild(), maxLengthSoFar, root);
		getMaxContinuousLength(root.getRightChild(), maxLengthSoFar, root);
	}

	public static int getMinSteps(int number) {
		int step = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				size--;
				int start = queue.remove();
				if (start + step == number || start - step == number) {
					return step;
				}
				queue.add(start - step);
				queue.add(start + step);
			}
			step++;
		}
		return -1;
	}

	// http://www.geeksforgeeks.org/find-multiplication-of-sums-of-data-of-all-leaves-at-sane-levels/
	public static int getMultiplicationOfLeavesAtSameLevel(Tree root) {
		if (root == null) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		getMultiplicationOfLeavesAtSameLevel(root, map, 0);
		int product = 1;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Sum at level = " + entry.getKey() + " = " + entry.getValue());
			product *= entry.getValue();
		}
		return product;
	}

	private static void getMultiplicationOfLeavesAtSameLevel(Tree root, Map<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}
		if (root.isLeaf()) {
			if (map.keySet().contains(level)) {
				map.put(level, map.get(level) + root.getData());
			} else {
				map.put(level, root.getData());
			}
		}
		getMultiplicationOfLeavesAtSameLevel(root.getLeftChild(), map, level + 1);
		getMultiplicationOfLeavesAtSameLevel(root.getRightChild(), map, level + 1);
	}

}
