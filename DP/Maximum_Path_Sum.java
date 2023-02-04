package com.company.DP;

import java.util.Arrays;

public class Maximum_Path_Sum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,10,4},
                {100,3,2,1},
                {1,1,20,2},
                {1,2,2,1}
        };
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dpArr = new int[row][col];
        for(int[] ele : dpArr) Arrays.fill(ele,-1);
        int[][] tabulated = new int[row][col];
        int[] prev = new int[col];

//        int ans = Integer.MIN_VALUE;
//        for(int i = 0;i < col;i++){
//            int maxPathSum = FindPathSum(0,i,row,col,matrix);
//            ans = Math.max(maxPathSum,ans);
//        }

//        int ans1 = Integer.MIN_VALUE;
//        for(int i = 0;i < col;i++){
//            int maxPathSum = FindPathSum1(0,i,row,col,matrix,dpArr);
//            ans1 = Math.max(maxPathSum,ans1);
//        }

//      int maxPathSum2 = FindPathSum2(row,col,matrix,tabulated);
        int maxPathSum3 = FindPathSum3(row,col,matrix,prev);
        System.out.println(maxPathSum3);
    }

    static int FindPathSum(int startRow,int startCol,int row,int col,int[][] matrix){
        if(startRow == row-1) return matrix[startRow][startCol];
        int down = 0;
        int downLeftDiagonal = 0;
        int downRightDiagonal = 0;
        // Moving down
        if(startRow + 1 < row){
            down += matrix[startRow][startCol] + FindPathSum(startRow+1,startCol,row,col,matrix);
        }
        // Moving down left
        if(startRow + 1 < row && startCol - 1 >= 0){
            downLeftDiagonal += matrix[startRow][startCol] + FindPathSum(startRow+1,startCol-1,row,col,matrix);
        }else downLeftDiagonal = Integer.MAX_VALUE;
        // Moving down right
        if(startRow + 1 < row && startCol + 1 < col){
            downRightDiagonal += matrix[startRow][startCol] + FindPathSum(startRow+1,startCol+1,row,col,matrix);
        }else downRightDiagonal = Integer.MAX_VALUE;
        return Math.max(down,Math.max(downLeftDiagonal,downRightDiagonal));
    }

    static int FindPathSum1(int startRow,int startCol,int row,int col,int[][] matrix,int[][] dpArr){
        if(dpArr[startRow][startCol] != -1) return dpArr[startRow][startCol];
        if(startRow == row-1) return matrix[startRow][startCol];
        int down = 0;
        int downLeftDiagonal = 0;
        int downRightDiagonal = 0;
        // Moving down
        if(startRow + 1 < row){
            down += matrix[startRow][startCol] + FindPathSum1(startRow+1,startCol,row,col,matrix,dpArr);
        }
        // Moving down left
        if(startRow + 1 < row && startCol - 1 >= 0){
            downLeftDiagonal += matrix[startRow][startCol] + FindPathSum1(startRow+1,startCol-1,row,col,matrix,dpArr);
        }else downLeftDiagonal = Integer.MAX_VALUE;
        // Moving down right
        if(startRow + 1 < row && startCol + 1 < col){
            downRightDiagonal += matrix[startRow][startCol] + FindPathSum1(startRow+1,startCol+1,row,col,matrix,dpArr);
        }else downRightDiagonal = Integer.MAX_VALUE;
        return dpArr[startRow][startCol] = Math.max(down,Math.max(downLeftDiagonal,downRightDiagonal));
    }

    static int FindPathSum2(int row,int col,int[][] matrix,int[][] tabulated){
        // Using two for loop traversal
        // Initialising the first row
        for(int i = 0;i < col;i++){
            tabulated[0][i] = matrix[0][i];
        }
        // Deriving the latter values using the first row
        for(int i = 1;i < row;i++){
            for(int j = 0;j < col;j++){
                int up = 0;
                int upDiagonalRight = 0;
                int upDiagonalLeft = 0;
                up = matrix[i][j] + tabulated[i-1][j];
                if(j+1 < col) upDiagonalRight = matrix[i][j] + tabulated[i-1][j+1];
                else upDiagonalRight = Integer.MIN_VALUE;
                if(j-1 >= 0) upDiagonalLeft = matrix[i][j] + tabulated[i-1][j-1];
                else upDiagonalLeft = Integer.MIN_VALUE;
                tabulated[i][j] = Math.max(up,Math.max(upDiagonalLeft,upDiagonalRight));
            }
        }
        int maxPathSum = Integer.MIN_VALUE;
        for(int i = 0;i < tabulated[row-1].length;i++){
            int ele = tabulated[row-1][i];
            maxPathSum = Math.max(ele,maxPathSum);
        }
        return maxPathSum;
    }

    static int FindPathSum3(int row,int col,int[][] matrix,int[] prev){
        // Using two for loop traversal
        // Initialising the first row
        for(int i = 0;i < col;i++){
            prev[i] = matrix[0][i];
        }
        // Deriving the latter values using the first row
        for(int i = 1;i < row;i++){
            int[] current = new int[col];
            for(int j = 0;j < col;j++){
                int up = 0;
                int upDiagonalRight = 0;
                int upDiagonalLeft = 0;
                up = matrix[i][j] + prev[j];
                if(j+1 < col) upDiagonalRight = matrix[i][j] + prev[j+1];
                else upDiagonalRight = Integer.MIN_VALUE;
                if(j-1 >= 0) upDiagonalLeft = matrix[i][j] + prev[j-1];
                else upDiagonalLeft = Integer.MIN_VALUE;
                current[j] = Math.max(up,Math.max(upDiagonalLeft,upDiagonalRight));
            }
            prev = current;
        }
        int maxPathSum = Integer.MIN_VALUE;
        for(int i = 0;i < prev.length;i++){
            int ele = prev[i];
            maxPathSum = Math.max(ele,maxPathSum);
        }
        return maxPathSum;
    }
}
