

//GFG : https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.stacks;

import java.util.Stack;

public class NextGreaterElementRight {
	
	public static long[] nextLargerElement(long[] arr, int n)
    { 

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(stack.size()>0 && arr[i]>arr[stack.peek()]){
                int idx = stack.pop();
                arr[idx] = arr[i];
            }
            stack.push(i);
        }
        
        while(stack.size()>0){
            int idx = stack.pop();
            arr[idx]=-1;
        }
        return arr;
    } 

}
