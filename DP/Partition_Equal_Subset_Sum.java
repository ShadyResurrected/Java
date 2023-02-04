package com.company.DP;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,4,5};
        int sum = 0;
        for(int i : arr) sum += i;
        int[][] dpArr = new int[arr.length][(sum/2)+1];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        if(sum%2 != 0) System.out.println(false);
        else{
            sum /= 2;
//          boolean res = FindSum(0,arr,sum);
            boolean res1 = FindSum1(0,arr,sum,dpArr);
            System.out.println(res1);
        }
    }

    static boolean FindSum(int index,int[] arr,int sum){
        if(index == arr.length-1) return arr[index] == sum;
        // Choosing the elements
        boolean taken = false;
        boolean notTaken;
        notTaken = FindSum(index+1,arr,sum);
        if(arr[index] <= sum){
            taken = FindSum(index+1,arr,sum-arr[index]);
        }
        return taken || notTaken;
    }

    static boolean FindSum1(int index,int[] arr,int sum,int[][] dpArr){
        if(index == arr.length-1) return arr[index] == sum;
        if(dpArr[index][sum] != -1) return true ? dpArr[index][sum] == 1 : false;
        // Choosing the elements
        boolean taken = false;
        boolean notTaken;
        notTaken = FindSum1(index+1,arr,sum,dpArr);
        if(arr[index] <= sum){
            taken = FindSum1(index+1,arr,sum-arr[index],dpArr);
        }
        boolean res = taken || notTaken;
        dpArr[index][sum] = res ? 1 : 0;
        return res;
    }
}
