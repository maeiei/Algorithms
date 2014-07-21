package com.maeiei.greedy.test;

import org.junit.Test;

import com.maeiei.greedy.ActivitySelection;
import com.maeiei.greedy.DynamicActivitySelection;

public class ActivitySelectionTest {

	
	public void testActivitySelection() {

		int[] stratTime = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] finishTime = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

		ActivitySelection selection = new ActivitySelection(stratTime,
				finishTime);
		selection.recursiveActivitySelection();
		int[] result = selection.getActivityResult();
		
		for(int i = 0 ; i < result.length;i++){
			if(result[i] == -1){
				System.out.print("A" + (i+1) + ", ");
			}
		}
		selection.greedActivitySelection();
		result = selection.getActivityResult();
		for(int i = 0 ; i < result.length;i++){
			if(result[i] == -1){
				System.out.print("A" + (i+1) + ", ");
			}
		}
	}
	@Test
	public void testDynamicActivitySelection() {
		
		int[] stratTime = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] finishTime = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		
		DynamicActivitySelection selection = new DynamicActivitySelection(stratTime, finishTime);
	
		selection.dynamicActivitySelection();
		
		int[][] orderNumMatrix = selection.getOrderNumMatrix();
		int[][] orderMatrix = selection.getOrderMatrix();
		
		for (int l = 2; l < stratTime.length + 1; l++) {
			for (int i = 0; i < (stratTime.length - l + 1); i++) {
				int j = i + l - 1;
				System.out.print("[" + i + "][" + j + "] = ");
				System.out.print(orderMatrix[i][j] + " ");
			}
			System.out.println();
		}
//		for (int i = 0; i < stratTime.length; i++) {
					
//			for (int j = 1; j < stratTime.length; j++) {
//				System.out.print(orderMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}






