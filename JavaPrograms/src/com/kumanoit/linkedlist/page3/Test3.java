package com.kumanoit.linkedlist.page3;

import com.kumanoit.linkedlist.LinkedListSampleData;

public class Test3 {

	private static void testGetMaxSumLinkedList() {
		System.out.println(Solution3.getMaxSumLinkedList(LinkedListSampleData.list3, LinkedListSampleData.list4));
	}

	private static void testConstructMergetLinkedListWithMaxSum() {
		System.out.println(Solution3.constructLinkList(LinkedListSampleData.list3, LinkedListSampleData.list4).toString());
		System.out.println(Solution3.constructLinkList(LinkedListSampleData.listEven, LinkedListSampleData.listOdd).toString());
	}

	public static void main(String[] args) {
		testConstructMergetLinkedListWithMaxSum();
	}

}
