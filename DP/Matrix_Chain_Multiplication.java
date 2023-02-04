package com.company.DP;

import java.util.*;

public class Matrix_Chain_Multiplication {
    public static int matrixMultiplication(int[] arr , int N) {
        // Write your code here
        int[][] dpArr = new int[N][N];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        return HelperFunc(arr,1,N-1,dpArr);
    }

    static int HelperFunc(int[] arr,int i,int j,int[][] dpArr){
        if(i == j) return 0;

        if(dpArr[i][j] != -1) return dpArr[i][j];

        int res = (int)1e9;
        for(int k = i;k <= j-1; k++){
            int ans = HelperFunc(arr,i,k,dpArr) + HelperFunc(arr,k+1,j,dpArr) + arr[i-1] * arr[k] * arr[j];
            res = Math.min(res,ans);
        }
        return dpArr[i][j] = res;
    }
}
