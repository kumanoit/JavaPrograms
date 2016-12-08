package com.kumanoit.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BipartiteGraph {

	private static final int WHITE = 0;
	private static final int RED = 1;
	private static final int BLUE = 2;


	public static void main(String[] args) {
		Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
		int[][] matrix = {
				{0, 0, 0, 1, 0},
				{0, 0, 0, 0, 1},
				{0, 0, 0, 1, 1},
				{1, 0, 1, 0, 1},
				{0, 1, 1, 1, 0}
		};

		System.out.println("New : " + isPossible(matrix));
		List<Integer> listA = new ArrayList<Integer>();
		listA.add(4);
		listA.add(5);

		List<Integer> listB = new ArrayList<Integer>();
		listB.add(4);
		listB.add(6);

		List<Integer> listC = new ArrayList<Integer>();
		listC.add(4);
		listC.add(5);

		List<Integer> listD = new ArrayList<Integer>();
		listD.add(2);
		listD.add(3);

		List<Integer> listE = new ArrayList<Integer>();
		listE.add(1);
		listE.add(3);
		listE.add(6);

		List<Integer> listF = new ArrayList<Integer>();
		listF.add(2);

		adjacencyList.put(1, listA);
		adjacencyList.put(2, listB);
		adjacencyList.put(3, listC);
		adjacencyList.put(4, listD);
		adjacencyList.put(5, listE);
		adjacencyList.put(6, listF);

		System.out.println(isPossible(adjacencyList));
	}
	
	private static String getColor(int i) {
		if (i == WHITE) {
			return "WHITE";
		} else if (i == RED) {
			return "RED";
		}
		return "BLUE";
	}
	private static boolean isPossible(Map<Integer, List<Integer>> adjacencyList) {
		int[] color = new int[adjacencyList.size() + 1];
		for (int i = 1; i < color.length; i++) {
			System.out.println(i + "\t" + getColor(color[i]));
		}
		for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
			int source = entry.getKey();
			List<Integer> next = entry.getValue();
			if (color[source] == WHITE) {
				color[source] = RED;
			}
			for (Integer x : next) {
				if(color[x] == color[source]) {
					for (int i = 1; i < color.length; i++) {
						System.out.println(i + "\t" + getColor(color[i]));
					}
					System.out.println(x + " : destination color = " + getColor(color[x]));
					System.out.println(source + " : source color = " + getColor(color[source]));
					return false;
				} else {
					color[x] = color[source] == RED ? BLUE : RED;
				}
			}
		}
		for (int i = 1; i < color.length; i++) {
			System.out.println(i + "\t" + getColor(color[i]));
		}
		return true;
	}
    private static boolean isPossible(int[][] matrix) {
        int[] color = new int[matrix.length];
        int WHITE = 0;
        for (int i = 0; i < color.length; i++) {
        	color[i] = WHITE;
        }
        int RED = 1;
        int BLUE = 2;
        int source = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        color[source] = RED;
        int newColor = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            if (color[v] == RED) {
                newColor = BLUE;
            } else {
                newColor = RED;
            }
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[v][i] == 1) {
                    if (color[i] == WHITE) {
	                    color[i] = newColor;
	                    queue.add(i);
	                } else if (v != i && color[v] == color[i]) {
	                    return false;
	                }
                }
            }
        }
        return true;
    }

}
