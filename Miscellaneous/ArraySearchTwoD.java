package com.company.Miscellaneous;

import java.util.Arrays;

public class ArraySearchTwoD {
    public static void main(String[] args) {
        int[][] arr = {
                {18,9,12},
                {36,-4,91},
                {44,33,16}
        };
        int target = 91;
        int[] result = Search2(arr,target);
        System.out.println(Arrays.toString(result));
    }

//    Time complexity is n^2
    static int[] Search(int[][] arr,int target){
        for(int row=0;row<arr.length;row++){
            for(int column=0;column<arr[row].length;column++){
                if(arr[row][column] == target){
                    return new int[]{row,column};
                }
            }
        }

        return new int[]{-1,-1};
    }

    static int[] Search2(int[][] matrix,int target){
        int row = 0;
        int col = matrix.length - 1;
        while(row < matrix.length - 1 && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row,col};
            }

            if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }

        return new int[]{-1,-1};
    }
}
