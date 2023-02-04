package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Get_Maximum_Generated_In_Array {
    public static void main(String[] args) {
        int n = 7;
        int res = getMaximumGenerated(n);
        System.out.println(res);
    }
    static int getMaximumGenerated(int n) {
        if(n == 0 || n == 1) return n;
        int[] dpArr = new int[n+1];
        int res = HelperFunc(n,dpArr);
        return res;
    }

    static int HelperFunc(int n,int[] dpArr){
        int max = Integer.MIN_VALUE;
        dpArr[0] = 0; dpArr[1] = 1;
        for(int num = 2; num <= n; num++){
            int cur = 0;
            if(num % 2 == 0){
                cur = dpArr[num/2];
            }else{
                cur = dpArr[num/2] + dpArr[(num/2)+1];
            }
            dpArr[num] = cur;
            max = Math.max(max,cur);
        }
        return max;
    }
}
