//Question : Given N array elements and Q queries. For every query find frequency of element in array.


//Approach1: using nested loops

//Approach2: using hashmap

package com.firdose.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class FrequencyQueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		int[] queries = new int[m];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int j=0;j<m;j++) {
			queries[j] = sc.nextInt();
		}
		
		frequencyQuery(arr, queries, n, m);
	}
	private static void frequencyQuery(int[] arr, int[] query, int n, int m) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0;i<n;i++) {
			if(hm.containsKey(arr[i])) {
				int temp = hm.get(arr[i]);
				hm.put(arr[i], temp+1);
			}
			else {
				hm.put(arr[i], 1);
			}
		}
		
		for(int j=0;j<m;j++) {
			if(hm.containsKey(query[j])==true) {
				System.out.println(hm.get(query[j]));
			}
			else {
				System.out.println(0);
			}
		}
	}

}
