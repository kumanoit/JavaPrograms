package com.kumanoit.trees.binarySearchTree;

import com.kumanoit.linkedlist.LinkList;
import com.kumanoit.linkedlist.MyListUtils;
import com.kumanoit.trees.utils.Tree;

public class CreateBalancedBinaryTreeFromLinkedList {

	public static void main(String[] args) {
		LinkList linkList = MyListUtils.createLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7 });

		linkList.display();
		start = linkList;
		createTree(7).display();
	}

	private static LinkList start;

	public static Tree createTree(int n) {
		if (n <= 0) {
			return null;
		}
		Tree leftChild = createTree(n / 2);
		Tree root = new Tree(start.getData());
		start = start.getNextNode();
		Tree rightChild = createTree(n - n / 2 - 1);
		root.setLeftChild(leftChild);
		root.setRightChild(rightChild);
		return root;
	}
}
