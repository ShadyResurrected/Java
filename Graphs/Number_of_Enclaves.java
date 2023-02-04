package com.company.Graphs;

public class Number_of_Enclaves {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0;i < m; i++){
            // Traversing the horizontal boundary
            if(grid[0][i] == 1 && visited[0][i] == 0){
                HelperFunc(0,i,grid,visited);
            }

            // Traversing the horizontal boundary at bottom
            if(grid[n-1][i] == 1 && visited[n-1][i] == 0){
                HelperFunc(n-1,i,grid,visited);
            }
        }

        for(int i = 0;i < n; i++){
            // Traversing the vertical boundary
            if(grid[i][0] == 1 && visited[i][0] == 0){
                HelperFunc(i,0,grid,visited);
            }

            // Traversing the vertical boundary in last
            if(grid[i][m-1] == 1 && visited[i][m-1] == 0){
                HelperFunc(i,m-1,grid,visited);
            }
        }

        int count = 0;
        for(int row = 0;row < visited.length;row++){
            for(int col = 0;col < visited[row].length;col++){
                if(visited[row][col] == 0 && grid[row][col] == 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void HelperFunc(int row,int col,int[][] a,int[][] visited){
        visited[row][col] = 1;

        // Traversing all the available four directions
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0;i < 4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            // Checking for the validity of the four directions
            if(newRow >= 0 && newRow < a.length && newCol >= 0 && newCol < a[0].length && visited[newRow][newCol] == 0 && a[newRow][newCol] == 1){
                HelperFunc(newRow,newCol,a,visited);
            }
        }
    }
}
