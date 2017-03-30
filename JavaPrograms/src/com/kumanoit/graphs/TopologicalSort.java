package com.kumanoit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
		map.put('A', new ArrayList<Character>(Arrays.asList('B', 'C', 'D')));
		map.put('B', new ArrayList<Character>(Arrays.asList('E', 'C')));
		map.put('C', new ArrayList<Character>(Arrays.asList('E', 'D')));
		map.put('D', new ArrayList<Character>(Arrays.asList('E')));
		printTopologicalSort(map);

		int[][] graph = { { 0, 1, 0, 1, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 }, };
//		getSolution(graph);
	}

	private static int getIndegree(int index, int[][] graph) {
		int indegree = 0;
		for (int i = 0; i < graph.length; i++) {
			if (graph[i][index] == 1) {
				indegree++;
			}
		}
		return indegree;
	}

	private static void getSolution(int[][] graph) {
		int[] indegree = new int[graph.length];
		List<Integer> topologicalSortList = new ArrayList<Integer>();
		for (int i = 0; i < graph.length; i++) {
			indegree[i] = getIndegree(i, graph);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < graph.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		if (queue.size() == 0) {
			System.out.println("Deadlock");
		}

		while (!queue.isEmpty()) {
			int v = queue.remove();
			topologicalSortList.add(v);
			for (int i = 0; i < graph.length; i++) {
				if (graph[v][i] == 1) {
					indegree[i]--;
					if (indegree[i] == 0) {
						queue.add(i);
					}
				}
			}
		}
		if (topologicalSortList.size() != graph.length) {
			System.out.println("There is some deadlock in jobs.");
		}
		topologicalSortList.forEach(item -> System.out.print(item + "\t"));
	}

	private static void printTopologicalSort(Map<Character, List<Character>> map) {
		Stack<Character> topo = new Stack<Character>();
		Set<Character> set = new HashSet<Character>();
		for (Map.Entry<Character, List<Character>> entry : map.entrySet()) {
			char source = entry.getKey();
			if (set.contains(source)) {
				continue;
			}
			dfs(map, topo, set, source);
		}
		System.out.println("Topological sort");
		while (!topo.isEmpty()) {
			System.out.print(topo.pop() + ", ");
		}
	}

	private static void dfs(Map<Character, List<Character>> map, Stack<Character> stack, Set<Character> set,
			Character source) {
		set.add(source);
		List<Character> destinations = map.get(source);
		if (destinations != null) {
			for (int i = 0; i < destinations.size(); i++) {
				Character destination = destinations.get(i);
				if (set.contains(destination)) {
					continue;
				}
				dfs(map, stack, set, destination);
			}
		}
		stack.push(source);
	}

}
