package com.company.DP;

import java.util.*;

public class Partition_Array_For_Maximum_Sum {
    public static void main(String[] args) {

    }

    public static int maximumSubarray(int num[], int k) {
        int[] dpArr = new int[num.length];
        Arrays.fill(dpArr,-1);
        return HelperFunc(0,num,k,dpArr);
    }

    static int HelperFunc(int i,int[] num,int k,int[] dpArr){
        // Base Case
        if(i == num.length) return 0;

        if(dpArr[i] != -1) return dpArr[i];

        // Trying out all possibilities
        int len = 0;
        int maxEle = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int j = i;j < Math.min(num.length,i+k); j++){
            len++;
            maxEle = Math.max(maxEle,num[j]);
            int sum = (len * maxEle) + HelperFunc(j+1, num, k,dpArr);
            res = Math.max(sum, res);
        }

        return dpArr[i] = res;
    }
}
