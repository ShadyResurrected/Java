package com.company.DP;

import java.util.Arrays;

public class Subset_Sum_Equal_To_K {
    public static void main(String[] args) {
        int[] arr = {4,3,1,2};
//        int[] arr = {2,5,1,6,7};
        int k = 4;
        int[][] dpArr = new int[arr.length][k+1];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        boolean[][] tabulated = new boolean[arr.length][k+1];
        for(boolean[] row : tabulated) Arrays.fill(row,false);
        boolean[] prev = new boolean[k+1];

//      boolean res = FindSubsetSumEqual(0,arr,k);
//      boolean res1 = FindSubsetSumEqual1(0,arr,k,dpArr);
//      boolean res2 = FindSubsetSumEqual2(arr,k,tabulated);
        boolean res3 = FindSubsetSumEqual3(arr,k,prev);
        System.out.println(res3);
    }

    static boolean FindSubsetSumEqual(int index,int[] arr,int k){
        if(k < 0 || index == arr.length) return false;
        if(k == 0) return true;
        // Choosing the index
        if(FindSubsetSumEqual(index+1,arr,k-arr[index])) return true;
        // Not Choosing the index
        if(FindSubsetSumEqual(index+1,arr,k)) return true;

        return false;
    }

    static boolean FindSubsetSumEqual1(int index,int[] arr,int k,int[][] dpArr){
        if(k==0)
            return true;

        if(index == 0)
            return arr[0] == k;

        if(dpArr[index][k]!=-1)
            return dpArr[index][k]==0?false:true;

        boolean notTaken = FindSubsetSumEqual1(index-1,arr,k,dpArr);

        boolean taken = false;
        if(arr[index]<=k)
            taken = FindSubsetSumEqual1(index-1,arr,k-arr[index],dpArr);
        dpArr[index][k]=notTaken||taken?1:0;
        return notTaken||taken;
    }

    static boolean FindSubsetSumEqual2(int[] arr,int k,boolean[][] tabulated){
        // Initialising the base conditions
        for(int i = 0;i < arr.length-1;i++){
            tabulated[i][0] = true;
        }
        tabulated[0][arr[0]] = true;
        for(int i = 1;i < arr.length;i++){
            for (int j = 1;j <= k;j++){
                boolean notTaken = tabulated[i-1][j];
                boolean taken = false;
                if(arr[i]<=j) taken = tabulated[i-1][j-arr[i]];
                tabulated[i][j]=notTaken||taken;
            }
        }
        return tabulated[arr.length-1][k];
    }

    static boolean FindSubsetSumEqual3(int[] arr,int k,boolean[] prev){
        // First colum of every row must be true
        prev[0] = true;
        prev[arr[0]] = true;
        for(int i = 1;i < arr.length;i++){
            boolean[] current = new boolean[k+1];
            current[0] = true;
            for (int j = 1;j <= k;j++){
                boolean notTaken = prev[j];
                boolean taken = false;
                if(arr[i]<=j) taken = prev[j-arr[i]];
                current[j]=notTaken||taken;
            }
            prev = current;
        }
        return prev[k];
    }
}
