package com.kumanoit.trees.page10;

public class Test {

	private static void testPrintPostorder() {
		Solution.printPostorder(new int[] {4, 2, 5, 1, 3, 6}, new int[] {1, 2, 4, 5, 3, 6});
		// {4, 5, 2, 6, 3, 1}
	}

	public static void main(String[] args) {
		testPrintPostorder();
	}

}
