package com.company.DP;

import java.util.Arrays;

public class Rod_Cutting_Problem {
    public static void main(String[] args) {
        int[] arr = {2,5,7,8,10};
//        int[] arr = {3,5,8,9,10,17,17,20};
        int n = arr.length;
        int[][] dpArr = new int[arr.length][n+1];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[arr.length][n+1];
        int[] prev = new int[n+1];

//      int maxSum = FindCost(1,arr,n);
//      int maxSum1 = FindCost1(1,arr,n,dpArr);
//      int maxSum2 = FindCost2(arr,n,tabulated);
        int maxSum3 = FindCost3(arr,n,prev);
        System.out.println(maxSum3);
    }

    static int FindCost(int index,int[] arr,int length){
        // Base Case
        if(index > length) return (int)(-1 * 1e9);
        if(index == length){
            return arr[index-1];
        }
        // Picking and not Picking the pieces of the rod
        int pick = (int)(-1 * 1e9);
        if(index <= length) pick = arr[index-1] + FindCost(index,arr,length-index);
        int notPick = FindCost(index+1,arr,length);
        return Math.max(pick,notPick);
    }

    static int FindCost1(int index,int[] arr,int length,int[][] dpArr){
        // Base Case
        if(index > length) return (int)(-1 * 1e9);
        if(index == length){
            return arr[index-1];
        }
        if(dpArr[index][length] != -1) return dpArr[index][length];
        // Picking and not Picking the pieces of the rod
        int pick = (int)(-1 * 1e9);
        if(index <= length) pick = arr[index-1] + FindCost1(index,arr,length-index,dpArr);
        int notPick = FindCost1(index+1,arr,length,dpArr);
        return dpArr[index][length] = Math.max(pick,notPick);
    }

    static int FindCost2(int[] arr,int n,int[][] tabulated){
        // Base Case
        for(int index = 0;index <= n;index++){
            tabulated[0][index] = index * arr[0];
        }

        // Now traversing using two for loops
        for(int index = 1;index < n;index++){
            for (int length = 0;length <= n;length++){
                int pick = (int)(-1 * 1e9);
                if(index <= length) pick = arr[index-1] + tabulated[index][length-index];
                int notPick = tabulated[index-1][length];
                tabulated[index][length] = Math.max(pick,notPick);
            }
        }
        return tabulated[arr.length-1][n];
    }

    static int FindCost3(int[] arr,int n,int[] prev){
        // Base Case
        for(int index = 0;index <= n;index++){
            prev[index] = index * arr[0];
        }

        // Now traversing using two for loops
        for(int index = 1;index < n;index++){
            int[] current = new int[n+1];
            for (int length = 0;length <= n;length++){
                int pick = (int)(-1 * 1e9);
                if(index <= length) pick = arr[index-1] + current[length-index];
                int notPick = prev[length];
                current[length] = Math.max(pick,notPick);
            }
            prev = current;
        }
        return prev[n];
    }
}
