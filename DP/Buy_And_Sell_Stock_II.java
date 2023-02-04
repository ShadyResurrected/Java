package com.company.DP;

import java.util.Arrays;

public class Buy_And_Sell_Stock_II {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int N = arr.length;
        int[][] dpArr = new int[arr.length][2];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[arr.length+1][2];
        int[] ahead = new int[2];

//      int maxProfit = FindProfit(0,arr,0);
//      int maxProfit1 = FindProfit1(0,arr,0,dpArr);
//      int maxProfit2 = FindProfit2(arr,tabulated);
        int maxProfit3 = FindProfit3(arr,ahead);
        System.out.println(maxProfit3);
    }

    // 0 --> it means we are able to buy a stock
    // 1 --> it means we are not able to buy a stock
    static int FindProfit(int index,int[] arr,int ifAbleToBuy){
        // Base Case
        if(index == arr.length) return 0;

        // Now considering all the possibilities
        int option1 = 0;
        int option2 = 0;

        if(ifAbleToBuy == 0){
            option1 = FindProfit(index+1,arr,0); // Not considering stock on that day
            option2 = (-1) * arr[index] + FindProfit(index+1,arr,1);
        }

        if(ifAbleToBuy == 1){
            option1 = FindProfit(index+1,arr,1); // Not considering to sell the stock on that day
            option2 = arr[index] + FindProfit(index+1,arr,0);
        }

        return Math.max(option1,option2);
    }

    static int FindProfit1(int index,int[] arr,int ifAbleToBuy,int[][] dpArr){
        // Base Case
        if(index == arr.length) return 0;

        if(dpArr[index][ifAbleToBuy] != -1) return dpArr[index][ifAbleToBuy];
        // Now considering all the possibilities
        int option1 = 0;
        int option2 = 0;

        if(ifAbleToBuy == 0){
            option1 = FindProfit1(index+1,arr,0,dpArr); // Not considering stock on that day
            option2 = (-1) * arr[index] + FindProfit1(index+1,arr,1,dpArr);
        }

        if(ifAbleToBuy == 1){
            option1 = FindProfit1(index+1,arr,1,dpArr); // Not considering to sell the stock on that day
            option2 = arr[index] + FindProfit1(index+1,arr,0,dpArr);
        }

        return dpArr[index][ifAbleToBuy] = Math.max(option1,option2);
    }

    static int FindProfit2(int[] arr,int[][] tabulated){
        // Base Case
        tabulated[arr.length-1][0] = 0;
        tabulated[arr.length-1][1] = 0;

        // Traversal using two for loops
        for (int index = arr.length-2;index >= 0;index--){
            for (int ifAbleToBuy = 0;ifAbleToBuy <= 1;ifAbleToBuy++){
                // Now considering all the possibilities
                int option1 = 0;
                int option2 = 0;

                if(ifAbleToBuy == 0){
                    option1 = tabulated[index+1][0]; // Not considering stock on that day
                    option2 = (-1) * arr[index] + tabulated[index+1][1];
                }

                if(ifAbleToBuy == 1){
                    option1 = tabulated[index+1][1]; // Not considering to sell the stock on that day
                    option2 = arr[index] + tabulated[index+1][0];
                }

                tabulated[index][ifAbleToBuy] = Math.max(option1,option2);
            }
        }
        return tabulated[0][0];
    }

    static int FindProfit3(int[] arr,int[] ahead){
        // Base Case
        ahead[0] = 0;
        ahead[1] = 0;

        // Traversal using two for loops
        for (int index = arr.length-1;index >= 0;index--){
            int[] current = new int[2];
            for (int ifAbleToBuy = 0;ifAbleToBuy <= 1;ifAbleToBuy++){
                // Now considering all the possibilities
                int option1 = 0;
                int option2 = 0;

                if(ifAbleToBuy == 0){
                    option1 = ahead[0]; // Not considering stock on that day
                    option2 = (-1) * arr[index] + ahead[1];
                }

                if(ifAbleToBuy == 1){
                    option1 = ahead[1]; // Not considering to sell the stock on that day
                    option2 = arr[index] + ahead[0];
                }

                current[ifAbleToBuy] = Math.max(option1,option2);
            }
            ahead = current;
        }
        return ahead[0];
    }
}
