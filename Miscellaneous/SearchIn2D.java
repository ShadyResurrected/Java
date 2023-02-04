package com.company.Miscellaneous;

import java.util.Arrays;

public class SearchIn2D{
    public static void main(String[] args){
        int[][] arr = {
                {1,2,3},
                {23,54,76,89,90},
                {12,32,712,99}
        };
//        int target = 991;
//        int[] ans = Search(arr,target);
//        System.out.println(Arrays.toString(ans));
        System.out.println(MaxValue(arr));
    }

    static int[] Search(int[][] arr, int num){
        for(int row=0;row < arr.length;row++){
            for(int col = 0;col<arr[row].length;col++){
                if(arr[row][col] == num){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1,-1};
    }

    static int MaxValue(int[][] arr){
        int Max = Integer.MIN_VALUE;
        for(int row = 0;row<arr.length;row++){
            for(int col = 0;col<arr[row].length;col++){
                if(arr[row][col] > Max){
                    Max = arr[row][col];
                }
            }
        }
        return Max;
    }
}
