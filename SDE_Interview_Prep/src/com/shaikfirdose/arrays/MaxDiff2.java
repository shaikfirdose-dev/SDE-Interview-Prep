package com.shaikfirdose.arrays;

public class MaxDiff2 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxDiff(arr, n));
    }
    public static int maxDiff(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<=n-1;j++){
                int exp = (arr[i]-arr[j])+(i-j);
                
                if(exp<0){
                    exp = -exp;
                    if(exp>max){
                        max = exp;
                    }
                }
                else{
                    if(exp>max){
                        max = exp;
                    }
                }
            }
        }
        return max;
    }

}
