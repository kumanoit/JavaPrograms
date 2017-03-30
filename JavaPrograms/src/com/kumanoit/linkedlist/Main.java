package com.kumanoit.linkedlist;

public class Main {

	private static LinkList list1 = MyListUtils.createLinkedList(ListConstants.list1);
	private static LinkList list2 = MyListUtils.createLinkedList(ListConstants.list2);
	private static LinkList listOdd = MyListUtils.createLinkedList(ListConstants.listOdd);
	private static LinkList listEven = MyListUtils.createLinkedList(ListConstants.listEven);

	private static void testNthNode() {
		list1.display();
		for (int i = 1; i <= ListConstants.list1.length; i++) {
			System.out
					.println("The " + i + " node from beginning is = " + Solution.getNthNodeFromBeginning(list1, i).getData());
		}
	}

	private static void testMiddleOfLinkedList() {
		list1.display();
		System.out.println("Middle of list is = " + Solution.getMiddleOfList(list1).getData());
		listOdd.display();
		System.out.println("Middle of list is = " + Solution.getMiddleOfList(listOdd).getData());
	}

	private static void testOccurrenceCount() {
		list2.display();
		for (int i = 0; i < ListConstants.list2.length; i++) {
			System.out
					.println(ListConstants.list2[i] + " occurs = " + Solution.getOccurrenceCount(list2, ListConstants.list2[i]));
		}
	}

	public static void testPairwiseSwap() {
		listOdd.display();
		Solution.pairwiseSwap(listOdd).display();
	}

	public static void testMoveLastNodeToFront() {
		listOdd.display();
		Solution.moveLastElementToFront(listOdd).display();
	}

	public static void testRemoveDuplicatesFromSortedLinkedList() {
		int[] array = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6 };
		LinkList start = MyListUtils.createLinkedList(array);
		start.display();
		Solution.removeDuplicatesFromSortedLinkedList(start);
		start.display();
	}

	public static void testDisplayReverseRecursively() {
		list1.display();
		Solution.displayReverseRecursively(list1);
	}

	public static void main(String[] args) {
		// System.out.println(list1.toString());
		// System.out.println(reverseListInGroup(list1, 5).toString());
//		System.out.println(reverseInPair(listOdd).toString());
		// testDisplayReverseRecursively();
		System.out.println(isLinkedListPalindrome(listOdd, listOdd));
	}

	public static LinkList reverse(LinkList start) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}
		LinkList temp = reverse(start.getNextNode());
		start.getNextNode().setNextNode(start);
		start.setNextNode(null);
		return temp;
	}

	public static LinkList reverseListInGroup(LinkList start, int k) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}
		int temp = k;
		LinkList ptr = start;
		while (--temp > 0 && ptr.getNextNode() != null) {
			ptr = ptr.getNextNode();
		}
		LinkList nextStart = ptr.getNextNode();
		ptr.setNextNode(null);
		LinkList newStart = reverse(start);
		start.setNextNode(reverseListInGroup(nextStart, k));
		return newStart;
	}

	public static LinkList reverseInPair(LinkList start) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}
		LinkList nextStart = start.getNextNode().getNextNode();
		LinkList nextNode = start.getNextNode();
		nextNode.setNextNode(start);
		start.setNextNode(reverseInPair(nextStart));
		return nextNode;
	}

	public static boolean isLinkedListPalindrome(LinkList start, LinkList p) {
		if (start == null) {
			return true;
		}
		if (isLinkedListPalindrome(start.getNextNode(), p) || start.getData() == p.getData()) {
			p = p.getNextNode();
			return true;
		}
		return false;
	}
}
