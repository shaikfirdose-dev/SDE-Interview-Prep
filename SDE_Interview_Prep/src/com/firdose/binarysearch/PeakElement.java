//
//Question:	Leetcode 162
//	A peak element is an element that is strictly greater than its neighbors.
//
//	Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
//
//	You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
//
//	You must write an algorithm that runs in O(log n) time

//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

package com.firdose.binarysearch;

import java.util.Scanner;

public class PeakElement {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(peakElement(arr, n));
	}
	private static int peakElement(int[] arr, int n) {
		if(n==1) {   // when array length 1 then result will be the zero because it is between -infinity<arr[0]>+infinity
			return 0;
		}
		
		if(arr[0]>arr[1]) { //when 0th index element is greater than 1st index element
			return 0;       // Edge case1
		}
		if(arr[n-1]>arr[n-2]) {//edge case 2
			return n-1;
		}
		
		int low = 1; //search sapce should between 1 to n-2
		int high = n-2;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {     //mid element should be greater than it's neighbours
				return mid;
			}
			else if(arr[mid-1]>arr[mid]) { //when mid-1th element greater than mid then discard right side
				high = mid-1;
			}
			else {         // when mid+1th element greater than mid then discard left side
				low = mid+1;
			}
		}
		return -1;
	}

}
