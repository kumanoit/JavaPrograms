package com.kumanoit.crackingTheCodingInterview.stacksQueues;

import java.util.Stack;

public class ImplementingQueueUsingTwoStacks {
	public static void main(String[] args) {
		
		MyQueue<Integer> queue = new MyQueue<Integer>();
		System.out.println(queue.remove());
		queue.add(1);
		queue.add(2);
		System.out.println(queue.remove());
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println(queue.remove());
		queue.add(6);
		System.out.println(queue.remove());
	}
}
