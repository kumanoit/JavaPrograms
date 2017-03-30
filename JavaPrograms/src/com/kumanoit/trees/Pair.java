package com.kumanoit.trees;

public class Pair {
	int inclusive;
	int exclusive;

	public Pair(int inclusive, int exclusive) {
		this.inclusive = inclusive;
		this.exclusive = exclusive;
	}

	public int getInclusive() {
		return inclusive;
	}

	public int getExclusive() {
		return exclusive;
	}

	@Override
	public String toString() {
		return "(" + inclusive + "," + exclusive + ")";
	}
}