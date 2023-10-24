package com.firdose.functions;

import java.util.Scanner;

public class Factors {

	public static void main(String[] args) {
		Scanner sc  =new Scanner(System.in);
		int num = sc.nextInt();
		int factorCount = factors(num);
		System.out.println(factorCount);
	}
	private static int factors(int num) {
		int count=0;
		for(int i=1;i<=num/i;i++) {
			if(num%i==0) {
				if(i==num/i) {
					count++;
				}
				else {
					count+=2;
				}
			}
		}
		return count;
	}

}
