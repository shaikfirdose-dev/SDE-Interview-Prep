
//Leetcode (medium): https://leetcode.com/problems/subsets/description/
//	T.C:O(2^N * N)
//	S.C: O(2^N * N)

package com.firdose.bitmanupulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		int totalno = 1 << n;
		for (int i = 0; i < totalno; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (checkBit(i, j) == true) {
					list.add(nums[j]);
				}
			}
			ans.add(list);
		}
		return ans;
	}

	private static boolean checkBit(int n, int k) {
		if ((n & (1 << k)) != 0) {
			return true;
		}
		return false;
	}

}
