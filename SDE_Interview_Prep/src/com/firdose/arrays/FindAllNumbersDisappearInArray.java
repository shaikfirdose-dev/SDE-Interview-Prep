package com.firdose.arrays;

import java.util.ArrayList;

//Leetcode(easy):https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//	T.C:O(N)
//	S.C:O(1)

import java.util.List;

public class FindAllNumbersDisappearInArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		List<Integer> ans = new ArrayList<>();
		int j = 0;
		while (j < n) {
			if (nums[j] == j + 1 || nums[j] > n) {
				j++;
			} else {
				int idx = nums[j] - 1;
				if (nums[j] == nums[idx]) {
					j++;
				} else {
					int temp = nums[j];
					nums[j] = nums[idx];
					nums[idx] = temp;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				ans.add(i + 1);
			}
		}
		return ans;
	}

}
