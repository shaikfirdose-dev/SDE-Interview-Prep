



//Leetcode : https://leetcode.com/problems/find-pivot-index/

package com.firdose.arrays;

public class PivotIndex {
	
	public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = helper(nums);
        
        for (int i = 0; i < n; i++) {
            int leftSum = i > 0 ? prefixSum[i - 1] : 0;               // given element index should be greater than zero because if the index is zero before index zero there is no elements present which is negative index, so sum should be zero
            int rightSum = prefixSum[n - 1] - prefixSum[i];			//for right sum get prefix sum of n-1th index then remove prefix sum of current index then we should get right sum

            if (leftSum == rightSum) {			// if both equals then it should be at pivot index
                return i;
            }
        }

        return -1;							// if no pivot present then return -1
    }
    private static int[] helper(int[] nums){      // finding prefix sum of the each element in an array
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        return prefixSum;
    }

}
