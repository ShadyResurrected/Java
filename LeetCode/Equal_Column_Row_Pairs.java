package com.company.LeetCode;

import java.util.HashMap;

public class Equal_Column_Row_Pairs {
    public static void main(String[] args) {
//        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        int[][] transposeMatrix = new int[grid.length][grid.length];
        // Storing the rows of the matrix
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                transposeMatrix[row][col] = grid[row][col];
            }
        }

        // Checking for the equal row and col
        int count = 0;
        for(int row = 0; row < transposeMatrix.length; row++){
            for(int times = 0; times < transposeMatrix.length; times++){
                int countLength = 0;
                for(int col = 0; col < transposeMatrix[row].length; col++){
                    if(transposeMatrix[row][col] == grid[col][times]) {
                        countLength++;
                    }else
                        break;
                }
                if(countLength == transposeMatrix[row].length) count++;
            }
        }
        System.out.println(count);
    }
}
