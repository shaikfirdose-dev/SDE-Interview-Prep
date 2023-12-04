package com.firdose.heaps;

import java.util.PriorityQueue;

public class MinimizeTheSum {
	
	long minimizeSum(int N, int arr[]) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            minHeap.add(arr[i]);
        }
        
        long ans = 0;
        
        while(minHeap.size()>1){
            long temp1 = minHeap.remove();
            long temp2 = minHeap.remove();
            long sum = ans + (temp1+temp2);
            ans = sum;
            minHeap.add((int)(temp1+temp2));
        }
        return ans;
    }

}
