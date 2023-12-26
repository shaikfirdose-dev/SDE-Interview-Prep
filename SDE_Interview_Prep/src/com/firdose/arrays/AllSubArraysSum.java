
//Given an array A with N elements , you need to find the sum all sub arrays of array A. 


//Contribution technique

package com.firdose.arrays;

import java.util.Scanner;

public class AllSubArraysSum {
	
	public static void main(String[] args) {     // this technique is COntribution technique
		Scanner sc = new Scanner(System.in);	// which finds each element contribution
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int totalSum = 0;							//T.C: O(N),  S.C : O(1)
		for (int i = 0; i < n; i++) {
			int occ = (i + 1) * (n - i);   			// (number of valid start points)* (number of valid end points)
			totalSum = totalSum + (arr[i] * occ);	// adding each element contribution
		}
		System.out.println(totalSum);
	}
	
	
	
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
//		int[] prefixSum = findprefixSum(arr);       // This technique is prefix sum technique T.C : O(N^2) S.C :O(N)
//		int totalSum=0;
//		for (int st = 0; st < n; st++) {    // starting point should start from index 0
//			for (int en = st; en < n; en++) {	// ending point starts from start index
//				if(st==0) {	
//					totalSum = totalSum+prefixSum[en];
//				}
//				else {
//					totalSum+= prefixSum[en]-prefixSum[st-1];
//				}
//			}
//		}
//		System.out.println(totalSum);
//		
//	}
//	
//	private static int[] findprefixSum(int[] nums) {
//		int n = nums.length;
//		int[] prefixSum = new int[n];
//		prefixSum[0] =nums[0];
//		for(int i=1;i<n;i++) {
//			prefixSum[i] = prefixSum[i-1]+nums[i];
//		}
//		return prefixSum;
//	}

}
