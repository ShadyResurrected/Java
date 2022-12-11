package com.company.Backtracking;

public class N_Knights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nKnights(board,0,0,4);
    }

    static void nKnights(boolean[][] board,int row, int col, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }

        //if your target gets out of bound
        if(row == board.length - 1 && col == board.length){
            return;
        }

        // if column is full then go to the next row
        if(col == board.length){
            nKnights(board,row+1,0,knights);
            return;
        }
        // Checking if the position is safe or not
        if(isSafe(board,row,col)){
            // if it is safe then set the index value as true
            board[row][col] = true;
            nKnights(board,row,col+1,knights-1);
            board[row][col] = false; // backtracking
        }

        //if it is not safe then move ahead by one column
        nKnights(board,row,col+1,knights);
    }

    static boolean isSafe(boolean[][] board,int row, int col){
        if(isValid(board,row-2,col+1)){ // Checking whether this is a valid position in matrix or not
            if(board[row-2][col+1]){ // Checking whether a knight is present or not
                return false;
            }
        }
        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }
        if(isValid(board,row-1,col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }
        if(isValid(board,row-1,col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }

        return true;
    }

    // checking whether every position is valid or not
    static boolean isValid(boolean[][] board, int row, int col){
        if((row >= 0 && row < board.length) && (col >= 0 && col < board.length)){
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board){
            for (boolean ele : row){
                if(ele){
                    System.out.print("K");
                }else
                    System.out.print(".");
            }
            System.out.println();
        }
    }
}
