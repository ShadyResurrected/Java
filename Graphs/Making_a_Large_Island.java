package com.company.Graphs;

import java.util.HashSet;

public class Making_a_Large_Island {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,1,1},
                {1,1,0,1,1},
                {1,1,0,1,1},
                {0,0,1,0,0},
                {0,0,1,1,1},
                {0,0,1,1,1},
        };
        int n = grid.length;
        int m = grid[0].length;

        int ans = HelperFunc(grid,n,m);
        System.out.println(ans);
    }

    static int HelperFunc(int[][] grid,int n,int m){
        int count = 0;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        DisjointSet dsu = new DisjointSet(n*m);

        // Forming all the components using disjoint set ds
        for (int row = 0;row < n; row++){
            for(int col = 0;col < m; col++){
                if(grid[row][col] == 1){
                    int Node = (m*row) + col;

                    // Traversing all the adjacent four directions
                    for(int i = 0;i < 4; i++){
                        int newRow = delRow[i] + row;
                        int newCol = delCol[i] + col;
                        if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1){
                            int newNode = (m*newRow) + newCol;
                            dsu.unionBySize(Node,newNode);
                        }
                    }
                }
            }
        }

        // Try converting all the zeros and find the size of max component
        for (int row = 0;row < n; row++){
            for(int col = 0;col < m; col++){
                int curNodes = 1;
                HashSet<Integer> hSet = new HashSet<>();
                if(grid[row][col] == 0){
                    int Node = (m*row) + col;

                    // Traversing all the adjacent four directions
                    for(int i = 0;i < 4; i++){
                        int newRow = delRow[i] + row;
                        int newCol = delCol[i] + col;
                        if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1){
                            int newNode = (m*newRow) + newCol;
                            int parent = dsu.findUPar(newNode);
                            // Edge case : to make sure that we take a component only once
                            if(!hSet.contains(parent)){
                                curNodes += dsu.size.get(parent);
                                hSet.add(parent);
                            }
                        }
                    }
                }
                count = Math.max(count,curNodes);
            }
        }

        return count;
    }
}
