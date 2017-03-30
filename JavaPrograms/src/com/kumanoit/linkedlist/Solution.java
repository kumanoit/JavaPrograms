package com.kumanoit.linkedlist;

public class Solution {

	/**
	 * http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
	 */
	public static LinkList reverse(LinkList start) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}
		LinkList temp = reverse(start.getNextNode());
		start.getNextNode().setNextNode(start);
		start.setNextNode(null);
		return temp;
	}

	/**
	 * reverse linked list in groups
	 */
	public static LinkList reverseInGroupOfK(LinkList start, int k) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}

		LinkList ptr = start;
		int temp = k;
		while (--temp != 0 && ptr.getNextNode() != null) {
			ptr = ptr.getNextNode();
		}

		LinkList nextStart = ptr.getNextNode();
		ptr.setNextNode(null);
		LinkList newStart = reverse(start);
		start.setNextNode(reverseInGroupOfK(nextStart, k));
		return newStart;
	}

	/**
	 * http://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
	 */
	public static LinkList getNthNodeFromBeginning(LinkList start, int n) {
		if (start == null) {
			return start;
		}
		LinkList ptr = start;
		while (--n > 0) {
			ptr = ptr.getNextNode();
		}
		return ptr;
	}

	/**
	 * http://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
	 */
	public static LinkList getMiddleOfList(LinkList start) {
		LinkList slow = start;
		LinkList fast = start;
		while (fast != null && fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode().getNextNode();
		}
		return slow;
	}

	/**
	 * http://www.geeksforgeeks.org/write-a-function-that-counts-the-number-of-times-a-given-int-occurs-in-a-linked-list/
	 */
	public static int getOccurrenceCount(LinkList start, int data) {
		int count = 0;
		LinkList ptr = start;
		while (ptr != null) {
			if (ptr.getData() == data) {
				count++;
			}
			ptr = ptr.getNextNode();
		}
		return count;
	}

	/**
	 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
	 */
	public static LinkList pairwiseSwap(LinkList start) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}
		LinkList nextNode = start.getNextNode();
		start.setNextNode(pairwiseSwap(nextNode.getNextNode()));
		nextNode.setNextNode(start);
		return nextNode;
	}

	/**
	 * http://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
	 */
	public static LinkList moveLastElementToFront(LinkList start) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}
		LinkList ptr = start;
		while (ptr.getNextNode().getNextNode() != null) {
			ptr = ptr.getNextNode();
		}
		ptr.getNextNode().setNextNode(start);
		start = ptr.getNextNode();
		ptr.setNextNode(null);
		return start;
	}

	/**
	 * http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
	 */
	public static void removeDuplicatesFromSortedLinkedList(LinkList start) {
		if (start == null && start.getNextNode() == null) {
			return;
		}
		LinkList ptr = start;
		while (ptr != null) {
			LinkList nextNode = ptr.getNextNode();
			while (nextNode != null && nextNode.getData() == ptr.getData()) {
				nextNode = nextNode.getNextNode();
			}
			ptr.setNextNode(nextNode);
			ptr = nextNode;
		}
	}

	/**
	 * http://www.geeksforgeeks.org/write-a-recursive-function-to-print-reverse-of-a-linked-list/
	 */
	public static void displayReverseRecursively(LinkList start) {
		if (start == null) {
			return;
		}
		displayReverseRecursively(start.getNextNode());
		System.out.print(start.getData() + "\t");
	}
	
}
