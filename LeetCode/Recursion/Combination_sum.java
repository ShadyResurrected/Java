package com.company.LeetCode.Recursion;

import java.util.ArrayList;

public class Combination_sum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        GenerateSubsets(list,candidates,target,new ArrayList<>(),0);
        System.out.println(list);
    }
    static void GenerateSubsets(ArrayList<ArrayList<Integer>> list,int[] candidates, int target, ArrayList<Integer> Pick,int index){
        if( index == candidates.length || candidates[index] > target){
            if(target == 0){
                ArrayList<Integer> ans = new ArrayList<>(Pick);
                list.add(ans);
            }
            return;
        }
        // Picking the element from the same index
        Pick.add(candidates[index]);
        GenerateSubsets(list,candidates,target-candidates[index],Pick,index);
        // Removing the element
        Pick.remove(Pick.size()-1);
        // Moving onto to the next index
        GenerateSubsets(list,candidates,target,Pick,index+1);
    }
}
