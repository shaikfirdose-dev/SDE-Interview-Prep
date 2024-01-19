
//GFG: https://www.geeksforgeeks.org/problems/sieve-of-eratosthenes5242/1?utm_source=gfg

//T.C:O(Nlong(logN))=O(N)
//S.C:O(N)


package com.firdose.maths;

import java.util.ArrayList;
import java.util.Scanner;

public class SeiveOfEratosthenesPrime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sieveOfEratosthenes(n));
	}

	static ArrayList<Integer> sieveOfEratosthenes(int N) {
		
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		boolean[] arr = new boolean[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = true;
		}
		arr[0] = arr[1] = false;
		for (int i = 2; i * i <= N; i++) {
			if (arr[i] == true) {
				for (int j = i * i; j <= N; j += i) {
					arr[j] = false;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if (arr[i] == true) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}

}
