package com.company.DP;

import java.util.Arrays;

public class Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] profit = {5,11,13};
        int[] weight = {2,4,6};
        int maxWeight = 10;
        int n = profit.length;
        int[][] dpArr = new int[n][maxWeight+1];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[n][maxWeight+1];
        int[] prev = new int[maxWeight+1];

//      int maxProfit = FindProfit(n-1,profit,weight,maxWeight);
//      int maxProfit1 = FindProfit1(n-1,profit,weight,maxWeight,dpArr);
//      int maxProfit2 = FindProfit2(profit,weight,maxWeight,tabulated);
        int maxProfit3 = FindProfit3(profit,weight,maxWeight,prev);
        System.out.println(maxProfit3);
    }

    static int FindProfit(int index,int[] profit,int[] weight,int maxWeight){
        // Base Case
        if(index == 0){
            return (maxWeight/weight[0]) * profit[0];
        }
        // Choosing one element and not choosing the other
        int pick = (int)(-1 * 1e9);
        if(weight[index] <= maxWeight) pick = profit[index] + FindProfit(index,profit,weight,maxWeight-weight[index]);
        int notPick = FindProfit(index-1,profit,weight,maxWeight);
        return Math.max(pick,notPick);
    }

    static int FindProfit1(int index,int[] profit,int[] weight,int maxWeight,int[][] dpArr){
        // Base Case
        if(index == 0){
            return (maxWeight/weight[0]) * profit[0];
        }
        if(dpArr[index][maxWeight] != -1) return dpArr[index][maxWeight];
        // Choosing one element and not choosing the other
        int pick = (int)(-1 * 1e9);
        if(weight[index] <= maxWeight) pick = profit[index] + FindProfit1(index,profit,weight,maxWeight-weight[index],dpArr);
        int notPick = FindProfit1(index-1,profit,weight,maxWeight,dpArr);
        return dpArr[index][maxWeight] =  Math.max(pick,notPick);
    }

    static int FindProfit2(int[] profit,int[] weight,int maxWeight,int[][] tabulated){
        // Base Case
        for(int capacity = 0;capacity <= maxWeight;capacity++){
            tabulated[0][capacity] = (capacity/weight[0]) * profit[0];
        }
        // Now traversing using two for loops
        for(int index = 1;index < weight.length;index++){
            for(int capacity = 0;capacity <= maxWeight;capacity++){
                int pick = (int)(-1 * 1e9);
                if(weight[index] <= capacity) pick = profit[index] + tabulated[index][capacity-weight[index]];
                int notPick = tabulated[index-1][capacity];
                tabulated[index][capacity] =  Math.max(pick,notPick);
            }
        }
        return tabulated[weight.length-1][maxWeight];
    }

    static int FindProfit3(int[] profit,int[] weight,int maxWeight,int[] prev){
        // Base Case
        for(int capacity = 0;capacity <= maxWeight;capacity++){
            prev[capacity] = (capacity/weight[0]) * profit[0];
        }
        // Now traversing using two for loops
        for(int index = 1;index < weight.length;index++){
            int[] current = new int[maxWeight+1];
            for(int capacity = 0;capacity <= maxWeight;capacity++){
                int pick = (int)(-1 * 1e9);
                if(weight[index] <= capacity) pick = profit[index] + current[capacity-weight[index]];
                int notPick = prev[capacity];
                current[capacity] =  Math.max(pick,notPick);
            }
            prev = current;
        }
        return prev[maxWeight];
    }
}
