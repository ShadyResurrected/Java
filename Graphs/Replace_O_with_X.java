package com.company.Graphs;

public class Replace_O_with_X {
    public static void main(String[] args) {
        char[][] a = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        int n = a.length;
        int m = a[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0;i < m; i++){
            // Traversing the horizontal boundary
            if(a[0][i] == 'O' && visited[0][i] == 0){
                HelperFunc(0,i,a,visited);
            }

            // Traversing the horizontal boundary at bottom
            if(a[n-1][i] == 'O' && visited[n-1][i] == 0){
                HelperFunc(n-1,i,a,visited);
            }
        }

        for(int i = 0;i < n; i++){
            // Traversing the vertical boundary
            if(a[i][0] == 'O' && visited[i][0] == 0){
                HelperFunc(i,0,a,visited);
            }

            // Traversing the vertical boundary in last
            if(a[i][m-1] == 'O' && visited[i][m-1] == 0){
                HelperFunc(i,m-1,a,visited);
            }
        }

        char[][] clone = new char[n][m];

        for(int row = 0;row < visited.length;row++){
            for(int col = 0;col < visited[row].length;col++){
                if(visited[row][col] == 0 && a[row][col] == 'O'){
                    a[row][col] = 'X';
                }
            }
        }

        for(int row = 0;row < visited.length;row++){
            for(int col = 0;col < visited[row].length;col++){
                System.out.print(a[row][col] + " ");
            }
            System.out.println();
        }
    }

    static void HelperFunc(int row,int col,char[][] a,int[][] visited){
        visited[row][col] = 1;

        // Traversing all the available four directions
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0;i < 4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            // Checking for the validity of the four directions
            if(newRow >= 0 && newRow < a.length && newCol >= 0 && newCol < a[0].length && visited[newRow][newCol] == 0 && a[newRow][newCol] == 'O'){
                HelperFunc(newRow,newCol,a,visited);
            }
        }
    }
}
