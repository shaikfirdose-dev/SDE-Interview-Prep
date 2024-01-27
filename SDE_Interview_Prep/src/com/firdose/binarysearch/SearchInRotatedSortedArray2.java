

//Leetcode : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//	T.C :O(logN)
//	S.c: O(1)


package com.firdose.binarysearch;

import java.util.Scanner;

public class SearchInRotatedSortedArray2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(search(arr, target));
	}
	

	private static boolean search(int[] arr, int target) {
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(arr[mid]==target) {
				return true;
			}
			if(arr[mid]==arr[low] && arr[mid]==arr[high]) {
				low++;
				high--;
			}
			else if(arr[mid]<=arr[high]) {
				if(target > arr[mid] && target <= arr[high]) {
					low = mid+1;
				}
				else {
					high = mid-1;
				}
			}
			else {
				if(target >= arr[low] && target < arr[mid]) {
					high = mid-1;
				}
				else {
					low = mid+1;
				}
			}
		}
		return false;
	}

}
