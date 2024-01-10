
//Leetcode : https://leetcode.com/problems/container-with-most-water/
//	T.C:O(N)
//	S.C:O(1)

package com.firdose.twopointers;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int maxArea = Integer.MIN_VALUE;
		while (i < j) {
			int water = (j - i) * Math.min(height[i], height[j]);
			maxArea = Math.max(maxArea, water);
			if (height[i] <= height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxArea;
	}

}
