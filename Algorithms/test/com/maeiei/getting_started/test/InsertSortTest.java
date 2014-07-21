package com.maeiei.getting_started.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.getting_started.InsertSort;

public class InsertSortTest {

	@Test
	public void testSort() {
		Random random = new Random();
		int[] array = { random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100), random.nextInt(100),
				random.nextInt(100), random.nextInt(100) };
		print(array);
		InsertSort insertSort = new InsertSort(array);
		insertSort.sort();
		int[] sortedArray = insertSort.getSortedArray();
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
