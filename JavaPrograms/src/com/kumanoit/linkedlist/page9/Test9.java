package com.kumanoit.linkedlist.page9;

import com.kumanoit.linkedlist.LinkedListSampleData;

public class Test9 {

	private static void printMiddleOfLinkedList() {
		Solution9.printMiddle(LinkedListSampleData.list1);
		Solution9.printMiddle(LinkedListSampleData.list2);
	}

	private static void getNthNodeInLinkList() {
		try {
		System.out.println(Solution9.getNthNode(LinkedListSampleData.list1, 1).getData());
		System.out.println(Solution9.getNthNode(LinkedListSampleData.list1, 4).getData());
		System.out.println(Solution9.getNthNode(LinkedListSampleData.list1, 10).getData());
		System.out.println(Solution9.getNthNode(LinkedListSampleData.list1, 15).getData());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getNthNodeInLinkList();
	}

}
