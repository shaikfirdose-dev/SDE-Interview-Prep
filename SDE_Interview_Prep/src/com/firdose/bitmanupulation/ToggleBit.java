
//Question: Given numbers n and k, toggle kth bit of number n. Rightmost bit is considered 0th bit and so on.
//
//	T.C:O(1)
//	S.C:O(1)

package com.firdose.bitmanupulation;

import java.util.Scanner;

public class ToggleBit {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(toggleBit(n, k));
	}

	private static int toggleBit(int n, int k) {
		int ans = n ^ (1 << k);
		return ans;
	}
}
