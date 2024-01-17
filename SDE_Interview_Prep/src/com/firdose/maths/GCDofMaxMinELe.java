
//Leetcode: https://leetcode.com/problems/find-greatest-common-divisor-of-array/
//
//T.C:O(N)
//S.C:O(logN)


package com.firdose.maths;

public class GCDofMaxMinELe {

	public int findGCD(int[] nums) {
		int n = nums.length;
		int minEle = Integer.MAX_VALUE;
		int maxEle = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (minEle > nums[i]) {
				minEle = nums[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (maxEle < nums[i]) {
				maxEle = nums[i];
			}
		}
		int ans = helper(maxEle, minEle);
		return ans;

	}

	private static int helper(int a, int b) {
		if (a == 0) {
			return b;
		}
		int temp = helper(b % a, a);
		return temp;
	}

}
