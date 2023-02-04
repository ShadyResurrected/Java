package com.company.DP;

import java.util.Arrays;

public class knapsack_Memoized {
    public static void main(String[] args) {
        int[] wt = {1,3,4,4};
        int[] val = {1,4,5,7};
        int W = 7;
        int n = val.length;
//        This below code sets every value of index to -1
        for (int i = 0; i < dpArr.length; i++){
            Arrays.fill(dpArr[i], -1);
        }
        System.out.println(memo_knapsack(wt,val,W,n));
    }
    static int dpArr[][] = new int[5][8]; // define the size of the array by checking the constraints
    static int memo_knapsack(int[] wt,int[] val,int W,int n){
        //Base condition
        if(n == 0 || W == 0){
            return 0;
        }
//        Check if the value is stored in matrix
        if(dpArr[n][W] != -1){
            return dpArr[n][W];
        }

//        Now storing the values in array
        if(wt[n-1] <= W){
            return dpArr[n][W] = Math.max((val[n-1] + memo_knapsack(wt,val,W-wt[n-1],n-1)),memo_knapsack(wt,val,W,n-1));
        }else
            return dpArr[n][W] = memo_knapsack(wt,val,W,n-1);
    }
}
