package com.firdose.functions;

import java.util.Scanner;

public class SquareRoot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(squareRoot(n));
	}
	private static int squareRoot(int n) {
		int initialSqrt = 1;
		int actualSqrt = 1;
		while(initialSqrt*initialSqrt<=n) {
			actualSqrt = initialSqrt;
			initialSqrt++;
		}
		return actualSqrt;
	}

}
