package com.maeiei.getting_started.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.problem.UnimodalSearch;

public class UnimodalSearchTest {
	@Test
	public void testSearchByRadomLocation() {
		Random random = new Random();
		int[] array = generateUnimodalArray(random.nextInt(9));
		UnimodalSearch unimodalSearch = new UnimodalSearch(array);
		int searchedValue = unimodalSearch.search();
		System.out.println("searchedValue = " + searchedValue);
	}
	@Test
	public void testSearchByZeroIndex() {
		int[] array = generateUnimodalArray(0);
		UnimodalSearch unimodalSearch = new UnimodalSearch(array);
		int searchedValue = unimodalSearch.search();
		System.out.println("searchedValue = " + searchedValue);
	}
	@Test
	public void testSearchByMaxIndex() {
		int[] array = generateUnimodalArray(9);
		UnimodalSearch unimodalSearch = new UnimodalSearch(array);
		unimodalSearch.search();
		int searchedValue = unimodalSearch.search();
		System.out.println("searchedValue = " + searchedValue);
	}

	public int[] generateUnimodalArray(int location) {
		Random random = new Random();
		int[] array = { random.nextInt(10), random.nextInt(10)+10,
				random.nextInt(10)+20, random.nextInt(10)+30, random.nextInt(10)+40,
				random.nextInt(10)+50, random.nextInt(10)+60, random.nextInt(10)+70,
				random.nextInt(10)+80, random.nextInt(10)+90 };
		System.out.print("Original Array is: ");
		print(array);
		UnimodalSearch unimodalSearch = new UnimodalSearch(array);
		int[] sortedArray = unimodalSearch.generateArray(location);
		System.out.println("location = " + location);
		System.out.print("Unimodal Array is: ");
		print(sortedArray);
		for (int i = 1; i < location; i++) {
			Assert.assertTrue(sortedArray[i - 1] <= sortedArray[i]);
		}
		for (int i = location; i < sortedArray.length - 1; i++) {
			Assert.assertTrue(sortedArray[i] >= sortedArray[i + 1]);
		}
		return sortedArray;
	}

	public void print(int[] array) {
		for (int item : array) {
			System.out.print(item + ",");
		}
		System.out.println();
	}
}
