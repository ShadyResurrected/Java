package com.company.Greedy_Algorithms;

import java.util.Arrays;

public class Minimum_Number_Of_Coins {
    public static void main(String[] args) {
        int[] coins = {1,5,6,9};
        int V = 11;
        Arrays.sort(coins);
        long count = 0;
        for(int i = coins.length - 1; i >= 0; i--){
            if(coins[i] <= V){
                // System.out.println(V);
                count += V / coins[i];
                V = V % coins[i];
            }
        }
//        if(V != 0){
//            return -1;
//        }
        System.out.println(count);;
    }
}
