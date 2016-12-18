package com.kumanoit.crackingTheCodingInterview.linkedList;

import com.kumanoit.linkedlist.ListConstants;
import com.kumanoit.linkedlist.MyList;
import com.kumanoit.linkedlist.MyListUtils;

public class LinkedListTest {

	private static MyList list1 = MyListUtils.createLinkedList(ListConstants.list1);
	private static MyList list2 = MyListUtils.createLinkedList(ListConstants.list2);
	private static MyList listOdd = MyListUtils.createLinkedList(ListConstants.listOdd);
	private static MyList listEven = MyListUtils.createLinkedList(ListConstants.listEven);

	public static void testKthElementFromLast() {
		try {
			for (int i = 1; i <= ListConstants.list1.length; i++) {
				System.out.println(LinkedListSolution.getKthLastElement(list1, i).getData());
			}
			System.out.println(LinkedListSolution.getKthLastElement(list1, 17).getData());
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public static void testDeleteAnyMiddleNode() {
		MyList ptr = list1;
		int count = 5;
		list1.display();
		while (--count > 0) {
			ptr = ptr.getNextNode();
		}
		System.out.println("Deleting node = " + ptr.getData());
		LinkedListSolution.deleteANodeFromMiddle(ptr);
		list1.display();
	}

	public static void testPartitionListAroundK() {
		list2.display();
		LinkedListSolution.partitionListAroundK(list2, 6);
	}

	public static void testAddTwoNumbers() {
		int[] num1 = { 1, 2, 3 };
		int[] num2 = {};
		MyList first = MyListUtils.createLinkedList(num1);
		MyList second = MyListUtils.createLinkedList(num2);
		first.display();
		second.display();
		System.out.println("Summing by recursion");
		LinkedListSolution.addTwoNumbersRecursive(first, second).display();
		first.display();
		second.display();
		System.out.println("Summing by iteration");
		LinkedListSolution.addTwoNumbersIterative(first, second).display();
	}

	public static void testIfLinkedListIsPalindrom() {
		int[] palindrome = { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
		MyList palinLinkedList = MyListUtils.createLinkedList(palindrome);
		System.out.println(LinkedListSolution.isLinkedListPalindrom(list1));
		System.out.println(LinkedListSolution.isLinkedListPalindrom(palinLinkedList));
	}

	public static void testCircularLoop() {
		MyList ptr = list1;
		MyList last = list1;
		int count = 6;
		while (last.getNextNode() != null) {
			last = last.getNextNode();
		}
		while (--count > 0) {
			ptr = ptr.getNextNode();
		}
		last.setNextNode(ptr);
		list1.display();
		MyList loopStartsAt = LinkedListSolution.findStartOfLoop(list1);
		if (loopStartsAt == null) {
			System.out.println("No intersection point in loop");
		} else {
			System.out.println("Loop starts at = " + loopStartsAt.getData());
		}
	}

	public static void testRemoveDuplicateNode() {
		list2.display();
		LinkedListSolution.removeDuplicates(list2);
		list2.display();
	}

	public static void testIfTwoListIntersects() {
		int count = 6;
		MyList ptr = listOdd;
		while (--count > 0) {
			ptr = ptr.getNextNode();
		}
		MyList lastNode = listEven.getLastNode();
		lastNode.setNextNode(ptr);
		listOdd.display();
		listEven.display();
		MyList intersectionPoint = LinkedListSolution.getIntersectionOfTwoLinkedList(listOdd, listEven);
		if (intersectionPoint != null) {
			System.out.println("Intersection point is = " + intersectionPoint.getData());
		} else {
			System.out.println("No intersection point.");
		}
		System.out.println("Intersection point in O(n) : "
				+ LinkedListSolution.getIntersectionOfTwoLinkedList2(listOdd, listEven).getData());
	}

	public static void main(String[] args) {
		testIfTwoListIntersects();
	}
}
