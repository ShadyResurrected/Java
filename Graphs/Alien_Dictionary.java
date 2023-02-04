package com.company.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Alien_Dictionary {
    public static void main(String[] args) {
        int N = 5;
        int K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};
        HashMap<Character,Integer> hMapChar = new HashMap<>();
        HashMap<Integer,Character> hMapValue = new HashMap<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i < K+1; i++){
            adj.add(new ArrayList<>());
        }

        // Inserting the characters with their corresponding vertex number
        char inChar = 'a';
        char inValue = 'a';
        for(int i = 0;i < K;i++) {
            hMapChar.put(inChar++, i);
            hMapValue.put(i,inValue++);
        }

        // Comparing the characters
        for(int i = 0;i < dict.length-1; i++){
            String str1 = dict[i];
            String str2 = dict[i+1];

            int c1 = 0;
            int c2 = 0;
            while(c1 < str1.length() && c2 < str2.length()){
                char ch1 = str1.charAt(c1);
                char ch2 = str2.charAt(c2);
                if(ch1 != ch2){
                    int u = hMapChar.get(ch1);
                    int v = hMapChar.get(ch2);
                    addEdge(u,v,adj);
                    break;
                }
                c1++; c2++;
            }
        }

        String res = "";
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[K];

        for (int i = 0;i < visited.length;i++){
            if(visited[i] == 0){
                TopologicalSort(i,adj,stack,visited);
            }
        }

        while (!stack.isEmpty()){
            int num = stack.pop();
            res += hMapValue.get(num);
        }

        System.out.println(res);
    }

    private static void TopologicalSort(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack,int[] visited) {
        visited[node] = 1;
        for (int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                TopologicalSort(adjNode,adj,stack,visited);
            }
        }
        stack.push(node);
    }


    static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
    }
}
