//
//Leetcode(medium): https://leetcode.com/problems/subsets-ii/
//	T.C:O(2^N)
//	S.C:O(2^N)

package com.firdose.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		int n = nums.length;
		int totalNo = 1 << n;
		Set<List<Integer>> ans = new HashSet<>();
		for (int i = 0; i < totalNo; i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (checkBit(i, j)) {
					subset.add(nums[j]);
				}
			}
			Collections.sort(subset);
			ans.add(subset);
		}
		List<List<Integer>> result = new ArrayList(ans);
		return result;
	}

	private boolean checkBit(int n, int k) {
		if ((n & (1 << k)) != 0) {
			return true;
		}
		return false;
	}

}
