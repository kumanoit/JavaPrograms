package com.kumanoit.arrays.miscellaneous;

import java.util.Stack;

public class MyQueue<T> {
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	private static int MAX_VALUE = 100;

	public void add(T value) {
		if (stack1.size() == MAX_VALUE) {
			System.out.println("overflow");
			return;
		}
		stack1.push(value);
	}

	public T remove() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				System.out.println("Underflow");
				return null;
			}
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public boolean isEmpty() {
		return stack2.isEmpty() && stack1.isEmpty();
	}
}