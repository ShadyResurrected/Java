package com.company.DP;

public class knapsack_problem {
    public static void main(String[] args) {
        int[] wt = {1,2,4,5,7};
        int[] val = {1,2,3,4,5};
        int W = 7;
        System.out.println(knap(wt,val,W,5));
    }

    static int knap(int[] wt,int[] val,int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knap(wt,val,W-wt[n-1],n-1),knap(wt,val,W,n-1));
        }else
            return knap(wt,val,W,n-1);
    }
}
