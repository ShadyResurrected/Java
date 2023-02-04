package com.company.DP;

public class Equal_Sum_Partition_Problem {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(EqualSum(arr));
    }

    static boolean EqualSum(int[] arr){
//        Calculating the sum of the array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
//        Checking whether the sum is even or odd
        if(sum%2 != 0){
            return false;
        }else
            return SubsetSum(arr,sum/2);
    }

    static boolean[][] dpArr = new boolean[6][12];
    static boolean SubsetSum(int[] arr, int target){
//        Initialisation
//        i --> array size
//        j --> sum value
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < target+1; j++) {
                if(i==0){
                    dpArr[i][j] = false;
                }
                if(j==0){
                    dpArr[i][j] = true;
                }
            }
        }

//        Choice Diagram
        for (int i = 1; i < arr.length; i++) {
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
