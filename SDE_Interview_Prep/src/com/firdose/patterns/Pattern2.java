//input : no.of rows
//output:
//		*
//	   **
//	  ***
//	 ****
//	*****

package com.firdose.patterns;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int nstr = 1;
		int nsp = n-1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=nsp;j++) {
				System.out.print("  ");
			}
			for(int k=1;k<=nstr;k++) {
				System.out.print("* ");
			}
			nsp--;
			nstr++;
			System.out.println();
		}

	}

}
