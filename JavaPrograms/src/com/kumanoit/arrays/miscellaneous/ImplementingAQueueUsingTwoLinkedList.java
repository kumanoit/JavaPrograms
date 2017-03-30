package com.kumanoit.arrays.miscellaneous;

public class ImplementingAQueueUsingTwoLinkedList {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		System.out.println(queue.isEmpty());
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.isEmpty());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}

}
