package com.firdose.linkedlist;

public class Node1 {
	
	int val;
	Node1 next;
	Node1 prev;
	
	Node1(int val){
		this.val = val;
	}
	
	Node1(int val, Node1 next, Node1 prev){
		this.val = val;
		this.next = next;
		this.prev = prev;
	}

}
