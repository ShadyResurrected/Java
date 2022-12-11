package com.company.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans1 = new ArrayList<>();
        HashMap<Integer,Integer> hMap = new HashMap<>();
        GeneratePermutations(arr,0,ans);
        GeneratePermutations2(arr,0,ans1,new ArrayList<>(),hMap);
        System.out.println(ans);
        System.out.println(ans1);
    }

    static void GeneratePermutations(int[] arr,int index,List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> Pick = new ArrayList<>();
            for(int e : arr){
                Pick.add(e);
            }
            ans.add(Pick);
            return;
        }
        for(int i = index; i < arr.length; i++){
            swap(i,index,arr);
            GeneratePermutations(arr,index+1,ans);
            swap(i,index,arr);
        }
    }

    static void GeneratePermutations2(int[] arr,int index,List<List<Integer>> ans,List<Integer> Pick,HashMap<Integer,Integer> hMap){
        if(Pick.size() == arr.length){
            ans.add(new ArrayList<>(Pick));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!hMap.containsKey(i)){
                Pick.add(arr[i]);
                hMap.put(i,1);
                GeneratePermutations2(arr,index,ans,Pick,hMap);
                hMap.remove(i);
                Pick.remove(Pick.size()-1);
            }
        }
    }

    static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
