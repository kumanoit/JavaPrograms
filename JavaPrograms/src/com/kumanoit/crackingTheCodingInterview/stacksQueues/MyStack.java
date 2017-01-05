package com.kumanoit.crackingTheCodingInterview.stacksQueues;

import java.util.EmptyStackException;

public class MyStack<T> {

	StackNode<T> top;

	public void push(T data) {
		StackNode<T> newNode = new StackNode<T>(data);
		newNode.setNextNode(top);
		top = newNode;
	}

	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T topNode = top.getData();
		top = top.getNextNode();
		return topNode;
	}
}
