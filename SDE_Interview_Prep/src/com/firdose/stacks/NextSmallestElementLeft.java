

//GFG : https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
//	T.C:O(N)
//	S.C:O(N)


package com.firdose.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextSmallestElementLeft {

	static List<Integer> leftSmaller(int n, int a[]) {
		// code here
		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (stack.size() > 0 && a[i] < a[stack.peek()]) {
				int idx = stack.pop();
				a[idx] = a[i];
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			int idx = stack.pop();
			a[idx] = -1;
		}
		List<Integer> ans = new ArrayList<>();
		for (int ele : a) {
			ans.add(ele);
		}
		return ans;
	}

}
