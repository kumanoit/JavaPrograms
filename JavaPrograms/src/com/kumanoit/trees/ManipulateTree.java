package com.kumanoit.trees;

import com.kumanoit.trees.utils.Tree;

public class ManipulateTree {

	// convert a tree to its mirror form
	// http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
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

	// convert a binary tree to children sum property tree
	public static int convertToCSP(Tree root) {
		if (root == null) {
			return 0;
		}
		if (root.isLeaf()) {
			return root.getData();
		}
		int leftValue = convertToCSP(root.getLeftChild());
		int rightValue = convertToCSP(root.getRightChild());
		int sum = leftValue + rightValue;
		if (root.getData() <= sum) {
			root.setData(sum);
		} else {
			int diff = root.getData() - sum;
			convertToCSP(root, diff);
		}
		return root.getData();
	}

	private static void convertToCSP(Tree root, int diff) {
		if (root.getLeftChild() != null) {
			Tree leftChild = root.getLeftChild();
			leftChild.setData(leftChild.getData() + diff);
			convertToCSP(leftChild, diff);
		} else if (root.getRightChild() != null) {
			Tree rightChild = root.getRightChild();
			rightChild.setData(rightChild.getData() + diff);
			convertToCSP(rightChild, diff);
		}
	}

	public static void convertTreeToDoubleTree(Tree root) {
		if (root == null) {
			return;
		}
		convertTreeToDoubleTree(root.getLeftChild());
		convertTreeToDoubleTree(root.getRightChild());
		Tree newNode = new Tree(root.getData());
		newNode.setLeftChild(root.getLeftChild());
		root.setLeftChild(newNode);
	}

	// http://www.geeksforgeeks.org/swap-nodes-binary-tree-every-kth-level/
	public static void swapNodesEveryKLevel(Tree root, int k) {
		swapNodesEveryKLevel(root, k, 1);
	}

	private static void swapNodesEveryKLevel(Tree root, int k, int level) {
		if (root == null) {
			return;
		}
		if ((level + 1) % k == 0) {
			Tree temp = root.getLeftChild();
			root.setLeftChild(root.getRightChild());
			root.setRightChild(temp);
		}
		swapNodesEveryKLevel(root.getLeftChild(), k, level + 1);
		swapNodesEveryKLevel(root.getRightChild(), k, level + 1);
	}

	// http://www.geeksforgeeks.org/flip-binary-tree/
	public static Tree flipTree(Tree root) {
		if (root == null) {
			return null;
		}
		Tree leftmostNode = root;
		Tree parLeftmost = null;
		Tree parparLeftmost = null;
		while (leftmostNode.getLeftChild() != null) {
			parparLeftmost = parLeftmost;
			parLeftmost = leftmostNode;
			leftmostNode = leftmostNode.getLeftChild();
		}
		leftmostNode.setLeftChild(parLeftmost.getRightChild());
		leftmostNode.setRightChild(parLeftmost);

		parLeftmost.setLeftChild(parparLeftmost.getRightChild());
		parLeftmost.setRightChild(parparLeftmost);

		parparLeftmost.setLeftChild(null);
		parparLeftmost.setRightChild(null);
		return leftmostNode;
	}

	// http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
	private static Tree lastNode = null;

	public static Tree convertTreeToDoublyLinkedList(Tree root) {
		lastNode = null;
		convertToDoublyLinkedList(root);
		while (root.getLeftChild() != null) {
			root = root.getLeftChild();
		}
		return root;
	}

	private static void convertToDoublyLinkedList(Tree root) {
		if (root == null) {
			return;
		}
		convertToDoublyLinkedList(root.getLeftChild());
		if (lastNode != null) {
			lastNode.setRightChild(root);
		}
		root.setLeftChild(lastNode);
		lastNode = root;
		convertToDoublyLinkedList(root.getRightChild());
	}

	public static Tree convertTreeToDoublyLinkedList2(Tree root) {
		convertToDoublyLinkedList2(root);
		while (root.getLeftChild() != null) {
			root = root.getLeftChild();
		}
		return root;
	}

	private static Tree convertToDoublyLinkedList2(Tree root) {
		if (root == null) {
			return null;
		}
		if (root.getLeftChild() != null) {
			Tree inpred = convertToDoublyLinkedList2(root.getLeftChild());
			while (inpred.getRightChild() != null) {
				inpred = inpred.getRightChild();
			}
			inpred.setRightChild(root);
			root.setLeftChild(inpred);
		}
		if (root.getRightChild() != null) {
			Tree insucc = convertToDoublyLinkedList2(root.getRightChild());
			while (insucc.getLeftChild() != null) {
				insucc = insucc.getLeftChild();
			}
			insucc.setLeftChild(root);
			root.setRightChild(insucc);
		}
		return root;
	}

}
