
//Leetcode(easy):https://leetcode.com/problems/merge-sorted-array/
//	T.C:O(m+n)
//	S.C:O(1)

package com.firdose.arrays;

public class MergeTwoSortedArraysWithoutSpace {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				k--;
				i--;
			} else {
				nums1[k] = nums2[j];
				k--;
				j--;
			}
		}

		return;
	}

}
