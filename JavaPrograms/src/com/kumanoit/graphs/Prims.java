package com.kumanoit.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prims {

	public static void main(String[] args) {
//		int[][] graph = {
//				{0,  4,  0,  0,  0,  0,  0,  8,  0},
//				{4,  0,  8,  0,  0,  0,  0, 11,  0},
//				{0,  8,  0,  7,  0,  4,  0,  0,  2},
//				{0,  0,  7,  0,  9, 14,  0,  0,  0},
//				{0,  0,  0,  9,  0, 10,  0,  0,  0},
//				{0,  0,  4, 14, 10,  0,  2,  0,  0},
//				{0,  0,  0,  0,  0,  2,  0,  1,  6},
//				{8, 11,  0,  0,  0,  0,  1,  0,  7},
//				{0,  0,  2,  0,  0,  0,  6,  7,  0},
//		};
		String filename = args[0];//"/Users/kuma/Documents/Utkarsh/Assignment_64/dir/KruskalTree2.txt";
		System.out.println(filename);
		String filecontent = readFromFile(filename);
		String[] lines = filecontent.split("\n");
		int verticesCount = Integer.parseInt(lines[0].trim());
		int[][] graph = new int[verticesCount + 1][verticesCount + 1];
		for (int i = 1; i < lines.length; i++) {
			String[] ids = lines[i].split("\\s+");
			graph[Integer.parseInt(ids[0])][Integer.parseInt(ids[1])] = Integer.parseInt(ids[2]);
			graph[Integer.parseInt(ids[1])][Integer.parseInt(ids[0])] = Integer.parseInt(ids[2]);
		}
		primSolution(graph);
	}

	private static void primSolution(int[][] graph) {
		int[] weights = new int[graph.length];
		boolean[] visited = new boolean[graph.length];
		int[] parent = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			weights[i] = Integer.MAX_VALUE;
			visited[i] = false;
			parent[i] = -1;
		}

		weights[0] = 0;

		int totalWeight = 0;
		while (true) {
			int v = getMinIndex(visited, weights);
			if (v == -1) {
				break;
			}
			totalWeight += weights[v];
			for (int i = 0; i < graph.length; i++) {
				if (graph[v][i] > 0 && !visited[i] && graph[v][i] < weights[i]) {
					weights[i] = graph[v][i];
				}
			}
			visited[v] = true;
		}

		int allVisistedCount = 0;
		for (int i = 0; i < visited.length; i++) {
			allVisistedCount += visited[i] ? 1 : 0;
		}
		if (allVisistedCount != visited.length) {
			System.out.println("Impossible.");
			return;
		}
		System.out.println(totalWeight);
		for (int i = 0; i < graph.length; i++) {
			System.out.print("Destination Node = " + i + " through path = ");
			printPath(parent, i);
			System.out.println(" weight of " + weights[i]);
		}

	}

	private static int getMinIndex(boolean[] visited, int[] weights) {
		int minIndex = -1;
		int minWeight = Integer.MAX_VALUE;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i] && weights[i] < minWeight) {
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

	/**
	 * reads file
	 * @param filename : absolute path to file that needs to be read
	 * @return content of file
	 */
	public static String readFromFile(String filename) {
	    BufferedReader br = null;
	    StringBuilder sb = new StringBuilder();
	    try {
	        br = new BufferedReader(new FileReader(filename));
	        String line = br.readLine();
	
	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	    } catch (Exception e) {
	        System.out.println("Couldn't read from file " + e.toString());
	    }
	    finally {
	        try {
	            br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }    
	    return sb.toString();
	}

}
