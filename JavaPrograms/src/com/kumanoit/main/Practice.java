package com.kumanoit.main;

public class Practice {

	public static void main(String[] args) {
		int[] coins =  {20, 30, 2, 2, 2, 10};//{ 5, 3, 7, 10 }; //{ 8, 15, 3, 7 };//
		System.out.println(getMax(coins, 0, coins.length - 1));
		System.out.println(getMaxDP(coins));
	}

	private static long getMax(int[] coins, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return coins[start];
		}
		return Math.max(coins[start] + Math.min(getMax(coins, start + 2, end), getMax(coins, start + 1, end - 1)),
				coins[end] + Math.min(getMax(coins, start + 1, end - 1), getMax(coins, start, end - 2)));
	}

	private static int getMaxDP(int[] coins) {
		int n = coins.length;
		int[][] memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			memo[i][i] = coins[i];
		}
		for (int start = 0; start < n - 1; start++) {
			int end = start + 1;
			memo[start][end] = Math.max(coins[start], coins[end]);
		}
		for (int len = 3; len <= n; len++) {
			for (int start = 0; start < n - len + 1; start++) {
				int end = start + len - 1;
				int a = memo[start + 2][end];
				int b = memo[start + 1][end - 1];
				int c = memo[start][end - 2];
				memo[start][end] = Math.max(coins[start] + Math.min(a, b), coins[end] + Math.min(b, c));
			}
		}
		return memo[0][n - 1];
	}

}
