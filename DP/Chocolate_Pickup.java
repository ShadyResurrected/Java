package com.company.DP;

import java.util.Arrays;

public class Chocolate_Pickup {
    public static void main(String[] args) {
        int[][] grid = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        int r = grid.length;
        int c = grid[0].length;
        int [][][] dpArr = new int[r][c][c];
        for(int[][] row : dpArr){
            for(int[] ele : row){
                Arrays.fill(ele,-1);
            }
        }
        int[][][] tabulated = new int[r][c][c];
        int[][] prev = new int[c][c];

//      int maxCandies = FindMaxCandy(0,0,c-1,r,c,grid);
//      int maxCandies1 = FindMaxCandy1(0,0,c-1,r,c,grid,dpArr);
//      int maxCandies2 = FindMaxCandy2(r,c,grid,tabulated);
        int maxCandies3 = FindMaxCandy3(r,c,grid,prev);
        System.out.println(maxCandies3);
    }

    static int FindMaxCandy(int startRow,int AliceCol,int BobCol,int row,int col,int[][] grid){
        // Base Case
        if(AliceCol < 0 || AliceCol > col-1 || BobCol < 0 || BobCol > col-1) return (int)-1e9;
        if(startRow == row - 1){
            if(AliceCol == BobCol) return grid[startRow][AliceCol];
            else return grid[startRow][AliceCol] + grid[startRow][BobCol];
        }

        // Applying the various directions
        int maximumCandies = Integer.MIN_VALUE;
        for(int di = -1; di <= 1; di++){
            for(int dj = -1; dj <= 1; dj++){
                int ans = 0;
                if(AliceCol == BobCol){
                    ans = grid[startRow][AliceCol] + FindMaxCandy(startRow+1,AliceCol+di,BobCol+dj,row,col,grid);
                }else
                    ans = grid[startRow][AliceCol] + grid[startRow][BobCol] + FindMaxCandy(startRow+1,AliceCol+di,BobCol+dj,row,col,grid);
                maximumCandies = Math.max(ans,maximumCandies);
            }
        }
        return maximumCandies;
    }

    static int FindMaxCandy1(int startRow,int AliceCol,int BobCol,int row,int col,int[][] grid,int[][][] dpArr){
        if(dpArr[startRow][AliceCol][BobCol] != -1) return dpArr[startRow][AliceCol][BobCol];
        // Base Case
        if(AliceCol < 0 || AliceCol > col-1 || BobCol < 0 || BobCol > col-1) return (int)-1e9;
        if(startRow == row - 1){
            if(AliceCol == BobCol) return grid[startRow][AliceCol];
            else return grid[startRow][AliceCol] + grid[startRow][BobCol];
        }

        // Applying the various directions
        int maximumCandies = Integer.MIN_VALUE;
        for(int di = -1; di <= 1; di++){
            for(int dj = -1; dj <= 1; dj++){
                int ans = 0;
                if(AliceCol == BobCol){
                    ans = grid[startRow][AliceCol] + FindMaxCandy(startRow+1,AliceCol+di,BobCol+dj,row,col,grid);
                }else
                    ans = grid[startRow][AliceCol] + grid[startRow][BobCol] + FindMaxCandy(startRow+1,AliceCol+di,BobCol+dj,row,col,grid);
                maximumCandies = Math.max(ans,maximumCandies);
            }
        }
        return dpArr[startRow][AliceCol][BobCol] = maximumCandies;
    }

    static int FindMaxCandy2(int row,int col,int[][] grid,int[][][] tabulated){
        // Initialising the base condition
        for(int AliceCol = 0; AliceCol < col;AliceCol++){
            for(int BobCol = 0;BobCol < col;BobCol++){
                if(AliceCol == BobCol) tabulated[row-1][AliceCol][BobCol] = grid[row-1][BobCol];
                else tabulated[row-1][AliceCol][BobCol] = grid[row-1][BobCol] + grid[row-1][AliceCol];
            }
        }

        // Iterating over the rest cases
        for(int r = row - 2;r >= 0;r--){
            for(int AliceCol = 0;AliceCol < col;AliceCol++){
                for(int BobCol = 0;BobCol < col;BobCol++){
                    int maximumCandies = Integer.MIN_VALUE;
                    for(int di = -1; di <= 1; di++){
                        for(int dj = -1; dj <= 1; dj++){
                            int ans = 0;
                            boolean b = AliceCol + di < col && AliceCol + di >= 0 && BobCol + dj < col && BobCol + dj >= 0;
                            if(AliceCol == BobCol){
                                if(b) ans = grid[r][AliceCol] + tabulated[r+1][AliceCol+di][BobCol+dj];
                                else ans = (int)-1e8;
                            }else
                            {
                                if(b) ans = grid[r][AliceCol] + grid[r][BobCol] + tabulated[r+1][AliceCol+di][BobCol+dj];
                                else ans = (int)-1e8;
                            }
                            maximumCandies = Math.max(ans,maximumCandies);
                        }
                    }

                    tabulated[r][AliceCol][BobCol] = maximumCandies;
                }
            }
        }
        return tabulated[0][0][col-1];
    }

    static int FindMaxCandy3(int row,int col,int[][] grid,int[][] prev){
        // Initialising the base condition
        for(int AliceCol = 0; AliceCol < col;AliceCol++){
            for(int BobCol = 0;BobCol < col;BobCol++){
                if(AliceCol == BobCol) prev[AliceCol][BobCol] = grid[row-1][BobCol];
                else prev[AliceCol][BobCol] = grid[row-1][BobCol] + grid[row-1][AliceCol];
            }
        }

        // Iterating over the rest cases
        for(int r = row - 2;r >= 0;r--){
            int[][] current = new int[col][col];
            for(int AliceCol = 0;AliceCol < col;AliceCol++){
                for(int BobCol = 0;BobCol < col;BobCol++){
                    int maximumCandies = Integer.MIN_VALUE;
                    for(int di = -1; di <= 1; di++){
                        for(int dj = -1; dj <= 1; dj++){
                            int ans = 0;
                            boolean b = AliceCol + di < col && AliceCol + di >= 0 && BobCol + dj < col && BobCol + dj >= 0;
                            if(AliceCol == BobCol){
                                if(b) ans = grid[r][AliceCol] + prev[AliceCol+di][BobCol+dj];
                                else ans = (int)-1e8;
                            }else
                            {
                                if(b) ans = grid[r][AliceCol] + grid[r][BobCol] + prev[AliceCol+di][BobCol+dj];
                                else ans = (int)-1e8;
                            }
                            maximumCandies = Math.max(ans,maximumCandies);
                        }
                    }

                    current[AliceCol][BobCol] = maximumCandies;
                }
            }
            prev = current;
        }
        return prev[0][col-1];
    }
}
