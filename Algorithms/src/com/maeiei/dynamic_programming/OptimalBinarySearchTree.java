package com.maeiei.dynamic_programming;

public class OptimalBinarySearchTree {

	double[] keyProbability;
	double[] dummyKeyProbability;

	double[][] expectedCost;
	double[][] wholeProbability;
	int[][] root;

	int length = 0;

	public OptimalBinarySearchTree(double[] keyProbability,
			double[] dummyKeyProbability) {
		this.keyProbability = keyProbability;
		this.dummyKeyProbability = dummyKeyProbability;

		length = dummyKeyProbability.length;

		expectedCost = new double[length][length];
		wholeProbability = new double[length][length];
		root = new int[length - 1][length - 1];
	}

	public void optimal_BST() {
		for (int i = 0; i < length; i++) {
			expectedCost[i][i] = dummyKeyProbability[i];
			wholeProbability[i][i] = dummyKeyProbability[i];
		}
		for (int l = 2; l < length + 1; l++) {
			for (int i = 0; i < (length - l + 1); i++) {
				int j = i + l - 1;
				wholeProbability[i][j] = wholeProbability[i][j - 1]
						+ keyProbability[j - 1] + dummyKeyProbability[j];
				for (int r = i; r < j; r++) {
					double t = expectedCost[i][r] + expectedCost[r + 1][j]
							+ wholeProbability[i][j];
					if (t < expectedCost[i][j] || expectedCost[i][j] == 0) {
						expectedCost[i][j] = t;
						root[i][j - 1] = r;
					}
				}
			}
		}
	}

	public void constructoptimal_BST() {
		int treeRoot = root[0][length - 2];
		System.out.println("K" + (treeRoot + 1) + "是根");
		printConstruct(0, treeRoot - 1, treeRoot, "左");
		printConstruct(treeRoot + 1, 4, treeRoot, "右");
	}

	public void printConstruct(int i, int j, int parentNode, String position) {
		int treeRoot = -1;
		if (i <= j) {
			treeRoot = root[i][j];
			System.out.println("K" + (treeRoot + 1) + "是K" + (parentNode + 1)
					+ "的" + position + "孩子");
		}
		if (i != j && i < j) {
			printConstruct(i, treeRoot - 1, treeRoot, "左");
			printConstruct(treeRoot + 1, j, treeRoot, "右");
		}
		if (treeRoot != -1) {
			if (i > treeRoot - 1) {
				System.out.println("D" + treeRoot + "是K" + (treeRoot + 1)
						+ "的左孩子");
			}
			if (treeRoot + 1 > j) {
				System.out.println("D" + (treeRoot + 1) + "是K" + (treeRoot + 1)
						+ "的右孩子");
			}
		}
	}

	public double[][] getExpectedCost() {
		return expectedCost;
	}

	public void setExpectedCost(double[][] expectedCost) {
		this.expectedCost = expectedCost;
	}

	public double[][] getWholeProbability() {
		return wholeProbability;
	}

	public void setWholeProbability(double[][] wholeProbability) {
		this.wholeProbability = wholeProbability;
	}

	public int[][] getRoot() {
		return root;
	}

	public void setRoot(int[][] root) {
		this.root = root;
	}
}
