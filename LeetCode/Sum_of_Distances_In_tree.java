package com.company.LeetCode;

import java.util.*;

public class Sum_of_Distances_In_tree {
    static private int[] subDist;
    static private int[] subCount;
    static private int N;

    static Map<Integer, List<Integer>> nbs = new HashMap<>();
    static private int[] res;

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
    }

    int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 1) return new int[]{0};
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            nbs.putIfAbsent(u, new ArrayList<>());
            nbs.putIfAbsent(v, new ArrayList<>());
            nbs.get(u).add(v);
            nbs.get(v).add(u);
        }

        this.N = N;
        this.subDist = new int[N];
        this.subCount = new int[N];

        postOrder(0, -1);

        // alternatively we can reuse the space of subDist
        this.res = new int[N];
        res[0] = subDist[0];

        for (int next : nbs.get(0)) {
            preOrder(next, 0);
        }
        return res;
    }

    // updating subDist, subCount for each node by post-order traversal
    static void postOrder(int node, int parent) {
        for (int child : nbs.get(node)) {
            if (child == parent) continue;

            postOrder(child, node);  // after dfs call, subDist & subCount for nb is calculated
            subDist[node] += (subDist[child] + subCount[child]);
            subCount[node] += subCount[child];
        }
        subCount[node]++;
    }

    // calculate final result for eahc node by pre-Order traversal
    static void preOrder(int node, int parent) {
        // res[node] = subDist[node] + (res[parent] - subDist[node] - subCount[node]) +
        //             (N - subCount[node]);
        res[node] =  (res[parent]  - subCount[node]) + (N - subCount[node]);
        for (int child : nbs.get(node)) {
            if (child == parent) continue;
            if (child != parent) preOrder(child, node);
        }
    }
}
