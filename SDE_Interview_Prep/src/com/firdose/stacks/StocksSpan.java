
//GFG (medium): https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

//T.C:O(N)
//S.C : O(N)

package com.firdose.stacks;

import java.util.Stack;

public class StocksSpan {
	
	// finding stock span
	//in this i used next smaller element left
	// if span is not occured which means it occurs -1th index
	//so span of that element is its index+1

	public static int[] calculateSpan(int price[], int n) {
		
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && price[i] > price[stack.peek()]) {
				int idx = stack.pop();
				price[idx] = idx - i;
			}
			stack.push(i);
		}
		while (stack.size() > 0) {    //here some of the non span stocks present in stack
			int idx = stack.pop();
			price[idx] = idx + 1;
		}
		return price;
	}

}
