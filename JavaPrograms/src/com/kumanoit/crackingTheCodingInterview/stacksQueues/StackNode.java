package com.kumanoit.crackingTheCodingInterview.stacksQueues;

public class StackNode<T> {
	private T data;
	private StackNode<T> nextNode;

	public StackNode(T data) {
		this.data = data;
		this.nextNode = null;
	}

	public void setNextNode(StackNode<T> newNode) {
		this.nextNode = newNode;
	}

	public StackNode<T> getNextNode() {
		return this.nextNode;
	}

	public T getData() {
		return this.data;
	}
}
