package com.company.Graphs;

import java.util.*;

class coordinates{
    int x;
    int y;
    public coordinates(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Number_of_Distinct_Islands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        Queue<coordinates> queue = new LinkedList<>();
        HashSet<List<String>> hSet = new HashSet<>();
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int row = 0;row < visited.length; row++){
            for(int col = 0;col < visited[row].length; col++){
                if(visited[row][col] == 0 && grid[row][col] == 1){
                    HelperFunc(new coordinates(row,col),grid,visited,queue,hSet,delRow,delCol,row,col);
                }
            }
        }

        System.out.println(hSet.size());

    }

    private static void HelperFunc(coordinates node, int[][] grid, int[][] visited, Queue<coordinates> queue, HashSet<List<String>> hSet,int[] delRow,int[] delCol,int baseX,int baseY) {
        List<String> list = new ArrayList<>();
        queue.offer(node);
        visited[baseX][baseY] = 1;
        list.add(toString(node.x - baseX,node.y - baseY));


        while(!queue.isEmpty()){
            coordinates cNode = queue.poll();
            int row = cNode.x;
            int col = cNode.y;

            // Checking all the four directions
            for(int i = 0;i < 4;i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                    coordinates newNode = new coordinates(newRow,newCol);
                    queue.offer(newNode);
                    visited[newRow][newCol] = 1;

                    int newX = newRow - baseX;
                    int newY = newCol - baseY;
                    list.add(toString(newX,newY));
                }
            }
        }
        hSet.add(list);
    }

    static String toString(int r,int c){
        return Integer.toString(r)  + " " + Integer.toString(c);
    }
}
