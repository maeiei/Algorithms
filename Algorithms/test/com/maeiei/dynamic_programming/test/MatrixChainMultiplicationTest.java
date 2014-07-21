package com.maeiei.dynamic_programming.test;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.dynamic_programming.MatrixChainMultiplication;

public class MatrixChainMultiplicationTest {

	@Test
	public void testMatrixChainMultiplication() {
		int[] matrixArray = { 30, 35, 15, 5, 10, 20, 25 };

		MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication(
				matrixArray);

		matrixChainMultiplication.matrixChainOrder();
		matrixChainMultiplication.printOptimalParens();
		int[][] costMatrix = matrixChainMultiplication.getCostMatrix();
		int[][] segmentationMatrix = matrixChainMultiplication
				.getSegmentationMatrix();

		for (int i = 0; i < costMatrix.length; i++) {
			Assert.assertEquals(costMatrix[i][i], 0);
		}
		printCostAndSegmentation(costMatrix, segmentationMatrix,
				matrixArray.length - 1);
	}

	@Test
	public void testMatrixChainMultiplicationAgain() {
		int[] matrixArray = { 5, 10, 3, 12, 5, 50, 6 };

		MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication(
				matrixArray);

		matrixChainMultiplication.matrixChainOrder();
		matrixChainMultiplication.printOptimalParens();
		int[][] costMatrix = matrixChainMultiplication.getCostMatrix();
		int[][] segmentationMatrix = matrixChainMultiplication
				.getSegmentationMatrix();

		for (int i = 0; i < costMatrix.length; i++) {
			Assert.assertEquals(costMatrix[i][i], 0);
		}
		printCostAndSegmentation(costMatrix, segmentationMatrix,
				matrixArray.length - 1);
	}

	public void printCostAndSegmentation(int[][] costMatrix,
			int[][] segmentationMatrix, int lineLength) {
		for (int l = 2; l < lineLength + 1; l++) {
			for (int i = 0; i < (lineLength - l + 1); i++) {
				int j = i + l - 1;
				System.out.println("M[" + i + "][" + j + "] = "
						+ costMatrix[i][j]);
			}
		}
		for (int l = 2; l < lineLength + 1; l++) {
			for (int i = 0; i < (lineLength - l + 1); i++) {
				int j = i + l - 1;
				System.out.println("S[" + i + "][" + j + "] = "
						+ segmentationMatrix[i][j]);
			}
		}
	}

	public void testFromArrayToMatrix() {
		int[] matrixArray = { 30, 35, 15, 5, 10, 20, 25 };
		String[] matrixChain = fromArrayToMatrix(matrixArray);
		for (int i = 0; i < matrixChain.length; i++) {
			Assert.assertEquals(matrixChain[i], matrixArray[i] + " * "
					+ matrixArray[i + 1]);
		}
	}

	public String[] fromArrayToMatrix(int[] matrixArray) {
		String[] matrixChain = new String[matrixArray.length - 1];
		for (int i = 0; i < matrixArray.length - 1; i++) {
			matrixChain[i] = matrixArray[i] + " * " + matrixArray[i + 1];
			System.out.println(matrixChain[i]);
		}
		return matrixChain;
	}
}
