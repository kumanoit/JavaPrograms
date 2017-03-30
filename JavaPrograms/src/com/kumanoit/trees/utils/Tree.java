/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees.utils;

import com.kumanoit.trees.TreeTraversal;

public class Tree {

	private Integer data;
	private Tree leftChild;
	private Tree rightChild;

	public Tree(Integer data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
	}

	public void addNode(Integer data) {
		Tree newNode = new Tree(data);
		if (this.leftChild == null) {
			this.leftChild = newNode;
		} else {
			this.rightChild = newNode;
		}
	}

	public Integer getData() {
		return data;
	}

	public Tree getLeftChild() {
		return leftChild;
	}

	public Tree getRightChild() {
		return rightChild;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeftChild(int data) {
		this.leftChild = new Tree(data);
	}

	public void setRightChild(int data) {
		this.rightChild = new Tree(data);
	}

	public void setLeftChild(Tree node) {
		this.leftChild = node;
	}

	public void setRightChild(Tree node) {
		this.rightChild = node;
	}

	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.data + "");
		if (this.leftChild != null) {
			sb.append("," + this.leftChild.toString());
		}
		if (this.rightChild != null) {
			sb.append("," + this.rightChild.toString() + ",");
		}
		return sb.toString();
	}

	public void display() {
		TreeTraversal.displayTree(this);
	}

	public void printPreorder() {
		TreeTraversal.printPreOrder(this);
	}

	public void printInorder() {
		TreeTraversal.printInorder(this);
	}

	public void printPostorder() {
		TreeTraversal.printPostOrder(this);
	}

	public void printLevelOrder() {
		TreeTraversal.printLevelOrder(this);
	}
	
	@Override
	public boolean equals(Object object) {
		return this.getData() == ((Tree) object).getData();
	}

	public void displayDoublyLinkedList() {
		Tree ptr = this;
		System.out.println("Forward >> ");
		while (ptr.getRightChild() != null) {
			System.out.print(ptr.getData() + ", ");
			ptr = ptr.getRightChild();
		}
		System.out.println(ptr.getData());
		System.out.println("Reverse << ");
		while (ptr != null) {
			System.out.print(ptr.getData() + ", ");
			ptr = ptr.getLeftChild();
		}
	}
}
