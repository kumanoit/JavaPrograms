package com.kumanoit.linkedlist;

public class MyList {

	private int data;
	private MyList nextNode;

	public MyList(int data) {
		this.data = data;
		this.nextNode = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MyList getNextNode() {
		return nextNode;
	}

	public void setNextNode(MyList nextNode) {
		this.nextNode = nextNode;
	}

	public MyList getLastNode() {
		MyList ptr = this;
		while (ptr.getNextNode() != null) {
			ptr = ptr.getNextNode();
		}
		return ptr;
	}

	public void display() {
		MyList start = this;
		System.out.println("Here is the linked list");
		while (start != null) {
			System.out.print(start.getData() + "\t");
			start = start.nextNode;
		}
		System.out.println();
	}

}
