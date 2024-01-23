




//Question: Given N which is even, your task is to create N/2 pairs using numbers {1,2....,N} such that each pair is a co-prime. 
//if not possible return -1
//		
//		T.C: O(NlongN)
//		S.C:O(1)

package com.firdose.maths;

import java.util.Scanner;

public class CoPrimes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n % 2 == 0) {
			for (int i = 1; i < n; i += 2) {
				if (gcd(i, i + 1) == 1) {
					System.out.println(i + " " + (i + 1));
				}

			}
		} else {
			System.out.println(-1);
		}
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		int temp = gcd(b % a, a);
		return temp;
	}

}
