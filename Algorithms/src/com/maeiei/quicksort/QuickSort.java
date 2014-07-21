package com.maeiei.quicksort;

public class QuickSort {

	private int[] array;

	public QuickSort(int[] array) {
		this.array = array;
	}

	public void sort() {
		sort(0, array.length - 1);
	}

	private void sort(int start, int end) {
		if (start < end) {
			int mid = partition(start, end);
			sort(start, mid - 1);
			sort(mid + 1, end);
		}
	}

	private int partition(int start, int end) {

		int x = array[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (array[j] <= x) {
				i++;
				exchangeValue(i, j);
			}
		}
		exchangeValue(i + 1, end);

		return i + 1;
	}

	private void exchangeValue(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public int[] getSortedArray() {
		return this.array;
	}
}
