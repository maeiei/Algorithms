package com.maeiei.dynamic_programming;

public class AssemblyLine {

	int[] lineOne; 
	int[] lineTwo;

	int[][] costBetweenArray;

	int startCostOfOne;
	int startCostOfTwo;

	int endCostOfOne;
	int endCostOfTwo;

	int[] costOne;
	int[] costTwo;

	int[] resultLineOne;
	int[] resultLineTwo;

	int sumCost;
	int lastLine;

	int lineLength;

	public AssemblyLine(int[] lineOne, int[] lineTwo, int[][] costBetweenArray,
			int startCostOfOne, int startCostOfTwo, int endCostOfOne,
			int endCostOfTwo) {

		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.costBetweenArray = costBetweenArray;
		this.startCostOfOne = startCostOfOne;
		this.startCostOfTwo = startCostOfTwo;
		this.endCostOfOne = endCostOfOne;
		this.endCostOfTwo = endCostOfTwo;
		lineLength = lineOne.length;

		costOne = new int[lineLength];
		costTwo = new int[lineLength];
		resultLineOne = new int[lineLength - 1];
		resultLineTwo = new int[lineLength - 1];
	}

	public void fastestWay() {
		costOne[0] = startCostOfOne + lineOne[0];
		costTwo[0] = startCostOfTwo + lineTwo[0];

		for (int j = 1; j < lineLength; j++) {
			if (costOne[j - 1] + lineOne[j] <= costTwo[j - 1] + lineOne[j]
					+ costBetweenArray[1][j - 1]) {
				costOne[j] = costOne[j - 1] + lineOne[j];
				resultLineOne[j - 1] = 1;
			} else {
				costOne[j] = costTwo[j - 1] + lineOne[j]
						+ costBetweenArray[1][j - 1];
				resultLineOne[j - 1] = 2;
			}
			if (costTwo[j - 1] + lineTwo[j] <= costOne[j - 1] + lineTwo[j]
					+ costBetweenArray[0][j - 1]) {
				costTwo[j] = costTwo[j - 1] + lineTwo[j];
				resultLineTwo[j - 1] = 2;
			} else {
				costTwo[j] = costOne[j - 1] + lineTwo[j]
						+ costBetweenArray[0][j - 1];
				resultLineTwo[j - 1] = 1;
			}
		}
		if (costOne[lineLength - 1] + endCostOfOne <= costTwo[lineLength - 1]
				+ endCostOfTwo) {
			sumCost = costOne[lineLength - 1] + endCostOfOne;
			lastLine = 1;
		} else {
			sumCost = costTwo[lineLength - 1] + endCostOfTwo;
			lastLine = 2;
		}
	}

	public void printFastestWay() {
		int lastLine = this.lastLine;
		System.out.println("Station " + lineLength + ", Line " + lastLine);
		for (int i = lineLength - 1; i > 0; i--) {
			if (i == lineLength - 1) {
				if (lastLine == 1) {
					System.out.println("Station " + i + ", Line "
							+ resultLineOne[i - 1]);
					lastLine = resultLineOne[i - 1];
				} else {
					System.out.println("Station " + i + ", Line "
							+ resultLineTwo[i - 1]);
					lastLine = resultLineTwo[i - 1];
				}
			} else {
				if (lastLine == 1) {
					System.out.println("Station " + i + ", Line "
							+ resultLineOne[i - 1]);
				} else {
					System.out.println("Station " + i + ", Line "
							+ resultLineTwo[i - 1]);
				}
			}
		}
	}

	public void printFastestWayByRecursion() {
		printFastestWayByRecursion(6, 1);
		printFastestWayByRecursion(1);
	}

	/**
	 * 递归方式，倒序输出结果
	 * 
	 * @param index
	 * @return
	 */
	public int printFastestWayByRecursion(int index) {
		if (index == lineLength) {
			System.out.println("Station " + lineLength + ", Line " + lastLine);
			return lastLine;
		} else {
			if (printFastestWayByRecursion(index + 1) == 1) {
				System.out.println("Station " + index + ", Line "
						+ resultLineOne[index - 1]);
				return resultLineOne[index - 1];
			} else {
				System.out.println("Station " + index + ", Line "
						+ resultLineTwo[index - 1]);
				return resultLineTwo[index - 1];
			}
		}
	}

	/**
	 * 递归方式，正序输出结果
	 * 
	 * @param index
	 * @param lastLine
	 */
	public void printFastestWayByRecursion(int index, int lastLine) {
		if (index == 1) {
			System.out.println("Station " + index + ", Line " + lastLine);
		} else {
			if (index == 6) {
				printFastestWayByRecursion(index - 1, resultLineOne[index - 2]);
				System.out.println("Station " + index + ", Line " + lastLine);
			} else {
				if (lastLine == 1) {
					printFastestWayByRecursion(index - 1,
							resultLineOne[index - 2]);
					System.out.println("Station " + index + ", Line "
							+ resultLineOne[index - 1]);
				} else {
					printFastestWayByRecursion(index - 1,
							resultLineTwo[index - 2]);
					System.out.println("Station " + index + ", Line "
							+ resultLineTwo[index - 1]);
				}
			}
		}
	}

	public int[] getLineOne() {
		return lineOne;
	}

	public void setLineOne(int[] lineOne) {
		this.lineOne = lineOne;
	}

	public int[] getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(int[] lineTwo) {
		this.lineTwo = lineTwo;
	}

	public int[][] getCostBetweenArray() {
		return costBetweenArray;
	}

	public void setCostBetweenArray(int[][] costBetweenArray) {
		this.costBetweenArray = costBetweenArray;
	}

	public int getStartCostOfOne() {
		return startCostOfOne;
	}

	public void setStartCostOfOne(int startCostOfOne) {
		this.startCostOfOne = startCostOfOne;
	}

	public int getStartCostOfTwo() {
		return startCostOfTwo;
	}

	public void setStartCostOfTwo(int startCostOfTwo) {
		this.startCostOfTwo = startCostOfTwo;
	}

	public int getEndCostOfOne() {
		return endCostOfOne;
	}

	public void setEndCostOfOne(int endCostOfOne) {
		this.endCostOfOne = endCostOfOne;
	}

	public int getEndCostOfTwo() {
		return endCostOfTwo;
	}

	public void setEndCostOfTwo(int endCostOfTwo) {
		this.endCostOfTwo = endCostOfTwo;
	}

	public int[] getCostOne() {
		return costOne;
	}

	public void setCostOne(int[] costOne) {
		this.costOne = costOne;
	}

	public int[] getCostTwo() {
		return costTwo;
	}

	public void setCostTwo(int[] costTwo) {
		this.costTwo = costTwo;
	}

	public int[] getResultLineOne() {
		return resultLineOne;
	}

	public void setResultLineOne(int[] resultLineOne) {
		this.resultLineOne = resultLineOne;
	}

	public int[] getResultLineTwo() {
		return resultLineTwo;
	}

	public void setResultLineTwo(int[] resultLineTwo) {
		this.resultLineTwo = resultLineTwo;
	}

	public int getSumCost() {
		return sumCost;
	}

	public void setSumCost(int sumCost) {
		this.sumCost = sumCost;
	}

	public int getLastLine() {
		return lastLine;
	}

	public void setLastLine(int lastLine) {
		this.lastLine = lastLine;
	}
}
