package com.kumanoit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Stack;

import com.kumanoit.strings.Permutation;
import com.kumanoit.trees.TreeSamples;
import com.kumanoit.trees.utils.Tree;

public class DummyClass {

	public static void main(String[] args) {
		printNodesVertically(TreeSamples.root1);
	}

	public static void printNodesVertically(Tree root) {
		if (root == null) {
			return;
		}
		TreeMap<Integer, TreeMap<Integer, ArrayList<Tree>>> map = new TreeMap<Integer, TreeMap<Integer, ArrayList<Tree>>>();
		printNodesVertically(root, 0, 0, map);
		map.forEach((k, v) -> {
			System.out.println("\nAt width " + k);
			v.forEach((key, value1) -> {
				value1.forEach(item -> System.out.print(item.getData() + ", "));
			});
		});
	}

	private static void printNodesVertically(Tree root, int width, int height,
			TreeMap<Integer, TreeMap<Integer, ArrayList<Tree>>> map) {
		if (root == null) {
			return;
		}
		if (!map.keySet().contains(width)) {
			ArrayList<Tree> list = new ArrayList<Tree>();
			list.add(root);
			TreeMap<Integer, ArrayList<Tree>> nodesAtHeight = new TreeMap<Integer, ArrayList<Tree>>();
			nodesAtHeight.put(height, list);
			map.put(width, nodesAtHeight);
		} else {
			if (!map.get(width).keySet().contains(height)) {
				ArrayList<Tree> list = new ArrayList<Tree>();
				list.add(root);
				map.get(width).put(height, list);
			} else {
				List<Tree> list = map.get(width).get(height);
				list.add(root);
			}
		}
		printNodesVertically(root.getLeftChild(), width - 1, height + 1, map);
		printNodesVertically(root.getRightChild(), width + 1, height + 1, map);
	}

	private static void detectDeadlockfun() {
		Stack stack = new Stack();

		int[][] matrix = { { 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0 } };
		int[] resourceInstance = { 2, 2 };
		detectDeadlock(matrix, resourceInstance, 4, 2);
	}

	private static void showGraph(int[][] matrix) {
		System.out.println("Graph");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
		}
	}

	private static void detectDeadlock(int[][] matrix, int[] resourceInstance, int processCount, int resourceType) {
		int i = 0;
		int j = 0;
		int totalResourcesAvailable = 0;
		showGraph(matrix);
		// counting total resources available
		for (i = 0; i < resourceType; i++) {
			totalResourcesAvailable += resourceInstance[i];
		}

		int n = processCount + totalResourcesAvailable;

		int[][] graph = new int[n][n];
		// // allocating memory to graph
		// int **graph = (int **) malloc (sizeof(int *) * n);
		// for (i = 0; i < n; i++) {
		// graph[i] = (int *) malloc (sizeof(int));
		// }

		// initializing all values to zero
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				graph[i][j] = 0;
			}
		}

		int oldDim = processCount + resourceType;

		// initialising process indices
		for (i = 0; i < processCount; i++) {
			for (j = 0; j < processCount; j++) {
				graph[i][j] = matrix[i][j];
			}
		}

		// initialising resource requested by process
		int k = processCount;
		int m = k;
		for (j = processCount; j < oldDim; j++) {
			for (i = 0; i < processCount; i++) {
				if (matrix[i][j] == 1) {
					graph[i][k++] = 1;
				}
			}
			k = m + resourceInstance[j - processCount];
			m = k;
		}

		// initializing resource allocated to process
		k = processCount;
		m = k;
		for (i = processCount; i < oldDim; i++) {
			for (j = 0; j < processCount; j++) {
				if (matrix[i][j] == 1) {
					graph[k++][j] = 1;
				}
			}
			k = m + resourceInstance[i - processCount];
			m = k;
		}
		showGraph(graph);
	}

}
