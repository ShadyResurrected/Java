package com.company.DP;

import java.util.Arrays;

public class Maximum_Sum_Of_Non_Adjacent_Elements {
    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int N = arr.length-1;
        int[] dpArr = new int[arr.length];
        int[] tabulated = new int[arr.length];
        Arrays.fill(dpArr,-1);
//      int maxSum = FindSum(N,arr);
//      int maxSum1 = FindSum1(N,arr,dpArr);
//      int maxSum2 = FindSum2(N,arr,tabulated);
        int maxSum3 = FindSum3(N,arr);
        System.out.println(maxSum3);
    }

    // Recursive Approach
    private static int FindSum(int n, int[] arr) {
        if(n == 0) return arr[n];
        if(n < 0) return 0;
        int pickElement = Integer.MIN_VALUE;
        pickElement = FindSum(n-2,arr) + arr[n];
        int NotPickElement = FindSum(n-1,arr);
        return Math.max(pickElement,NotPickElement);
    }

    // Memoized
    public static int FindSum1(int index,int[] arr,int[] dpArr){
        if(index == 0) return arr[0];
        if(index < 1) return 0; // it means no element is selected
        if(dpArr[index] != -1) return dpArr[index];
        int pick = arr[index] + FindSum1(index-2,arr,dpArr);
        int nonPick = FindSum1(index-1,arr,dpArr);
        return dpArr[index] = Math.max(pick,nonPick);
    }

    // Tabulated Form
    public static int FindSum2(int index,int[] arr,int[] tabulated){
        tabulated[0] = arr[0]; // base case : when we pick the first element
        for(int i = 1;i < arr.length; i++){
            int pick = arr[i];
            if(i > 1) pick += tabulated[i-2];
            int nonPick = tabulated[i-1];
            tabulated[i] = Math.max(pick,nonPick);
        }
        return tabulated[arr.length-1];
    }

    // Space Optimization
    public static int FindSum3(int index,int[] arr){
        int prev = arr[0]; // base case : when we pick the first element
        int prev2 = 0; // we pick it zero as when index-2 reaches -1
        for(int i = 1;i < arr.length; i++){
            int pick = arr[i];
            if(i > 1) pick += prev2;
            int nonPick = prev;
            int current = Math.max(pick,nonPick);
            prev2 = prev;
            prev = current;

        }
        return prev;
    }
}
