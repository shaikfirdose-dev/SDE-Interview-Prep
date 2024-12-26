
//Leetcode(medium): https://leetcode.com/problems/combinations/description/
//	T.C:O(2^N)
//	S.C:O(2^N)

package com.firdose.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(n, k, new ArrayList<>(), ans);
		return ans;
	}

	public void helper(int n, int k, List<Integer> curr, List<List<Integer>> ans) {
		if (k == 0) {
			ans.add(new ArrayList<>(curr));
			return;
		}
		if (n == 0) {
			return;
		}

		// pick
		curr.add(n);
		helper(n - 1, k - 1, curr, ans);
		curr.remove(curr.size() - 1);
		helper(n - 1, k, curr, ans);

		return;
	}

}
