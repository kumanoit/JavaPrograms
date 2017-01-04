/**
 * 
 * Created by Amit Kumar on 12/11/16.
 * Copyright © 2016 Amit Kumar. All rights reserved.
 * 
 */
package com.kumanoit.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.kumanoit.trees.utils.Tree;

public class TreeView {

	private static int maxLevel = -1;

	/**
	 * LEFT view of tree.
	 */
	public static void printLeftView(Tree root) {
		maxLevel = -1;
		System.out.println("Left view of tree.");
		printLeftView(root, 0);
		System.out.println();
	}

	private static void printLeftView(Tree root, int level) {
		if (root == null) {
			return;
		}
		if (level > maxLevel) {
			maxLevel = level;
			System.out.print(root.getData() + "\t");
		}
		printLeftView(root.getLeftChild(), level + 1);
		printLeftView(root.getRightChild(), level + 1);
	}

	/**
	 * RIGHT view of tree.
	 */
	public static void printRightView(Tree root) {
		maxLevel = -1;
		System.out.println("Right view of tree.");
		printRightView(root, 0);
		System.out.println();
	}

	private static void printRightView(Tree root, int level) {
		if (root == null) {
			return;
		}
		if (level > maxLevel) {
			maxLevel = level;
			System.out.print(root.getData() + "\t");
		}
		printRightView(root.getRightChild(), level + 1);
		printRightView(root.getLeftChild(), level + 1);
	}

	/**
	 * TOP view of tree
	 */
	public static void printTopViewOfTree(Tree root) {
		int minIndex = Integer.MAX_VALUE;
		Map<Integer, Tree> map = new HashMap<Integer, Tree>();
		printTopViewOfTree(root, map, 0);
		for (Entry<Integer, Tree> entry : map.entrySet()) {
			minIndex = Math.min(minIndex, entry.getKey());
		}
		System.out.println("\nTop view of tree");
		for (int index = minIndex; index < map.size() + minIndex; index++) {
			System.out.print(map.get(index).getData() + "\t");
		}
	}

	private static void printTopViewOfTree(Tree root, Map<Integer, Tree> map, int level) {
		if (root == null) {
			return;
		}
		if (!map.keySet().contains(level)) {
			map.put(level, root);
		}
		printTopViewOfTree(root.getLeftChild(), map, level - 1);
		printTopViewOfTree(root.getRightChild(), map, level + 1);
	}

	/**
	 * BOTTOM view of a tree
	 */
	public static void printBottomViewOfTree(Tree root) {
		int minIndex = Integer.MAX_VALUE;
		Map<Integer, Map<Integer, Tree>> map = new HashMap<Integer, Map<Integer, Tree>>();
		printBottomViewOfTree(root, map, 0, 0);
		for (Entry<Integer, Map<Integer, Tree>> entry : map.entrySet()) {
			minIndex = Math.min(minIndex, entry.getKey());
		}
		System.out.println("\nBottom view of tree");
		for (int index = minIndex; index < map.size() + minIndex; index++) {
			for (Entry<Integer, Tree> entry : map.get(index).entrySet()) {
				System.out.print(entry.getValue().getData() + "\t");
			}
		}
	}	
	private static void printBottomViewOfTree(Tree root, Map<Integer, Map<Integer, Tree>> map, int height, int width) {
		if (root == null){
			return;
		}
		if (!map.keySet().contains(width)) {
			Map<Integer, Tree> rootAtLevel = new HashMap<Integer, Tree>();
			rootAtLevel.put(height, root);
			map.put(width, rootAtLevel);
		} else {
			Map<Integer, Tree> rootAtLevel = map.get(width);
			int localHeight = 0;
			for (Entry<Integer, Tree> entry : rootAtLevel.entrySet()) {
				localHeight = entry.getKey();
			}
			if (localHeight < height) {
				rootAtLevel.remove(localHeight);
				rootAtLevel.put(height, root);
			}
		}
		printBottomViewOfTree(root.getLeftChild(), map, height + 1, width - 1);
		printBottomViewOfTree(root.getRightChild(), map, height + 1, width + 1);
	}

}
