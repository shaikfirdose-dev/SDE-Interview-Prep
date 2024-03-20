
//Leetcode(medium): https://leetcode.com/problems/subarray-sum-equals-k/
//T.C: O(N)
//S.C:O(N)

package com.firdose.hashmap;

import java.util.HashMap;

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		int[] psum = func(nums);
		int ans = 0;
		for (int ep = 0; ep < nums.length; ep++) {
			int diff = psum[ep] - k;
			ans = ans + hm.getOrDefault(diff, 0);
			hm.put(psum[ep], hm.getOrDefault(psum[ep], 0) + 1);
		}
		return ans;
	}

	public int[] func(int[] arr) {
		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}
		return prefixSum;
	}

}
