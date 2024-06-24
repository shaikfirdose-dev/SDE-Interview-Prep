
/*
 * Important for interviews
 */

package com.firdose.heaps;

import java.util.ArrayList;

public class ImplementHeap {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ArrayList<Integer> al = new ArrayList<>();

		insert(al, 1);
		System.out.println(al);
		insert(al, 2);
		System.out.println(al);
		insert(al, 0);
		System.out.println(al);
		insert(al, 3);
		System.out.println(al);

		System.out.println("----------------------------------------------------");
		System.out.println(delete(al));
		System.out.println(al);
		System.out.println(delete(al));
		System.out.println(al);
		System.out.println(delete(al));
		System.out.println(al);
		System.out.println(delete(al));
		System.out.println(al);
	}

	public static void insert(ArrayList<Integer> al, int x) {
		al.add(x);
		int i = al.size() - 1;

		while (i > 0) {
			int pidx = (i - 1) / 2;
			if (al.get(pidx) > al.get(i)) {
				int temp = al.get(pidx);
				al.set(pidx, al.get(i));
				al.set(i, temp);

				i = pidx;
			} else {
				break;
			}
		}
	}

	public static int delete(ArrayList<Integer> al) {
		int temp = al.get(0);
		al.set(0, al.get(al.size() - 1));
		al.set(al.size() - 1, temp);

		int ele = al.size() - 1;

		int ans = al.remove(ele);
		int i = 0;

		while (i < al.size()) {
			int min_i = i;
			int leftChild = 2 * i + 1;
			if (leftChild < al.size() && al.get(leftChild) < al.get(min_i)) {
				min_i = leftChild;
			}
			int rightChild = 2 * i + 2;
			if (rightChild < al.size() && al.get(rightChild) < al.get(min_i)) {
				min_i = rightChild;
			}

			if (i == min_i) {
				break;
			}

			else {
				int temp1 = al.get(i);
				al.set(i, al.get(min_i));
				al.set(min_i, temp1);

				i = min_i;
			}
		}

		return ans;
	}
}
