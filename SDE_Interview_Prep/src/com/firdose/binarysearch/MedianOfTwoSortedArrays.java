
//Leetcode (hard): https://leetcode.com/problems/median-of-two-sorted-arrays/

T.C : O(logN)
S.C:O(1)

package com.firdose.binarysearch;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1 > n2) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int low = 0;
		int high = n1;
		int total = n1 + n2;
		while (low <= high) {
			int m1 = (low + high) / 2;
			int m2 = (total + 1) / 2 - m1;
			int am = (m1 == nums1.length) ? Integer.MAX_VALUE : nums1[m1];
			int am1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1 - 1];
			int bm = (m2 == nums2.length) ? Integer.MAX_VALUE : nums2[m2];
			int bm1 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2 - 1];
			if (am1 <= bm && bm1 <= am) {
				if (total % 2 != 0) {
					return Math.max(am1, bm1);
				} else {
					double lmax = Math.max(am1, bm1);
					double rmax = Math.min(am, bm);
					return (lmax + rmax) / 2;
				}
			} else if (am1 > bm) {
				high = m1 - 1;
			} else {
				low = m1 + 1;
			}
		}
		return 0.0;

	}

}
