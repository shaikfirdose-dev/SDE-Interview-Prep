//Question : 
//Take as input n
//
//Print sum of n natural numbers using recursion

package com.firdose.recursion;

import java.util.Scanner;

public class SumOfNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(sum(n));
	}

	private static int sum(int n) {
		if (n == 1) {
			return 1;
		}
		int temp = sum(n - 1);
		return temp + n;
	}

}
