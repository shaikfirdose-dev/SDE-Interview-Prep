//Question:
//
//Take as input a number n.  
//Print the nth number of Fibonacci sequence where  
//0th Fibonacci is 0 and 1st Fibonacci is 1. Here is a sample  
//0 1 1 2 3 5 8 13 21 34 55


package com.firdose.recursion;

import java.util.Scanner;

public class FibanacciNumber {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fib(n));
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int temp1 = fib(n - 1);
		int temp2 = fib(n - 2);
		return temp1 + temp2;

	}

}
