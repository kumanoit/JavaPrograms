package com.kumanoit.crackingTheCodingInterview.stacksQueues;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 3.4 Queue via Stacks: Implement a MyQueue class which implements a queue
 * using two stacks. Hints: #98, #7 74 . ....... -·--· --·····-·--------- _pg
 * 236
 */

public class MyQueue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public MyQueue() {
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();
	}

	public void add(T data) {
		stack1.push(data);
	}

	private int size() {
		return stack1.size() + stack2.size();
	}

	public T remove() {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		if (!stack2.isEmpty()) {
			T item = stack2.pop();
			return item;
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		T item = stack2.pop();
		return item;
	}
}
