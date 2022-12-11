package com.company.Miscellaneous;

public class Search_In_2D_Array {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
            };
        int target = 3;
        System.out.println(Find2(matrix,target));
    }

    static boolean Find(int[][] matrix,int target){
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0;col < matrix[row].length; col++){
                if(matrix[row][col] == target){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean Find2(int[][] matrix,int target){
        for (int row = 0; row < matrix.length; row++){
            int start = 0;
            int end = matrix[row].length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(matrix[row][mid] < target){
                    start = mid + 1;
                }else if(matrix[row][mid] > target){
                    end = mid - 1;
                }else
                    return true;
            }
        }
        return false;
    }
}
