
//Leetcode : https://leetcode.com/problems/largest-rectangle-in-histogram/
//	
//	T.C:O(3N)=O(n)
//	S.C:O(N)


package com.firdose.stacks;

import java.util.Stack;

public class LargestRectangleHistogram {

	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] nser = func1(heights);
		int[] nsel = func2(heights);
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int ht = heights[i];
			int nsl = nsel[i] + 1;
			int nsr = nser[i] - 1;
			int width = nsr - nsl + 1;
			int area = width * ht;
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	private static int[] func1(int[] heights) {
		int n = heights.length;
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (stack.size() > 0 && heights[i] < heights[stack.peek()]) {
				int idx = stack.pop();
				arr[idx] = i;
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			int idx = stack.pop();
			arr[idx] = n;
		}
		return arr;
	}

	private static int[] func2(int[] heights) {
		int n = heights.length;
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && heights[i] < heights[stack.peek()]) {
				int idx = stack.pop();
				arr[idx] = i;
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			int idx = stack.pop();
			arr[idx] = -1;
		}
		return arr;
	}

}
