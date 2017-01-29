/**
 * 
 * Created by Amit Kumar on 29/01/17.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees.page2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.kumanoit.trees.utils.Tree;

public class Solution {

	/**
	 * http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
	 */
	public static void convertBinaryTreeToDoublyLinkedList(Tree root) {
		convertBTDoublyLinkedList(root);
		while (root.getLeftChild() != null) {
			root = root.getLeftChild();
		}
		while (root != null) {
			System.out.print(root.getData() + ", ");
			root = root.getRightChild();
		}
	}

	private static Tree lastNode = null;

	private static void convertBTDoublyLinkedList(Tree root) {
		if (root == null) {
			return;
		}
		convertBTDoublyLinkedList(root.getLeftChild());
		if (lastNode != null) {
			lastNode.setRightChild(root);
			root.setLeftChild(lastNode);
		}
		lastNode = root;
		convertBTDoublyLinkedList(root.getRightChild());
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
		if (n == 0) {
			return 0;
		}
		while (true) {
			int size = queue.size();
			level++;
			while (size > 0) {
				size--;
				int pop = queue.remove();
				if (pop + level == n || pop - level == n) {
					return level;
				}
				queue.add(pop + level);
				queue.add(pop - level);
			}
		}
	}

	/**
	 * http://www.geeksforgeeks.org/evaluation-of-expression-tree/
	 * 
	 * refer package com.kumanoit.generics.trees.Problems;
	 */

	/**
	 * http://www.geeksforgeeks.org/print-extreme-nodes-of-each-level-of-binary-tree-in-alternate-order/
	 */
	public static void printExtremeNodesInBinaryTree(Tree root) {
		Stack<Tree> stackLR = new Stack<Tree>();
		Stack<Tree> stackRL = new Stack<Tree>();
		stackLR.push(root);
		while (!(stackLR.isEmpty() && stackRL.isEmpty())) {
			if (!stackLR.isEmpty()) {
				Tree temp = stackLR.peek();
				System.out.print(temp.getData() + "\t");
				do {
					temp = stackLR.pop();
					if (temp.getRightChild() != null) {
						stackRL.push(temp.getRightChild());
					}
					if (temp.getLeftChild() != null) {
						stackRL.push(temp.getLeftChild());
					}
				} while (!stackLR.isEmpty());
			}
			if (!stackRL.isEmpty()) {
				Tree temp = stackRL.peek();
				System.out.print(temp.getData() + "\t");
				do {
					temp = stackRL.pop();
					if (temp.getLeftChild() != null) {
						stackLR.push(temp.getLeftChild());
					}
					if (temp.getRightChild() != null) {
						stackLR.push(temp.getRightChild());
					}
				} while (!stackRL.isEmpty());
			}
		}
		System.out.println();
	}

	/**
	 * http://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree/
	 */
	public static void printAllSiblings(Tree root, int node) {
		int level = getLevelOfNode(root, node, 0);
		if (level == 0) {
			System.out.println("Node is root. No sibling present.");
			return;
		}
		printSiblings(root, node, 0, level);
		System.out.println();
	}

	private static int getLevelOfNode(Tree root, int node, int level) {
		if (root == null) {
			return -1;
		}
		if (root.getData() == node) {
			return level;
		}
		int leftLevel = getLevelOfNode(root.getLeftChild(), node, level + 1);
		if (leftLevel != -1) {
			return leftLevel;
		}
		int rightLevel = getLevelOfNode(root.getRightChild(), node, level + 1);
		if (rightLevel != -1) {
			return rightLevel;
		}
		return -1;
	}

	private static void printSiblings(Tree root, int node, int level, int nodeLevel) {
		if (root == null) {
			return;
		}
		if (level + 1 == nodeLevel) {
			Tree lc = root.getLeftChild();
			Tree rc = root.getRightChild();
			if (lc != null && lc.getData() == node || rc != null && rc.getData() == node) {
				return;
			}
			System.out.print((lc != null ? lc.getData() + ", " : ""));
			System.out.print((rc != null ? rc.getData() + ", " : ""));
		} else {
			printSiblings(root.getLeftChild(), node, level + 1, nodeLevel);
			printSiblings(root.getRightChild(), node, level + 1, nodeLevel);
		}
	}

	/**
	 * http://www.geeksforgeeks.org/iterative-function-check-two-trees-identical/
	 */
	public static boolean areTreesIdenticalIterative(Tree root1, Tree root2) {
		Tree ptr1 = root1;
		Tree ptr2 = root2;
		Stack<Tree> stack1 = new Stack<Tree>();
		Stack<Tree> stack2 = new Stack<Tree>();
		boolean traverse1 = true;
		boolean traverse2 = true;
		boolean empty1 = false;
		boolean empty2 = false;
		int value1 = 0;
		int value2 = 1;
		while (true) {
			while (traverse1) {
				if (ptr1 != null) {
					stack1.push(ptr1);
					ptr1 = ptr1.getLeftChild();
				} else if (stack1.isEmpty()) {
					empty1 = true;
					break;
				} else {
					ptr1 = stack1.pop();
					value1 = ptr1.getData();
					ptr1 = ptr1.getRightChild();
					traverse1 = false;
				}
			}
			while (traverse2) {
				if (ptr2 != null) {
					stack2.push(ptr2);
					ptr2 = ptr2.getLeftChild();
				} else if (stack2.isEmpty()) {
					empty2 = true;
					break;
				} else {
					ptr2 = stack2.pop();
					value2 = ptr2.getData();
					ptr2 = ptr2.getRightChild();
					traverse2 = false;
				}
			}
			if (value1 != value2) {
				return false;
			}
			if (empty1 && empty2) {
				return true;
			}
			traverse1 = true;
			traverse2 = true;
		}
	}

	/**
	 * http://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
	 */
	public static boolean areTreesMirror(Tree root) {
		return areTreesMirror(root.getLeftChild(), root.getRightChild());
	}

	private static boolean areTreesMirror(Tree root1, Tree root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.getData() != root2.getData()) {
			return false;
		}
		return areTreesMirror(root1.getLeftChild(), root2.getRightChild())
				&& areTreesMirror(root1.getRightChild(), root2.getLeftChild());
	}

	/**
	 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
	 */
	public static Tree constructTreeFromInorderPostorder(int[] inorder, int[] postorder) {
		return constructTreeFromInorderPostorder(inorder, postorder, 0, 0, inorder.length);
	}
	private static Tree constructTreeFromInorderPostorder(int[] inorder, int[] postorder, int inIndex, int postIndex,
			int size) {
		if (size == 0) {
			return null;
		}
		Tree root = new Tree(postorder[postIndex + size - 1]);
		int index = inIndex;
		while (inorder[index] != postorder[postIndex + size - 1]) {
			index++;
		}
		root.setLeftChild(constructTreeFromInorderPostorder(inorder, postorder, inIndex, postIndex, index - inIndex));
		root.setRightChild(constructTreeFromInorderPostorder(inorder, postorder, index + 1, postIndex + (index - inIndex),
				size - (index - inIndex) - 1));
		return root;
	}
}
