package com.maeiei.problem;

public class BinarySearch {

	private int[] array;
	private int location = -1;

	public BinarySearch(int[] array) {
		this.array = array;
	}

	public void search(int searchValue) {
		search(searchValue, 0, array.length - 1);
	}

	private void search(int searchValue, int start, int end) {
		if ((end - start) <= 1) {
			if (searchValue == array[start] || searchValue == array[end])
				location = start;
			return;
		} else {
			int middle = (start + end) / 2;
			if (searchValue == array[middle])
				location = middle;
			else if (searchValue < array[middle])
				search(searchValue, start, middle);
			else if (searchValue > array[middle])
				search(searchValue, middle, end);
		}
	}

	public int getLocation() {
		return location;
	}
}
