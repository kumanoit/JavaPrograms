package com.kumanoit.graphs;

/**
 * @author kuma
 *
 * Nov 19, 2016
 */
public class DFS {

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
		DFSTraverse(graph);
	}

	private static void DFSTraverse(int[][] graph) {
		int vertices = graph.length;
		int[] color = new int[vertices];
		int[] distance = new int[vertices];
		int[] parent = new int[vertices];

		for(int i = 0; i < vertices; i++) {
			color[i] = WHITE;
			distance[i] = vertices + 1;
			parent[i] = -1;
		}

		parent[0] = -1;
		distance[0] = 0;

		for(int i = 0; i < vertices; i++) {
			if (color[i] == WHITE) {
				DFSTraverse(graph, color, distance, parent, i);
			}
		}

		for (int i = 0; i < vertices; i++) {
			System.out.print("NodeId : " + (i + 1) + " \t  Path = ");
			printPath(parent, i);
			System.out.println(" with distance = " + distance[i]);
		}
	}

	private static void DFSTraverse(int[][] graph, int[] color, int[] distance, int[] parent, int source) {
		color[source] = BLACK;
		for (int i = 0; i < color.length; i++) {
			if (graph[source][i] == 1 && color[i] == WHITE) {
				distance[i] = distance[source] + 1;
				parent[i] = source;
				DFSTraverse(graph, color, distance, parent, i);
			}
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