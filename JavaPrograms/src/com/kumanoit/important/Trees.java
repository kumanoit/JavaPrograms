package com.kumanoit.important;

import java.util.LinkedList;
import java.util.Queue;

import com.kumanoit.trees.Pair;
import com.kumanoit.trees.utils.Tree;

public class Trees {
	/**
	 * 2.
	 * http://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
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
	 * http://www.geeksforgeeks.org/find-a-number-in-minimum-steps/
	 */
	public static int getMinsteps(int n) {
		return getMinsteps(0, n, 1);
	}

	/**
	 * will give stack overflow exception because it leads to dfs and one may end
	 * up traversing unnecessary paths
	 */
	private static int getMinsteps(int start, int end, int steps) {
		if (start == end) {
			return steps;
		}
		if (steps >= 100) {
			return Integer.MAX_VALUE;
		}

		return Math.min(getMinsteps(start + steps, end, steps + 1), getMinsteps(start - steps, end, steps + 1));
	}

	public static int getMinSteps(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int level = 0;
		queue.add(0);
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			while (size > 0) {
				int pop = queue.remove();
				if (pop == n) {
					return level - 1;
				}
				queue.add(pop + level);
				queue.add(pop - level);
				size--;
			}
		}
		return -1;
	}
}
