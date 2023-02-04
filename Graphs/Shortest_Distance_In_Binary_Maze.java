package com.company.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class NodeCell{
    int distance;
    int row;
    int col;
    public NodeCell(int distance,int row,int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

public class Shortest_Distance_In_Binary_Maze {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};
        int[] source = {0, 1};
        int[] destination = {2, 2};
        int n = grid.length;
        int m = grid[0].length;

        Queue<NodeCell> queue = new LinkedList<>();

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row,(int)1e9);
        dist[source[0]][source[1]] = 0;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        int shortestDistance = HelperFunc(grid,source,destination,queue,dist,delRow,delCol);
        System.out.println(shortestDistance);
    }

    private static int HelperFunc(int[][] grid, int[] source, int[] destination, Queue<NodeCell> queue, int[][] dist,int[] delRow,int[] delCol) {
        queue.offer(new NodeCell(0,source[0],source[1]));
        while(!queue.isEmpty()){
            NodeCell curNode = queue.poll();
            int curDistance = curNode.distance;
            int curRow = curNode.row;
            int curCol = curNode.col;

            // Traversing all the adjacent four cells
            for (int i = 0;i < 4; i++){
                int newRow = delRow[i] + curRow;
                int newCol = delCol[i] + curCol;
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && (curDistance + 1 < dist[newRow][newCol])){
                    dist[newRow][newCol] = curDistance + 1;
                    if(newRow == destination[0] && newCol == destination[1]) return dist[newRow][newCol];
                    queue.offer(new NodeCell(dist[newRow][newCol],newRow,newCol));
                }
            }
        }
        if(dist[destination[0]][destination[1]] == (int)1e9) return -1;
        return 0;
    }

}
