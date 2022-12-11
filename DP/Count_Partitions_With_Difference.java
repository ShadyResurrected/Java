package com.company.DP;

import java.util.Arrays;

public class Count_Partitions_With_Difference {
    public static void main(String[] args) {
        int[] arr = {5,2,6,4};
        int d = 3;
        int n = arr.length;
        int maxSum = 0;
        for (int ele : arr) maxSum += ele;
        int S1 = (maxSum-d) / 2;
        int[][] dpArr = new int[n][maxSum+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[n][maxSum+1];
        int[] prev = new int[maxSum+1];

        if(maxSum >= d && (maxSum-d)%2 == 0){
//          int partitions = FindPartitions(0,arr,S1,n);
//          int partitions1 = FindPartitions1(0,arr,S1,n,dpArr);
//          int partitions2 = FindPartitions2(arr,S1,n,tabulated);
            int partitions3 = FindPartitions3(arr,S1,n,prev);
            System.out.println(partitions3);
        }else System.out.println(0);
    }

    static int FindPartitions(int index,int[] arr,int target,int n){
        if(index == arr.length-1)
        {
            if(target==0 && arr[arr.length-1]==0)return 2;
            if(target==0 || target==arr[arr.length-1])return 1;
            return 0;
        }
        // Now considering and not considering the elements
        int taken = 0;
        if(arr[index]<=target) taken = FindPartitions(index+1,arr,target-arr[index],n);
        int notTaken = FindPartitions(index+1,arr,target,n);
        return taken + notTaken;
    }

    static int FindPartitions1(int index,int[] arr,int n,int target,int[][] dpArr){
        if(index == arr.length-1)
        {
            if(target==0 && arr[arr.length-1]==0)return 2;
            if(target==0 || target==arr[arr.length-1])return 1;
            return 0;
        }
        // Now considering and not considering the elements
        if(dpArr[index][target] != -1) return dpArr[index][target];
        int taken = 0;
        if(arr[index] <= target) taken = FindPartitions1(index+1,arr,n,target-arr[index],dpArr);
        int notTaken = FindPartitions1(index+1,arr,n,target,dpArr);
        return dpArr[index][target] = taken + notTaken;
    }

    static int FindPartitions2(int[] arr,int target,int n,int[][] tabulated){
        // Base Case
        if(arr[0] == 0) tabulated[0][0] = 2;
            else tabulated[0][0] = 1;
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

    static int FindPartitions3(int[] arr,int target,int n,int[] prev){
        // Base Case
        if(arr[0] == 0) prev[0] = 2;
            else prev[0] = 1;
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
