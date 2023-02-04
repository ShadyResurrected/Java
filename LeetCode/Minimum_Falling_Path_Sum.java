package com.company.LeetCode;

public class Minimum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int ans = minFallingPathSum(matrix);
        System.out.println(ans);
    }
    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = HelperFunc(0,0,n,m,matrix);
        return res;
    }

    static int HelperFunc(int row,int col,int n,int m,int[][] matrix){
        if(row == n-1) return matrix[row][col];

        // Moving diagonal left
        int dLeft = Integer.MAX_VALUE;
        if(row + 1 < n && col - 1 >= 0){
            dLeft = matrix[row][col] + HelperFunc(row+1,col-1,n,m,matrix);
        }

        // Moving down
        int down = Integer.MAX_VALUE;
        if(row + 1 < n){
            down = matrix[row][col] + HelperFunc(row+1,col,n,m,matrix);
        }

        // Moving diagonal right
        int dRight = Integer.MAX_VALUE;
        if(row + 1 < n && col + 1 < m){
            dRight = matrix[row][col] + HelperFunc(row+1,col+1,n,m,matrix);
        }

        return Math.min(dLeft,Math.min(down,dRight));
    }
}
