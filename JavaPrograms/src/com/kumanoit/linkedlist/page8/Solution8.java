package com.kumanoit.linkedlist.page8;

import com.kumanoit.linkedlist.LinkList;

public class Solution8 {

	// 1.
	// http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
	public static LinkList insertNodeInSortedLinkedList(LinkList start, int value) {
		LinkList newNode = new LinkList(value);
		if (start == null) {
			return newNode;
		}
		if (start.getData() > value) {
			newNode.setNextNode(start);
			return newNode;
		}
		LinkList ptr = start;
		while (ptr.getNextNode() != null && ptr.getNextNode().getData() < value) {
			ptr = ptr.getNextNode();
		}
		if (ptr.getNextNode() == null) {
			ptr.setNextNode(newNode);
		} else {
			newNode.setNextNode(ptr.getNextNode());
			ptr.setNextNode(newNode);
		}
		return start;
	}
}
