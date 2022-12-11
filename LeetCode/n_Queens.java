package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class n_Queens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        ToPlace(board,ans,0);
        System.out.println(ans);
    }
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> ans = new ArrayList<>();
//        boolean[][] board = new boolean[n][n];
//        ToPlace(board,ans,0);
//        return ans;
//    }
    static void ToPlace(boolean[][] board, List<List<String>> ans, int row){
        if(row == board.length){
            display(board,ans);
            return;
        }

        //placing the queen in every row and column
        for (int col = 0; col < board.length; col++){
            //checking if it is safe to place the queen or not
            if(isSafe(board,row,col)){
                board[row][col] = true;
                ToPlace(board,ans,row+1);
                board[row][col] = false;
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // checking the vertical col
        for (int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }

        //checking the left diagonal
        int maxLeft = Math.min(row,col);
        for (int i = 0; i <= maxLeft; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        //checking the right diagonal
        int maxRight = Math.min(row,board.length-1-col);
        for (int i = 0; i <= maxRight; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board, List<List<String>> ans) {
        int i = 0;
        List<String> l1 = new ArrayList<>();
        for (boolean[] row : board){
            for (boolean ele : row){
                if(ele){
                    l1.add("Q");
                }else
                    l1.add(".");
            }
            ans.add(l1);
            i++;
        }
    }
}
