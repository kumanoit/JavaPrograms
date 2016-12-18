package com.kumanoit.crackingTheCodingInterview.linkedList;

import com.kumanoit.linkedlist.MyList;

public class LinkedListSolution {
	/**
	 * 2.1 Remove Dups! Write code to remove duplicates from an unsorted linked
	 * list. FOLLOW UP How would you solve this problem if a temporary buffer is
	 * not allowed?
	 */
	public static void removeDuplicates(MyList start) {
		if (start == null || start.getNextNode() == null) {
			return ;
		}
		for (MyList p = start; p.getNextNode() != null; p = p.getNextNode()) {
			for (MyList q = p; q.getNextNode() != null;) {
				MyList nextNode = q.getNextNode();
				if (nextNode.getData() == p.getData()) {
					q.setNextNode(nextNode.getNextNode());
					nextNode = null;
				} else {
					q = q.getNextNode();
				}
			}
			if (p.getNextNode() == null) {
				break;
			}
		}
	}

	/**
	 * 2.2 Return Kth to Last: Implement an algorithm to find the kth to last
	 * element of a singly linked list.
	 */
	public static MyList getKthLastElement(MyList start, int k) throws NullPointerException {
		if (start == null) {
			return start;
		}
		MyList slow = start;
		MyList fast = start;
		while (--k > 0 && fast != null) {
			fast = fast.getNextNode();
		}
		if (fast == null) {
			throw new NullPointerException("Not enough element in linked list.");
		}
		while (fast.getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode();
		}
		return slow;
	}

	/**
	 * 2.3 Delete Middle Node: Implement an algorithm to delete a node in the
	 * middle (i.e., any node but the first and last node, not necessarily the
	 * exact middle) of a singly linked list, given only access to that node.
	 * EXAMPLE lnput:the node c from the linked list a->b->c->d->e->f Result:
	 * nothing is returned, but the new linked list looks like a->b->d->e- >f
	 */
	public static void deleteANodeFromMiddle(MyList nodeToBeDeleted) {
		if (nodeToBeDeleted == null || nodeToBeDeleted.getNextNode() == null) {
			return;
		}
		MyList nextNode = nodeToBeDeleted.getNextNode();
		nodeToBeDeleted.setData(nextNode.getData());
		nodeToBeDeleted.setNextNode(nextNode.getNextNode());
		nextNode = null;
	}

	/**
	 * 2.4 Partition: Write code to partition a linked list around a value x, such
	 * that all nodes less than x come before all nodes greater than or equal to
	 * x. If x is contained within the list, the values of x only need to be after
	 * the elements less than x (see below). The partition element x can appear
	 * anywhere in the "right partition"; it does not need to appear between the
	 * left and right partitions. EXAMPLE Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
	 * [partition= 5] Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
	 */
	public static void partitionListAroundK(MyList start, int k) {
		if (start == null || start.getNextNode() == null) {
			return;
		}
		MyList start1 = null;
		MyList p1 = null;
		MyList start2 = null;
		MyList p2 = null;
		MyList ptr = start;
		while (ptr != null) {
			if (ptr.getData() < k) {
				if (start1 == null) {
					start1 = new MyList(ptr.getData());
					p1 = start1;
				} else {
					p1.setNextNode(new MyList(ptr.getData()));
					p1 = p1.getNextNode();
				}
			} else {
				if (start2 == null) {
					start2 = new MyList(ptr.getData());
					p2 = start2;
				} else {
					p2.setNextNode(new MyList(ptr.getData()));
					p2 = p2.getNextNode();
				}
			}
			ptr = ptr.getNextNode();
		}
		System.out.println("After partition");
		start1.display();
		start2.display();
	}

	/**
	 * 2.5 Sum Lists: You have two numbers represented by a linked list, where
	 * each node contains a single digit. The digits are stored in reverse order,
	 * such that the 1 's digit is at the head of the list. Write a function that
	 * adds the two numbers and returns the sum as a linked list. EXAMPLE Input:
	 * (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output: 2 -> 1 -> 9. That
	 * is, 912. FOLLOW UP Suppose the digits are stored in forward order. Repeat
	 * the above problem. EXAMPLE lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617
	 * + 295. Output: 9 - > 1 -> 2. That is, 912.
	 */
	public static MyList addTwoNumbersRecursive(MyList start1, MyList start2) {
		return addTwoNumbersRecursive(start1, start2, 0);
	}

