package com.firdose.bitmanupulation;

import java.util.Scanner;

public class BitsEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n & 1) ==0){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }

	}

}
