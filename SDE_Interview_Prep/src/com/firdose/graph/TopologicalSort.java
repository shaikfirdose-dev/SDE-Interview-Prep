//Topological sort
//GFG (Medium): https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=gfg

package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
	
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       
        
        int indegree[] = new int[adj.size()];
        Arrays.fill(indegree, 0);
        
        int result[] = new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            List<Integer> neighbours = adj.get(i);
            for(int nbr : neighbours){
                indegree[nbr]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int index = 0;
        while(queue.size()>0){
            int rem = queue.remove();
            result[index++] = rem;
            List<Integer> neighbours = adj.get(rem);
            for(int nbr : neighbours){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    queue.add(nbr);
                }
            }
            
        }
        
        
        return result;
    }

}
