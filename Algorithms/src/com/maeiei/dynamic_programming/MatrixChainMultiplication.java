package com.maeiei.dynamic_programming;

public class MatrixChainMultiplication {

	int[] matrixArray;
	int lineLength;
	int[][] costMatrix;
	int[][] segmentationMatrix;
	String[] matrixChain;

	public MatrixChainMultiplication(int[] matrixArray) {
		this.matrixArray = matrixArray;
		lineLength = matrixArray.length - 1;
		costMatrix = new int[lineLength][lineLength];
		segmentationMatrix = new int[lineLength][lineLength];
		matrixChain = new String[lineLength - 1];
		for (int i = 0; i < lineLength - 1; i++) {
			matrixChain[i] = matrixArray[i] + " * " + matrixArray[i + 1];
		}
	}

	public void matrixChainOrder() {
		initializeCostMatrixCatercorner();
		for (int l = 2; l < lineLength + 1; l++) {
			for (int i = 0; i < (lineLength - l + 1); i++) {
				int j = i + l - 1;
				costMatrix[i][j] = -1;
				for (int k = i; k < j; k++) {
					int tempCost = costMatrix[i][k] + costMatrix[k + 1][j]
							+ matrixArray[i] * matrixArray[k + 1]
							* matrixArray[j + 1];
					if (costMatrix[i][j] == -1) {
						costMatrix[i][j] = tempCost;
						segmentationMatrix[i][j] = k;
					} else if (tempCost < costMatrix[i][j]) {
						costMatrix[i][j] = tempCost;
						segmentationMatrix[i][j] = k;
					}
				}
			}
		}
	}

	public void printOptimalParens() {
		print(0, lineLength - 1);
		System.out.println();
	}

	private void print(int i, int j) {
		if (i == j)
			System.out.print("A" + i);
		else {
			System.out.print("(");
			print(i, segmentationMatrix[i][j]);
			print(segmentationMatrix[i][j] + 1, j);
			System.out.print(")");
		}
	}

	public void initializeCostMatrixCatercorner() {
		for (int i = 0; i < costMatrix.length; i++) {
			costMatrix[i][i] = 0;
		}
	}

	public int[] getMatrixArray() {
		return matrixArray;
	}

	public void setMatrixArray(int[] matrixArray) {
		this.matrixArray = matrixArray;
	}

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int lineLength) {
		this.lineLength = lineLength;
	}

	public int[][] getCostMatrix() {
		return costMatrix;
	}

	public void setCostMatrix(int[][] costMatrix) {
		this.costMatrix = costMatrix;
	}

	public int[][] getSegmentationMatrix() {
		return segmentationMatrix;
	}

	public void setSegmentationMatrix(int[][] segmentationMatrix) {
		this.segmentationMatrix = segmentationMatrix;
	}
}
