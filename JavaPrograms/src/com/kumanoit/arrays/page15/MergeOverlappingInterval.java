package com.kumanoit.arrays.page15;

import java.util.Arrays;

//http://www.geeksforgeeks.org/merging-intervals/
public class MergeOverlappingInterval {

	public static void main(String[] args) {
		Pair[] pairs = new Pair[4];
		pairs[0] = new Pair(1, 3);
		pairs[1] = new Pair(2, 4);
		pairs[2] = new Pair(5, 7);
		pairs[3] = new Pair(6, 8);
		mergeOverlappingIntervals(pairs);

		Pair[] pairs1 = new Pair[4];
		pairs1[0] = new Pair(6, 8);
		pairs1[1] = new Pair(1, 9);
		pairs1[2] = new Pair(2, 4);
		pairs1[3] = new Pair(4, 7);
		mergeOverlappingIntervals(pairs1);

	}

	public static void mergeOverlappingIntervals(Pair[] pairs) {
		Arrays.sort(pairs);
		int start = 0;
		int end = 0;
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[end].y >= pairs[i].x) {
				if (pairs[end].y < pairs[i].y) {
					pairs[end].y = pairs[i].y;
				}
			} else {
				end++;
				pairs[end].x = pairs[i].x;
				pairs[end].y = pairs[i].y;
			}
		}
		for (int i = start; i <= end; i++) {
			System.out.print(pairs[i].toString());
		}
		System.out.println();
	}
}

class Pair implements Comparable<Pair> {
	int x;
	int y;

	Pair(int x, int y) {
		if (x < y) {
			this.x = x;
			this.y = y;
		} else {
			this.x = y;
			this.y = x;
		}
	}

	@Override
	public int compareTo(Pair pair) {
		if (this.x != pair.x) {
			return this.x - pair.x;
		}
		return this.y - pair.y;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ") ";
	}
}
