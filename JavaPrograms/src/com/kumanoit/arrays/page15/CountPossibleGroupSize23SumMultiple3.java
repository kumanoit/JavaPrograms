package com.kumanoit.arrays.page15;

//http://www.geeksforgeeks.org/count-possible-groups-size-2-3-sum-multiple-3/
public class CountPossibleGroupSize23SumMultiple3 {
	public static void main(String[] args) {
		System.out.println(countAllPossibleGroup(new int[] { 3, 6, 7, 2, 9 }));
		System.out.println(countAllPossibleGroup(new int[] { 2, 1, 3, 4 }));
	}

	private static int countAllPossibleGroup(int[] array) {
		int ones = 0;
		int twos = 0;
		int threes = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 3 == 2) {
				twos++;
			} else if (array[i] % 3 == 0) {
				threes++;
			} else {
				ones++;
			}
		}
		int count = 0;
		count = getPairs(threes) // pairs of 3
				+ ones * twos + ones * twos * threes // triplets
				+ getTriplets(ones) + getTriplets(twos) + getTriplets(threes);
		return count;
	}

	private static int getPairs(int n) {
		return n * (n - 1) / 2;
	}

	private static int getTriplets(int n) {
		return n * (n - 1) * (n - 2) / 6;
	}

}
