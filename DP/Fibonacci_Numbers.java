package com.company.DP;

import java.util.Arrays;

public class Fibonacci_Numbers {
    public static void main(String[] args) {
        int n = 5785;
        int[] dpArr = new int[n+1];
        Arrays.fill(dpArr,-1);
        int ans = FindFibo(n,dpArr);
        System.out.println(ans);
    }

    static int FindFibo(int n,int[] dpArr){
        if(n <= 1) return n;
        if(dpArr[n] != -1) return dpArr[n];
        return dpArr[n] = FindFibo(n-1,dpArr) + FindFibo(n-2,dpArr);
    }
}
