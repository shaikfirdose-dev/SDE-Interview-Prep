


//LeetCode 295 (Hard): https://leetcode.com/problems/find-median-from-data-stream/description/


package com.firdose.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==minHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        }
        else{
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }
        
    }
    
    public double findMedian() {

        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        return maxHeap.peek()/1.0;
        
    }

}
