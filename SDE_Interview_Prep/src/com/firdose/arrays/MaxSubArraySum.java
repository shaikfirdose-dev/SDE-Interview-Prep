
//Leetcode: https://leetcode.com/problems/maximum-subarray/

// Algo : Kadanes Algo

// T.C : O(N)
// S.C: O(1)

package com.firdose.arrays;

public class MaxSubArraySum {

	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (sum >= 0) {
				sum += nums[i];
			} else {
				sum = nums[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

}
