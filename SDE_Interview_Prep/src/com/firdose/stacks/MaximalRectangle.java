
//Leetcode (hard): https://leetcode.com/problems/maximal-rectangle/
//	T.C:O(N^2)
//	S.C: O(N)

package com.firdose.stacks;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] == '0') {
			return 0;
		}
		if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] == '1') {
			return 1;
		}
		char[] charArr = matrix[0];
		int[] arr = new int[charArr.length];
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == '1') {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}

		int histogram = maxHistogramArea(arr);
		int maxRectangleArea = histogram;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					arr[j] += 1;
				} else {
					arr[j] = 0;
				}
			}
			histogram = maxHistogramArea(arr);
			maxRectangleArea = Math.max(maxRectangleArea, histogram);
		}
		return maxRectangleArea;
	}

	private static int maxHistogramArea(int[] nums) {
		int[] nsel = findNextSmallerLeft(nums);
		int[] nser = findNextSmallerRight(nums);

		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int x1 = nsel[i] + 1;
			int x2 = nser[i] - 1;
			int width = x2 - x1 + 1;
			int area = width * nums[i];
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}

	private static int[] findNextSmallerLeft(int[] nums) {
		int n = nums.length;
		int[] arr = new int[n];
//		Arrays.fill(arr, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && nums[i] < nums[stack.peek()]) {
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

	private static int[] findNextSmallerRight(int[] nums) {
		int n = nums.length;
		int[] arr = new int[n];
		// Arrays.fill(arr, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (stack.size() > 0 && nums[i] < nums[stack.peek()]) {
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

}
