

//GFG : https://www.geeksforgeeks.org/problems/help-classmates--141631/1
//	T.C:O(N)
//	S.C:O(N)

//
//Professor X wants his students to help each other in the chemistry lab. 
//He suggests that every student should help out a classmate who scored less marks than him in chemistry 
//and whose roll number appears after him. But the students are lazy and they don't
//want to search too far. They each pick the first roll number after them that fits the criteria. 
//Find the marks of the classmate that each student picks.
//Note: one student may be selected by multiple classmates.

package com.firdose.stacks;

import java.util.Stack;

public class NextSmallerElementRight {
	
	public static int[] help_classmate(int arr[], int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
				int idx = stack.pop();
				arr[idx] = arr[i];
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			int idx = stack.pop();
			arr[idx] = -1;
		}
		return arr;
	}

}
