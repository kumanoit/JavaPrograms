package com.kumanoit.linkedlist;

public class Main {

	private static MyList list1 = MyListUtils.createLinkedList(ListConstants.list1);
	private static MyList list2 = MyListUtils.createLinkedList(ListConstants.list2);
	private static MyList listOdd = MyListUtils.createLinkedList(ListConstants.listOdd);
	private static MyList listEven = MyListUtils.createLinkedList(ListConstants.listEven);

	private static void testNthNode() {
		list1.display();
		for (int i = 1; i <= ListConstants.list1.length; i++) {
			System.out.println("The " + i + " node from beginning is = " + Solution.getNthNodeFromBeginning(list1, i).getData());
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
			System.out.println(ListConstants.list2[i] + " occurs = " + Solution.getOccurrenceCount(list2, ListConstants.list2[i]));
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
		int[] array = {1,1,1,1,1,2,2,2,2,2,3,3,3,4,4,4,4,4,5,5,6,6,6,6,6};
		MyList start = MyListUtils.createLinkedList(array);
		start.display();
		Solution.removeDuplicatesFromSortedLinkedList(start);
		start.display();
	}

	public static void testDisplayReverseRecursively() {
		list1.display();
		Solution.displayReverseRecursively(list1);
	}

	public static void main(String[] args) {
		testDisplayReverseRecursively();
	}
}
