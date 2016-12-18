package com.kumanoit.crackingTheCodingInterview.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import com.kumanoit.trees.Tree;

/**
 * @author kuma wrote on Dec 10, 2016
 */
public class TreesGraphs {
	/**
	 * 4.1 Route Between Nodes: Given a directed graph, design an algorithm to
	 * find out whether there is a route between two nodes.
	 */
	public static boolean doesPathExist(int[][] graph, int source, int destination) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] isVisited = new boolean[graph.length];
		queue.add(source);
		isVisited[source] = true;
		while (!queue.isEmpty()) {
			int vertex = queue.remove();
			for (int index = 0; index < graph.length; index++) {
				if (graph[vertex][index] == 1) {
					if (index == destination) {
						queue.clear();
						return true;
					}
					if (!isVisited[index]) {
						queue.add(index);
						isVisited[index] = true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique
	 * integer elements, write an algorithm to create a binary search tree with
	 * minimal height.
	 */
	public static Tree createBalancedBstFromSortedArray(Integer[] array) {
		return createBalancedBstFromSortedArray(array, 0, array.length - 1);
	}

	private static Tree createBalancedBstFromSortedArray(Integer[] array, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		Tree root = new Tree(array[mid]);
		root.setLeftChild(createBalancedBstFromSortedArray(array, low, mid - 1));
		root.setRightChild(createBalancedBstFromSortedArray(array, mid + 1, high));
		return root;
	}

	/**
	 * 4.3 List of Depths: Given a binary tree, design an algorithm which creates
	 * a linked list of all the nodes at each depth (e.g., if you have a tree with
	 * depth D, you'll have D linked lists).
	 */

	public static void createLinkedListOfNodesAtSameLevel(Tree root) {
		Map<Integer, List<Tree>> map = new HashMap<Integer, List<Tree>>();
		createLinkedListOfNodesAtSameLevel(root, map, 1);
		map.forEach((u, v) -> {
			System.out.print("\nAt level " + u + " linked list elements  : ");
			v.forEach(element -> System.out.print(element.getData() + "\t"));
		});
	}

	private static void createLinkedListOfNodesAtSameLevel(Tree root, Map<Integer, List<Tree>> map, int level) {
		if (root == null) {
			return;
		}
		if (map.keySet().contains(level)) {
			map.get(level).add(root);
		} else {
			List<Tree> list = new ArrayList<Tree>();
			list.add(root);
			map.put(level, list);
		}
		createLinkedListOfNodesAtSameLevel(root.getLeftChild(), map, level + 1);
		createLinkedListOfNodesAtSameLevel(root.getRightChild(), map, level + 1);
	}

	/**
	 * 4.4 Check Balanced: Implement a function to check if a binary tree is
	 * balanced. For the purposes of this question, a balanced tree is defined to
	 * be a tree such that the heights of the two subtrees of any node never
	 * differ by more than one.
	 */
	public static boolean isBalanced(Tree root) {
		return isBalancedHeightTree(root) != -1;
	}

	private static int isBalancedHeightTree(Tree root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = isBalancedHeightTree(root.getLeftChild());
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = isBalancedHeightTree(root.getRightChild());
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	/**
	 * 4.5 Validate BST: Implement a function to check if a binary tree is a
	 * binary search tree.
	 */
	private static Tree lastNode = null;

	public static boolean isBinarySearchTree(Tree root) {
		if (root == null) {
			return true;
		}
		if (!isBinarySearchTree(root.getLeftChild())) {
			return false;
		}
		if (lastNode != null && lastNode.getData() >= root.getData()) {
			return false;
		}
		lastNode = root;
		return isBinarySearchTree(root.getRightChild());
	}

	/**
	 * 4.6 Successor: Write an algorithm to find the "next" node (i.e., in-order
	 * successor) of a given node in a binary search tree. You may assume that
	 * each node has a link to its parent.
	 */
	static Tree lastVisitedNode = null;

	public static Tree getInorderSuccessor(Tree root, int key) {
		if (root == null) {
			return null;
		}
		Tree left = getInorderSuccessor(root.getLeftChild(), key);
		if (left != null) {
			return left;
		}
		if (lastVisitedNode != null && lastVisitedNode.getData() == key) {
			return root;
		}
		lastVisitedNode = root;
		return getInorderSuccessor(root.getRightChild(), key);
	}

	public static Tree getInorderPredecessor(Tree root, int key) {
		if (root == null) {
			return null;
		}
		Tree left = getInorderPredecessor(root.getLeftChild(), key);
		if (left != null) {
			return left;
		}
		if (root.getData() == key) {
			return lastVisitedNode;
		}
		lastVisitedNode = root;
		return getInorderPredecessor(root.getRightChild(), key);
	}

	/**
	 * 
	 * 4.7 Build Order: You are given a list of projects and a list of
	 * dependencies (which is a list of pairs of projects, where the second
	 * project is dependent on the first project). All of a project's dependencies
	 * must be built before the project is. Find a build order that will allow the
	 * projects to be built. If there is no valid build order, return an error.
	 * EXAMPLE Input: projects: a, b, c, d, e, f dependencies: (a, d), (f, b), (b,
	 * d), (f, a), (d, c) Output: f, e, a, b, d, c
	 */

	public static void topologicalSort() {
		Scanner in = new Scanner(System.in);
		int totalProjects = in.nextInt();
		int totalDependencies = in.nextInt();
		Map<Integer, List<Integer>> dependencies = new HashMap<Integer, List<Integer>>();
		for (int index = 0; index < totalDependencies; index++) {
			int before = in.nextInt() - 1;
			int after = in.nextInt() - 1;
			if (dependencies.keySet().contains(before)) {
				dependencies.get(before).add(after);
			} else {
				List<Integer> dependencyList = new ArrayList<Integer>();
				dependencyList.add(after);
				dependencies.put(before, dependencyList);
			}
		}
		dependencies.forEach((k, v) -> {
			System.out.print("\n" + k + "  : ");
			v.forEach(items -> {
				System.out.print(items + "\t");
			});
		});
		topologicalSort(totalProjects, dependencies);
		in.close();
	}

	public static void topologicalSort(int totalProjects, Map<Integer, List<Integer>> dependencies) {
		int[] incomingEdges = new int[totalProjects];
		List<Integer> projectSequence = new ArrayList<Integer>();
		for (Entry<Integer, List<Integer>> dependency : dependencies.entrySet()) {
			List<Integer> dependencyList = dependency.getValue();
			dependencyList.forEach(item -> incomingEdges[item]++);
		}
		Queue<Integer> startingProjects = new LinkedList<Integer>();
		for (int index = 0; index < incomingEdges.length; index++) {
			if (incomingEdges[index] == 0) {
				startingProjects.add(index);
			}
		}
		if (startingProjects.isEmpty()) {
			System.out.println("Deadlock");
			System.exit(1);
		}
		while (!startingProjects.isEmpty()) {
			int start = startingProjects.remove();
			projectSequence.add(start + 1);
			if (dependencies.keySet().contains(start)) {
				List<Integer> dependentProjects = dependencies.get(start);
				dependentProjects.forEach(item -> {
					incomingEdges[item]--;
					if (incomingEdges[item] == 0) {
						startingProjects.add(item);
					}
				});
			}
		}
		if (projectSequence.size() != totalProjects) {
			System.out.println("Some projects can't be completed. They are stuck in deadlock");
		}
		System.out.println("Safe sequence");
		projectSequence.forEach(item -> System.out.print(item + "\t"));
	}

	/**
	 * 4.8 First Common Ancestor: Design an algorithm and write code to find the
	 * first common ancestor of two nodes in a binary tree. Avoid storing
	 * additional nodes in a data structure. NOTE: This is not necessarily a
	 * binary search tree.
	 */
	public static Tree getLeastCommonAncestor(Tree root, int value1, int value2) {
		if (root == null) {
			return null;
		}
		Tree left = getLeastCommonAncestor(root.getLeftChild(), value1, value2);
		Tree right = getLeastCommonAncestor(root.getRightChild(), value1, value2);
		if (root.getData() == value1 || root.getData() == value2) {
			return root;
		}
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	/**
	 * 4.9 BST Sequences: A binary search tree was created by traversing through
	 * an array from left to right and inserting each element. Given a binary
	 * search tree with distinct elements, print all possible arrays that could
	 * have led to this tree.
	 */

	/**
	 * 4.1 O Check Subtree: Tl and T2 are two very large binary trees, with Tl
	 * much bigger than T2. Create an algorithm to determine if T2 is a subtree of
	 * Tl. A tree T2 is a subtree of Tl if there exists a node n in Tl such that
	 * the subtree of n is identical to T2. That is, if you cut off the tree at
	 * node n, the two trees would be identical.
	 */
	public static boolean isSubTree(Tree root1, Tree root2, int k) {
		if (root1 == null) {
			return false;
		}
		if (root1.getData() == k) {
			return isSubTree(root1, root2);
		}
		return isSubTree(root1.getLeftChild(), root2, k) || isSubTree(root1.getRightChild(), root2, k);
	}

	public static boolean isSubTree(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null || root1.getData() != root2.getData()) {
			return false;
		}
		return isSubTree(root1.getLeftChild(), root2.getLeftChild())
				&& isSubTree(root1.getRightChild(), root2.getRightChild());
	}

	/**
	 * 4.11 Random Node: You are implementing a binary tree class from scratch
	 * which, in addition to insert, find, and delete, has a method
	 * getRandomNode() which returns a random node from the tree. All nodes should
	 * be equally likely to be chosen. Design and implement an algorithm for
	 * getRandomNode, and explain how you would implement the rest of the methods.
	 */

	/**
	 * 4.12 Paths with Sum: You are given a binary tree in which each node
	 * contains an integer value (which might be positive or negative). Design an
	 * algorithm to count the number of paths that sum to a given value. The path
	 * does not need to start or end at the root or a leaf, but it must go
	 * downwards (traveling only from parent nodes to child nodes).
	 */
	public static int getTotalNumberOfPathsWithKSum(Tree root, int k) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		return getTotalNumberOfPathsWithKSum(root, k, 0, set);
	}

	private static int getTotalNumberOfPathsWithKSum(Tree root, int k, int sum, Set<Integer> set) {
		if (root == null) {
			return 0;
		}
		sum += root.getData();
		set.add(sum);
		int total = getTotalNumberOfPathsWithKSum(root.getLeftChild(), k, sum, set)
				+ getTotalNumberOfPathsWithKSum(root.getRightChild(), k, sum, set);
		if (set.contains(sum - k)) {
			total++;
		}
		set.remove(sum);
		return total;
	}

	public static int getTotalNumberOfPathsWithKSumWithValues(Tree root, int k) {
		Map<Integer, Integer> sumIndex = new HashMap<Integer, Integer>();
		sumIndex.put(0, -1);
		List<Tree> path = new ArrayList<Tree>();
		return getTotalNumberOfPathsWithKSumWithValues(root, k, path, sumIndex, 0, 0);
	}

	public static int getTotalNumberOfPathsWithKSumWithValues(Tree root, int k, List<Tree> path,
			Map<Integer, Integer> sumIndex, int sum, int level) {
		if (root == null) {
			return 0;
		}
		sum += root.getData();
		path.add(root);
		sumIndex.put(sum, level);
		int total = getTotalNumberOfPathsWithKSumWithValues(root.getLeftChild(), k, path, sumIndex, sum, level + 1)
				+ getTotalNumberOfPathsWithKSumWithValues(root.getRightChild(), k, path, sumIndex, sum, level + 1);
		if (sumIndex.keySet().contains(sum - k)) {
			for (int i = sumIndex.get(sum - k) + 1; i <= level; i++) {
				System.out.print(path.get(i).getData() + "\t");
			}
			System.out.println();
			total++;
		}
		sumIndex.remove(sum);
		path.remove(root);
		return total;
	}

}
