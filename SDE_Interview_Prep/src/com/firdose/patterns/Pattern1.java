//input:5
//output:
//		*
//		**
//		***
//		****
//		*****
package com.firdose.patterns;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int nstr = 1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=nstr;j++) {
				System.out.print("* ");
			}
			nstr++;
			System.out.println();
		}
	}

}
