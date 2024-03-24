//Leetcode : https://leetcode.com/problems/random-pick-with-blacklist/
//	T.C:O(m)-->length of blacklist
//	S.C:O(m)

package com.firdose.hashmap;

import java.util.HashMap;
import java.util.Random;

public class RandomPick {

	HashMap<Integer, Integer> hm;
	Random r;
	int valid;

	public RandomPick(int n, int[] blacklist) {
        hm = new HashMap<>();
        r = new Random();
        valid = n-blacklist.length;
        for(int i=0;i<blacklist.length;i++){
            hm.put(blacklist[i],-1);
        }
        for(int i=0;i<blacklist.length;i++){
            if(blacklist[i]<valid){
                 while(hm.containsKey(n-1)==true){
                    n--;
                 }
                 hm.put(blacklist[i],n-1);
                 n--;
            }
        }
    }

	public int pick() {
		int val = r.nextInt(valid);
		if (hm.containsKey(val) == true) {
			return hm.get(val);
		}
		return val;
	}
}
