package com.company.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MultiplyNode{
    int steps;
    int node;
    public MultiplyNode(int steps,int node){
        this.steps = steps;
        this.node = node;
    }
}

public class Minimum_Multiplications_To_Reach_End {
    public static void main(String[] args) {
        int[] arr = {3,4,65};
        int start = 7;
        int end = 66175;
        int mod = 100000;

        int[] dist = new int[100000];
        Arrays.fill(dist,(int)1e9);
        dist[start] = 0;

        Queue<MultiplyNode> queue = new LinkedList<>();
        HelperFunc(arr,start,end,queue,dist,mod);
        System.out.println(dist[end]);
    }

    private static void HelperFunc(int[] arr, int start, int end, Queue<MultiplyNode> queue, int[] dist, int mod) {
        queue.offer(new MultiplyNode(0,start));
        while (!queue.isEmpty()){
            MultiplyNode cur = queue.poll();
            int curSteps = cur.steps;
            int curNode = cur.node;

            // Traversing all the adjacent nodes
            // that is multiplying by all the elements present in the array
            for(int ele : arr){
                int adjNode = (curNode * ele) % mod;
                if(curSteps + 1 < dist[adjNode]){
                    dist[adjNode] = curSteps + 1;
                    if(adjNode == end) return;
                    queue.offer(new MultiplyNode(curSteps+1,adjNode));
                }
            }
        }
    }
}
