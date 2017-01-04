package com.kumanoit.generics.trees;

import com.kumanoit.generics.utils.trees.Constants;
import com.kumanoit.generics.utils.trees.TreeNode;
import com.kumanoit.generics.utils.trees.TreeUtility;

public class Main {

	private static TreeNode<String> root1 = TreeUtility.createBinaryTree(Constants.array1);

	public static void testExpressionEvaluator() {
		root1.display();
		System.out.println(Problems.evaluateExpression(root1));
	}

	public static void main(String[] args) {
		testExpressionEvaluator();
	}
}