	public static MyList addTwoNumbersRecursive(MyList start1, MyList start2, int carry) {
		if (start1 == null && start2 == null) {
			return carry > 0 ? (new MyList(carry)) : null;
		}
		int value1 = start1 == null ? 0 : start1.getData();
		int value2 = start2 == null ? 0 : start2.getData();
		int sum = value1 + value2 + carry;
		carry = sum / 10;
		sum %= 10;
		MyList newNode = new MyList(sum);
		if (start1 != null && start2 != null) {
			newNode.setNextNode(addTwoNumbersRecursive(start1.getNextNode(), start2.getNextNode(), carry));
		} else if (start1 == null) {
			newNode.setNextNode(addTwoNumbersRecursive(start1, start2.getNextNode(), carry));
		} else {
			newNode.setNextNode(addTwoNumbersRecursive(start1.getNextNode(), start2, carry));
		}
		return newNode;
	}

	public static MyList addTwoNumbersIterative(MyList start1, MyList start2) {
		if (start1 == null && start2 == null) {
			return null;
		}
		MyList sumList = null;
		MyList ptr = null;
		MyList ptr1 = start1;
		MyList ptr2 = start2;
		int carry = 0;
		int sum = 0;
		while (ptr1 != null && ptr2 != null) {
			sum = ptr1.getData() + ptr2.getData() + carry;
			carry = sum / 10;
			sum %= 10;
			if (sumList == null) {
				sumList = new MyList(sum);
				ptr = sumList;
			} else {
				ptr.setNextNode(new MyList(sum));
				ptr = ptr.getNextNode();
			}
			ptr1 = ptr1.getNextNode();
			ptr2 = ptr2.getNextNode();
		}
		while (ptr1 != null) {
			sum = ptr1.getData() + carry;
			carry = sum / 10;
			sum %= 10;
			if (sumList == null) {
				sumList = new MyList(sum);
				ptr = sumList;
			} else {
				ptr.setNextNode(new MyList(sum));
				ptr = ptr.getNextNode();
			}
			ptr1 = ptr1.getNextNode();
		}
		while (ptr2 != null) {
			sum = ptr2.getData() + carry;
			carry = sum / 10;
			sum %= 10;
			if (sumList == null) {
				sumList = new MyList(sum);
				ptr = sumList;
			} else {
				ptr.setNextNode(new MyList(sum));
				ptr = ptr.getNextNode();
			}
			ptr2 = ptr2.getNextNode();
		}
		if (carry > 0) {
			ptr.setNextNode(new MyList(carry));
		}
		return sumList;
	}

	/**
	 * 2.6 Palindrome: Implement a function to check if a linked list is a
	 * palindrome.
	 */
	static MyList last;
	
	public static boolean isLinkedListPalindrom(MyList start) {
		last = start;
		return isLinkedListPalindrome(start);
	}
	
	private static boolean isLinkedListPalindrome(MyList start) {
		if (start == null) {
			return true;
		}
		if (isLinkedListPalindrome(start.getNextNode()) && start.getData() == last.getData()) {
			last = last.getNextNode();
			return true;
		}
		return false;
	}
	/**
	 * 2.7 Intersection: Given two (singly) linked lists, determine if the two
	 * lists intersect. Return the intersecting node. Note that the intersection
	 * is defined based on reference, not value. That is, if the kth node of the
	 * first linked list is the exact same node (by reference) as the jth node of
	 * the second linked list, then they are intersecting.
	 */
	/**
	 * O(n^2) solution
	 */
	public static MyList getIntersectionOfTwoLinkedList(MyList start1, MyList start2) {
		for (MyList p = start1; p != null; p = p.getNextNode()) {
			for (MyList q = start2; q != null; q = q.getNextNode()) {
				if (p == q) {
					return p;
				}
			}
		}
		return null;
	}

	/**
	 * O(n) solution
	 */
	public static MyList getIntersectionOfTwoLinkedList2(MyList start1, MyList start2) {
		MyList lastNode = start1.getLastNode();
		lastNode.setNextNode(start2);
		return findStartOfLoop(start1);
	}

	/**
	 * 2.8 Loop Detection: Given a circular linked list, implement an algorithm
	 * that returns the node at the beginning of the loop. DEFINITION Circular
	 * linked list: A (corrupt) linked list in which a node's next pointer points
	 * to an earlier node, so as to make a loop in the linked list. EXAMPLE Input:
	 * A -> B -> C - > D -> E -> C [the same C as earlier] Output: C
	 */
	public static MyList findStartOfLoop(MyList start) {
		if (start == null || start.getNextNode() == null) {
			return null;
		}
		MyList slow = start;
		MyList fast = start;
		while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode().getNextNode();
			if (fast == slow) {
				break;
			}
		}
		if (fast.getNextNode() == null || fast.getNextNode().getNextNode() == null) {
			System.out.println("There is no loop in given linked list.");
			return null;
		}
		slow = start;
		while (slow != fast) {
			slow = slow.getNextNode();
			fast = fast.getNextNode();
		}
		return slow;
	}
}
