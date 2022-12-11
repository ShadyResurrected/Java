package com.company.DP;

import java.util.Arrays;

public class Frog_Jump {
    public static void main(String[] args) {
        int[] heights = {10,20,30,10};
        int[] dpArr = new int[heights.length+1];
//      Arrays.fill(dpArr,-1);
        int n = heights.length-1;
//      int minEnergy = FindEnergy(heights,n);
//      int minEnergy1 = FindEnergy1(n,heights,dpArr);
//      int minEnergy2 = FindEnergy2(n,heights,dpArr);
        int minEnergy3 = FindEnergy3(n,heights);
        System.out.println(minEnergy3);
    }

    // Simple recursive approach
    static int FindEnergy(int[] heights,int index){
        if(index == 0) return 0;
        int left = FindEnergy(heights,index-1) + Math.abs(heights[index] - heights[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1) right = FindEnergy(heights,index-2) + Math.abs(heights[index] - heights[index-2]);
        return Math.min(left,right);

    }

    // Memoization
    static int FindEnergy1(int index,int[] heights,int[] dpArr){
        if(index == 0) return 0;
        if(dpArr[index] != -1) return dpArr[index];
        int left = FindEnergy1(index-1,heights,dpArr) + Math.abs(heights[index]-heights[index-1]); // When the frog is jumping only one step
        int right = Integer.MAX_VALUE;
        // Including the edge case bcz on jumping 2 steps from the 1st index frog would reach -1
        if(index > 1) right = FindEnergy1(index-2,heights,dpArr) + Math.abs(heights[index]-heights[index-2]);
        return dpArr[index] = Math.min(left,right);
    }

    // Tabulation Method
    static int FindEnergy2(int index,int[] heights,int[] dpArr){
        dpArr[0] = 0; // Initializing the dpArr with base case
        for(int i = 1;i < index; i++){
            int left = dpArr[i-1] + Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = dpArr[i-2] + Math.abs(heights[i]-heights[i-2]);
            dpArr[i] = Math.min(left,right);
        }
        return dpArr[index-1];
    }

    // Space Optimization
    static int FindEnergy3(int index,int[] heights){
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 1;i < index;i++){
            int left = prev1 + Math.abs(heights[i]-heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = prev2 + Math.abs(heights[i]-heights[i-2]);
            int current = Math.min(left,right);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

}
