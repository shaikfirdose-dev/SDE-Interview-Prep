
//Question : Given N integers, Calculate the GCD of all the numbers

//T.C : O((NlogN))
//S.C:O(logN);

package com.firdose.maths;

import java.util.Scanner;

public class GCDOfArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(gcdArr(arr));
	}

	private static int gcdArr(int[] arr) {
		int n = arr.length;
		int ans = Math.abs(arr[0]);
		for (int i = 1; i < n; i++) {
			ans = gcd(ans, arr[i]);
		}
		return ans;
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}

		int temp = gcd(b % a, a);
		return temp;
	}

}
