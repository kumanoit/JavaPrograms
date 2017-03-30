package com.kumanoit.linkedlist.page9;

import com.kumanoit.linkedlist.LinkList;

public class Solution9 {

	// 1.
	// http://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
	public static void printMiddle(LinkList start) {
		LinkList slow = start;
		LinkList fast = start;
		while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode().getNextNode();
		}
		System.out.println("Middle node = " + slow.getData());
	}

	// 3.
	// http://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
	public static LinkList getNthNode(LinkList start, int n) {
		if (start == null) {
			return null;
		}
		LinkList ptr = start;
		while (--n > 0 && ptr != null) {
			ptr = ptr.getNextNode();
		}
		if (ptr == null) {
			throw new NullPointerException("Not enough node in linked list.");
		}
		return ptr;
	}

}
