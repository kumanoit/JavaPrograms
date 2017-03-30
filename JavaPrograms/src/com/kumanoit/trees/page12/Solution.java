package com.kumanoit.trees.page12;

import java.util.HashMap;
import java.util.Map;

import com.kumanoit.trees.utils.Tree;

public class Solution {

	private static int p = 1;

	public static boolean printAllNodesAtDistanceK(Tree root, int value, int k) {
		if (root == null) {
			return false;
		}
		if (value == root.getData()) {
			printAllNodesAtDistanceKInSubTree(root, k);
			return true;
		}
		if (printAllNodesAtDistanceK(root.getLeftChild(), value, k)) {
			if (k - p == 0) {
				System.out.println(root.getData() + "\t");
			}
			p++;
			printAllNodesAtDistanceKInSubTree(root.getRightChild(), k - p);
			return true;
		}
		if (printAllNodesAtDistanceK(root.getRightChild(), value, k)) {
			if (k - p == 0) {
				System.out.println(root.getData() + "\t");
			}
			p++;
			printAllNodesAtDistanceKInSubTree(root.getLeftChild(), k - p);
			return true;
		}
		return false;
	}

	public static void printAllNodesAtDistanceKInSubTree(Tree root, int k) {
		if (root == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.print(root.getData() + "\t");
			return;
		}
		printAllNodesAtDistanceKInSubTree(root.getLeftChild(), k - 1);
		printAllNodesAtDistanceKInSubTree(root.getRightChild(), k - 1);
	}

	
	
	public static void printBottomView(Tree root) {
		printBottomView(root, 0, 0);
		map.forEach((k, v) -> System.out.println(v.getValue()));
	}

	private static Map<Integer, Pair> map = new HashMap<>();

	public static void printBottomView(Tree root, int hd, int level) {
		if (root == null) {
			return;
		}
		if (map.keySet().contains(hd)) {
			Pair node = map.get(hd);
			if (node.getHeight() < level) {
				node.setHeight(level);
				node.setValue(root.getData());
				map.put(hd, node);
			}
		} else {
			Pair node = new Pair(level, root.getData());
			map.put(hd, node);
		}
		printBottomView(root.getLeftChild(), hd - 1, level + 1);
		printBottomView(root.getRightChild(), hd + 1, level + 1);
	}
}

	class Pair {
		int height;
		int value;

		public Pair(int height, int value) {
			this.height = height;
			this.value = value;
		}

		public int getHeight() {
			return height;
		}

		public int getValue() {
			return value;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
	