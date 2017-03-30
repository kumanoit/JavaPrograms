package com.kumanoit.trees.page5;

import com.kumanoit.trees.RefObject;
import com.kumanoit.trees.utils.Tree;

public class Solution {

	/**
	 * 3 http://www.geeksforgeeks.org/closest-leaf-to-a-given-node-in-binary-tree/
	 */
	public static void findMinDistanceLeaf(Tree root, int value) {
		RefObject p = new RefObject(1);
		RefObject minDistance = new RefObject(Integer.MAX_VALUE);
		RefObject minDistanceLeaf = new RefObject(-1);
		findMinDistanceLeaf(root, minDistanceLeaf, 0, p, minDistance, value);
		System.out.print("Minimum distance = " + minDistance.getData());
		System.out.println(", Minimum distance leaf = " + minDistanceLeaf.getData());
	}

	public static void getMinDistanceLeaf(Tree root) {
		if (root == null) {
			return;
		}
		System.out.println("Minimum distance leaf from " + root.getData() + " = " + getMinDistanceLeaf(root, 0));
		getMinDistanceLeaf(root.getLeftChild());
		getMinDistanceLeaf(root.getRightChild());
	}

	private static int getMinDistanceLeaf(Tree root, int level) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		if (root.isLeaf()) {
			return level;
		}
		return Math.min(getMinDistanceLeaf(root.getLeftChild(), level + 1),
				getMinDistanceLeaf(root.getRightChild(), level + 1));

	}

	private static void findMinDistanceLeaf(Tree root, RefObject minDistance, int level, RefObject minDistanceLeaf) {
		if (root == null) {
			return;
		}
		if (root.isLeaf()) {
			if (minDistance.getData() > level) {
				minDistance.setData(level);
				minDistanceLeaf.setData(root.getData());
			}
			return;
		}
		findMinDistanceLeaf(root.getLeftChild(), minDistance, level + 1, minDistanceLeaf);
		findMinDistanceLeaf(root.getRightChild(), minDistance, level + 1, minDistanceLeaf);
	}

	private static boolean findMinDistanceLeaf(Tree root, RefObject minDistanceLeaf, int level, RefObject p,
			RefObject minDistance, int value) {
		if (root == null) {
			return false;
		}
		if (root.getData() == value) {
			findMinDistanceLeaf(root, minDistance, level, minDistanceLeaf);
			return true;
		}
		if (findMinDistanceLeaf(root.getLeftChild(), minDistanceLeaf, level, p, minDistance, value)) {
			p.setData(p.getData() + 1);
			findMinDistanceLeaf(root.getRightChild(), minDistance, p.getData(), minDistanceLeaf);
			return true;
		} else if (findMinDistanceLeaf(root.getRightChild(), minDistanceLeaf, level, p, minDistance, value)) {
			p.setData(p.getData() + 1);
			findMinDistanceLeaf(root.getLeftChild(), minDistance, p.getData(), minDistanceLeaf);
			return true;
		}
		return false;
	}

	public static void getMinimumDistance(Tree root, int value) {
		RefObject minDist = new RefObject(Integer.MAX_VALUE);
		RefObject p = new RefObject(1);
		getMinimumDistance(root, value, minDist, p);
		System.out.println("Minimum distance = " + minDist.getData());
		
	}
	public static boolean getMinimumDistance(Tree root, int value, RefObject minDist, RefObject p) {
		if (root == null) {
			return false;
		}
		if (root.getData() == value) {
			minDist.setData(getMinDistanceLeaf(root, 0));
			return true;
		}
		if (getMinimumDistance(root.getLeftChild(), value, minDist, p)) {
			p.setData(p.getData() + 1);
			minDist.setData(Math.min(minDist.getData(), getMinDistanceLeaf(root.getRightChild(), p.getData())));
			return true;
		} else if (getMinimumDistance(root.getRightChild(), value, minDist, p)){
			p.setData(p.getData() + 1);
			minDist.setData(Math.min(minDist.getData(), getMinDistanceLeaf(root.getLeftChild(), p.getData())));
			return true;
		}
		return false;
	}
}
