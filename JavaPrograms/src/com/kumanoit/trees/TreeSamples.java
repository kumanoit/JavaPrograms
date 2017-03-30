package com.kumanoit.trees;

import com.kumanoit.trees.utils.Tree;
import com.kumanoit.trees.utils.TreeUtils;

public class TreeSamples {

	public static Tree root1 = TreeUtils.createTree(
			new Integer[] { 1, 2, 3, 4, 5, 6, 7, null, 8, 9, null, null, 10, 11, 12, 13, null, null, null, 14, 15 });
	public static Tree root2 = TreeUtils.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, null, null, null, null, 8 });
	public static Tree root3 = TreeUtils.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 });
	public static Tree root4 = TreeUtils.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, null, null, null, 10,
			null, null, null, 13, 14, null, null, null, 11, null, null, 15 });
	public static Tree largestBst = TreeUtils.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 50, 10, null, null,
			60, null, null, null, null, null, 25, 75, null, null, 50, 70, 12, 37, 60, 100, 15 });
	public static Tree root5 = TreeUtils.createTree(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 });
	public static Tree heightBalanced = TreeUtils.createTree(new Integer[] { 2, null, 1, null, null });

}
