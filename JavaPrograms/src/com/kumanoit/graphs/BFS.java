package com.kumanoit.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private static final int WHITE = 0;
	private static final int BLACK = 1;

	public static void main(String[] args) {
		int[][] graph = {
				{0, 1, 0, 1, 1, 0},
				{1, 0, 1, 0, 0, 0},
				{0, 1, 0, 1, 0, 0},
				{1, 0, 1, 0, 0, 1},
				{1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0},
		};
		traverseBfs(graph);
	}

	private static void traverseBfs(int[][] graph) {
		int totalNodes = graph.length;
		int[] color = new int[totalNodes];
		int[] parent = new int[totalNodes];
		int[] distance = new int[totalNodes];
		for (int i = 0; i < totalNodes; i++) {
			color[i] = WHITE;
			parent[i] = -1;
			distance[i] = totalNodes + 1;
		}

		distance[0] = 0;
		color[0] = BLACK;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int i = 0; i < totalNodes; i++) {
				if (graph[v][i] == 1 && color[i] == WHITE) {
					distance[i] = distance[v] + 1;
					parent[i] = v;
					queue.add(i);
					color[i] = BLACK;
				}
			}
		}

		for (int i = 0; i < totalNodes; i++) {
			System.out.print("NodeId : " + (i + 1) + " \t  Path = ");
			printPath(parent, i);
			System.out.println(" with distance = " + distance[i]);
		}
	}

	private static void printPath(int[] parent, int i) {
		if (parent[i] == -1) {
			return;
		}
		printPath(parent, parent[i]);
		System.out.print((parent[i] + 1) + "\t");
	}
}
