package com.company.DP;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {{1},{2,3},{3,6,7},{8,9,6,10}};
        int row = triangle.length;

        int[][] dpArr = new int[row][row];
        for(int[] ele : dpArr) Arrays.fill(ele,-1);
        int[][] tabulated = new int[row][row];
        int[] prev = new int[row];

//      int MinPathSum = FindPathSum(0,0,row,triangle);
//      int MinPathSum1 = FindPathSum1(0,0,row,triangle,dpArr);
//      int MinPathSum2 = FindPathSum2(row,triangle,tabulated);
        int MinPathSum3 = FindPathSum3(row,triangle,prev);
        System.out.println(MinPathSum3);
    }

    static int FindPathSum(int startRow,int startCol,int row,int[][] triangle){
        if(startRow == row-1) return triangle[startRow][startCol];
        int down = 0;
        int diagonalDown = 0;
        // Moving down
        if(startRow + 1 < row){
            down += triangle[startRow][startCol] + FindPathSum(startRow+1,startCol,row,triangle);
        }else down = Integer.MAX_VALUE;
        // Moving diagonal down
        diagonalDown += triangle[startRow][startCol] + FindPathSum(startRow+1,startCol+1,row,triangle);
        return Math.min(down,diagonalDown);
    }

    static int FindPathSum1(int startRow,int startCol,int row,int[][] triangle,int[][] dpArr){
        if(startRow == row-1) return triangle[startRow][startCol];
        if(dpArr[startRow][startCol] != -1) return dpArr[startRow][startCol];
        int down = 0;
        int diagonalDown = 0;
        // Moving down
        if(startRow + 1 < row){
            down += triangle[startRow][startCol] + FindPathSum1(startRow+1,startCol,row,triangle,dpArr);
        }else down = Integer.MAX_VALUE;
        // Moving diagonal down
        diagonalDown += triangle[startRow][startCol] + FindPathSum1(startRow+1,startCol+1,row,triangle,dpArr);
        return dpArr[startRow][startCol] = Math.min(down,diagonalDown);
    }

    static int FindPathSum2(int row,int[][] triangle,int[][] tabulated){
        // Initializing the base condition
        // Copying the values of last row of triangle array in the tabulated array
        for(int i = 0;i < row;i++){
            tabulated[row-1][i] = triangle[row-1][i];
        }
        // Then calculating the values starting from the last 2nd row
        for(int i = row - 2;i >= 0;i--){
            for(int j = i; j >= 0;j--){
                int down = triangle[i][j] + tabulated[i+1][j];
                int diagonal = triangle[i][j] + tabulated[i+1][j+1];
                tabulated[i][j] = Math.min(down,diagonal);
            }
        }
        return tabulated[0][0];
    }

    static int FindPathSum3(int row,int[][] triangle,int[] prev){
        // Initializing the base condition
        // Copying the values of last row of triangle array in the tabulated array
        for(int i = 0;i < row;i++){
            prev[i] = triangle[row-1][i];
        }
        // Then calculating the values starting from the last 2nd row
        for(int i = row - 2;i >= 0;i--){
            int[] current = new int[prev.length-1];
            for(int j = i; j >= 0;j--){
                int down = triangle[i][j] + prev[j];
                int diagonal = triangle[i][j] + prev[j+1];
                current[j] = Math.min(down,diagonal);
            }
            prev = current;
        }
        return prev[0];
    }
}
