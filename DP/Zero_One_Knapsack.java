package com.company.DP;

import java.util.Arrays;

public class Zero_One_Knapsack {
    public static void main(String[] args) {
        int[] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        int n = weight.length;
        int maxWeight = 5;

        int[][] dpArr = new int[maxWeight+1][n];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[n][maxWeight+1];
        int[] prev = new int[maxWeight+1];

//      int MaxValue = FindMaxValue(0,weight,value,maxWeight);
//      int MaxValue1 = FindMaxValue1(0,weight,value,maxWeight,dpArr);
//      int MaxValue2 = FindMaxValue2(weight,value,maxWeight,tabulated);
//      int MaxValue3 = FindMaxValue3(weight,value,maxWeight,prev);
        int MaxValue4 = FindMaxValue4(weight,value,maxWeight,prev);
        System.out.println(MaxValue4);
    }

    static int FindMaxValue(int index,int[] weight,int[] value,int maxWeight){
        // Base Case
        if(maxWeight == 0 || index == weight.length) return 0;
        // We have to choices : either we can pick a element or not
        int pick = 0;
        if(weight[index] <= maxWeight) pick = value[index] + FindMaxValue(index+1,weight,value,maxWeight-weight[index]);
        int notPick = FindMaxValue(index+1,weight,value,maxWeight);
        return Math.max(pick,notPick);
    }

    static int FindMaxValue1(int index,int[] weight,int[] value,int maxWeight,int[][] dpArr){
        // Base Case
        if(maxWeight == 0 || index == weight.length) return 0;
        // We have to choices : either we can pick a element or not
        if(dpArr[maxWeight][index] != -1) return dpArr[maxWeight][index];
        int pick = 0;
        if(weight[index] <= maxWeight) pick = value[index] + FindMaxValue1(index+1,weight,value,maxWeight-weight[index],dpArr);
        int notPick = FindMaxValue1(index+1,weight,value,maxWeight,dpArr);
        return dpArr[maxWeight][index] =  Math.max(pick,notPick);
    }

    static int FindMaxValue2(int[] weight,int[] value,int maxWeight,int[][] tabulated){
        // Base case
        for (int i = weight[0];i <= maxWeight;i++) {
            tabulated[0][i] = value[0];
        }
//        tabulated[1][0] = value[0]; // When the maxWeight is 1,and we can only choose one element

        for(int row = 1;row < tabulated.length;row++){
            for (int col = 0;col <= maxWeight;col++){
                int pick = 0;
                if(weight[row] <= col) pick = value[row] + tabulated[row-1][col - weight[row]];
                int notPick = tabulated[row-1][col];
                tabulated[row][col] =  Math.max(pick,notPick);
            }
        }

        return tabulated[tabulated.length-1][maxWeight];
    }

    static int FindMaxValue3(int[] weight,int[] value,int maxWeight,int[] prev){
        // Base case
        for (int i = weight[0];i <= maxWeight;i++) {
            prev[i] = value[0];
        }
        for(int row = 1;row < weight.length;row++){
            int[] current = new int[maxWeight+1];
            for (int col = 0;col <= maxWeight;col++){
                int pick = 0;
                if(weight[row] <= col) pick = value[row] + prev[col - weight[row]];
                int notPick = prev[col];
                current[col] =  Math.max(pick,notPick);
            }
            prev = current;
        }

        return prev[maxWeight];
    }

    static int FindMaxValue4(int[] weight,int[] value,int maxWeight,int[] prev){
        // Base case
        for (int i = weight[0];i <= maxWeight;i++) {
            prev[i] = value[0];
        }
        for(int row = 1;row < weight.length;row++){
            for (int col = maxWeight;col >= 0;col--){
                int pick = 0;
                if(weight[row] <= col) pick = value[row] + prev[col - weight[row]];
                int notPick = prev[col];
                prev[col] =  Math.max(pick,notPick);
            }
        }

        return prev[maxWeight];
    }
}
