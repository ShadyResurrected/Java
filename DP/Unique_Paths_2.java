package com.company.DP;

import java.util.Arrays;

public class Unique_Paths_2 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,-1,0},{0,0,0}};
//      int[][] grid = {{0,-1},{-1,0}};
        int row = grid.length;
        int col = grid[0].length;
        int[][] dpArr = new int[row][col];
        for(int[] ele : dpArr) Arrays.fill(ele,-1);
        int[][] tabulated = new int[row][col];
        int[] prev = new int[col];

//      int paths = FindPaths(0,0,row,col,grid);
//      int paths1 = FindPaths1(0,0,row,col,grid,dpArr);
//      int paths2 = FindPaths2(row,col,grid,tabulated);
        int paths3 = FindPaths3(row,col,grid,prev);
        System.out.println(paths3);
    }

    static int FindPaths(int startRow,int startCol,int row,int col,int[][] grid){
        if(startRow == row-1 && startCol == col-1) return 1;
        int sum = 0;
        // Moving rightwards
        if(startCol + 1 < col && grid[startRow][startCol+1] != -1){
            sum += FindPaths(startRow,startCol+1,row,col,grid);
        }
        // Moving downwards
        if(startRow + 1 < row && grid[startRow+1][startCol] != -1){
            sum += FindPaths(startRow+1,startCol,row,col,grid);
        }
        return sum;
    }

    static int FindPaths1(int startRow,int startCol,int row,int col,int[][] grid,int[][] dpArr){
        if(startRow == row-1 && startCol == col-1) return 1;
        if(dpArr[startRow][startCol] != -1) return dpArr[startRow][startCol];
        int sum = 0;
        // Moving rightwards
        if(startCol + 1 < col && grid[startRow][startCol+1] != -1){
            sum += FindPaths1(startRow,startCol+1,row,col,grid,dpArr);
        }
        // Moving downwards
        if(startRow + 1 < row && grid[startRow+1][startCol] != -1){
            sum += FindPaths1(startRow+1,startCol,row,col,grid,dpArr);
        }
        return dpArr[startRow][startCol] = sum;
    }

    static int FindPaths2(int row,int col,int[][] grid,int[][] tabulated){
        // Using two for loops
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(i == 0 && j == 0) tabulated[i][j] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i > 0 && grid[i-1][j] != -1) up = tabulated[i-1][j];
                    if(j > 0 && grid[i][j-1] != -1) left = tabulated[i][j-1];
                    tabulated[i][j] = up + left;
                }
            }
        }
        return tabulated[row-1][col-1];
    }

    static int FindPaths3(int row,int col,int[][] grid,int[] prev){
        for (int i = 0;i < row;i++){
            int[] cur = new int[col];
            for (int j = 0;j < col;j++){
                if(i == 0 && j == 0) cur[j] = 1;
                else{
                    int left = 0;
                    int up = 0;
                    if(i > 0 && grid[i-1][j] != -1) up = prev[j];
                    if(j > 0 && grid[i][j-1] != -1) left = cur[j-1];
                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[col-1];
    }
}
