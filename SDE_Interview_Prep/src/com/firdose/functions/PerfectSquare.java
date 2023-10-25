package com.firdose.functions;

import java.util.Scanner;

public class PerfectSquare {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(perfectSquare(n));

	}
	private static boolean perfectSquare(int n) {
		int ans = 1;
		int initialPerfectSquare = 1;
		while(initialPerfectSquare*initialPerfectSquare<=n) {
			ans = initialPerfectSquare;
			initialPerfectSquare++;
		}
		if(ans*ans == n) {
			return true;
		}
		return false;
	}

}
