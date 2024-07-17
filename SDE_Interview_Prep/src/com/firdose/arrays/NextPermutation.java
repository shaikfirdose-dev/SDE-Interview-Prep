
//Leetcode(medium): https://leetcode.com/problems/next-permutation/
//	T.C:O(N)
//	S.C:O(1)

package com.firdose.arrays;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int idx = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				idx = i;
				break;
			}
		}

		if (idx == -1) {
			reverse(nums, 0);
			return;
		} else {
			int val = nums[idx];
			int nextBig = idx + 1;

			for (int i = idx + 1; i < n; i++) {
				if (nums[i] > val && nums[i] <= nums[nextBig]) {
					nextBig = i;
				}
			}

			int temp = nums[idx];
			nums[idx] = nums[nextBig];
			nums[nextBig] = temp;

			// revere the array from idx+1 to n-1
			int st = idx + 1;
			int end = n - 1;
			while (st <= end) {
				int temp1 = nums[st];
				nums[st] = nums[end];
				nums[end] = temp1;
				st++;
				end--;
			}
		}
	}

	private void reverse(int[] nums, int start) {
		int i = start;
		int j = nums.length - 1;
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}
