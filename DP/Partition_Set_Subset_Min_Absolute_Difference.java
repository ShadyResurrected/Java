package com.company.DP;

import java.util.Arrays;

public class Partition_Set_Subset_Min_Absolute_Difference {
    public static void main(String[] args) {
        int[] arr = {8,6,5};
        int n = arr.length;
        int maxSum = 0;
        for (int ele : arr) maxSum += ele;
        int minDiff = Integer.MAX_VALUE;
        int[][] dpArr = new int[n][maxSum+1];
        boolean[][] tabulated = new boolean[n][maxSum+1];
        boolean[] prev = new boolean[maxSum+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);


//        for (int target = 0;target <= maxSum;target++){
//            int S1 = 0; int S2 = 0;
//            if(FindSubsetPossible(0,target,arr)){
//                S1 = target; S2 = maxSum - target;
//                int min = Math.abs(S2-S1);
//                minDiff = Math.min(min,minDiff);
//            }
//        }

//        for (int target = 0;target <= maxSum;target++){
//            int S1 = 0; int S2 = 0;
//            if(FindSubsetPossible1(0,target,arr,dpArr)){
//                S1 = target; S2 = maxSum - target;
//                int min = Math.abs(S2-S1);
//                minDiff = Math.min(min,minDiff);
//            }
//        }

//        FindPossible2(maxSum,arr,tabulated);
        FindPossible3(maxSum,arr,prev); // Having some problems
        for (int target = 0;target <= maxSum;target++){
            int S1 = 0; int S2 = 0;
            if(prev[target]){
                S1 = target; S2 = maxSum - target;
                int min = Math.abs(S2-S1);
                minDiff = Math.min(min,minDiff);
            }
        }
        System.out.println(minDiff);
    }

    static boolean FindSubsetPossible(int index,int target,int[] arr){
        if(target == 0) return true;
        if(index == arr.length-1) return arr[arr.length-1] == target;
        // Now considering and not considering the elements present in the array
        boolean take = false;
        boolean notTake;
        notTake = FindSubsetPossible(index+1,target,arr);
        if(arr[index] <= target) take = FindSubsetPossible(index+1,target-arr[index],arr);
        return take || notTake;
    }

    static boolean FindSubsetPossible1(int index,int target,int[] arr,int[][] dpArr){
        if(target == 0) return true;
        if(index == arr.length-1) return arr[arr.length-1] == target;
        if(dpArr[index][target] != -1) return dpArr[index][target] == 1 ? true : false;
        // Now considering and not considering the elements present in the array
        boolean take = false;
        boolean notTake;
        notTake = FindSubsetPossible1(index+1,target,arr,dpArr);
        if(arr[index] <= target) take = FindSubsetPossible1(index+1,target-arr[index],arr,dpArr);
        boolean res = take || notTake;
        dpArr[index][target] = res ? 1 : 0;
        return res;
    }

    static void FindPossible2(int maxSum,int[] arr,boolean[][] tabulated){
        // Initializing the base conditions
        for(int i = 0;i < tabulated.length;i++) tabulated[i][0] = true;
        if(arr[0] <= maxSum) tabulated[0][arr[0]] = true;

        // Traversing using two for loops
        for (int i = 1;i < tabulated.length;i++){
            for(int target = 1;target <= maxSum;target++){
                boolean take = false;
                boolean notTake;
                notTake = tabulated[i-1][target];
                if(arr[i] <= target) take = tabulated[i-1][target-arr[i]];
                boolean res = take || notTake;
                tabulated[i][target] = res;
            }
        }
    }

    static void FindPossible3(int maxSum,int[] arr,boolean[] prev){
        // Initializing the base conditions
        boolean[] current = new boolean[maxSum+1];
        current[0] = true;
        prev[0] = true;
        if(arr[0] <= maxSum) prev[arr[0]] = true;

        // Traversing using two for loops
        for (int i = 1;i < arr.length;i++){
            for(int target = 1;target <= maxSum;target++){
                boolean take = false;
                boolean notTake;
                notTake = prev[target];
                if(arr[i] <= target) take = prev[target-arr[i]];
                boolean res = take || notTake;
                current[target] = res;
            }
            prev = current;
        }
    }
}
