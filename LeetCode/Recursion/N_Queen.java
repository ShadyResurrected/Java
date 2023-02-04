package com.company.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

// Problem Statement - The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
public class N_Queen {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        List<List<String>> ans1 = new ArrayList<>();
        // On basis of row placement
        QueenPlacementsRow(n,0,board,ans);
        // On basis of column placement
        QueenPlacementsCol(n,0,board,ans1);
        // Optimising the isSafeToPlace
        int[] rowCheck = new int[n];
        int[] left_diagonal_Up = new int[2*n-1];
        int[] left_diagonal_Down = new int[2*n-1];
        List<List<String>> ans2 = new ArrayList<>();
        QueenPlacementsOptimized(n,0,board,ans2,rowCheck,left_diagonal_Up,left_diagonal_Down);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    static void QueenPlacementsRow(int n,int row,int[][] board,List<List<String>> ans){
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for(int[] e : board){
                String res = "";
                for(int ele : e){
                    if(ele == 1){
                        res += "Q";
                    }else
                        res += ".";
                }
                list.add(res);
            }
            ans.add(list);
            return;
        }

        // Placing in every row
        for(int col = 0; col < board.length; col++){
            if(isSafePlaceRow(board,row,col)){
                board[row][col] = 1;
                QueenPlacementsRow(n,row+1,board,ans);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafePlaceRow(int[][] board,int row,int col) {
        // Checking in the column
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 1) return false;
        }

        // Checking diagonally

        //checking the left diagonal
        int maxLeft = Math.min(row,col);
        for (int i = 0; i <= maxLeft; i++){
            if(board[row-i][col-i] == 1){
                return false;
            }
        }

        //checking the right diagonal
        int maxRight = Math.min(row,board.length-1-col);
        for (int i = 0; i <= maxRight; i++){
            if(board[row-i][col+i] == 1){
                return false;
            }
        }
        return true;
    }

    static void QueenPlacementsCol(int n,int col,int[][] board,List<List<String>> ans){
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int[] e : board){
                String res = "";
                for(int ele : e){
                    if(ele == 1){
                        res += "Q";
                    }else
                        res += ".";
                }
                list.add(res);
            }
            ans.add(list);
            return;
        }

        // Placing in every column
        for (int row = 0; row < board.length; row++){
            if(isSafePlaceCol(board,row,col)){
                board[row][col] = 1;
                QueenPlacementsCol(n,col+1,board,ans);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafePlaceCol(int[][] board, int row, int col) {
        // Checking to the left
        for(int i = 0; i < col; i++){
            if(board[row][i] == 1) return false;
        }

        // Checking the left-diagonal-up
        int duplRow = row;
        int duplCol = col;
        while(duplCol >= 0 && duplRow >= 0){
            if(board[duplRow][duplCol] == 1) return false;
            duplCol--;
            duplRow--;
        }

        // Checking the left-diagonal-down
        int duplRow1 = row;
        int duplCol1 = col;
        while(duplCol1 >= 0 && duplRow1 < board.length){
            if(board[duplRow1][duplCol1] == 1) return false;
            duplCol1--;
            duplRow1++;
        }

        return true;
    }

    private static void QueenPlacementsOptimized(int n, int col, int[][] board, List<List<String>> ans2, int[] rowCheck, int[] left_diagonal_up, int[] left_diagonal_down) {
        if(col == n){
            List<String> list = new ArrayList<>();
            for (int[] element : board){
                String res = "";
                for(int e : element){
                    if(e == 1){
                        res += "Q";
                    }else
                        res += ".";
                }
                list.add(res);
            }
            ans2.add(list);
            return;
        }

        for (int row = 0; row < board.length; row++){
            if(rowCheck[row] == 0 && left_diagonal_down[row+col] == 0 && left_diagonal_up[n-1+col-row] == 0){
                board[row][col] = 1;
                rowCheck[row] = 1;
                left_diagonal_down[row+col] = 1;
                left_diagonal_up[n-1+col-row] = 1;
                QueenPlacementsOptimized(n,col+1,board,ans2,rowCheck,left_diagonal_up,left_diagonal_down);
                board[row][col] = 0;
                rowCheck[row] = 0;
                left_diagonal_down[row+col] = 0;
                left_diagonal_up[n-1+col-row] = 0;
            }
        }
    }
}
