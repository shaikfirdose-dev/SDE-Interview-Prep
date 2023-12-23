
//Leetcode: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/

//T.C: O(N)
//S.C: O(1)


package com.firdose.arrays;

public class NumberofSubArrays {
	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		int n = nums.length;
		int ans = 0;
		int lgei = 0;
		int previousValidCount = 0;

		for (int end = 0; end < n; end++) {
			if (nums[end] > right) {
				ans = ans + 0;
				lgei = end + 1;
				previousValidCount = 0;
			} else if (nums[end] >= left && nums[end] <= right) {
				ans = ans + (end - lgei + 1);
				previousValidCount = end - lgei + 1;
			} else {
				ans += previousValidCount;
			}
		}
		return ans;
	}

}
