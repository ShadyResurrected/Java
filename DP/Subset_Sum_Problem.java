package com.company.DP;

public class Subset_Sum_Problem {
    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        int target = 11;
        System.out.println(SubsetSum(arr,target));
    }
    static boolean[][] dpArr = new boolean[6][12];
    static boolean SubsetSum(int[] arr, int target){
        //Initialisation
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < target+1; j++) {
                if(i == 0){
                    dpArr[i][j] = false;
                }
                if(j == 0){
                    dpArr[i][j] = true;
                }
            }
        }
        //Choice Diagram
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if(arr[i-1] <= j){
                    dpArr[i][j] = dpArr[i][j-arr[i-1]] || dpArr[i-1][j];
                }else
                    dpArr[i][j] = dpArr[i-1][j];
            }
        }

        return dpArr[arr.length][target];
    }
}
