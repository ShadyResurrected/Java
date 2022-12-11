package com.company.LeetCode.Recursion;

// Incomplete

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Word_Break {
    public static void main(String[] args) {
//        String s = "leetcode";
//        String[] wordDict = {"leet","code"};
//        String s = "catsandog";
//        String[] wordDict = {"cats","dog","sand","and","cat"};
//        String s = "applepenapple";
//        String[] wordDict = {"apple","pen"};
        String s = "aaaaaaa";
        String[] wordDict = {"aaaa","aaa"};
        HashSet<String> hSet = new HashSet<>();
        for(String s1 : wordDict){
            hSet.add(s1);
        }
        boolean ans = BreakTheWord(s,wordDict,0,hSet,"");
        System.out.println(ans);
    }

    static boolean BreakTheWord(String s,String[] wordDict,int n,HashSet<String> hSet,String str){
        if(n == s.length()){
            return hSet.contains(str);
        }
        for(int i = n; i < s.length(); i++){
            if(hSet.contains(str)){
                BreakTheWord(s,wordDict,i+1,hSet,"");
                return true;
            }
            BreakTheWord(s,wordDict,i+1,hSet,str+s.charAt(i));
        }
        return false;
    }
}
