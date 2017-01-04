/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import com.kumanoit.trees.utils.Tree;

import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	public static void printPreOrder(Tree root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getData() + "\t");
		printPreOrder(root.getLeftChild());
		printPreOrder(root.getRightChild());
	}

	public static void printInorder(Tree root) {
		if (root == null) {
			return;
		}
		printInorder(root.getLeftChild());
		System.out.print(root.getData() + "\t");
		printInorder(root.getRightChild());
	}

	public static void printPostOrder(Tree root) {
		if (root == null) {
			return;
		}
		printPostOrder(root.getLeftChild());
		printPostOrder(root.getRightChild());
		System.out.print(root.getData() + "\t");
	}

	public static void printLevelOrder(Tree root) {
		if (root == null) {
			return;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			root = queue.remove();
			System.out.print(root.getData() + "\t");
			if (root.getLeftChild() != null) {
				queue.add(root.getLeftChild());
			}
			if (root.getRightChild() != null) {
				queue.add(root.getRightChild());
			}
		}
	}

	public static void printVerticalOrder(Tree root) {
		HashMap<Integer, List<Tree>> map = new HashMap<Integer, List<Tree>>();
		printVerticalOrder(root, map, 0);
		for (Entry<Integer, List<Tree>> entry : map.entrySet()) {
			System.out.println("\nNodes at column : " + entry.getKey());
			entry.getValue().forEach(item -> System.out.print(item.getData() + ", "));
		}
	}

	public static void printVerticalOrder(Tree root, HashMap<Integer, List<Tree>> map, int level) {
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
		printVerticalOrder(root.getLeftChild(), map, level - 1);
		printVerticalOrder(root.getRightChild(), map, level + 1);
	}

	public static void printVerticalOrderLevelOrder(Tree root) {
		Queue<Tree> queue = new LinkedList<Tree>();
		HashMap<Integer, List<Tree>> map = new HashMap<Integer, List<Tree>>();
		queue.add(root);
		queue.add(new Tree(0));
		int minIndex = Integer.MAX_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			Tree ptr = queue.remove();
			int index = queue.remove().getData();
			minIndex = minIndex > index ? index : minIndex;
			maxIndex = maxIndex < index ? index : maxIndex;
			if (map.keySet().contains(index)) {
				map.get(index).add(ptr);
			} else {
				List<Tree> list = new ArrayList<Tree>();
				list.add(ptr);
				map.put(index, list);
			}
			if (ptr.getLeftChild() != null) {
				queue.add(ptr.getLeftChild());
				queue.add(new Tree(index - 1));
			}
			if (ptr.getRightChild() != null) {
				queue.add(ptr.getRightChild());
				queue.add(new Tree(index + 1));
			}
		}
		for (int index = minIndex; index <= maxIndex; index++) {
			System.out.println("\nIndex = " + index);
			map.get(index).forEach(item -> System.out.print(item.getData() + "\t"));
		}
	}

	public static void displayTree(Tree root) {
		System.out.print("\nDisplaying tree");
		System.out.print("\nPreorder   :   ");
		printPreOrder(root);
		System.out.print("\nPostorder  :   ");
		printPostOrder(root);
		System.out.print("\nInorder    :   ");
		printInorder(root);
		System.out.print("\nLevelorder :   ");
		printLevelOrder(root);
	}

	public static void printPreorderWithoutRecursion(Tree root) {
		if (root == null) {
			return;
		}
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Tree ptr = stack.pop();
			System.out.print(ptr.getData() + "\t");
			if (ptr.getRightChild() != null) {
				stack.push(ptr.getRightChild());
			}
			if (ptr.getLeftChild() != null) {
				stack.push(ptr.getLeftChild());
			}
		}
	}

	public static void printInorderWithoutRecursion(Tree root) {
		if (root == null) {
			return;
		}

		Stack<Tree> stack = new Stack<Tree>();
		Tree ptr = root;
		while (true) {
			while (ptr.getLeftChild() != null) {
				stack.push(ptr);
				ptr = ptr.getLeftChild();
			}

			while (ptr.getRightChild() == null) {
				System.out.print(ptr.getData() + "\t");
				if (stack.isEmpty()) {
					return;
				}
				ptr = stack.pop();
			}
			System.out.print(ptr.getData() + "\t");
			ptr = ptr.getRightChild();
		}
	}

	public static void printPostorderWithoutRecursion(Tree root) {
		if (root == null) {
			return;
		}
		Stack<Tree> stack = new Stack<Tree>();
		Tree ptr = root;
		Tree temp = null;
		while (true) {
			while (ptr.getLeftChild() != null) {
				stack.push(ptr);
				ptr = ptr.getLeftChild();
			}

			while (ptr.getRightChild() == null || ptr.getRightChild() == temp) {
				System.out.print(ptr.getData() + "\t");
				temp = ptr;
				if (stack.isEmpty()) {
					return;
				}
				ptr = stack.pop();
			}
			stack.push(ptr);
			ptr = ptr.getRightChild();
		}
	}

	public static void displayTreeNonRecursion(Tree root) {
		System.out.print("\nDisplaying tree");
		System.out.print("\nPreorder   :   ");
		printPreorderWithoutRecursion(root);
		System.out.print("\nPostorder  :   ");
		printPostorderWithoutRecursion(root);
		System.out.print("\nInorder    :   ");
		printInorderWithoutRecursion(root);
		System.out.print("\nLevelorder :   ");
		printLevelOrder(root);
	}

	public static void printMorrisPreorder(Tree root) {
		if (root == null) {
			return;
		}
		System.out.println();
		Tree ptr = root;
		while (ptr != null) {
			System.out.print(ptr.getData() + "\t");
			if (ptr.getLeftChild() == null) {
				ptr = ptr.getRightChild();
			} else {
				Tree temp = ptr.getLeftChild();
				while (temp.getRightChild() != null) {
					temp = temp.getRightChild();
				}
				temp.setRightChild(ptr.getRightChild());
				ptr = ptr.getLeftChild();
			}
		}
	}

	public static void printMorrisInorder(Tree root) {
		if (root == null) {
			return;
		}
		System.out.println();
		Tree ptr = root;
		while (ptr != null) {
			if (ptr.getLeftChild() == null) {
				System.out.print(ptr.getData() + "\t");
				ptr = ptr.getRightChild();
			} else {
				Tree temp = ptr.getLeftChild();
				while (temp.getRightChild() != null) {
					temp = temp.getRightChild();
				}
				temp.setRightChild(ptr);
				temp = ptr.getLeftChild();
				ptr.setLeftChild(null);
				ptr = temp;
			}
		}
	}

	public static void printSpiralTree(Tree root) {
		if (root == null) {
			return;
		}
		Stack<Tree> stackRL = new Stack<Tree>();
		Stack<Tree> stackLR = new Stack<Tree>();
		stackRL.push(root);
		while (!stackRL.isEmpty() || !stackLR.isEmpty()) {
			while (!stackRL.isEmpty()) {
				Tree ptr = stackRL.pop();
				System.out.print(ptr.getData() + "\t");
				if (ptr.getRightChild() != null) {
					stackLR.push(ptr.getRightChild());
				}
				if (ptr.getLeftChild() != null) {
					stackLR.push(ptr.getLeftChild());
				}
			}
			while (!stackLR.isEmpty()) {
				Tree ptr = stackLR.pop();
				System.out.print(ptr.getData() + "\t");
				if (ptr.getLeftChild() != null) {
					stackRL.push(ptr.getLeftChild());
				}
				if (ptr.getRightChild() != null) {
					stackRL.push(ptr.getRightChild());
				}
			}
		}
	}

}
