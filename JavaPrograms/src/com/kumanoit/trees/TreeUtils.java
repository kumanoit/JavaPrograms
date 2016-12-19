/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class TreeUtils {

	/**
	 * @param start
	 * @param end
	 * @param size
	 * @return a set of random number in given range
	 */
	public static Set<Integer> getRandomUniqueNumber(int start, int end,
			int size) {
		Set<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		while (set.size() < size) {
			set.add(random.nextInt(end - start) + start);
		}
		return set;
	}

	/**
	 * 
	 * @param array
	 *            : level order traversal
	 * @return
	 */
	public static Tree createTree(Integer[] array) {
		if (array.length == 0) {
			return null;
		}
		Tree root = new Tree(array[0]);
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		int index = 1;
		while (index < array.length) {
			Tree ptr = queue.remove();
			if (ptr == null) {
				continue;
			}

			if (array[index] != null) {
				ptr.setLeftChild(array[index]);
				queue.add(ptr.getLeftChild());
			}
			index++;

			if (index < array.length && array[index] != null) {
				ptr.setRightChild(array[index]);
				queue.add(ptr.getRightChild());
			}
			index++;
		}
		return root;
	}

	// create binary search tree
	public static Tree createBinarySearchTree(int[] array) {
		Tree root = null;
		for(int index = 0; index < array.length; index++) {
			root = insertIntoBst(root, array[index]);
		}
		return root;
	}

	private static Tree insertIntoBst(Tree root, int data) {
		if (root == null) {
			return new Tree(data);
		}
		if (root.getData() == data) {
			System.out.println(data + " already present");
		} else if (root.getData() < data) {
			root.setRightChild(insertIntoBst(root.getRightChild(), data));
		} else {
			root.setLeftChild(insertIntoBst(root.getLeftChild(), data));
		}
		return root;
	}

}
