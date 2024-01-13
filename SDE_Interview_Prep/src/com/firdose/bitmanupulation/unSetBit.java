//
//Question : Given numbers n and k, unset the kth bit of number n. Rightmost bit is considered 0th bit and so on.
//
//	T.C: O(1)
//	S.C:O(1)

package com.firdose.bitmanupulation;

import java.util.Scanner;

public class unSetBit {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(unSetBit(n, k));
	}

	private static int unSetBit(int n, int k) {
		if (checkBit(n, k) == true) {
			int ans = n ^ (1 << k);
			return ans;
		}
		return n;

	}

	private static boolean checkBit(int n, int k) {
		if ((n & (1 << k)) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
