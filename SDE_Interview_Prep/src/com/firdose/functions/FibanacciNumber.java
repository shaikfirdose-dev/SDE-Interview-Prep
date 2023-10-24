package com.firdose.functions;

import java.util.Scanner;

public class FibanacciNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fib(n));

	}
	private static int fib(int n) {
		
		int a = 0;
		int b = 1;
		for(int i=2;i<=n;i++) {
			int temp = a+b;
			a=b;
			b=temp;
		}
		return b;
		
	}

}
