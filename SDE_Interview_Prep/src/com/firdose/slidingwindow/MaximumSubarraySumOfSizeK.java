
//Leetcode(medium): https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarraySumOfSizeK {

	public long maximumSubarraySum(int[] nums, int k) {
		int n = nums.length;
		if (n < k || n == 0) {
			return 0;
		}
		long maxSum = 0;
		long currSum = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < k; i++) {
			currSum = currSum + nums[i];
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}
		if (hm.size() == k) {
			maxSum = currSum;
		}

		for (int i = k; i < n; i++) {
			// release
			int outElement = nums[i - k];
			currSum -= outElement;
			hm.put(outElement, hm.get(outElement) - 1);
			if (hm.get(outElement) == 0) {
				hm.remove(outElement);
			}

			// aquire
			int inElement = nums[i];
			currSum += inElement;
			hm.put(inElement, hm.getOrDefault(inElement, 0) + 1);

			if (hm.size() == k) {
				maxSum = Math.max(maxSum, currSum);
			}
		}
		return maxSum;
	}

}
