package com.maeiei.dynamic_programming.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.maeiei.dynamic_programming.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {

	@Test
	public void test() {

		String[] x = { "A", "B", "C", "B", "D", "A", "B" };
		String[] y = { "B", "D", "C", "A", "B", "A" };

		LongestCommonSubsequence lcs = new LongestCommonSubsequence(x, y);
		lcs.lcsLength();

		int[][] commomMatrix = lcs.getCommomMatrix();
		String[][] signMatrix = lcs.getSignMatrix();

		assertMatrix(commomMatrix);
		assertSign(signMatrix);
		
		lcs.generateSubsequence(x.length, y.length);
		String subsequence = lcs.getLongestCommonSubsequence();
		Assert.assertEquals("BCBA", subsequence);
	}

	private void assertMatrix(int[][] commomMatrix) {
		Assert.assertEquals(4, commomMatrix[7][6]);
		Assert.assertEquals(4, commomMatrix[6][6]);
		Assert.assertEquals(3, commomMatrix[5][5]);
		Assert.assertEquals(3, commomMatrix[4][5]);
		Assert.assertEquals(2, commomMatrix[3][4]);
		Assert.assertEquals(2, commomMatrix[3][3]);
		Assert.assertEquals(1, commomMatrix[2][2]);
		Assert.assertEquals(1, commomMatrix[2][1]);
		Assert.assertEquals(0, commomMatrix[1][0]);
	}

	private void assertSign(String[][] signMatrix) {
		Assert.assertEquals("¡ü", signMatrix[7][6]);
		Assert.assertEquals("¨I", signMatrix[6][6]);
		Assert.assertEquals("¡ü", signMatrix[5][5]);
		Assert.assertEquals("¨I", signMatrix[4][5]);
		Assert.assertEquals("¡û", signMatrix[3][4]);
		Assert.assertEquals("¨I", signMatrix[3][3]);
		Assert.assertEquals("¡û", signMatrix[2][2]);
		Assert.assertEquals("¨I", signMatrix[2][1]);
		Assert.assertEquals(null, signMatrix[1][0]);
	}
}
