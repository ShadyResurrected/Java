package com.company.LeetCode;

import java.util.Arrays;

public class Counting_Bits {
    public static void main(String[] args) {
        int n = 5;
//        System.out.println(CheckOnes(n));
        System.out.println(Arrays.toString(countBits(n)));
    }

    static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = CheckOnes(i);
        }
        return ans;
    }
    static int CheckOnes(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
