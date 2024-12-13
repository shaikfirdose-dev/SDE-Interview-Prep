package com.firdose.backtracking;

import java.util.ArrayList;

//Leetcode(medium): https://leetcode.com/problems/permutations
//	T.C:O(N!)
//	S.C:O(N)

//optimal solution

import java.util.List;

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		helper(nums, new ArrayList<>(), ans);
		return ans;
	}

	public void helper(int[] nums, List<Integer> per, List<List<Integer>> ans) {
		if (per.size() == nums.length) {
			ans.add(new ArrayList<>(per));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (per.contains(nums[i])) {
				continue;
			}
			per.add(nums[i]);
			helper(nums, per, ans);
			per.remove(per.size() - 1);
		}
		return;
	}

}
