
//Leetcode : https://leetcode.com/problems/range-sum-query-immutable/description/

//Time Complexity : O(N);
//Space Complexity: O(N);

package com.firdose.arrays;

public class RangeSumQuery {
	int[] prefixSum;
    public RangeSumQuery(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return prefixSum[right];
        }
        else{
            return prefixSum[right]-prefixSum[left-1];
        }
    }

}
