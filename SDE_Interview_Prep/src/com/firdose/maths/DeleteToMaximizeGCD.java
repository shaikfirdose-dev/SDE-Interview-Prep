

//Question: Given an array, we have to delete 1 element such that gcd of array is maximum

//T.C: O(NlogN)
//S.C:O(N)

package com.firdose.maths;

import java.util.Scanner;

public class DeleteToMaximizeGCD {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(DeleteToMaximize(arr));
	}

	private static int DeleteToMaximize(int[] arr) {
		int n = arr.length;
		int prefixGcd[] = func1(arr);
		int suffixGcd[] = func2(arr);
		int ans = Integer.MIN_VALUE;
		for(int i=1;i<n-1;i++) {
			int left = prefixGcd[i-1];
			int right = suffixGcd[i+1];
			int temp = gcd(left, right);
			ans = Math.max(ans, temp);
		}
		return ans;
	}
	
	private static int gcd(int a, int b) {
		if(a==0) {
			return b;
		}
		int temp = gcd(b%a, a);
		return temp;
	}
	private static int[] func1(int[] arr) {
		int n = arr.length;
		int []prefixGcd = new int[n];
		prefixGcd[0]=arr[0];
		for(int i=1;i<n;i++) {
			prefixGcd[i] = gcd(prefixGcd[i-1], arr[i]);
		}
		return prefixGcd;
	}
	
	private static int[] func2(int[] arr) {
		int n = arr.length;
		int []suffixGcd = new int[n];
		suffixGcd[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--) {
			suffixGcd[i] = gcd(suffixGcd[i+1], arr[i]);
		}
		return suffixGcd;
	}

}
