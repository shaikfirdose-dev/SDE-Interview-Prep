package com.firdose.twodarrays;

import java.util.Scanner;

public class ZigZag2DArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int[][] arr = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            if(i%2==0){
                for(int j=0;j<column;j++){
                    System.out.print(arr[i][j]+" ");
                }
            }
            else{
                for(int j=column-1;j>=0;j--){
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }

	}

}
