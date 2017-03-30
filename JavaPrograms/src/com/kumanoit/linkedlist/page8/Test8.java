package com.kumanoit.linkedlist.page8;

import com.kumanoit.linkedlist.LinkedListSampleData;

public class Test8 {

	private static void insertNewNodeTest() {
		System.out.println(Solution8.insertNodeInSortedLinkedList(LinkedListSampleData.listOdd, 0).toString());
		System.out.println(Solution8.insertNodeInSortedLinkedList(LinkedListSampleData.listOdd, 20).toString());
		System.out.println(Solution8.insertNodeInSortedLinkedList(LinkedListSampleData.listOdd, 10).toString());
	}

	public static void main(String[] args) {
		insertNewNodeTest();
	}

}
