package com.kumanoit.trees.page5;

import com.kumanoit.trees.TreeSamples;

public class Test {

	private static void minDistanceLeafTest() {
		Solution.findMinDistanceLeaf(TreeSamples.largestBst, 10);
		Solution.findMinDistanceLeaf(TreeSamples.largestBst, 4);
		Solution.findMinDistanceLeaf(TreeSamples.largestBst, 50);
		Solution.findMinDistanceLeaf(TreeSamples.largestBst, 7);
		Solution.findMinDistanceLeaf(TreeSamples.largestBst, 1);
	}

	private static void minDistanceLeafTestnew() {
//		Solution.getMinDistanceLeaf(TreeSamples.largestBst);
		Solution.getMinimumDistance(TreeSamples.largestBst, 10);
		Solution.getMinimumDistance(TreeSamples.largestBst, 4);
		Solution.getMinimumDistance(TreeSamples.largestBst, 50);
		Solution.getMinimumDistance(TreeSamples.largestBst, 7);
		Solution.getMinimumDistance(TreeSamples.largestBst, 1);
	}
	public static void main(String[] args) {
		minDistanceLeafTestnew();
		minDistanceLeafTest();
	}

}
