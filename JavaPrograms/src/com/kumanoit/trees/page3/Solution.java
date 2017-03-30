package com.kumanoit.trees.page3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kumanoit.trees.utils.Tree;

public class Solution {

	// 3. http://www.geeksforgeeks.org/sink-odd-nodes-binary-tree/
	public static void sinkOddEven(Tree root) {
		if (root == null || root.isLeaf()) {
			return;
		}
		sinkOddEven(root.getLeftChild());
		sinkOddEven(root.getRightChild());
		if ((root.getData() & 1) == 1) {
			if (root.getLeftChild() != null) {
				int leftValue = root.getLeftChild().getData();
				if ((leftValue & 1) == 0) {
					root.getLeftChild().setData(root.getData());
					root.setData(leftValue);
					sinkOddEven(root.getLeftChild());
				}
			} else if (root.getRightChild() != null) {
				int rightValue = root.getRightChild().getData();
				if ((rightValue & 1) == 0) {
					root.getRightChild().setData(root.getData());
					root.setData(rightValue);
					sinkOddEven(root.getRightChild());
				}
			}
		}
	}

	// 9. http://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
	public static void printDiagonal(Tree root) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		printDiagonal(root, map, 0);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			entry.getValue().forEach(item -> System.out.print(item + "\t"));
			System.out.println();
		}
	}

	private static void printDiagonal(Tree root, Map<Integer, List<Integer>> map, int level) {
		if (root == null) {
			return;
		}
		if (!map.keySet().contains(level)) {
			map.put(level, new ArrayList<Integer>());
		}
		map.get(level).add(root.getData());
		printDiagonal(root.getLeftChild(), map, level - 1);
		printDiagonal(root.getRightChild(), map, level);
	}

}
