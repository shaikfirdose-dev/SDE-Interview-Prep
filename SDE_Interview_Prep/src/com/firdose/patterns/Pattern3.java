//Take as input a number n, the number of rows
//Print the following pattern
//  *
// ***
//*****
// ***
//  *
//for n = 5.
package com.firdose.patterns;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nstr = 1;
		int nsp = n/2;
		for(int i=1;i<=n;i++) {
			if(i<=n/2) {
				for(int j=1;j<=nsp;j++) {
					System.out.print("  ");
				}
				for(int k=1;k<=nstr;k++) {
					System.out.print("* ");
				}
				nsp--;
				nstr+=2;
				System.out.println();
			}
			else {
				for(int j=1;j<=nsp;j++) {
					System.out.print("  ");
				}
				for(int k=1;k<=nstr;k++) {
					System.out.print("* ");
				}
				nsp++;
				nstr-=2;
				System.out.println();
			}
		}
		

	}

}
