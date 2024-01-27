

//Leetcode (Hard): https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

//T.C : O(logN)
//S.C : O(1)

package com.firdose.binarysearch;

import java.util.Scanner;

public class FindMinimumInRotatedSortedArray2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(findMin(arr));
	}
	
	public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==nums[low] && nums[mid]==nums[high]){
                if(ans==-1 || nums[ans]>nums[low]){
                    ans = mid;
                }
                low++;
                high--;
            }
            else if(nums[mid]<=nums[high]){
                if(ans==-1 || nums[ans]>nums[mid]){
                    ans = mid;
                }
                high = mid-1;
            }
            else{
                if(ans==-1 || nums[ans]>nums[low]){
                    ans = low;
                }
                low = mid+1;
            }
        }
        return nums[ans];
    }

}
