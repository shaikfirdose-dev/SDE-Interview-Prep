

//Leetcode : https://leetcode.com/problems/insert-delete-getrandom-o1/
//	
//	T.C:O(1)

package com.firdose.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteRandom {
	
	
	class RandomizedSet {
	    HashMap<Integer,Integer> hm;
	    ArrayList<Integer> list;
	    Random r;
	    public RandomizedSet() {
	       hm = new HashMap<>();
	       list = new ArrayList<>();
	       r = new Random();
	    }
	    
	    public boolean insert(int val) {
	        if(hm.containsKey(val)==true){
	            return false;
	        }
	        hm.put(val, list.size());
	        list.add(val);
	        return true;
	    }
	    
	    public boolean remove(int val) {
	        if(hm.containsKey(val)==false){
	            return false;
	        }
	        int idx= hm.get(val);
	        hm.remove(val);
	        if(idx==list.size()-1){
	            list.remove(idx);
	            return true;
	        }
	        int idx2 = list.size()-1;
	        int temp = list.get(idx2);

	        list.set(idx2, val);
	        list.set(idx, temp);
	        list.remove(idx2);
	        hm.put(temp, idx);
	        return true;

	    }
	    
	    public int getRandom() {
	        int rval = r.nextInt(list.size());
	        return list.get(rval);
	    }
	}

}
