
//GFG medium: https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

//Given an array arr[] and an integer K where K is smaller than size of array,
//the task is to find the Kth smallest element in the given array.
//It is given that all array elements are distinct.
//
//
//Note :-  l and r denotes the starting and ending index of the array.

package com.firdose.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
	
	public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   // max heap means maximum element have first priority
        
        for(int i=l;i<k;i++){   // store k elements in heap
            maxHeap.add(arr[i]);
        }
        for(int i=k;i<=r;i++){				// then iterate array from k to n
            if(maxHeap.peek()>arr[i]){		// check heap peek element and current array element
                maxHeap.remove();			// if peek element is bigger then remove element from heap and add current array element to the heap
                maxHeap.add(arr[i]);
            }
        }
        
        return maxHeap.remove();      // return kth smallest element
    }

}
