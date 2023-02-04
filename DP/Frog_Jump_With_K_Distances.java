package com.company.DP;

import java.util.Arrays;

public class Frog_Jump_With_K_Distances {
    public static void main(String[] args) {
        int[] heights = {10,30,40,50,20};
        int N = heights.length;
        int[] dpArr = new int[N+1];
        Arrays.fill(dpArr,-1);
        int K = 3;
//      int minEnergy = FindEnergy(N-1,heights,K);
//      int minEnergy1 = FindEnergy1(N-1,heights,K,dpArr);
        int[] tabulated = new int[N];
        int minEnergy2 = FindEnergy2(heights,K,tabulated);
        System.out.println(minEnergy2);
    }

    private static int FindEnergy2(int[] heights, int k, int[] tabulated) {
        tabulated[0] = 0;
        for(int i = 1;i < heights.length; i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j = 1;j <= k; j++){
                if(i-j >= 0){
                    int jumps = tabulated[i-j] + Math.abs(heights[i] - heights[i-j]);
                    minSteps = Math.min(minSteps,jumps);
                }
            }
            tabulated[i] = minSteps;
        }
        return tabulated[heights.length-1];
    }

    private static int FindEnergy1(int index, int[] heights, int K,int[] dpArr) {
        if(index == 0) return 0;
        if(dpArr[index] != -1) return dpArr[index];
        int minSteps = Integer.MAX_VALUE;
        for(int j = 1;j <= K; j++){
            if(index-j >= 0){
                int jumps = FindEnergy(index-j,heights,K) + Math.abs(heights[index]-heights[index-j]);
                minSteps = Math.min(jumps,minSteps);
            }
        }
        return dpArr[index] = minSteps;
    }

    // Recursive Solution
    static int FindEnergy(int index,int[] heights,int K){
        if(index == 0) return 0;
        int minSteps = Integer.MAX_VALUE;
        for(int j = 1;j <= K; j++){
            if(index-j >= 0){
                int jumps = FindEnergy(index-j,heights,K) + Math.abs(heights[index]-heights[index-j]);
                minSteps = Math.min(jumps,minSteps);
            }
        }
        return minSteps;
    }


}
