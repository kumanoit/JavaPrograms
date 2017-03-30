package com.kumanoit.linkedlist;

public class MyListUtils {

	public static LinkList createLinkedList(int[] array) {
		if (array.length == 0) {
			return null;
		}
		LinkList start = new LinkList(array[0]);
		LinkList ptr = start;
		for (int index = 1; index < array.length; index++) {
			ptr.setNextNode(new LinkList(array[index]));
			ptr = ptr.getNextNode();
		}
		return start;
	}
}
