package com.shaikfirdose.arrays;

import java.util.Scanner;

public class ColumnWise2DArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int[][] arr = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int j=0;j<column;j++){
            for(int i=0;i<row;i++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
	}

}
