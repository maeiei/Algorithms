package com.maeiei.greedy;

public class ActivitySelection {

	int[] stratTime;
	int[] finishTime;

	int length;

	int[] activityResult;

	public ActivitySelection(int[] stratTime, int[] finishTime) {
		if (stratTime.length != finishTime.length) {
			throw new IllegalArgumentException("数组长度必须一致");
		} else {
			this.stratTime = stratTime;
			this.finishTime = finishTime;
			length = stratTime.length;
			activityResult = new int[length];
		}
	}

	public void greedActivitySelection() {
		activityResult[0] = -1;
		for (int m = 1, i = 0; m < length; m++) {
			if (stratTime[m] >= finishTime[i]) {
				activityResult[m] = -1;
				i = m;
			}
		}
	}

	public void recursiveActivitySelection() {
		activityResult[0] = -1;
		selection(0, length);
	}

	private void selection(int i, int j) {
		int m = i;
		while (m < j && stratTime[m] < finishTime[i]) {
			m++;
		}
		if (m < j) {
			activityResult[m] = -1;
			selection(m, j);
		}
	}

	public int[] getActivityResult() {
		return activityResult;
	}

	public void setActivityResult(int[] activityResult) {
		this.activityResult = activityResult;
	}
}
