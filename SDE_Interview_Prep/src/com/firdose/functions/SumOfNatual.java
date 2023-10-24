package com.firdose.functions;

import java.util.Scanner;

public class SumOfNatual {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sumOfNaturalNumbers = (n*(n+1))/2;
		System.out.println(sumOfNaturalNumbers);
	}

}
