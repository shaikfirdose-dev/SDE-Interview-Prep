package com.firdose.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinaryNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		generateBinaryNumbers(n);
	}

	private static void generateBinaryNumbers(int n) {
		Queue<String> q = new LinkedList<>();
		q.add("1");
		while (n-- > 0) {
			String rem = q.remove();
			System.out.println(rem);
			q.add(rem + "0");
			q.add(rem + "1");
		}
	}

}
