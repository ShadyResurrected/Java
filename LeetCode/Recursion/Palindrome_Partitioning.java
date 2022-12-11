package com.company.LeetCode.Recursion;

import java.util.ArrayList;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String str = "aabb";
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        GenerateSubStrings(str,0,ans,new ArrayList<>());
        System.out.println(ans);
    }

    static void GenerateSubStrings(String str,int index,ArrayList<ArrayList<String>> ans,ArrayList<String> Pick){
        if(index == str.length()){
            ans.add(new ArrayList<>(Pick));
            return;
        }
        for (int i = index; i < str.length(); i++){
            String substr = str.substring(index,i+1);
            if(CheckPalindrome(substr)){
                Pick.add(substr);
                GenerateSubStrings(str,i+1,ans,Pick);
                Pick.remove(Pick.size()-1);
            }
        }
    }

    static boolean CheckPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
