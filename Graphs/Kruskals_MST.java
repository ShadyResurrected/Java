package com.company.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class EdgeInfo{
    int u;
    int v;
    int weight;
    public EdgeInfo(int weight,int u,int v){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

class SortByWeight implements Comparator<EdgeInfo>{
    @Override
    public int compare(EdgeInfo o1, EdgeInfo o2) {
        return Integer.compare(o1.weight, o2.weight);
    }
}

public class Kruskals_MST {
    public static void main(String[] args) {
        int edges = 9;
        int vertices = 6;
        ArrayList<EdgeInfo> weights = new ArrayList<>();
        addEdge(weights,new EdgeInfo(1,1,4));
        addEdge(weights,new EdgeInfo(3,2,3));
        addEdge(weights,new EdgeInfo(2,1,2));
        addEdge(weights,new EdgeInfo(4,1,5));
        addEdge(weights,new EdgeInfo(3,2,4));
        addEdge(weights,new EdgeInfo(5,3,4));
        addEdge(weights,new EdgeInfo(7,2,6));
        addEdge(weights,new EdgeInfo(8,3,6));
        addEdge(weights,new EdgeInfo(9,4,5));
        Collections.sort(weights,new SortByWeight());

        int[] parent = new int[vertices+1];
        int[] rank = new int[vertices+1];
        int minWeight = 0;
        for (int i = 1;i < parent.length; i++){
            parent[i] = i;
        }
        while(weights.size() != 0){
            EdgeInfo node = weights.get(0);
            int u = node.u;
            int v = node.v;
            int weight = node.weight;
            boolean res = CheckCycle(u,v,parent,rank);
            if(!res){
                minWeight += weight;
            }
            weights.remove(node);
        }
        System.out.println(minWeight);
    }

    private static boolean CheckCycle(int u, int v, int[] parent, int[] rank) {
        int uParent = u;
        int vParent = v;
        while(parent[uParent] != uParent){
            uParent = parent[uParent];
        }
        while(parent[vParent] != vParent){
            vParent = parent[vParent];
        }
        if(uParent == vParent){
            // cycle is present
            return true;
        }
        int uRank = rank[uParent];
        int vRank = rank[vParent];
        if(uRank == vRank){
            parent[vParent] = uParent;
            rank[uParent] += 1;
        }else{
            if(uRank > vRank){
                parent[vParent] = uParent;
            }else{
                parent[uParent] = vParent;
            }
        }
        return false;
    }

    private static void addEdge(ArrayList<EdgeInfo> weights, EdgeInfo edgeInfo) {
        weights.add(edgeInfo);
    }


}
