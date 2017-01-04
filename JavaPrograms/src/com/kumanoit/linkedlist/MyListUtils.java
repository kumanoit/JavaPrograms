package com.kumanoit.linkedlist;

public class MyListUtils {

	public static MyList createLinkedList(int[] array) {
		if (array.length == 0) {
			return null;
		}
		MyList start = new MyList(array[0]);
		MyList ptr = start;
		for (int index = 1; index < array.length; index++) {
			ptr.setNextNode(new MyList(array[index]));
			ptr = ptr.getNextNode();
		}
		return start;
	}
}
