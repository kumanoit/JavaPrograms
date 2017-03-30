package com.kumanoit.company.amazonFeb262017;

import java.util.Scanner;

public class XOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		while (tc > 0) {
			int n = in.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = in.nextInt();
			}
			System.out.println(getSolution(array, n));
			tc--;
		}
		in.close();
	}

	private static int getSolution(int[] array, int n) {
		int xor = 0;
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total = i * (n - (i - 1));
			System.out.println(">> " + total);
			if ((total & 1) != 0) {
				xor ^= array[i - 1];
			}
		}
		return xor;
	}
}
