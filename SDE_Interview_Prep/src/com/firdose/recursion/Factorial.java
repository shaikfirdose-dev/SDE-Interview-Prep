//Question: 
//	Take as input n
//
//	Print n!

package com.firdose.recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fact(n));

	}

	private static int fact(int n) {
		if (n == 0) {
			return 1;
		}

		int temp = fact(n - 1);
		return temp * n;
	}

}
