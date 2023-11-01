package com.firdose.hashmap;

import java.util.HashSet;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
	    int n= sc.nextInt();
	    int[] x =new int[n];
	    int[] y =new int[n];
	    for(int i=0;i<n;i++){
	        x[i] = sc.nextInt();
	    }
	    for(int i=0;i<n;i++){
	        y[i] = sc.nextInt();
	    }
	    
	    HashSet<String> hs = new HashSet<>();
	    for(int i=0;i<n;i++){
	        hs.add(x[i]+" "+y[i]);
	    }
	    System.out.println(hs.size());

	}

}
