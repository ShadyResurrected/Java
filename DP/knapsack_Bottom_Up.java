package com.company.DP;

public class knapsack_Bottom_Up {
    public static void main(String[] args) {
        int[] wt = {1,3,4,4};
        int[] val = {1,4,5,7};
        int W = 7;
        int n = val.length;
        System.out.println(BottomUpKnapsack(wt,val,W,n));
    }

    static int dpArr[][] = new int[5][8];
    static int BottomUpKnapsack(int[] wt,int[] val,int W,int n){
        //Initialisation
        for (int i = 0; i < n+1; i++){
            for (int j = 0; j < W+1; j++){
                if(i == 0 || j == 0){
                    dpArr[i][j] = 0;
                }
            }
        }
//        Here j is analogous to W and i is analogous to n
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if(wt[i-1] <= j){
                    dpArr[i][j] = Math.max((val[i-1] + dpArr[i-1][j-wt[i-1]]), dpArr[i-1][j]);
                }else
                    dpArr[i][j] = dpArr[i-1][j];
            }
        }

        return dpArr[n][W];
    }
}
