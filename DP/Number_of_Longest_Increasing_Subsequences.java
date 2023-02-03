package com.company.DP;

import java.util.*;

public class Number_of_Longest_Increasing_Subsequences {
    public static void main(String[] args) {

    }
    public static int findNumberOfLIS(int n, int[] arr) {
        // Write your code here.
        int res = HelperFunc(arr);
        return res;
    }

    static int HelperFunc(int[] arr){
        int[] dpArr = new int[arr.length];
        Arrays.fill(dpArr,1);
        int[] count = new int[arr.length];
        Arrays.fill(count,1);

        int maxi = 1;
        for(int i = 0;i < arr.length; i++){
            for(int prev_index = 0;prev_index < i; prev_index++){
                if(arr[i] > arr[prev_index] && dpArr[i] < dpArr[prev_index] + 1){
                    dpArr[i] = dpArr[prev_index] + 1;
                    count[i] = count[prev_index];
                }else if(arr[i] > arr[prev_index] && dpArr[prev_index]+1 == dpArr[i]){
                    count[i] += count[prev_index];
                }
            }
            maxi = Math.max(maxi,dpArr[i]);
        }

        int res = 0;
        for(int i = 0;i < dpArr.length; i++){
            if(dpArr[i] == maxi) res += count[i];
        }
        return res;
    }
}
