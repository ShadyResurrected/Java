package com.company.Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class MstNode{
    int u;
    int v;
    public MstNode(int u,int v){
        this.u = u;
        this.v = v;
    }
}

class NodeInfo{
    int weight;
    int v;
    public NodeInfo(int weight,int v){
        this.weight = weight;
        this.v = v;
    }
}

class qNode implements Comparator<qNode> {
    int weight;
    int v;
    int parentNode;
    public qNode(int weight,int v,int parentNode){
        this.weight = weight;
        this.v = v;
        this.parentNode = parentNode;
    }

    public qNode(){}

    @Override
    public int compare(qNode o1,qNode o2){
        if(o1.weight < o2.weight) return -1;
        if(o1.weight > o2.weight) return 1;
        return 0;
    }
}

public class Optimized_Prims_MST {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<NodeInfo>> adj = new ArrayList<>();

        for (int i = 0;i < vertices; i++){
            adj.add(new ArrayList<>());
        }

        addEdge(0,1,2,adj);
        addEdge(0,2,1,adj);
        addEdge(2,1,1,adj);
        addEdge(2,4,2,adj);
        addEdge(2,3,2,adj);
        addEdge(4,3,1,adj);

        ArrayList<MstNode> list = new ArrayList<>();

        int[] visited = new int[vertices];

        PriorityQueue<qNode> pq = new PriorityQueue<qNode>(vertices,new qNode());

        int minWeight = HelperFunc(adj,pq,visited,list);

        System.out.println(minWeight);

        for (int i = 0;i < list.size(); i++){
            System.out.print(list.get(i).u + " " + list.get(i).v);
            System.out.println();
        }
    }

    private static int HelperFunc(ArrayList<ArrayList<NodeInfo>> adj, PriorityQueue<qNode> pq, int[] visited, ArrayList<MstNode> list) {
        int sum = 0;
        pq.offer(new qNode(0,0,-1));
        while(!pq.isEmpty()){
            qNode cur = pq.poll();
            int curWeight = cur.weight;
            int curNode = cur.v;
            int curParent = cur.parentNode;

            // Mark the popped out node as visited and add it to the mst
            if(visited[curNode] == 0 && curParent != -1){
                list.add(new MstNode(curNode,curParent));
                sum += curWeight;
            }

            visited[curNode] = 1;

            for(NodeInfo adjacent : adj.get(curNode)){
                if(visited[adjacent.v] == 0){
                    pq.offer(new qNode(adjacent.weight, adjacent.v, curNode));
                }
            }
        }
        return sum;
    }

    static void addEdge(int u,int v,int weight,ArrayList<ArrayList<NodeInfo>> adj){
        adj.get(u).add(new NodeInfo(weight,v));
        adj.get(v).add(new NodeInfo(weight,u));
    }
}
