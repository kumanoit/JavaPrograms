package com.kumanoit.matrix.page1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.kumanoit.utils.arrays.ArrayUtility;

public class NumDecisionsToReachDestination {

	public static void main(String[] args) {
		char[][] grid = { ".BBB.B.BB".toCharArray(), ".....B.B.".toCharArray(), "B.B.B.BSB".toCharArray(),
				".DB......".toCharArray() };
		ArrayUtility.printMatrix(grid);
		Cell source = new Cell(2, 7, null);
		Cell destination = new Cell(3, 1, null);
		System.out.println(source + " >> " + grid[source.getRow()][source.getColumn()]);
		System.out.println(destination + " >> " + grid[destination.getRow()][destination.getColumn()]);
		System.out.println(getTotalNumberOfDecisions(grid, source, destination));

	}

	private static int getTotalNumberOfDecisions(char[][] matrix, Cell source, Cell destination) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean destinationFound = false;
		Queue<Cell> queue = new LinkedList<Cell>();

		queue.add(source);
		Set<Cell> visited = new HashSet<Cell>();
		visited.add(source);
		while (!queue.isEmpty()) {
			Cell cell = queue.remove();
			if (cell.equals(destination)) {
				System.out.println("Destination found");
				destination.setParent(cell);
				destinationFound = true;
				break;
			}
			int count = 0;
			int row = cell.getRow();
			int col = cell.getColumn();
			if (col > 0 && matrix[row][col - 1] != 'B') { // left
				Cell child = new Cell(row, col - 1, cell);
				if (!visited.contains(child)) {
					++count;
					queue.add(child);
				}
			}
			if ((col < n - 1) && matrix[row][col + 1] != 'B') { // right
				Cell child = new Cell(row, col + 1, cell);
				if (!visited.contains(child)) {
					++count;
					queue.add(child);
				}
			}
			if (row > 0 && matrix[row - 1][col] != 'B') { // up
				Cell child = new Cell(row - 1, col, cell);
				if (!visited.contains(child)) {
					++count;
					queue.add(child);
				}
			}
			if ((row < m - 1) && matrix[row + 1][col] != 'B') { // down
				Cell child = new Cell(row + 1, col, cell);
				if (!visited.contains(child)) {
					++count;
					queue.add(child);
				}
			}
			if (count > 1) {
				cell.setMultiplePaths(true);
			}
			visited.add(cell);
		}
		int count = 0;
		System.out.println("Path");
		if (destinationFound) {
			Cell cell = destination;
			while (cell.parent != null) {
				System.out.println(cell.toString());
				if (cell.getMultiplePaths()) {
					count++;
				}
				cell = cell.parent;
			}
		}
		return count;
	}
}

class Cell {
	int row;
	int col;
	Cell parent;
	boolean multiplePaths;

	Cell(int row, int col, Cell parent) {
		this.row = row;
		this.col = col;
		this.parent = parent;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.col;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof Cell)) {
			return false;
		}
		Cell myCell = (Cell) object;
		return this.row == myCell.row && this.col == myCell.col;
	}

	public void setMultiplePaths(boolean multiplePaths) {
		this.multiplePaths = multiplePaths;
	}

	public boolean getMultiplePaths() {
		return multiplePaths;
	}

	public void setParent(Cell parent) {
		this.parent = parent;
	}

	public String toString() {
		return "(" + row + "," + col + " > " + multiplePaths + ") ";
	}
}