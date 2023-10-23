//Take as input a number n, the number of rows
//Print the following pattern
//    1
//  2 3 2
//3 4 5 4 3
//  2 3 2
//    1
//for n = 5.
 
package com.firdose.patterns;

import java.util.Scanner;

public class Pattern5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nval = 1;
		int nsp = n/2;
		int count=1;
		for(int i=1;i<=n;i++) {
			if(i<=n/2) {
				count=i;
			}
			else {
				count = n-i+1;
			}
			for(int j=1;j<=nsp;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=nval;k++) {
				System.out.print(count);
				if(k <= nval/2) {
					count++;
				}
				else {
					count--;
				}
			}
			if(i<=n/2) {
				nsp--;
				nval+=2;
				System.out.println();
			}
			else {
				nsp++;
				nval-=2;
				System.out.println();
			}
		}

	}

}
