package com.company.LeetCode;

import java.util.HashMap;
import java.util.Iterator;

public class Find_The_Difference {
    public static void main(String[] args) {
        String s  = "a";
        String t = "aa";
        char ans = ' ';
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            hmap.put(s.charAt(i),i);
        }
        for(int i = 0; i < t.length(); i++){
            if(hmap.containsKey(t.charAt(i))){
                hmap.remove(t.charAt(i));
            }else
                ans = t.charAt(i);
        }
        System.out.println(ans);
    }
}
