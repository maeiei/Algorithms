package com.maeiei.dynamic_programming.test;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.dynamic_programming.OptimalBinarySearchTree;

public class OptimalBinarySearchTreeTest {

	@Test
	public void test() {

		double[] keyProbability = { 0.15, 0.1, 0.05, 0.1, 0.2 };
		double[] dummyKeyProbability = { 0.05, 0.1, 0.05, 0.05, 0.05, 0.1 };
		int length = 6;
		OptimalBinarySearchTree optimal = new OptimalBinarySearchTree(
				keyProbability, dummyKeyProbability);

		optimal.optimal_BST();
		optimal.constructoptimal_BST();

		double[][] expectedCost = optimal.getExpectedCost();
		double[][] wholeProbability = optimal.getWholeProbability();
		int[][] root = optimal.getRoot();
		
		

		for (int i = 0; i < length; i++) {
			Assert.assertEquals("dummyKeyProbability[i] == expectedCost[i][i]",
					dummyKeyProbability[i], expectedCost[i][i], 0.0);
			Assert.assertEquals(
					"dummyKeyProbability[i] == wholeProbability[i][i]",
					dummyKeyProbability[i], wholeProbability[i][i], 0.0);
		}
//		for (int l = 2; l < length + 1; l++) {
//			for (int i = 0; i < (length - l + 1); i++) {
//				int j = i + l - 1;
//				System.out.println("expectedCost[" + i + "][" + j + "] = "
//						+ expectedCost[i][j]);
//				System.out.println("wholeProbability[" + i + "][" + j + "] = "
//						+ wholeProbability[i][j]);
//				System.out.println("root[" + i + "][" + (j - 1) + "] = "
//						+ root[i][j - 1]);
//			}
//		}
	}
}
