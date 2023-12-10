
//GFG: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
	
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        ArrayList<Integer> ans = new ArrayList<>();
        
        queue.add(0);
        visited[0] = true;
        
        while(queue.size()>0){
            int rem = queue.remove();
            ans.add(rem);
            // System.out.println(ans);
            
            if(rem<adj.size()){
                List<Integer> neighbours = adj.get(rem);
                for(int nbr : neighbours){
                    if(visited[nbr]==false){
                        queue.add(nbr);
                        visited[nbr] = true;
                    }
                }
            }
        }
        return ans;
    }

}
