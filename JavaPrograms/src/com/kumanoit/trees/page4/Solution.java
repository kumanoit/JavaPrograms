package com.kumanoit.trees.page4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.kumanoit.trees.utils.Tree;

public class Solution {

	/**
	 * http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal-set-2/
	 */
	public static void printReverseLevelSpecial(Tree root) {
		if (root == null) {
			return;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(root);
		queue.add(root.getRightChild());
		queue.add(root.getLeftChild());
		while (!queue.isEmpty()) {
			Tree ptr1 = queue.remove();
			Tree ptr2 = queue.remove();
			if (ptr1.getLeftChild() != null) {
				queue.add(ptr1.getLeftChild());
				queue.add(ptr2.getRightChild());
				queue.add(ptr1.getRightChild());
				queue.add(ptr2.getLeftChild());
			}
			stack.push(ptr1);
			stack.push(ptr2);
		}
		stack.forEach(item -> System.out.print(item.getData() + ", "));
		System.out.println();
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getData() + ", ");
		}
	}

	/**
	 * http://www.geeksforgeeks.org/vertical-sum-in-binary-tree-set-space-optimized/
	 */
	public static void sumNodesTreeVerticalOrder(Tree root) {
		Tree dll = new Tree(0);
		sumNodesTreeVerticalOrder(root, dll);
		while (dll.getLeftChild() != null) {
			dll = dll.getLeftChild();
		}
		while (dll != null) {
			System.out.print(dll.getData() + ", ");
			dll = dll.getRightChild();
		}
	}

	private static void sumNodesTreeVerticalOrder(Tree root, Tree dll) {
		if (root == null) {
			return;
		}
		dll.setData(dll.getData() + root.getData());
		System.out.println(root.getData() + "\t" + dll.getData());
		if (root.getLeftChild() != null) {
			if (dll.getLeftChild() == null) {
				Tree newNode = new Tree(0);
				dll.setLeftChild(newNode);
				newNode.setRightChild(dll);
			}
			sumNodesTreeVerticalOrder(root.getLeftChild(), dll.getLeftChild());
		}
		if (root.getRightChild() != null) {
			if (dll.getRightChild() == null) {
				Tree newNode = new Tree(0);
				dll.setRightChild(newNode);
				newNode.setLeftChild(dll);
			}
			sumNodesTreeVerticalOrder(root.getRightChild(), dll.getRightChild());
		}
	}

	/**
	 * http://www.geeksforgeeks.org/print-leftmost-and-rightmost-nodes-of-a-binary-tree/
	 */
	public static void printBorderNodesPerLevel(Tree root) {
		if (root == null) {
			return;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty() && queue.size() != 1) {
			Tree firstNode = queue.remove();
			Tree lastNode = null;
			System.out.print(firstNode.getData() + ", ");
			while (firstNode != null) {
				if (firstNode.getLeftChild() != null) {
					queue.add(firstNode.getLeftChild());
				}
				if (firstNode.getRightChild() != null) {
					queue.add(firstNode.getRightChild());
				}
				lastNode = firstNode;
				firstNode = queue.remove();
			}
			System.out.println(lastNode.getData());
			queue.add(null);
		}
	}

	/**
	 * http://www.geeksforgeeks.org/check-if-removing-an-edge-can-divide-a-binary-tree-in-two-halves/
	 */
	private static boolean isTreeBisectable = false;

	public static boolean ifRemovingEdgeDivides(Tree root) {
		int totalNodes = countTotalNodesInTree(root, 0);
		countTotalNodesInTree(root, totalNodes);
		return isTreeBisectable;
	}

	private static int countTotalNodesInTree(Tree root, int n) {
		if (root == null) {
			return 0;
		}
		int lc = countTotalNodesInTree(root.getLeftChild(), n);
		int rc = countTotalNodesInTree(root.getRightChild(), n);
		int total = lc + 1 + rc;
		if (n - total == total) {
			isTreeBisectable = true;
		}
		return total;
	}

	/**
	 * http://www.geeksforgeeks.org/check-sum-covered-uncovered-nodes-binary-tree/
	 */
	public static boolean checkSumCoveredUncoveredNodes(Tree root) {
		int leftSum = sumLeftCoveredNodes(root.getLeftChild());
		int rightSum = sumRightCoveredNodes(root.getRightChild());
		int totalSum = getAllNodesSum(root);
		return 2 * (leftSum + rightSum + root.getData()) == totalSum;
	}

	private static int getAllNodesSum(Tree root) {
		if (root == null) {
			return 0;
		}
		return root.getData() + getAllNodesSum(root.getLeftChild()) + getAllNodesSum(root.getRightChild());
	}

	private static int sumLeftCoveredNodes(Tree root) {
		if (root == null) {
			return 0;
		}
		int sum = root.getData();
		if (root.getLeftChild() != null) {
			return sum + sumLeftCoveredNodes(root.getLeftChild());
		} else if (root.getRightChild() != null) {
			return sum + sumLeftCoveredNodes(root.getRightChild());
		}
		return sum;
	}

	private static int sumRightCoveredNodes(Tree root) {
		if (root == null) {
			return 0;
		}
		int sum = root.getData();
		if (root.getRightChild() != null) {
			return sum + sumRightCoveredNodes(root.getRightChild());
		} else if (root.getLeftChild() != null) {
			return sum + sumRightCoveredNodes(root.getLeftChild());
		}
		return sum;
	}

	/**
	 * http://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
	 */
	private static int maxDifference = 0;

	public static int getMaxDifference(Tree root) {
		getMinimum(root);
		return maxDifference;
	}

	public static int getMinimum(Tree root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int leftMinimum = getMinimum(root.getLeftChild());
		int rightMinimum = getMinimum(root.getRightChild());
		int localMD = root.getData() - Math.min(leftMinimum, rightMinimum);
		if (maxDifference < localMD) {
			maxDifference = localMD;
		}
		return Math.min(Math.min(leftMinimum, rightMinimum), root.getData());
	}

	public static Tree getBST(int[] postorder, int start, int size) {
		if (size <= 0) {
			return null;
		}
		int lastIndex = start + size - 1;
		Tree root = new Tree(postorder[lastIndex]);
		int i = start + size - 2;
		while (i > start && postorder[i] > postorder[lastIndex]) {
			i--;
		}
		root.setLeftChild(getBST(postorder, start, i - start + 1));
		root.setRightChild(getBST(postorder, i + 1, size - i - 2));
		return root;
	}

	public static Tree createTreeAncestorMatrix(int[][] matrix) {
		int n = matrix.length;
		Tree root = null;
		Tree[] nodes = new Tree[n];
		int i = 0;
		int j = 0;
		for (i = 0; i < matrix.length; i++) {
			if (nodes[i] == null) {
				createTree(matrix, nodes, i);
			}
		}

		for (i = 0; i < matrix.length; i++) {
			for (j = 0; j < matrix[i].length; j++) {
				if (matrix[j][i] == 1) {
					break;
				}
			}
			if (j == matrix[i].length) {
				root = nodes[i];
				break;
			}
		}
		return root;
	}

	private static Tree createTree(int[][] matrix, Tree[] nodes, int index) {
		if (nodes[index] != null) {
			return nodes[index];
		}
		Tree newNode = new Tree(index);
		nodes[index] = newNode;
		for (int i = 0; i < nodes.length; i++) {
			if (i != index && matrix[index][i] == 1) {
				if (nodes[i] == null) {
					createTree(matrix, nodes, i);
				}

				if (nodes[index].getLeftChild() == null) {
					nodes[index].setLeftChild(nodes[i]);
				} else if (nodes[index].getRightChild() == null) {
					nodes[index].setRightChild(nodes[i]);
				} else {
					System.err.println("Wrong matrix");
					System.exit(1);
				}
			}
		}
		return newNode;
	}
}
