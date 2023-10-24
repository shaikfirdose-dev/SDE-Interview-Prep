//ncr=n!/r!*(n-r)!
//npr = n!/(n-r)!

package com.firdose.functions;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		int ncr = fact(n)/(fact(r)*fact(n-r));
		System.out.println(ncr);
	}
	private static int fact(int n) {
		int ans = 1;
		for(int i=1;i<=n;i++) {
			ans = ans*i;
		}
		return ans;
	}

}
