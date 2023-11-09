//Given a non-negative integer n, return the square root of x rounded down to the nearest integer.You must not use any built-in exponent function.
//
//Your solution must run in O(log n) time and O(1) space.


package com.firdose.binarysearch;

import java.util.Scanner;

public class SqrtNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sqrt(n));
	}

	private static int sqrt(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int l = 2;
		int h = n;
		int ans = Integer.MIN_VALUE;
		while (l <= h) {
			int mid = (l + h) / 2;
			if ((mid * mid) == n) {
				return mid;
			} else if ((mid * mid) < n) {
				ans = mid;
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return ans;
	}

}
