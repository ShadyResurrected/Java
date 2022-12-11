package com.company.Graphs;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Islands_II {
    public static void main(String[] args) {
        int[][] operators = {
                {0,0},
                {0,0},
                {1,1},
                {1,0},
                {0,1},
                {0,3},
                {1,3},
                {0,4},
                {3,2},
                {2,2},
                {1,2},
                {0,2},
        };
        int n = 4;
        int m = 5;

        int[][] islands = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        List<Integer> ans = new ArrayList<>();

        HelperFunc(operators,n,m,islands,visited,ans);

        System.out.println(ans);
    }

    private static void HelperFunc(int[][] operators, int n, int m, int[][] islands, boolean[][] visited,List<Integer> ans) {
        int count = 0;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        DisjointSet dsu = new DisjointSet(n*m);

        for(int i = 0;i < operators.length; i++){
            int row = operators[i][0];
            int col = operators[i][1];

            int node = (m * row) + col;

            if(!visited[row][col]){
                visited[row][col] = true;
                count++;
                islands[row][col] = 1;
                // Traversing all the adjacent four directions
                for(int j = 0;j < 4; j++){
                    int newRow = delRow[j] + row;
                    int newCol = delCol[j] + col;
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && islands[newRow][newCol] == 1){
                        int newNode = (m * newRow) + newCol;
                        if(dsu.findUPar(newNode) != dsu.findUPar(node)){
                            dsu.unionByRank(node,newNode);
                            count--;
                        }
                    }
                }
            }
            ans.add(count);
        }
    }
}
