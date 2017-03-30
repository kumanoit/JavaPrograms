package com.kumanoit.crackingTheCodingInterview.bitManipulation;

public class BitManipulationUtils {

	public static void printBinary(int num, int bitlength) {
		System.out.print("Bit representation for " + num + "\t");
		for (int i = 0; i < bitlength; i++) {
			System.out.print((((1 << i) & num) == 0) ? "0" : "1");
		}
		System.out.println();
	}
}
