package com.kumanoit.trees;

public class RefObject {
	int data;

	public RefObject(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void add(int data) {
		this.data += data;
	}

	public String toString() {
		return this.data + "";
	}

	public void increment() {
		this.data++;
	}

	public void decrement() {
		this.data--;
	}
}
