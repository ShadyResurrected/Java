package com.company.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Longest_String_Chain {
    public static void main(String[] args) {
//        String[] arr = {"a","b","ba","bca","bda","bcda"};
        String[] arr = {"a","bc","ad","adc","bcd"};
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0;i < arr.length;i++) dp.add(1);
        int ans = FindChain(arr,dp);
        System.out.println(ans);
    }

    static int FindChain(String[] arr, ArrayList<Integer> dp){
        ArrayList<Integer> hash = new ArrayList<>();
        for(int i = 0;i < arr.length;i++) hash.add(i);
        int maxi = Integer.MIN_VALUE;

        for (int i = 1;i < arr.length;i++){
            for(int prev_element = 0;prev_element < i;prev_element++){
                if(CompareString(arr[i],arr[prev_element]) && dp.get(i) < 1 + dp.get(prev_element)){
                    dp.set(i,1+dp.get(prev_element));
                    hash.set(i,prev_element);
                    maxi = Math.max(maxi,dp.get(i));
                }
            }
        }
        return maxi;
    }

    static boolean CompareString(String A,String B){
        HashMap<Character,Integer> hMap = new HashMap<>();
        for (int i = 0;i < A.length();i++) {
            char ch = A.charAt(i);
            if(hMap.containsKey(ch)){
                int count = hMap.get(ch);
                hMap.put(ch,count+1);
            }else hMap.put(ch,1);
        }
        int length = 0;
        for (int i = 0;i < B.length();i++) {
            char ch = B.charAt(i);
            if(hMap.containsKey(ch)){
                int count = hMap.get(ch);
                hMap.put(ch,count-1);
                if(hMap.get(ch) == 0) hMap.remove(ch);
                length++;
            }
        }

        if(length == 0) return false;

        return Math.abs(hMap.size()-length) == 0;
    }
}
