
//Question : Given N and multiple queries of integers in the range 1 to N, you have to prime factorize for every query.

//T.C: O(Nlog(logN))+O(N)*Q
//S.C:O(N)

package com.firdose.maths;

import java.util.Scanner;

public class PrimeFacMultiQueries {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] queries = new int[q];
		for (int i = 0; i < q; i++) {
			queries[i] = sc.nextInt();
		}
		int spf[] = smallestPrimeFactor(n);
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i];
			if (x <= 1 || x > n) {
				System.out.println("Invalid " + x);
				continue;
			}
			while (x > 1) {
				System.out.print(spf[x] + " ");
				x = x / spf[x];
			}
			System.out.println();
		}

	}

	private static int[] smallestPrimeFactor(int n) {
		int spf[] = new int[n + 1];

		for (int i = 0; i < n; i++) {
			spf[i] = i;
		}
		for (int i = 2; i * i <= n; i++) {
			if (spf[i] == i) {
				for (int j = i * i; j <= n; j += i) {
					spf[j] = Math.min(spf[j], spf[i]);
				}
			}
		}
		return spf;
	}

}
