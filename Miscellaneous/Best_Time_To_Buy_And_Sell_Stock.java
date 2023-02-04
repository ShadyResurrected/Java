package com.company.Miscellaneous;

import java.util.Arrays;

public class Best_Time_To_Buy_And_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        System.out.println(Profit(prices));
    }

    static int Profit(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            if(min > prices[i]) {
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }

        return max;

//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < prices.length ; i++){
//            for(int j = i+1; j < prices.length; j++){
//                if(Math.abs(prices[i] - prices[j]) > max && prices[i] < prices[j]){
//                    max = Math.abs(prices[i] - prices[j]);
//                }
//            }
//        }
//        return max;


//        int max = 0;
//        for(int i = prices.length - 1; i > 0 ; i--){
//            for (int j = i; j > 0; j--){
//                if((prices[i] - prices[j-1]) > max && (prices[i] - prices[j-1]) > 0){
//                    max = prices[i] - prices[j-1];
//                }
//            }
//        }
//        return max;

//        int max = 0;
//        int start = 0;
//        int end = prices.length - 1;
//        while(start != end){
//            if(prices[end] - prices[start] > max){
//                max = prices[end] - prices[start];
//            }
//            start++;
//            end--;
//        }
//        return max;
    }
}
