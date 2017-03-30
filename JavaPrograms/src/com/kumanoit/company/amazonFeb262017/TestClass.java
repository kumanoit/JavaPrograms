package com.kumanoit.company.amazonFeb262017;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

	private static long mod = 1_000_000_000 + 7;

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			String string = in.next();
			System.out.println(getSolution(string.toCharArray(), 0, -1, new char[3]));
			System.out.println(getSolution2(string.toCharArray()));
			in.close();
		} catch (StackOverflowError e) {
			e.printStackTrace();
		}
	}

	private static long getSolution(char[] array, int start, int level, char[] output) {
		long c = 0;
		if (start > array.length) {
			return 0;
		}
		if (level >= 0 && output[level] == 'c') {
			c = 1;
		}
		for (int i = start; i < array.length; i++) {
			if (level == -1 && array[i] == 'a') {
				output[level + 1] = 'a';
				c = (c + getSolution(array, i + 1, level + 1, output)) % mod;
			} else if (level != -1) {
				if (array[i] == output[level]) {
					c = (c + getSolution(array, i + 1, level, output) % mod);
				} else if (array[i] == output[level] + 1) {
					output[level + 1] = array[i];
					c = (c + getSolution(array, i + 1, level + 1, output)) % mod;
				}
			}
		}
		return c;
	}

	private static long getSolution2(char[] array) {
		long count = 0;
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 'a') {
				a.add(i);
			} else if (array[i] == 'b') {
				b.add(i);
			} else {
				c.add(i);
			}
		}
		int i = 0;
		int j = 0;
		int k = 0;
		int lastJ = 0;
		int lastI = 0;
		while (i < a.size()) {
			int coveredA = i - lastI + 1;
			lastI = i;
			while (j < b.size()) {
				if (b.get(j) < a.get(i)) {
					j++;
					continue;
				}
				int coveredB = j - lastJ + 1;
				lastJ = j;
				while (k < c.size()) {
					if (c.get(k) < b.get(j)) {
						k++;
						continue;
					}
					int leftC = (c.size() - k); // adding all later occurring c
					count = (count + leftC * coveredB * coveredA)  %mod;
					break;
				}
				break;
			}
			i++;
		}
		return count;
	}
}
