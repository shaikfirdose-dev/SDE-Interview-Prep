
//Leetcode(medium): https://leetcode.com/problems/combination-sum/
//	T.C:O(2^N)
//	S.C:O(N)

package com.firdose.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(0, candidates, ans, new ArrayList<>(), target);
		return ans;
	}

	private void helper(int index, int[] candidates, List<List<Integer>> ans, List<Integer> combination, int target) {

		if (index == candidates.length) {
			if (target == 0) {
				ans.add(new ArrayList(combination));
			}
			return;
		}
		// pick
		if (target >= candidates[index]) {
			combination.add(candidates[index]);
			helper(index, candidates, ans, combination, target - candidates[index]);
			combination.remove(combination.size() - 1);
		}
		// not pick
		helper(index + 1, candidates, ans, combination, target);

		return;
	}

}
