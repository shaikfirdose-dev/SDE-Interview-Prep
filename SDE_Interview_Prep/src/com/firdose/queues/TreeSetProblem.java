

//T.C:O(nlogn)
//s.C:O(1)

package com.firdose.queues;

import java.util.TreeSet;

public class TreeSetProblem {
	int arr[] = {0,0,0,0,0,0,0,0,0,0,0,0};
	TreeSet<Integer> ts = new TreeSet<>();
	public TreeSetProblem() {
		
	}
	void type1(int i) {
		if(arr[i]==0) {
			arr[i]=1;
			ts.add(i);
			
		}
		else {
			arr[i]=0;
			ts.remove(i);
		}
	}
	int type2(int i) {
		int leftside = ts.floor(i);
		int rightside = ts.ceiling(i);
		int leftDiff = i-leftside;
		int rightDiff = rightside-i;
		if(leftDiff<rightDiff) {
			return leftDiff;
		}
		return rightDiff;
	}

}
