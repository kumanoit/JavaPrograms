package com.kumanoit.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Map.Entry;

import com.kumanoit.trees.utils.Tree;

public class PrintTrees {

	// http://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/
	public static void printExtremeNodesAlternateOrder(Tree root) {
		if (root == null) {
			return;
		}
		Stack<Tree> stack1 = new Stack<Tree>();
		Stack<Tree> stack2 = new Stack<Tree>();
		stack1.push(root);
		while (!(stack1.isEmpty() && stack2.isEmpty())) {
			if (!stack1.isEmpty()) {
				Tree ptr = stack1.pop();
				System.out.print(ptr.getData() + "\t");
				stack1.push(ptr);
				while (!stack1.isEmpty()) {
					ptr = stack1.pop();
					if (ptr.getLeftChild() != null) {
						stack2.push(ptr.getLeftChild());
					}
					if (ptr.getRightChild() != null) {
						stack2.push(ptr.getRightChild());
					}
				}
			}

			if (!stack2.isEmpty()) {
				Tree ptr = stack2.pop();
				System.out.print(ptr.getData() + "\t");
				stack2.push(ptr);
				while (!stack2.isEmpty()) {
					ptr = stack2.pop();
					if (ptr.getRightChild() != null) {
						stack1.push(ptr.getRightChild());
					}
					if (ptr.getLeftChild() != null) {
						stack1.push(ptr.getLeftChild());
					}
				}
			}
		}
	}

	// http://www.geeksforgeeks.org/print-nodes-binary-tree-k-leaves/
	public static int printNodesWithKLeaves(Tree root, int k) {
		if (root == null) {
			return 0;
		}
		if (root.isLeaf()) {
			if (k == 0) {
				System.out.print(root.getData() + "/t");
			}
			return 1;
		}
		int leftLeaves = printNodesWithKLeaves(root.getLeftChild(), k);
		int rightLeaves = printNodesWithKLeaves(root.getRightChild(), k);
		int totalLeaves = leftLeaves + rightLeaves;
		if (totalLeaves == k) {
			System.out.print(root.getData() + "\t");
		}
		return totalLeaves;
	}

	public static void printAllPathFromRootToLeaf(Tree root) {
		printAllPathFromRootToLeaf(root, new ArrayList<Tree>());
	}

	private static void printAllPathFromRootToLeaf(Tree root, List<Tree> paths) {
		if (root == null) {
			return;
		}
		if (root.isLeaf()) {
			paths.forEach(item -> System.out.print(item.getData() + "\t"));
			System.out.println(root.getData());
		}
		paths.add(root);
		printAllPathFromRootToLeaf(root.getLeftChild(), paths);
		printAllPathFromRootToLeaf(root.getRightChild(), paths);
		paths.remove(root);
	}

	// level order sum
	public static void printSumLevelWise(Tree root) {
		System.out.println("Using hashmap");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		printSumLevelWise(root, 0, map);
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("The sum of nodes at level = " + entry.getKey() + ", " + entry.getValue());
		}
		System.out.println("Using queue");
		printSumUsingQueue(root);
	}

	private static void printSumLevelWise(Tree root, int level, Map<Integer, Integer> sumMap) {
		if (root == null) {
			return;
		}
		if (sumMap.keySet().contains(level)) {
			sumMap.put(level, sumMap.get(level) + root.getData());
		} else {
			sumMap.put(level, root.getData());
		}
		printSumLevelWise(root.getLeftChild(), level + 1, sumMap);
		printSumLevelWise(root.getRightChild(), level + 1, sumMap);
	}

	private static void printSumUsingQueue(Tree root) {
		if (root == null) {
			return;
		}
		int level = 0;
		int sum = 0;
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			sum = 0;
			int totalSizeOfQueue = queue.size();
			while (totalSizeOfQueue > 0) {
				Tree ptr = queue.remove();
				if (ptr.getLeftChild() != null) {
					queue.add(ptr.getLeftChild());
				}
				if (ptr.getRightChild() != null) {
					queue.add(ptr.getRightChild());
				}
				sum += ptr.getData();
				totalSizeOfQueue--;
			}
			System.out.println("The sum at level = " + ++level + " is = " + sum);
		}
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

}
