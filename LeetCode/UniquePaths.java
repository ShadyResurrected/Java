package com.company.LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 23;
        int n = 12;
//        int result = PathFinder(0,0,m,n);
        int[][] arr = new int[m][n];
        for(int[] row : arr){
            Arrays.fill(row,-1);
        }
        int result2 = PathFinder2(0,0,m,n,arr);
//        System.out.println(result);
        System.out.println(result2);
    }
    // Brute Force approach
    static int PathFinder(int startm, int startn, int m, int n) {
        if(startm == m-1 && startn == n-1){
            return 1;
        }
        if(startm >= m || startn >= n){
            return 0;
        }
        return PathFinder(startm+1,startn,m,n) + PathFinder(startm,startn+1,m,n);  // Moving Down + Moving Right
    }

    // Better Method
    static int PathFinder2(int startm, int startn, int m, int n, int[][] dpArr){
        if(startm == m-1 && startn == n-1){
            return 1;
        }
        if(startm >= m || startn >= n){
            return  0;
        }
        if(dpArr[startm][startn] != -1){
            return dpArr[startm][startn];
        }else
            return dpArr[startm][startn] = PathFinder2(startm+1,startn,m,n,dpArr) + PathFinder2(startm,startn+1,m,n,dpArr);
    }
}
