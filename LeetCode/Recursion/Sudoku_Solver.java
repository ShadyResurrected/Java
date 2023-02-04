package com.company.LeetCode.Recursion;

// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//        A sudoku solution must satisfy the following rules:
//
//        Each of the digits 1-9 must occur exactly once in each row.
//        Each of the digits 1-9 must occur exactly once in each column.
//        Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//        The '.' character indicates empty cells.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Sudoku_Solver {
    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};

        int n = board.length;
        String[] num = {"1","2","3","4","5","6","7","8","9"};
        SolveSudoku(n,board,num);
        for (String[] row : board){
            System.out.println(Arrays.toString(row));
        }
    }
    static boolean SolveSudoku(int n,String[][] board,String[] num){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == "."){

                    for (int k = 0; k < num.length; k++){
                        if(CanBePlaced(i,j,k,board,num)){
                            board[i][j] = num[k];

                            if(SolveSudoku(n,board,num)){
                                return true;
                            }else
                                board[i][j] = ".";
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean CanBePlaced(int row, int col,int k,String[][] board,String[] num) {
        for(int i = 0; i < board.length; i++){
            // Checking in the row
            if(board[row][i] == num[k]) return false;

            // Checking in the col
            if(board[i][col] == num[k]) return false;

            // Checking in the subMatrix
            if(board[3*(row/3) + (i/3)][3*(col/3) + (i%3)] == num[k]) return false;
        }
        return true;
    }
}
