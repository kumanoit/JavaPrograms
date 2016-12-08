package com.kumanoit.graphs;

public class Dijkstra {

	public static void main(String[] args) {
		int[][] graph = {
				{0,  7,  9,  0, 0, 14},
				{7,  0, 10, 15, 0, 0},
				{9, 10,  0, 11, 0, 2},
				{0, 15, 11,  0, 6, 0},
				{0,  0,  0,  6, 0, 9},
				{14, 0,  2,  0, 9, 0},
				
		};
		findShortestPath(graph, 0);
	}

	private static void findShortestPath(int[][] graph, int source) {
		int n = graph.length;
		int[] weights = new int[n];
		int[] parent = new int[n];
		boolean[] visited = new boolean[n];

		for (int i = 0; i < graph.length; i++) {
			weights[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}

		weights[source] = 0;
		while(true) {
			int v = getMinimumWeightedVertex(weights, visited);
			if (v == -1) {
				break;
			}
			for (int i = 0; i < graph.length; i++) {
				if (graph[v][i] > 0 && weights[i] > weights[v] + graph[v][i] && !visited[i]) {
					weights[i] = weights[v] + graph[v][i];
					parent[i] = v;
				}
			}
			visited[v] = true;
		}

		System.out.println("Source node = " + source);
		for (int i = 0; i < graph.length; i++) {
			System.out.print("Destination Node = " + i + " through path = ");
			printPath(parent, i);
			System.out.println(" weight of " + weights[i]);
		}
	}

	private static int getMinimumWeightedVertex(int[] weights, boolean[] visited) {
		int minWeight = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] < minWeight && !visited[i]) {
				minWeight = weights[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private static void printPath(int[] parent, int index) {
		if(parent[index] == -1) {
			return;
		}

		printPath(parent, parent[index]);
		System.out.print(parent[index] + ", ");
	}
}