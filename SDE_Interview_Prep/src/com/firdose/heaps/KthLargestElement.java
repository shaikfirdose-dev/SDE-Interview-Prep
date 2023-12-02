
//LeetCode 215 : https://leetcode.com/problems/kth-largest-element-in-an-array/description/

//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.

package com.firdose.heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
	
	public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(minHeap.peek()<nums[i]){
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.remove();
        
    }

}
