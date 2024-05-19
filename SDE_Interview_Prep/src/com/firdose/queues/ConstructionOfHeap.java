package com.firdose.queues;

import java.util.ArrayList;

public class ConstructionOfHeap {

public static void main(String[] args) {
        
        ArrayList<Integer> t = new ArrayList<>();
        insert(t, 10);
        insert(t, 11);
        insert(t, 12);
        insert(t, 19);
        insert(t, 5);
        System.out.println(t);
        
        int ans = remove(t);
        System.out.println(ans);
        System.out.println(t);
        
    }
    
	//T.C:O(log(n))
    public static void insert(ArrayList<Integer> list, int x){
        list.add(x);
        int i = list.size()-1;
        while(i>0){
            int parent = (i-1)/2;
            if(list.get(parent) > list.get(i)){
                //swap(i, parent)
                int temp = list.get(i);
                list.set(i, list.get(parent));
                list.set(parent, temp);
                i = parent;
            }
            else{
                break;
            }
        }
    }
    
    //T.C:O(log(N))
    public static int remove(ArrayList<Integer> list){
    
        int temp1 = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.set(list.size()-1, temp1);
        
        int ans = list.remove(list.size()-1);
        int i=0;
        while(i<list.size()){
            int min_i = i;
            int leftChild = (2*i)+1;
            if(leftChild<list.size() && list.get(leftChild)<list.get(min_i)){
                min_i = leftChild;
            }
            
            int rightChild = (2*i)+2;
            if(rightChild<list.size() && list.get(rightChild)<list.get(min_i)){
                min_i = rightChild;
            }
            
            if(i==min_i){
                break;
            }
            else{
                //swap(i, min_i)
                int temp = list.get(i);
                list.set(i, list.get(min_i));
                list.set(min_i, temp);
                
                i = min_i;
            }
        }
        return ans;
        
        
    }
}

