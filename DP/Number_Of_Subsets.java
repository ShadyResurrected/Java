package com.company.DP;

import java.util.Arrays;

public class Number_Of_Subsets {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        int n = arr.length;
        int target = 3;
        int[][] dpArr = new int[n][target+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[n][target+1];
        int[] prev = new int[target+1];

//      int NumberSubsets = FindSubsets(0,arr,n,target);
//      int NumberSubsets1 = FindSubsets1(0,arr,n,target,dpArr);
//      int NumberSubsets2 = FindSubsets2(arr,n,target,tabulated);
        int NumberSubsets3 = FindSubsets3(arr,n,target,prev);
        System.out.println(NumberSubsets3);
    }

    static int FindSubsets(int index,int[] arr,int n,int target){
        if(index == arr.length-1)
        {
            if(target==0 && arr[arr.length-1]==0)return 2;
            if(target==0 || target==arr[arr.length-1])return 1;
            return 0;
        }
        // Now considering and not considering the elements
        int taken = FindSubsets(index+1,arr,n,target-arr[index]);
        int notTaken = FindSubsets(index+1,arr,n,target);
        return taken + notTaken;
    }

    static int FindSubsets1(int index,int[] arr,int n,int target,int[][] dpArr){
        if(index == arr.length-1)
        {
            if(target==0 && arr[arr.length-1]==0)return 2;
            if(target==0 || target==arr[arr.length-1])return 1;
            return 0;
        }
        // Now considering and not considering the elements
        if(dpArr[index][target] != -1) return dpArr[index][target];
        int taken = 0;
        if(arr[index] <= target) taken = FindSubsets1(index+1,arr,n,target-arr[index],dpArr);
        int notTaken = FindSubsets1(index+1,arr,n,target,dpArr);
        return dpArr[index][target] = taken + notTaken;
    }

    static int FindSubsets2(int[] arr,int n,int target,int[][] tabulated){
        // Base Case
        for (int i = 0;i < n;i++){
            if(arr[i] == 0) tabulated[i][0] = 2;
            else tabulated[i][0] = 1;
        }
        if(arr[0] <= target) {
            if(arr[0] == 0) tabulated[0][arr[0]] = 2;
            else tabulated[0][arr[0]] = 1;
        }
        // Traversing using two for loops
        for (int i = 1;i <= n-1;i++){
            for(int sum = 0;sum <= target;sum++){
                int taken = 0;
                if(arr[i] <= sum) taken = tabulated[i-1][sum-arr[i]];
                int notTaken = tabulated[i-1][sum];
                tabulated[i][sum] = taken + notTaken;
            }
        }
        return tabulated[n-1][target];
    }

    static int FindSubsets3(int[] arr,int n,int target,int[] prev){
        // Base Case
        for (int i = 0;i < n;i++){
            if(arr[i] == 0) prev[0] = 2;
            else prev[0] = 1;
        }
        if(arr[0] <= target) {
            if(arr[0] == 0) prev[arr[0]] = 2;
            else prev[arr[0]] = 1;
        }
        // Traversing using two for loops
        for (int i = 1;i <= n-1;i++){
            int[] current = new int[target+1];
            for(int sum = 0;sum <= target;sum++){
                int taken = 0;
                if(arr[i] <= sum) taken = prev[sum-arr[i]];
                int notTaken = prev[sum];
                current[sum] = taken + notTaken;
            }
            prev = current;
        }
        return prev[target];
    }
}
