package com.company.DP;

import java.util.Arrays;

public class Buy_And_Sell_Stock_III {
    public static void main(String[] args) {
        int[] arr = {3,3,5,0,3,1,4};
        int[][][] dpArr = new int[arr.length][2][3];
        for (int[][] row: dpArr) for (int[] col : row) Arrays.fill(col,-1);
        int[][][] tabulated = new int[arr.length+1][2][3];


//      int maxProfit = FindProfit(0,arr,0,2);
//      int maxProfit1 = FindProfit1(0,arr,0,2,dpArr);
        int maxProfit2 = FindProfit2(arr,tabulated);
        System.out.println(maxProfit2);
    }

    static int FindProfit(int index,int[] arr,int ifAbleToBuy,int transaction){
        // Base Case
        if(transaction == 0 || index == arr.length) return 0;

        int profit = 0;

        if(ifAbleToBuy == 0){
            profit = Math.max((-1) * arr[index]+FindProfit(index+1,arr,1,transaction),FindProfit(index+1,arr,0,transaction));
        }

        if(ifAbleToBuy == 1){
            profit = Math.max(arr[index]+FindProfit(index+1,arr,0,transaction-1),FindProfit(index+1,arr,1,transaction));
        }

        return profit;
    }

    static int FindProfit1(int index,int[] arr,int ifAbleToBuy,int transaction,int[][][] dpArr){
        // Base Case
        if(transaction == 0 || index == arr.length) return 0;

        if(dpArr[index][ifAbleToBuy][transaction] != -1) return dpArr[index][ifAbleToBuy][transaction];

        int profit = 0;

        if(ifAbleToBuy == 0){
            profit = Math.max((-1) * arr[index]+FindProfit1(index+1,arr,1,transaction,dpArr),FindProfit1(index+1,arr,0,transaction,dpArr));
        }

        if(ifAbleToBuy == 1){
            profit = Math.max(arr[index]+FindProfit1(index+1,arr,0,transaction-1,dpArr),FindProfit1(index+1,arr,1,transaction,dpArr));
        }

        return dpArr[index][ifAbleToBuy][transaction] = profit;
    }

    static int FindProfit2(int[] arr,int[][][] tabulated){
        // Base Case

        // Traversal using two for loops
        for(int index = arr.length-1; index >= 0;index--){
            for (int ifAbleToBuy = 0;ifAbleToBuy <= 1;ifAbleToBuy++){
                for (int transaction = 1;transaction <= 2;transaction++){
                    int profit = 0;

                    if(ifAbleToBuy == 0){
                        profit = Math.max((-1) * arr[index]+tabulated[index+1][1][transaction],tabulated[index+1][0][transaction]);
                    }

                    if(ifAbleToBuy == 1){
                        profit = Math.max(arr[index]+tabulated[index+1][0][transaction-1],tabulated[index+1][1][transaction]);
                    }

                    tabulated[index][ifAbleToBuy][transaction] = profit;
                }
            }
        }

        return tabulated[0][0][2];
    }
}
