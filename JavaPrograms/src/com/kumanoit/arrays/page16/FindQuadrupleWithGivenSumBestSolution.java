package com.kumanoit.arrays.page16;

import java.util.Arrays;

public class FindQuadrupleWithGivenSumBestSolution {

	public static void main(String[] args) {
		findQuadruple(new int[] { 10, 2, 3, 4, 5, 9, 7, 8 }, 23);
	}

	public static void findQuadruple(int[] array, int sum) {
		int n = array.length;
		int k = 0;
		Data[] temp = new Data[n * (n - 1) / 2];
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				temp[k++] = new Data(array[i], array[j], array[i] + array[j]);
			}
		}
		Arrays.sort(temp);
		for (int i = 0; i < k; i++){
			System.out.print(temp[i].sum + ", ");
		}
		System.out.println();
		int i = 0;
		int j = k - 1;
		while (i < j) {
			int total = temp[i].sum + temp[j].sum;
			if (total == sum) {
				if (temp[i].isDifferent(temp[j])) {
					System.out.println(temp[i].x + " + " + temp[i].y + " + " + temp[j].x + " + " + temp[j].y + " = " + total);
				}
				j--;
			} else if (total < sum) {
				i++;
			} else {
				j--;
			}
		}
	}
}

class Data implements Comparable<Data> {
	int x;
	int y;
	int sum;

	Data(int x, int y, int sum) {
		if (x < y) {
			this.x = x;
			this.y = y;
		} else {
			this.x = y;
			this.y = x;
		}
		this.sum = sum;
	}

	public boolean isDifferent(Data data) {
		return !(this.x == data.x || this.x == data.y || this.y == data.x || this.y == data.y);
	}

	public String toString() {
		return this.x + " + " + this.y + " = " + this.sum;
	}

	@Override
	public int compareTo(Data data) {
		if (this.x == data.x) {
			return this.y - data.y;
		} else {
			return this.x - data.x;
		}
	}

}
