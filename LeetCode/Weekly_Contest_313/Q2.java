package com.company.LeetCode.Weekly_Contest_313;

// Maximum hourGlass

public class Q2 {
    public static void main(String[] args) {
//        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int sum = 0;
        for(int row = 0;row < grid.length;row++){
            if(row+2 < grid.length){
                int downRow = 0;
                int downCol = 0;
                // Adding the first greater row
                for(int col = 0;col < grid[row].length-3;col++){
                    int rowCandidate = 0;
                    for(int j = col; j < col+3; j++){
                        rowCandidate += grid[row][j];
                    }
                    if(rowCandidate > sum){
                        sum = rowCandidate;
                        downRow = row+1;
                        downCol = (col + (col+2))/2;
                    }
                }

                // Adding the only element below it
                sum += grid[downRow][downCol];

                // Adding the row below the only element
                for(int col = downCol - 1;col < downCol-1+3;col++){
                    sum += grid[downRow+1][col];
                }
            }
        }
        System.out.println(sum);
    }
}
