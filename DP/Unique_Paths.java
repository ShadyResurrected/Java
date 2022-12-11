package com.company.DP;

import java.util.Arrays;

public class Unique_Paths {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;

        int[][] dpArr = new int[row][col];
        for(int[] ele : dpArr){
            Arrays.fill(ele,-1);
        }
        int[][] tabulated = new int[row][col];
        int[] prev = new int[col]; // This will be used to store the answers of the current row

//      int paths = FindPaths(0,0,row,col);
//      int paths1 = FindPaths1(0,0,row,col,dpArr);
//      int paths2 = FindPaths2(row,col,tabulated);
        int paths3 = FindPaths3(row,col,prev);
        System.out.println(paths3);
    }

    // Simple Recursive Approach
    static int FindPaths(int startRow,int startCol,int row,int col){
        if(startRow == row-1 && startCol == col-1) return 1;
        int sum = 0;
        // Moving one step right
        if(startRow + 1 < row){
            sum += FindPaths(startRow+1,startCol,row,col);
        }
        // Moving one step down
        if(startCol + 1 < col){
            sum += FindPaths(startRow,startCol+1,row,col);
        }
        return sum;
    }

    // Memoized recursive approach
    static int FindPaths1(int startRow,int startCol,int row,int col,int[][] dpArr){
        if(startRow == row-1 && startCol == col-1) return 1;
        if(dpArr[startRow][startCol] != -1) return dpArr[startRow][startCol];
        int sum = 0;
        // Moving one step right
        if(startRow + 1 < row){
            sum += FindPaths1(startRow+1,startCol,row,col,dpArr);
        }
        // Moving one step down
        if(startCol + 1 < col){
            sum += FindPaths1(startRow,startCol+1,row,col,dpArr);
        }
        return dpArr[startRow][startCol] = sum;
    }

    // Tabulated approach
    static int FindPaths2(int row,int col,int[][] tabulated){
        for(int i = 0;i < row;i++){
            for(int j = 0;j < row;j++){
                if(i == 0 && j == 0) tabulated[i][j] = 1; // Base case
                else{
                    int right = 0;
                    int down = 0;
                    if(i > 0) right = tabulated[i-1][j];
                    if(j > 0) down = tabulated[i][j-1];
                    tabulated[i][j] = down + right;
                }
            }
        }
        return tabulated[row-1][col-1];
    }

    // Space Optimized
    static int FindPaths3(int row,int col,int[] prev){
        for(int i = 0;i < row;i++){
            int[] current = new int[col];
            for(int j = 0;j < col;j++){
                if(i == 0 && j == 0) current[j] = 1;
                else{
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = current[j-1];
                    current[j] = up + left;
                }
            }
            prev = current;
        }
        return prev[col-1];
    }
}
