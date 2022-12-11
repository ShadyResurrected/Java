package com.company.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Subset_Sum_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int index = 0;
//        HashSet<ArrayList<Integer>> hSet = new HashSet<>();
//        ArrayList<Integer> Pick = new ArrayList<>();
//        GenerateSubsets(arr,hSet,index,Pick);
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        ans.addAll(hSet);
//        System.out.println(ans);

        ArrayList<ArrayList<Integer>> ans1 = new ArrayList<>();
        Arrays.sort(arr);
        GenerateSubsets2(0,arr,ans1,new ArrayList<>());
        System.out.println(ans1);
    }

    static void GenerateSubsets(int[] arr, HashSet<ArrayList<Integer>> hSet, int index,ArrayList<Integer> Pick){
        if(index == arr.length){
            ArrayList<Integer> ans = new ArrayList<>(Pick);
            hSet.add(ans);
            return;
        }
        Pick.add(arr[index]);
        GenerateSubsets(arr,hSet,index+1,Pick);
        Pick.remove(Pick.size()-1);
        GenerateSubsets(arr,hSet,index+1,Pick);
    }

    static void GenerateSubsets2(int index,int[] arr,ArrayList<ArrayList<Integer>> ans1,ArrayList<Integer> Pick){
        ans1.add(new ArrayList<>(Pick));
        for (int i = index; i < arr.length; i++){
            if(i != index && arr[i] == arr[i-1]) continue;
            // Picking the element
            Pick.add(arr[i]);
            GenerateSubsets2(i+1,arr,ans1,Pick);
            // Not Picking the element
            Pick.remove(Pick.size()-1);
        }
    }
}
