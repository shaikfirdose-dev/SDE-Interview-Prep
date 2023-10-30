//Question : Given a number n and a value k. From the right, set the kth bit in the
//binary representation of n. The position of LSB(or last bit) is 0, second last
//bit is 1 and so on.
//
//Take the following as input.
//1. A number: N
//2. a Value: K
//
//let us assume 'res' is desired answer.
//
//For Example:
//Input :
//N = 20
//K = 3
//
//Output :
//28
//
//ExplanationL: 20 in binary Number: 10100, After turning on the thirst bit it will become 11100 which is 28 in decimal form.

package com.firdose.bitmanupulation;

import java.util.Scanner;

public class BitSetOn {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int ans = (n | 1 << k);
		System.out.println(ans);

	}

}
