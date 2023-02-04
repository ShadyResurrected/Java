package com.company.DP;

import java.util.Arrays;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = {{5,9,6},{11,5,2}};
        int row = grid.length;
        int col = grid[0].length;
        int[][] dpArr = new int[row][col];
        for(int[] ele : dpArr) Arrays.fill(ele,-1);
        int[][] tabulated = new int[row][col];
        int[] prev = new int[col];

//      int minPathSum = FindPathSum(0,0,grid,row,col);
//      int minPathSum1 = FindPathSum1(0,0,grid,row,col,dpArr);
//      int minPathSum2 = FindPathSum2(grid,row,col,tabulated);
        int minPathSum3 = FindPathSum3(grid,row,col,prev);
        System.out.println(minPathSum3);
    }

    static int FindPathSum(int startRow,int startCol,int[][] grid,int row,int col){
        if(startRow == row -1 && startCol == col-1) return grid[startRow][startCol];
        int downSum = 0;
        int rightSum = 0;
        // Moving downward
        if(startRow + 1 < row){
            downSum += grid[startRow][startCol] + FindPathSum(startRow+1,startCol,grid,row,col);
        }else downSum = Integer.MAX_VALUE;
        // Moving rightward
        if(startCol + 1 < col){
            rightSum += grid[startRow][startCol] + FindPathSum(startRow,startCol+1,grid,row,col);
        }else rightSum = Integer.MAX_VALUE;
        return Math.min(rightSum,downSum);
    }

    static int FindPathSum1(int startRow,int startCol,int[][] grid,int row,int col,int[][] dpArr){
        if(startRow == row -1 && startCol == col-1) return grid[startRow][startCol];
        if(dpArr[startRow][startCol] != -1) return dpArr[startRow][startCol];
        int downSum = 0;
        int rightSum = 0;
        // Moving downward
        if(startRow + 1 < row){
            downSum += grid[startRow][startCol] + FindPathSum1(startRow+1,startCol,grid,row,col,dpArr);
        }else downSum = Integer.MAX_VALUE; // It means we have crossed the boundary of the matrix, and don't want to include it in our path so substitute it with the largest value
        // Moving rightward
        if(startCol + 1 < col){
            rightSum += grid[startRow][startCol] + FindPathSum1(startRow,startCol+1,grid,row,col,dpArr);
        }else rightSum = Integer.MAX_VALUE;

        return dpArr[startRow][startCol] = Math.min(rightSum,downSum);
    }

    static int FindPathSum2(int[][] grid,int row,int col,int[][] tabulated){
        // Using two for loops
        for (int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(i == 0 && j == 0) tabulated[i][j] = grid[i][j];
                else{
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = grid[i][j] + tabulated[i-1][j];
                    else up = Integer.MAX_VALUE;
                    if(j > 0) left = grid[i][j] + tabulated[i][j-1];
                    else left = Integer.MAX_VALUE;
                    tabulated[i][j] = Math.min(up,left);
                }
            }
        }
        return tabulated[row-1][col-1];
    }

    static int FindPathSum3(int[][] grid,int row,int col,int[] prev){
        // Using two for loops
        for(int i = 0;i < row;i++){
            int[] current = new int[col];
            for(int j = 0;j < col;j++){
                if(i == 0 && j == 0) current[j] = grid[i][j];
                else{
                    int left = 0;
                    int up = 0;
                    if(i > 0) up = grid[i][j] + prev[j];
                    else up = Integer.MAX_VALUE;
                    if(j > 0) left = grid[i][j] + current[j-1];
                    else left = Integer.MAX_VALUE;
                    current[j] = Math.min(up,left);
                }
            }
            prev = current;
        }
        return prev[col-1];
    }
}
