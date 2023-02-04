package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_from_Source_To_Target {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
//        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> res = allPathsSourceTarget(graph);
        System.out.println(res);
    }
    static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if(graph.length == 0 || graph[0].length == 0)
            return paths;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        HelperFunc(graph,paths,list,0);

        return paths;
    }

    static void HelperFunc(int[][] graph, List<List<Integer>> res, List<Integer> list, int pos){
        if(pos == graph.length - 1){
            res.add(new ArrayList<>(list));
        }else{
            for(int d:graph[pos]){
                list.add(d);
                HelperFunc(graph,res,list,d);
                list.remove(list.size()-1);
            }
        }
    }
}
