
//Leetcode(Easy): https://leetcode.com/problems/running-sum-of-1d-array/

package com.firdose.arrays;

public class PrefixSumAlgo {
	
	public int[] runningSum(int[] nums) {
        int n = nums.length;
        int prefixSum[] = new int[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){                       //O(N)->time complexity
            prefixSum[i] = prefixSum[i-1]+nums[i];	//O(1)->Space complexity
        }
        return prefixSum;


        //O(N^2) -> time complexity
        //O(1)-> space complexity
        
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=0;j<=i;j++){
        //         sum = sum+nums[j];
        //     }
        //     prefixSum[i] = sum;
        // }
        // return prefixSum;
    }

}
