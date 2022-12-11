package com.company.DP;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {5,4,11,1,16,8};
        int[][] dpArr = new int[arr.length][arr.length+1];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[arr.length+1][arr.length + 1];
        int[] next = new int[arr.length+1];

//      int maxLength = FindLength(0,arr,-1);
//      int maxLength1 = FindLength1(0,arr,-1,dpArr);
//      int maxLength2 = FindLength2(arr,tabulated);
        int maxLength3 = FindLength3(arr,next);
        System.out.println(maxLength3);
    }

    static int FindLength(int index,int[] arr,int prev_index){
        // Base Case
        if(index == arr.length) return 0;

        int Pick = 0;
        if(prev_index == -1 || arr[index] > arr[prev_index]){
            Pick = 1 + FindLength(index+1,arr,index);
        }
        int notPick = FindLength(index+1,arr,prev_index);
        return Math.max(Pick,notPick);
    }

    static int FindLength1(int index,int[] arr,int prev_index,int[][] dpArr){
        // Base Case
        if(index == arr.length) return 0;

        if (dpArr[index][prev_index+1] != -1) return dpArr[index][prev_index+1];

        int Pick = 0;
        if(prev_index == -1 || arr[index] > arr[prev_index]){
            Pick = 1 + FindLength1(index+1,arr,index,dpArr);
        }
        int notPick = FindLength1(index+1,arr,prev_index,dpArr);
        return dpArr[index][prev_index+1] = Math.max(Pick,notPick);
    }

    static int FindLength2(int[] arr,int[][] tabulated){
        // Since array is already initialized with 0, we need not explicitly mention the base case

        for (int index = arr.length-1;index >= 0;index--){
            for(int prev_index = index-1;prev_index >= -1;prev_index--){
                int Pick = 0;
                if(prev_index == -1 || arr[index] > arr[prev_index]){
                    Pick = 1 + tabulated[index+1][index+1];
                }
                int notPick = tabulated[index+1][prev_index+1];
                tabulated[index][prev_index+1] = Math.max(Pick,notPick);
            }
        }
        return tabulated[0][0];
    }

    static int FindLength3(int[] arr,int[] next){
        // Since array is already initialized with 0, we need not explicitly mention the base case

        for (int index = arr.length-1;index >= 0;index--){
            int[] current = new int[arr.length+1];
            for(int prev_index = index-1;prev_index >= -1;prev_index--){
                int Pick = 0;
                if(prev_index == -1 || arr[index] > arr[prev_index]){
                    Pick = 1 + next[index+1];
                }
                int notPick = next[prev_index+1];
                current[prev_index+1] = Math.max(Pick,notPick);
            }
            next = current;
        }
        return next[0];
    }
}
