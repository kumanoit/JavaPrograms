package com.kumanoit.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class KnightProblem {

	// http://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();
		while (numberOfTestCases > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			Chess source = new Chess(in.nextInt(), in.nextInt());
			Chess destination = new Chess(in.nextInt(), in.nextInt());
			System.out.println(getMinDistance(n, m, source, destination));
			numberOfTestCases--;
		}
		in.close();
	}

	private static int getMinDistance(int n, int m, Chess source, Chess destination) {
		int step = 0;
		Queue<Chess> queue = new LinkedList<Chess>();
		queue.add(source);
		Set<Chess> visitedCells = new HashSet<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				Chess v = queue.remove();
				visitedCells.add(v);
				List<Chess> allReachableCells = getAllReachableCells(v, n, m);
				if (allReachableCells.contains(destination)) {
					return step + 1;
				}
				size--;
				allReachableCells.forEach(cell -> {
					if (!visitedCells.contains(cell)) {
						queue.add(cell);
					}
				});
			}
			step++;
		}
		return -1;
	}

	private static List<Chess> getAllReachableCells(Chess source, int n, int m) {
		List<Chess> reachables = new ArrayList<Chess>();
		int x = source.getX();
		int y = source.getY();
		Chess cell1 = new Chess(x - 1, y - 2);
		Chess cell2 = new Chess(x - 1, y + 2);
		Chess cell3 = new Chess(x + 1, y - 2);
		Chess cell4 = new Chess(x + 1, y + 2);
		Chess cell5 = new Chess(x - 2, y - 1);
		Chess cell6 = new Chess(x - 2, y + 1);
		Chess cell7 = new Chess(x + 2, y - 1);
		Chess cell8 = new Chess(x + 2, y + 1);
		if (isValidCell(cell1, m, n)) {
			reachables.add(cell1);
		}
		if (isValidCell(cell2, m, n)) {
			reachables.add(cell2);
		}
		if (isValidCell(cell3, m, n)) {
			reachables.add(cell3);
		}
		if (isValidCell(cell4, m, n)) {
			reachables.add(cell4);
		}
		if (isValidCell(cell5, m, n)) {
			reachables.add(cell5);
		}
		if (isValidCell(cell6, m, n)) {
			reachables.add(cell6);
		}
		if (isValidCell(cell7, m, n)) {
			reachables.add(cell7);
		}
		if (isValidCell(cell8, m, n)) {
			reachables.add(cell8);
		}
		return reachables;
	}

	private static boolean isValidCell(Chess cell, int m, int n) {
		int x = cell.getX();
		int y = cell.getY();
		return !(x < 0 || y < 0 || x > n || y > m);
	}
}

class Chess {
	int x;
	int y;
	int distance;

	Chess(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object cell) {
		Chess myCell = (Chess) cell;
		return myCell.getX() == this.getX() && myCell.getY() == this.getY();
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
