package com.kumanoit.linkedlist.page2;

import com.kumanoit.linkedlist.LinkedListSampleData;

public class Test2 {

	private static void testSegregateEvenOddNodes() {
		System.out.println(Solution2.rearrangeEvenOddNodes(LinkedListSampleData.list1).toString());
		System.out.println(Solution2.rearrangeEvenOddNodes(LinkedListSampleData.listEven).toString());
		System.out.println(Solution2.rearrangeEvenOddNodes(LinkedListSampleData.listOdd).toString());
	}

	private static void testMergeTwoLinkedListInReverse() {
		System.out.println(
				Solution2.mergeLinkListInReverseOrder(LinkedListSampleData.listOdd, LinkedListSampleData.listEven).toString());
		System.out.println(Solution2.mergeLinkListInReverseOrder(LinkedListSampleData.list1, null).toString());
		System.out.println(Solution2.mergeLinkListInReverseOrder(null, LinkedListSampleData.list2).toString());
	}

	private static void arrangeZigZagTest() {
		System.out.println(Solution2.rearrange(LinkedListSampleData.list1).toString());
	}

	public static void main(String[] args) {
		arrangeZigZagTest();
	}

}
