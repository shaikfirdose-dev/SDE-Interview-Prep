
//Leetcode: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//T.C:O(logN)
//S.C:O(1)

package com.firdose.binarysearch;

public class FirstAndLastOccurance {
	public int[] searchRange(int[] nums, int target) {
		int[] ans = { -1, -1 };
		ans[0] = findPosition(nums, target, true); // first occurance
		if (ans[0] != -1) {
			ans[1] = findPosition(nums, target, false); // last occurance
		}
		return ans;
	}

	private static int findPosition(int[] nums, int target, boolean firstOrLastOccu) {
		int start = 0;
		int end = nums.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > target) {
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				ans = mid;
				if (firstOrLastOccu) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return ans;
	}

}
