
//Leetcode  (medium) :https://leetcode.com/problems/find-all-duplicates-in-an-array/?envType=daily-question&envId=2024-03-25
//	T.C: O(N)
//	S.C:O(1)

package com.firdose.leetcode.daily.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;
		int i = 0;
		while (i < n) {
			if (nums[i] - 1 == i) {
				i++;
			} else {
				int idx = nums[i] - 1;
				if (nums[i] == nums[idx]) {
					i++;
				} else {
					int temp = nums[i];
					nums[i] = nums[idx];
					nums[idx] = temp;
				}
			}
		}

		for (int j = 0; j < n; j++) {
			if (j != nums[j] - 1) {
				ans.add(nums[j]);
			}
		}

		return ans;

	}

}
