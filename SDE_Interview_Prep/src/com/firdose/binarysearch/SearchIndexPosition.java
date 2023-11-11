//Question: Leetcode 35
//
//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.

package com.firdose.binarysearch;

import java.util.Scanner;

public class SearchIndexPosition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int k=sc.nextInt();
		System.out.println(searchInsert(arr, k));

	}
	public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // if(n==1){
        //     return 0;
        // }
        int low = 0;
        int high = n-1;
        int index = Integer.MIN_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                index = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        if(index>=0){
            return index+1;
        }
        else{
            return 0;
        }
    }

}
