package com.company.DP;

import java.util.ArrayList;
import java.util.Arrays;

public class Printing_LIS {
    public static void main(String[] args) {
        int[] arr = {5,4,11,1,16,8};
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        int[] hash = new int[arr.length];
        for (int i = 0;i < hash.length;i++) hash[i] = i;

        for (int i = 0;i < arr.length;i++){
            for (int prev_index = 0; prev_index < i;prev_index++){
                if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }
        int ans = -1;
        int lastIndex =-1;

        for(int i=0; i<=arr.length-1; i++){
            if(dp[i]> ans){
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);

        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for(int i=temp.size()-1; i>=0; i--){
            System.out.print(temp.get(i)+" ");
        }
    }
}
