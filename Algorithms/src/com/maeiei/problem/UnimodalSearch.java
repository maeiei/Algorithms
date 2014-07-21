package com.maeiei.problem;

import com.maeiei.getting_started.InsertSort;

public class UnimodalSearch {

	private int[] array;
	private int searchedValue;
	private InsertSort insertSort;

	public UnimodalSearch(int[] array) {
		this.array = array;
	}

	public int[] generateArray(int location) {

		getSortedArray();
		int start = location, end = array.length - 1;
		while (start < end) {
			int value = array[start];
			array[start] = array[end];
			array[end] = value;
			start++;
			end--;
		}
		return array;
	}

	private void getSortedArray() {
		insertSort = new InsertSort(array);
		insertSort.sort();
		this.array = insertSort.getSortedArray();
	}

	public int search() {
		int start = 0, end = array.length - 1, middle;
		while (start < end) {
			middle = (start + end) / 2;
			if (array[middle] < array[middle + 1])
				start = middle + 1;
			if (array[middle] > array[middle + 1])
				end = middle;
		}
		return searchedValue = array[start];
	}

	public int getSearchedValue() {
		return searchedValue;
	}
}
