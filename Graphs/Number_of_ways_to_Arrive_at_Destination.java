package com.company.Graphs;

import java.util.*;

class NNode implements Comparator<NNode> {
    int v;
    int time;
    public NNode(int v,int time){
        this.v = v;
        this.time = time;
    }

    public NNode(){}

    @Override
    public int compare(NNode o1, NNode o2) {
        if(o1.time < o2.time) return -1;
        if(o1.time > o2.time) return 1;
        return 0;
    }
}

public class Number_of_ways_to_Arrive_at_Destination {

    static int mod = (int)(1e9 + 7);

    public static void main(String[] args) {
        int n = 9;
        List<List<NNode>> adj = new ArrayList<>();

        for (int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(0,1,1,adj);
        addEdge(0,2,2,adj);
        addEdge(0,3,1,adj);
        addEdge(0,4,2,adj);
        addEdge(1,5,2,adj);
        addEdge(2,5,1,adj);
        addEdge(3,5,2,adj);
        addEdge(3,7,3,adj);
        addEdge(3,6,2,adj);
        addEdge(4,6,1,adj);
        addEdge(5,8,1,adj);
        addEdge(7,8,1,adj);
        addEdge(6,8,1,adj);

        int[] ways = new int[n];
        ways[0] = 1;

        int[] distance = new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[0] = 0;

        PriorityQueue<NNode> pq = new PriorityQueue<NNode>(n,new NNode());

        HelperFunc(adj,distance,ways,pq);

        System.out.println(ways[n-1]);
    }


    private static void HelperFunc(List<List<NNode>> adj, int[] distance, int[] ways, PriorityQueue<NNode> pq) {
        pq.offer(new NNode(0,0));
        while(!pq.isEmpty()){
            NNode cur = pq.poll();
            int v = cur.v;
            int curTime = cur.time;
            for(NNode ele : adj.get(v)){
                int adjNode = ele.v;
                int adjNodeTime = ele.time;
                if(curTime + adjNodeTime < distance[adjNode]){
                    distance[adjNode] = curTime + adjNodeTime;
                    ways[adjNode] += ways[v] % mod;
                    pq.offer(new NNode(adjNode,distance[adjNode]));
                }else if(curTime + adjNodeTime == distance[adjNode]){
                    ways[adjNode] += ways[v] % mod;
                }
            }
        }
    }

    static void addEdge(int u,int v,int time,List<List<NNode>> adj){
        adj.get(u).add(new NNode(v,time));
        adj.get(v).add(new NNode(u,time));
    }
}
