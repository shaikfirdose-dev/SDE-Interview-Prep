//input : no.of rows
//output: 
//		*** ***
//		**   **
//		*     *
//		**   **
//		*** ***
package com.firdose.patterns;

import java.util.Scanner;

public class Pattern4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int  n = sc.nextInt();
		int nsp = 1;
		int nstr = (n/2)+1;
		for(int i=1;i<=n;i++) {
			if(i<=n/2) {
				for(int j=1;j<=nstr;j++) {
					System.out.print("*");
				}
				for(int k=1;k<=nsp;k++) {
					System.out.print(" ");
				}
				for(int j=1;j<=nstr;j++) {
					System.out.print("*");
				}
				nsp+=2;
				nstr--;
				System.out.println();
			}
			else {
				for(int j=1;j<=nstr;j++) {
					System.out.print("*");
				}
				for(int k=1;k<=nsp;k++) {
					System.out.print(" ");
				}
				for(int j=1;j<=nstr;j++) {
					System.out.print("*");
				}
				nsp-=2;
				nstr++;
				System.out.println();
			}
		}

	}

}
