package com.maeiei.dynamic_programming.test;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.dynamic_programming.AssemblyLine;

public class AssemblyLineTest {

	@Test
	public void testAssemblyLine() {
		int[] lineOne = { 7, 9, 3, 4, 8, 4 };
		int[] lineTwo = { 8, 5, 6, 4, 5, 7 };

		int[][] costBetweenArray = { { 2, 3, 1, 3, 4 }, { 2, 1, 2, 2, 1 } };

		int startCostOfOne = 2;
		int startCostOfTwo = 4;

		int endCostOfOne = 3;
		int endCostOfTwo = 2;

		AssemblyLine assemblyLine = new AssemblyLine(lineOne, lineTwo,
				costBetweenArray, startCostOfOne, startCostOfTwo, endCostOfOne,
				endCostOfTwo);

		assemblyLine.fastestWay();

		int[] costOne = assemblyLine.getCostOne();
		int[] costTwo = assemblyLine.getCostTwo();

		int[] resultLineOne = assemblyLine.getResultLineOne();
		int[] resultLineTwo = assemblyLine.getResultLineTwo();

		int sumCost = assemblyLine.getSumCost();
		int lastLine = assemblyLine.getLastLine();

		print(costOne, "costOne");
		print(costTwo, "costTwo");
		print(resultLineOne, "resultLineOne");
		print(resultLineTwo, "resultLineTwo");

		Assert.assertEquals(sumCost, 38);
		Assert.assertEquals(lastLine, 1);
		
		assemblyLine.printFastestWay();
		assemblyLine.printFastestWayByRecursion();
	}

	public void print(int[] array, String arrayName) {
		System.out.println(arrayName);
		for (int item : array) {
			System.out.print(item + ",");
		}
		System.out.println();
	}
}
