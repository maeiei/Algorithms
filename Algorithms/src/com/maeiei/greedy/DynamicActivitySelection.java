package com.maeiei.greedy;

public class DynamicActivitySelection {

	int[] stratTime;
	int[] finishTime;

	int length;

	int[][] orderNumMatrix;
	int[][] orderMatrix;

	public DynamicActivitySelection(int[] stratTime, int[] finishTime) {
		if (stratTime.length != finishTime.length) {
			throw new IllegalArgumentException("数组长度必须一致");
		} else {
			this.stratTime = stratTime;
			this.finishTime = finishTime;
			length = stratTime.length;
			orderNumMatrix = new int[length][length];
			orderMatrix = new int[length][length];
		}
	}

	public void dynamicActivitySelection() {
		for (int l = 2; l < length + 1; l++) {
			for (int i = 0; i < (length - l + 1); i++) {
				int j = i + l - 1;
				System.out.println("[" + i + "][" + j + "]");
				for (int k = i + 1; k < j - 1; k++) {
					if (finishTime[i] <= stratTime[k]
							&& finishTime[k] <= stratTime[j]) {
						int q = orderNumMatrix[i][k] + orderNumMatrix[k][j] + 1;
						if (q > orderNumMatrix[i][j]) {
							orderNumMatrix[i][j] = q;
							orderMatrix[i][j] = k;
						}
					}
				}
			}
		}
	}

	public int[][] getOrderNumMatrix() {
		return orderNumMatrix;
	}

	public void setOrderNumMatrix(int[][] orderNumMatrix) {
		this.orderNumMatrix = orderNumMatrix;
	}

	public int[][] getOrderMatrix() {
		return orderMatrix;
	}

	public void setOrderMatrix(int[][] orderMatrix) {
		this.orderMatrix = orderMatrix;
	}
}
