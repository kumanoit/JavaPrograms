package com.kumanoit.arrays.page16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindFourNumbersWith {
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		ArrayList<Integer> maxSub = new ArrayList<Integer>();
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		int start = 0;
		int minStart = a.size();
		int length = 0;
		int maxLength = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) < 0) {
				if (maxSum == sum) {
					if (maxLength > length) {
						minStart = start;
						maxSub.clear();
						for (int k = minStart; k < i; k++) {
							maxSub.add(a.get(k));
						}
					}
				} else if (maxSum < sum) {
					minStart = start;
					maxSub.clear();
					for (int k = minStart; k < i; k++) {
						maxSub.add(a.get(k));
					}
					maxSum = sum;
				}
				sum = 0;
				length = 0;
				start = i + 1;
			} else {
				sum += a.get(i);
				length++;
			}
		}
		if (maxSum == sum) {
			if (maxLength > length) {
				minStart = start;
				maxSub.clear();
				for (int k = minStart; k < a.size(); k++) {
					maxSub.add(a.get(k));
				}
			}
		} else if (maxSum < sum) {
			minStart = start;
			maxSub.clear();
			for (int k = minStart; k < a.size(); k++) {
				maxSub.add(a.get(k));
			}
		}

		return maxSub;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a1 = new ArrayList<Integer>();

		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		a1.add(1967513926);
		a1.add(1540383426);
		a1.add(-1303455736);
		a1.add(-521595368);
//		a1.add(2);
//		a1.add(5);
//		a1.add(1);
//		a1.add(2);
//		a1.add(5);
//		a1.add(-7);
//		a1.add(2);
//		a1.add(5);
		int[] arr = {1967513926, 1540383426, -1303455736, -521595368};
		maxset(a1).forEach(item -> System.out.println(item));

		// List<Integer> a2 = new ArrayList<Integer>();
		// a2.add(5);
		// a2.add(6);
		// a2.add(7);
		// a2.add(8);
		//
		// List<Integer> a3 = new ArrayList<Integer>();
		// a3.add(9);
		// a3.add(10);
		// a3.add(11);
		// a3.add(12);
		// A.get(0).addAll(a1);
		// A.get(1).addAll(a2);
		// A.get(2).addAll(a3);
		//
		// ArrayList<ArrayList<Integer>> B = performOps(A);
		// for (int i = 0; i < B.size(); i++) {
		// for (int j = 0; j < B.get(i).size(); j++) {
		// System.out.print(B.get(i).get(j) + " ");
		// }
		// }

	}

	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < A.size(); i++) {
			B.add(new ArrayList<Integer>());

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).add(0);
			}

			for (int j = 0; j < A.get(i).size(); j++) {
				B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
			}
		}
		return B;
	}

}
