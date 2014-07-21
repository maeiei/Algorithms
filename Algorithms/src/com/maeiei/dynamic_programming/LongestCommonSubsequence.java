package com.maeiei.dynamic_programming;

public class LongestCommonSubsequence {

	String[] x;
	String[] y;

	int[][] commomMatrix;
	String[][] signMatrix;

	String longestCommonSubsequence = "";

	public LongestCommonSubsequence(String[] x, String[] y) {
		this.x = x;
		this.y = y;
		commomMatrix = new int[x.length + 1][y.length + 1];
		signMatrix = new String[x.length + 1][y.length + 1];
	}

	public void lcsLength() {
		for (int i = 0; i < commomMatrix.length; i++)
			commomMatrix[i][0] = 0;
		for (int j = 0; j < commomMatrix[0].length; j++)
			commomMatrix[0][j] = 0;

		for (int i = 1; i < commomMatrix.length; i++) {
			for (int j = 1; j < commomMatrix[i].length; j++) {
				if (x[i - 1] == y[j - 1]) {
					commomMatrix[i][j] = commomMatrix[i - 1][j - 1] + 1;
					signMatrix[i][j] = "¨I";
				} else {
					if (commomMatrix[i - 1][j] >= commomMatrix[i][j - 1]) {
						commomMatrix[i][j] = commomMatrix[i - 1][j];
						signMatrix[i][j] = "¡ü";
					} else {
						commomMatrix[i][j] = commomMatrix[i][j - 1];
						signMatrix[i][j] = "¡û";
					}
				}
			}
		}
	}

	public void generateSubsequence(int i, int j) {
		if (i == 0 || j == 0)
			return;
		if ("¨I".equals(signMatrix[i][j])) {
			generateSubsequence(i - 1, j - 1);
			longestCommonSubsequence += x[i - 1];
		} else if ("¡ü".equals(signMatrix[i][j])) {
			generateSubsequence(i - 1, j);
		} else {
			generateSubsequence(i, j - 1);
		}
	}

	public String[] getX() {
		return x;
	}

	public void setX(String[] x) {
		this.x = x;
	}

	public String[] getY() {
		return y;
	}

	public void setY(String[] y) {
		this.y = y;
	}

	public int[][] getCommomMatrix() {
		return commomMatrix;
	}

	public void setCommomMatrix(int[][] commomMatrix) {
		this.commomMatrix = commomMatrix;
	}

	public String[][] getSignMatrix() {
		return signMatrix;
	}

	public void setSignMatrix(String[][] signMatrix) {
		this.signMatrix = signMatrix;
	}

	public String getLongestCommonSubsequence() {
		return longestCommonSubsequence;
	}

	public void setLongestCommonSubsequence(String longestCommonSubsequence) {
		this.longestCommonSubsequence = longestCommonSubsequence;
	}

}
