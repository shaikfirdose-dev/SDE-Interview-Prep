
//Leetcode: https://leetcode.com/problems/kth-largest-element-in-a-stream/

package com.firdose.heaps;

import java.util.PriorityQueue;

public class DesignKthLargestElement {

	static class KthLargest {
	    private PriorityQueue<Integer> pq;
	    private int k;

	    public KthLargest(int k, int[] nums) {
	        pq = new PriorityQueue<>();
	        this.k = k;
	        for(int i : nums){
	            add(i);
	        }
	    }
	    
	    public int add(int val) { 
	        if(pq.size() < k){
	            pq.add(val);
	        }
	        else if(pq.peek() < val){
	            pq.remove();
	            pq.add(val);
	        }
	        return pq.peek();
	    }
	}

}
