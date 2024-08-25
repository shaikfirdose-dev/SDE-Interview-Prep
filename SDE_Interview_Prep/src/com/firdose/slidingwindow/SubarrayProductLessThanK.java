
//Leetcode (medium):https://leetcode.com/problems/subarray-product-less-than-k/?envType=daily-question&envId=2024-08-22

package com.firdose.slidingwindow;

public class SubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		int n = nums.length;
		int i = 0;
		int j = 0;
		int product = 1;
		int count = 0;
		while (j < n) {
			product = product * nums[j];

			while (product >= k) {
				product = product / nums[i++];
			}

			count = count + j - i + 1;
			j++;
		}

		return count;
	}

}
