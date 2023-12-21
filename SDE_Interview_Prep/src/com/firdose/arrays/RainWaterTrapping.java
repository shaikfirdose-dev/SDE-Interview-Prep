
//Leetcode(Hard):https://leetcode.com/problems/trapping-rain-water/

package com.firdose.arrays;

public class RainWaterTrapping {
	
	public int trap(int[] heights) {
        int n = heights.length;
        int[] preMax = findPreMax(heights);
        int[] suffMax = findSuffMax(heights);
        int totalAmount = 0;
        for(int i=1;i<n-1;i++){
            int leftBound = preMax[i-1];
            int rightBound = suffMax[i+1];
            int yourBound = Math.min(leftBound, rightBound);
            int contri = yourBound-heights[i];
            
            if(contri>0){
                totalAmount = totalAmount+contri;
            }
        }
        return totalAmount;
    }

    private static int[] findPreMax(int[] heights){
        int n = heights.length;
        int preMax[] = new int[n];
        preMax[0] = heights[0];
        for(int i=1;i<n;i++){
            preMax[i] = Math.max(preMax[i-1], heights[i]);
        }
        return preMax;
    }

    private static int[] findSuffMax(int[] heights){
        int n = heights.length;
        int suffMax[] = new int[n];
        suffMax[n-1] = heights[n-1];
        for(int i=n-2;i>=0;i--){
            suffMax[i] = Math.max(suffMax[i+1], heights[i]);
        }
        return suffMax;
    }

}
