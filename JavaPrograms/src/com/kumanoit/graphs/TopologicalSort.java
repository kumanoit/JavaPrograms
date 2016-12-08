package com.kumanoit.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {
		int[][] graph = {
				{0, 1, 0, 1, 0},
				{0, 0, 1, 1, 0},
				{0, 0, 0, 1, 0},
				{0, 1, 0, 0, 0},
				{1, 0, 1, 1, 0},
		};
		getSolution(graph);
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
        for(int i = 0; i < graph.length; i++) {
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

        while(!queue.isEmpty()) {
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

}
