/**
 * 
 * Created by Amit Kumar on 28/01/17.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees.page1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

import com.kumanoit.trees.Pair;
import com.kumanoit.trees.utils.Tree;

public class Solution {

	/**
	 * 1. http://www.geeksforgeeks.org/print-nodes-binary-tree-k-leaves/
	 */
	public static List<Tree> getAllNodesWithKLeafNodes(Tree root, int k) {
		List<Tree> solution = new ArrayList<Tree>();
		getAllNodesWithKLeafNodes(root, k, solution);
		return solution;
	}

	private static int getAllNodesWithKLeafNodes(Tree root, int k, List<Tree> solutionList) {
		if (root == null) {
			return 0;
		}
		int leftLeafNodesCount = getAllNodesWithKLeafNodes(root.getLeftChild(), k, solutionList);
		int rightLeafNodesCount = getAllNodesWithKLeafNodes(root.getRightChild(), k, solutionList);
		if (leftLeafNodesCount + rightLeafNodesCount == k) {
			solutionList.add(root);
		}
		if (root.isLeaf()) {
			return 1;
		}
		return leftLeafNodesCount + rightLeafNodesCount;
	}

	/**
	 * 2. http://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
	 */
	public static int getMaximumSumWrapper(Tree root) {
		Pair max = getMaximumSum(root);
		return Math.max(max.getExclusive(), max.getInclusive());
	}

	private static Pair getMaximumSum(Tree root) {
		Pair myMax = new Pair(0, 0);
		if (root == null) {
			return myMax;
		}
		Pair left = getMaximumSum(root.getLeftChild());
		Pair right = getMaximumSum(root.getRightChild());
		int maxInclusive = left.getExclusive() + right.getExclusive() + root.getData();
		int maxExclusive = Math.max(left.getInclusive(), left.getExclusive())
				+ Math.max(right.getInclusive(), right.getExclusive());
		myMax = new Pair(maxInclusive, maxExclusive);
		return myMax;
	}

	/**
	 * 3. http://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
	 */
	public static int getLevelWithMaximumSum(Tree root) {
		if (root == null) {
			return -1;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int maxSum = Integer.MIN_VALUE;
		int maxLevel = 0;
		getLevelWithMaximumSum(root, map, 0);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("level = " + entry.getKey() + ", sum = " + entry.getValue());
			if (entry.getValue() > maxSum) {
				maxSum = entry.getValue();
				maxLevel = entry.getKey();
			}
		}
		return maxLevel;
	}

	private static void getLevelWithMaximumSum(Tree root, Map<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}
		map.put(level, Optional.ofNullable(map.get(level)).orElse(0) + root.getData());
		// if (map.keySet().contains(level)) {
		// map.put(level, map.get(level) + root.getData());
		// } else {
		// map.put(level, root.getData());
		// }
		getLevelWithMaximumSum(root.getLeftChild(), map, level + 1);
		getLevelWithMaximumSum(root.getRightChild(), map, level + 1);
	}

	public static int getLevelWithMaximumSum2(Tree root) {
		if (root == null) {
			return -1;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		int maxSumLevel = 0;
		int maxSum = root.getData();
		int level = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int sum = 0;
			while (size > 0) {
				Tree ptr = queue.remove();
				sum += ptr.getData();
				if (ptr.getLeftChild() != null) {
					queue.add(ptr.getLeftChild());
				}
				if (ptr.getRightChild() != null) {
					queue.add(ptr.getRightChild());
				}
				size--;
			}
			if (sum > maxSum) {
				maxSumLevel = level;
				maxSum = sum;
			}
			System.out.println("level = " + level + ", sum = " + sum);
			level++;
		}
		return maxSumLevel;
	}

	/**
	 * http://www.geeksforgeeks.org/root-leaf-paths-equal-lengths-binary-tree/
	 */
	public static void getEqualLengthPathCount(Tree root) {
		if (root == null) {
			return;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		getEqualLengthPathCount(root, map, 1);
		map.forEach((length, totalPaths) -> System.out.println(totalPaths + " paths are of length : " + length));
	}

	private static void getEqualLengthPathCount(Tree root, Map<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}
		if (root.isLeaf()) {
			map.put(level, Optional.ofNullable(map.get(level)).orElse(0) + 1);
			return;
		}
		getEqualLengthPathCount(root.getLeftChild(), map, level + 1);
		getEqualLengthPathCount(root.getRightChild(), map, level + 1);
	}

	/**
	 * http://www.geeksforgeeks.org/continuous-tree/
	 */
	public static boolean isContinuousTree(Tree root) {
		if (root == null) {
			return true;
		}
		if (root.isLeaf()) {
			return true;
		}
		if (root.getLeftChild() != null) {
			if (Math.abs(root.getData() - root.getLeftChild().getData()) > 1) {
				return false;
			}
		}
		if (root.getRightChild() != null) {
			if (Math.abs(root.getData() - root.getRightChild().getData()) > 1) {
				return false;
			}
		}
		return isContinuousTree(root.getLeftChild()) && isContinuousTree(root.getRightChild());
	}

	/**
	 * http://www.geeksforgeeks.org/find-pair-root-leaf-path-sum-equals-roots-data/
	 */
	public static void printPairWithSumOfRoot(Tree root) {
		if (root == null) {
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		printPairWithSumOfRoot(root, set, root.getData());
	}

	private static void printPairWithSumOfRoot(Tree root, Set<Integer> set, int rootValue) {
		if (root == null) {
			return;
		}
		if (set.contains(rootValue - root.getData())) {
			System.out.println(root.getData() + " + " + (rootValue - root.getData()) + " = " + rootValue);
		}
		set.add(root.getData());
		printPairWithSumOfRoot(root.getLeftChild(), set, rootValue);
		printPairWithSumOfRoot(root.getRightChild(), set, rootValue);
		set.remove(root.getData());
	}

	/**
	 * http://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
	 */
	public static boolean isPathPresent(Tree root, int[] array) {
		return isPathPresent(root, 0, array);
	}

	private static boolean isPathPresent(Tree root, int level, int[] array) {
		if (level == array.length) {
			return true;
		}
		if (root == null) {
			return false;
		}
		if (root.getData() != array[level]) {
			return false;
		}
//		boolean isPP = false;
//		if (root.getData() == array[level]) {
//			isPP = isPathPresent(root.getLeftChild(), level + 1, array)
//					|| isPathPresent(root.getRightChild(), level + 1, array);
//		}
		return isPathPresent(root.getLeftChild(), level + 1, array)
				|| isPathPresent(root.getRightChild(), level + 1, array);
	}

	/**
	 * http://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/
	 */
	private static int longestConsecutiveSequenceLength = 1;
	public static int getLongestConsecutiveSequence(Tree root) {
		longestConsecutiveSequenceLength = 0;
		getLongestConsecutiveSequence(root, 1);
		return longestConsecutiveSequenceLength;
	}

	private static void getLongestConsecutiveSequence(Tree root, int currentConsecutiveLength) {
		if (root == null) {
			return;
		}
		Tree leftChild = root.getLeftChild();
		if (leftChild != null && (leftChild.getData() - 1 == root.getData())) {
			longestConsecutiveSequenceLength = Math.max(longestConsecutiveSequenceLength, currentConsecutiveLength + 1);
			getLongestConsecutiveSequence(root.getLeftChild(), currentConsecutiveLength + 1);
		} else {
			getLongestConsecutiveSequence(root.getLeftChild(), currentConsecutiveLength);
		}
		Tree rightChild = root.getRightChild();
		if (rightChild != null && (rightChild.getData() - 1 == root.getData())) {
			longestConsecutiveSequenceLength = Math.max(longestConsecutiveSequenceLength, currentConsecutiveLength + 1);
			getLongestConsecutiveSequence(root.getRightChild(), currentConsecutiveLength + 1);
		} else {
			getLongestConsecutiveSequence(root.getRightChild(), currentConsecutiveLength);
		}
	}

}
