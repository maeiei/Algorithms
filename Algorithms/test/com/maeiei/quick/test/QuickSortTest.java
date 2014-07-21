package com.maeiei.quick.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.quicksort.QuickSort;

public class QuickSortTest {

	@Test
	public void testSort() {
		Random random = new Random();
		int[] array = { random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100) };
		print(array);
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		int[] sortedArray = quickSort.getSortedArray();
		print(sortedArray);
		for (int i = 1; i < sortedArray.length; i++) {
			Assert.assertTrue(sortedArray[i - 1] <= sortedArray[i]);
		}
	}

	public void print(int[] array) {
		for (int item : array) {
			System.out.print(item + ",");
		}
		System.out.println();
	}

}
