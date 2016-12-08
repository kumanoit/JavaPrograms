package com.kumanoit.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Kruskal {

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
		String filecontent = readFromFile(filename);
		String[] lines = filecontent.split("\n");
		int verticesCount = Integer.parseInt(lines[0].trim());
		int[][] graph = new int[verticesCount + 1][verticesCount + 1];
		for (int i = 1; i < lines.length; i++) {
			String[] ids = lines[i].split("\\s+");
			graph[Integer.parseInt(ids[0])][Integer.parseInt(ids[1])] = Integer.parseInt(ids[2]);
			graph[Integer.parseInt(ids[1])][Integer.parseInt(ids[0])] = Integer.parseInt(ids[2]);
		}
		kruskal(graph);
	}

	private static void kruskal(int[][] graph) {
		List<Edge> list = new ArrayList<Edge>();
		Set<Integer> spanningTreeNodes = new HashSet<Integer>();
		int totalWeight = 0;
		List<Edge> nodesInMinSpanTree = new ArrayList<Edge>();
		List<Set<Integer>> trees = new ArrayList<Set<Integer>>();
		for (int i = 0; i < graph.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			set.add(i);
			trees.add(set);
		}

		// creating a list of graph edges
		for (int i = 0; i < graph.length; i++) {
			for (int j = i + 1; j < graph[i].length; j++) {
				if (graph[i][j] > 0) {
					list.add(new Edge(graph[i][j], i, j));
				}
			}
		}

		// sorting edge list by weights
		Collections.sort(list);
		list.sort((x, y) -> x.getWeight() - y.getWeight());

//		list.forEach(item -> {
//			System.out.println("(" + item.getFirstVertex() + ", " + item.getSecondVertex() + ")" + item.getWeight());
//		});
//
		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			int firstVertex = edge.getFirstVertex();
			int secondVertex = edge.getSecondVertex();
			int setId1 = getSet(trees, firstVertex);
			int setId2 = getSet(trees, secondVertex);
			if (setId1 == setId2) {
				continue;
			}
			trees.get(setId1).addAll(trees.get(setId2));
			trees.remove(setId2);
			totalWeight += edge.getWeight();
			nodesInMinSpanTree.add(edge);
		}

		if (trees.size() > 2) {
			System.out.println("Impossible");
			return;
		}
		System.out.println(totalWeight);
		nodesInMinSpanTree.sort((x, y) -> {
			if (x.getFirstVertex() != y.getFirstVertex()) {
				return x.getFirstVertex() - y.getFirstVertex();
			} else {
				return x.getSecondVertex() - y.getSecondVertex();
			}
		});

		for (Edge item : nodesInMinSpanTree) {
			System.out.println(item.getFirstVertex() + " " + item.getSecondVertex());
		}
//		System.out.println("Set size = " + trees.size());
	}

	private static int getSet(List<Set<Integer>> trees, int vertex) {
		int index = 0;
		for (index = 0; index < trees.size(); index++) {
			Iterator iter = trees.get(index).iterator();
			while(iter.hasNext()) {
				if (iter.next().equals(vertex)) {
					return index;
				}
			}
		}
		return index;
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

class Edge implements Comparable<Edge> {
	private int weight;
	private int vertex1;
	private int vertex2;

	Edge(int weight, int vertex1, int vertex2) {
		this.weight = weight;
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	public int getFirstVertex() {
		return this.vertex1;
	}

	public int getSecondVertex() {
		return this.vertex2;
	}

	public int getWeight() {
		return this.weight;
	}

	@Override
	public int compareTo(Edge node) {
		return this.weight - node.weight;
	}
}