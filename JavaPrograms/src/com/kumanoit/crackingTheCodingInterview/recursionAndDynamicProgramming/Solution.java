/**
* 
* Created by Amit Kumar on 12/11/16.
* Copyright © 2016 Amit Kumar. All rights reserved.
* 
*/
package com.kumanoit.crackingTheCodingInterview.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * 8.1 Triple Step: A child is running up a staircase with n steps and can hop
	 * either 1 step, 2 steps, or 3 steps at a time. Implement a method to count
	 * how many possible ways the child can run up the stairs. Hints: #152, #178,
	 * #217, #237, #262, #359
	 */
	public static void countStairJumpWays(int steps) {
		long startTime = System.currentTimeMillis();
		long fromRecursion = getTotalWaysToJumpStairs(steps);
		long middleTime = System.currentTimeMillis();
		long fromDP = getTotalWaysToJumpStairsDP(steps);
		long endTime = System.currentTimeMillis();
		System.out.println("Recursive solution for " + steps + " number of steps = " + fromRecursion + " took time = "
				+ (middleTime - startTime));
		System.out.println(
				"DP solution for " + steps + " number of steps = " + fromDP + " took time = " + (endTime - middleTime));
	}

	private static long getTotalWaysToJumpStairs(int steps) {
		if (steps < 3) {
			return steps;
		}
		if (steps == 3) {
			return 4;
		}
		return getTotalWaysToJumpStairs(steps - 1) + getTotalWaysToJumpStairs(steps - 2)
				+ getTotalWaysToJumpStairs(steps - 3);
	}

	private static long getTotalWaysToJumpStairsDP(int steps) {
		if (steps < 3) {
			return steps;
		}
		if (steps == 3) {
			return 4;
		}
		long a = 1;
		long b = 2;
		long c = 4;
		long d = 0;
		for (int i = 4; i <= steps; i++) {
			d = a + b + c;
			a = b;
			b = c;
			c = d;
		}
		return d;
	}

	/**
	 * 8.2 Robot in a Grid: Imagine a robot sitting on the upper left corner of
	 * grid with r rows and c columns. The robot can only move in two directions,
	 * right and down, but certain cells are "off limits" such that the robot
	 * cannot step on them. Design an algorithm to find a path for the robot from
	 * the top left to the bottom right. Hints: #331, #360, #388
	 * 
	 * @throws InterruptedException
	 */
	public static void printPath(boolean[][] grid) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		System.out.println("Recursion call : \n");
		printPathRecursive(grid, 0, 0, grid.length, grid[0].length);
		long middleTime = System.currentTimeMillis();
		System.out.println("\nDP call : \n");
		printPathDP(grid);
		long endTime = System.currentTimeMillis();
		System.out.println("\nRecursive solution took time = " + (middleTime - startTime));
		System.out.println("\nDP solution took time = " + (endTime - middleTime));
	}

	private static boolean printPathRecursive(boolean[][] grid, int i, int j, int row, int col)
			throws InterruptedException {
		Thread.sleep(100);
		// last grid cell
		if (i == row - 1 && j == col - 1) {
			return true;
		}
		// boundary checks
		if (i < 0 || j < 0 || i >= row || j >= col) {
			return false;
		}
		// off limits cell
		if (!grid[i][j]) {
			return false;
		}
		if (printPathRecursive(grid, i + 1, j, row, col) || printPathRecursive(grid, i, j + 1, row, col)) {
			System.out.print("(" + (i + 1) + ", " + (j + 1) + ") <<< ");
			return true;
		}
		return false;
	}

	private static boolean printPathDP(boolean[][] grid) throws InterruptedException {
		Thread.sleep(100);
		Boolean[][] cells = new Boolean[grid.length][grid[0].length];
		return printPathDP(grid, 0, 0, grid.length, grid[0].length, cells);
	}

	private static boolean printPathDP(boolean[][] grid, int i, int j, int row, int col, Boolean[][] cells)
			throws InterruptedException {
		// last grid cell
		if (i == row - 1 && j == col - 1) {
			return true;
		}
		// boundary checks
		if (i < 0 || j < 0 || i >= row || j >= col) {
			return false;
		}
		// off limits cell
		if (!grid[i][j]) {
			return false;
		}
		if (cells[i][j] != null) {
			return cells[i][j];
		}
		cells[i][j] = printPathDP(grid, i + 1, j, row, col, cells) || printPathDP(grid, i, j + 1, row, col, cells);
		if (cells[i][j]) {
			System.out.print("(" + (i + 1) + ", " + (j + 1) + ") <<< ");
			return true;
		}
		return false;
	}

	/**
	 * 8.3 Power Set: Write a method to return all subsets of a set.
	 */
	public static void printAllSubset(int[] array) {
		printAllSubset(array, new ArrayList<Integer>(), 0);
	}

	private static void printAllSubset(int[] array, List<Integer> subset, int index) {
		if (array.length <= index) {
			System.out.print("{");
			subset.forEach(item -> System.out.print(item + ","));
			System.out.println("}");
			return;
		}
		// including element at current index
		subset.add(array[index]);
		printAllSubset(array, subset, index + 1);
		subset.remove((Object) array[index]);
		// not including element at current index
		printAllSubset(array, subset, index + 1);
	}

	/**
	 * 8.4 Recursive Multiply: Write a recursive function to multiply two positive
	 * integers without using the * operator.You can use addition, subtraction,
	 * and bit shifting, but you should minimize the number of those operations.
	 * Hints: #166, #203, #227, #234, #246, #280
	 */
	private static int minOperations = 0;

	public static void multiply(int a, int b) {
		minOperations = 0;
		int product = getProduct(a, b);
		System.out.println("Product = " + product);
		System.out.println("Minimum number of steps taken to multiply numbers are = " + minOperations);
	}

	private static int getProduct(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		if (b == 1) {
			return a;
		}
		if (a == 1) {
			return b;
		}
		if (a < b) {
			return getProduct(b, a);
		}
		minOperations++;
		if ((b & 1) == 0) {
			return getProduct(a << 1, b >> 1);
		} else {
			int product = getProduct(a << 1, b >> 1);
			return a + product;
		}
	}

	/**
	 * 8.5 Towers of Hanoi: In the classic problem of the Towers of Hanoi, you
	 * have 3 towers and N disks of different sizes which can slide onto any
	 * tower. The puzzle starts with disks sorted in ascending order of size from
	 * top to bottom (i.e., each disk sits on top of an even larger one). You have
	 * the following constraints: (1) Only one disk can be moved at a time. (2) A
	 * disk is slid off the top of one tower onto another tower. (3) A disk cannot
	 * be placed on top of a smaller disk. Write a program to move the disks from
	 * the first tower to the last using stacks. Hints: #744, #224, #250, #272,
	 * #318
	 */
	public static void toh(int disks) {
		toh(disks, 'A', 'B', 'C');
	}

	private static void toh(int n, char source, char temp, char dest) {
		if (n == 0) {
			return;
		}
		toh(n - 1, source, dest, temp);
		System.out.println("Move disk " + n + " from " + source + " to " + dest);
		toh(n - 1, temp, source, dest);
	}

	/**
	 * 8.7 Permutations without Dups: Write a method to compute all permutations
	 * of a string of unique characters.
	 */
	public static void printPermutation(String input) {
		printPermutation(input.toCharArray(), 0);
	}

	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void printPermutation(char[] input, int beg) {
		if (beg == input.length) {
			for (int i = 0; i < beg; i++) {
				System.out.print(input[i]);
			}
			System.out.println();
			return;
		}
		for (int i = beg; i < input.length; i++) {
			swap(input, i, beg);
			printPermutation(input, beg + 1);
			swap(input, i, beg);
		}
	}

	public static void printPermutationWithDuplicates(String input) {
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		for (int index = 0; index < input.length(); index++) {
			char character = input.charAt(index);
			if (frequency.keySet().contains(character)) {
				frequency.put(character, frequency.get(character) + 1);
			} else {
				frequency.put(character, 1);
			}
		}
		printPermutationWithDuplicates(frequency, new ArrayList<Character>(), 0, input.length());
	}

	private static void printPermutationWithDuplicates(Map<Character, Integer> frequencyMap, List<Character> output,
			int level, int size) {
		if (level == size) {
			System.out.println();
			output.forEach(item -> System.out.print(item));
			return;
		}
		for (Character ch : frequencyMap.keySet()) {
			int count = frequencyMap.get(ch);
			if (count > 0) {
				output.add(ch);
				frequencyMap.put(ch, count - 1);
				printPermutationWithDuplicates(frequencyMap, output, level + 1, size);
				output.remove((Object) ch);
				frequencyMap.put(ch, count);
			}
		}
	}

	/**
	 * 8.9 Parens: Implement an algorithm to print all valid (e.g., properly
	 * opened and closed) combinations of n pairs of parentheses. EXAMPLE Input: 3
	 * Output: ( ( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () () Hints:
	 * #138, #174, #787, #209, #243, #265, #295
	 */
	public static void printParenthesis(int number) {
		printParenthesis(number, 0, new char[number * 2], 0);
	}

	private static void printParenthesis(int open, int closed, char[] output, int level) {
		if (open == 0 && closed == 0) {
			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}
		if (open > 0) {
			output[level] = '(';
			printParenthesis(open - 1, closed + 1, output, level + 1);
		}
		if (closed > 0) {
			output[level] = ')';
			printParenthesis(open, closed - 1, output, level + 1);
		}
	}

	/**
	 * 8.11 Coins: Given an infinite number of quarters (25 cents), dimes (10
	 * cents), nickels (5 cents), and pennies (1 cent), write code to calculate
	 * the number of ways of representing n cents. Hints: #300, #324, #343, #380,
	 * #394
	 */
	public static void getWaysToGiveNCents(int n, int[] quarters, int size) {
		long startTime = System.currentTimeMillis();
		long fromRecursion = getTotalWaysToGiveNCents(n, quarters, size);
		long middleTime = System.currentTimeMillis();
		long fromDP = getTotalWaysToGiveNCentsDP(n, quarters, size);
		long endTime = System.currentTimeMillis();
		System.out.println(
				"Recursive solution for " + n + " cents = " + fromRecursion + " took time = " + (middleTime - startTime));
		System.out.println("DP solution for " + n + " cents = " + fromDP + " took time = " + (endTime - middleTime));
	}

	private static int getTotalWaysToGiveNCents(int n, int[] quarters, int size) {
		if (n == 0) {
			return 1;
		}
		if (size <= 0) {
			return 0;
		}
		if (n < quarters[size - 1]) {
			// can't use this cent as it exceeds n
			return getTotalWaysToGiveNCents(n, quarters, size - 1);
		}
		// reducing size means that this cent is not used
		return getTotalWaysToGiveNCents(n, quarters, size - 1)
				// didn't reduce 'size' which means that a cent can be reused
				+ getTotalWaysToGiveNCents(n - quarters[size - 1], quarters, size);
	}

	private static int getTotalWaysToGiveNCentsDP(int n, int[] quarters, int size) {
		int[][] memo = new int[n + 1][size + 1];
		for (int i = 0; i <= size; i++) {
			// initializing first row to zero which means that whenver n has been met,
			// coins can be deliverd.
			memo[0][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= size; j++) {
				if (quarters[j - 1] > i) {
					memo[i][j] = memo[i][j - 1];
				} else {
					memo[i][j] = memo[i][j - 1] + memo[i - quarters[j - 1]][j];
				}
			}
		}
		return memo[n][size];
	}

	/**
	 * 8.12 Eight Queens: Write an algorithm to print all ways of arranging eight
	 * queens on an 8x8 chess board so that none of them share the same row,
	 * column, or diagonal. In this case, "diagonal" means all diagonals, not just
	 * the two that bisect the board. Hints: #308, #350, #371
	 */
	private static int count = 0;

	public static void solveQueen(int boardSize) {
		solveQueen(boardSize, 0, new int[boardSize]);
	}

	private static void solveQueen(int boardSize, int row, int[] column) {
		if (row == boardSize) {
			System.out.print(++count + ": \t");
			for (int i = 0; i < column.length; i++) {
				System.out.print((column[i] + 1) + ", ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < boardSize; i++) {
			column[row] = i;
			if (conflicts(column, row)) {
				continue;
			}
			solveQueen(boardSize, row + 1, column);
		}
	}

	private static boolean conflicts(int[] column, int row) {
		for (int i = 0; i < row; i++) {
			int diff = column[i] - column[row];
			if (diff == 0 || Math.abs(diff) == (row - i)) {
				return true;
			}
		}
		return false;
	}
}
