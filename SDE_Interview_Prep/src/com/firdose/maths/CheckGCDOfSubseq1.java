
//Question: Given an array, check if there exists any subsequence with gcd==1 or not

//T.C:O(NlonN)
//S.C:O(logN)

package com.firdose.maths;

import java.util.Scanner;

public class CheckGCDOfSubseq1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(subSequenceGCDOne(arr));
	}

	private static boolean subSequenceGCDOne(int[] arr) {
		int n = arr.length;
		int ans = Math.abs(arr[0]);
		for(int i=1;i<n;i++) {
			ans = gcdHelper(ans, arr[i]);
		}
		if(ans==1) {
			return true;
		}
		return false;
	}

	private static int gcdHelper(int a, int b) {
		if(a==0) {
			return b;
		}
		int temp = gcdHelper(b%a, a);
		return temp;
	}

}
