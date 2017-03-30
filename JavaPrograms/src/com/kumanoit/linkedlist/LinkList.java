package com.kumanoit.linkedlist;

public class LinkList {

	private int data;
	private LinkList nextNode;

	public LinkList(int data) {
		this.data = data;
		this.nextNode = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkList getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkList nextNode) {
		this.nextNode = nextNode;
	}

	public LinkList getLastNode() {
		LinkList ptr = this;
		while (ptr.getNextNode() != null) {
			ptr = ptr.getNextNode();
		}
		return ptr;
	}

	public void display() {
		LinkList start = this;
		System.out.println("Here is the linked list");
		while (start != null) {
			System.out.print(start.getData() + "\t");
			start = start.nextNode;
		}
		System.out.println();
	}

	@Override
	public String toString() {
		if (this.getNextNode() != null) {
			return this.getData() + "\t" + this.getNextNode().toString();
		}
		return this.getData() + "";
	}
}
