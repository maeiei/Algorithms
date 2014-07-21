package com.maeiei.getting_started.test;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.maeiei.getting_started.InsertSort;
import com.maeiei.problem.BinarySearch;

public class BinarySearchTest {

	private int[] array;
	private int searchValue;

	@Before
	public void beforSearch() {
		Random random = new Random();
		int[] array = { random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100) };
		searchValue = array[5];
		InsertSort insertSort = new InsertSort(array);
		insertSort.sort();
		int[] sortedArray = insertSort.getSortedArray();
		print(sortedArray);
		this.array = array;
	}

	@Test
	public void testSearch() {
		System.out.println("searchValue = " + searchValue);
		BinarySearch binarySearch = new BinarySearch(array);
		binarySearch.search(searchValue);
		System.out.println(binarySearch.getLocation());
	}

	public void print(int[] array) {
		for (int item : array) {
			System.out.print(item + ",");
		}
		System.out.println();
	}
}
