package com.kumanoit.crackingTheCodingInterview.recursionAndDynamicProgramming;

public class Test {

	private static void testStairJump() {
		int steps = 30;
		Solution.countStairJumpWays(steps);
	}

	private static void testGridPath() {
		boolean[][] grid = { { true, true, true, false, false, false }, { true, true, true, true, true, false },
				{ true, true, true, true, false, false }, { true, true, true, true, true, false },
				{ true, true, true, false, true, true } };
		try {
			Solution.printPath(grid);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void testPowerSet() {
		Solution.printAllSubset(new int[] { 1, 2, 3 });
	}

	private static void testProductWithoutAsterisk() {
		Solution.multiply(12, 43);
		Solution.multiply(43, 12);
		Solution.multiply(12, 44);
		Solution.multiply(44, 12);
		Solution.multiply(11, 44);
		Solution.multiply(44, 11);
		Solution.multiply(1, 43);
		Solution.multiply(12, 1);
	}

	private static void tohTest() {
		Solution.toh(3);
	}

	private static void testPermutation() {
		Solution.printPermutation("ABC");
	}

	private static void testPermutationWithDuplicates() {
		Solution.printPermutationWithDuplicates("ABAB");
	}

	private static void testPrintParenthesis() {
		Solution.printParenthesis(3);
	}

	private static void testTotalWaysToGiveNCents() {
		int n = 1000;
		int[] quarters = { 1, 2, 5 };
		Solution.getWaysToGiveNCents(n, quarters, quarters.length);
	}

	private static void testSolveQueen() {
		Solution.solveQueen(8);
	}

	public static void main(String[] args) {
		testSolveQueen();
	}
}
