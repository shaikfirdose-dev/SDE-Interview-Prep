
//GFG: https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
//T.C:O(N)
//S.C:O(1)

package com.firdose.slidingwindow;

import java.util.ArrayList;

public class MaxAllSubarraySumWithSizeK {
	
	
	static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        
        //brute force
        
        // long maxSum = Long.MIN_VALUE;
        // for(int i=0;i<N-K+1;i++){
        //     long sum = 0;
        //     for(int j=i;j<i+K;j++){
        //         sum = sum+Arr.get(j);
        //     }
        //     maxSum = Math.max(maxSum, sum);
        // }
        // return maxSum;
        
        //better solution
        
        // long maxSum = Long.MIN_VALUE;
        // long[] psum = func(Arr, N);
        // long sum = psum[K-1];
        // maxSum = Math.max(maxSum, sum);
        // int start=1;
        // for(int ep=K;ep<N;ep++){
        //     sum = psum[ep]-psum[start-1];
        //     maxSum = Math.max(maxSum, sum);
        //     start++;
        // }
        // return maxSum;
        
        //optimal solution
        
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<K;i++){
            sum = sum+Arr.get(i);
        }
        maxSum = Math.max(maxSum, sum);
        int start = 1;
        int ep = K;
        while(ep<N){
            sum = sum+Arr.get(ep)-Arr.get(start-1);
            maxSum = Math.max(maxSum, sum);
            start++;
            ep++;
        }
        return maxSum;
    }
    
    // public static long[] func(ArrayList<Integer> arr, int n){
    //     long[] psum = new long[n];
    //     psum[0] = arr.get(0);
    //     for(int i=1;i<n;i++){
    //         psum[i] = psum[i-1]+arr.get(i);
    //     }
    //     return psum;
    // }


}
