package com.company.DP;

import java.util.*;

public class Longest_String_Chain {
    public static void main(String[] args) {
        String[] arr = {"a","b","ba","bca","bda","bcda"};
    }
    public static int longestStrChain(int n, String[] arr) {
        // Write your code here.

        // Sorting the array as per the length of strings present in it
        Arrays.sort(arr, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
        int result = HelperFunc(arr);
        return result;
    }

    static int HelperFunc(String[] arr){
        int[] dpArr = new int[arr.length];
        Arrays.fill(dpArr,1);
        int maxi = 1;
        for(int i = 0;i < arr.length; i++){
            for(int prev_index = 0;prev_index < i; prev_index++){
                if(comparePossible(arr[i],arr[prev_index])){
                    dpArr[i] = 1 + dpArr[prev_index];
                }
            }
            if(dpArr[i] > maxi){
                maxi = dpArr[i];
            }
        }
        return maxi;
    }

    static boolean comparePossible(String s1,String s2){
        if(s1.length() != 1 + s2.length()) return false;
        int i = 0;
        int j = 0;

        while(i < s1.length()){
            if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++; j++;
            }else{
                i++;
            }
        }

        if(i == s1.length() && j == s2.length()) return true;
        return false;
    }
}
