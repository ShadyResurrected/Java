package com.company.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination_Sum2 {
    public static void main(String[] args) {
        int[] candidates = {1,1,1,2,2};
        int target = 4;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        GenerateSubsets(0,ans,candidates,target,new ArrayList<>());
        System.out.println(ans);
    }

    static void GenerateSubsets(int index,ArrayList<ArrayList<Integer>> ans,int[] candidates,int target,ArrayList<Integer> Pick){
        if(target == 0){
            ArrayList<Integer> list1 = new ArrayList<>(Pick);
            ans.add(list1);
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            Pick.add(candidates[i]);
            GenerateSubsets(i+1,ans,candidates,target-candidates[i],Pick);
            Pick.remove(Pick.size()-1);
        }
    }
}
