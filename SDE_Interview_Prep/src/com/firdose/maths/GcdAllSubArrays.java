
//Question: https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/

//T.C:O(N^2longN)
//S.C:O(logN)

package com.firdose.maths;

public class GcdAllSubArrays {

	public int subarrayGCD(int[] nums, int k) {
		int n = nums.length;
		int count = 0;
		for (int sp = 0; sp < n; sp++) {
			int ans = nums[sp];
			if (ans == k) {
				count++;
			}
			for (int ep = sp + 1; ep < n; ep++) {
				if (nums[ep] < k) {
					break;
				}
				ans = gcd(nums[ep], ans);
				if (ans == k) {
					count++;
				}
			}

		}
		return count;
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		int temp = gcd(b % a, a);
		return temp;
	}

}
