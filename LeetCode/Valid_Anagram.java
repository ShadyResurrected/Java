package com.company.LeetCode;

import java.util.HashMap;

public class Valid_Anagram {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";
        String s = "ab";
        String t = "a";
        HashMap<Character,Integer> hMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if (hMap.containsKey(s.charAt(i))){
                int count = hMap.get(s.charAt(i));
                hMap.put(s.charAt(i),count+1);
            }else
                hMap.put(s.charAt(i),1);
        }
        for(int i = 0; i < t.length(); i++){
            if(hMap.containsKey(t.charAt(i)) && hMap.get(t.charAt(i)) != 0){
                int count = hMap.get(t.charAt(i));
                hMap.put(t.charAt(i),count-1);
            }else {
                System.out.println(false);
                break;
            }
        }
        System.out.println(true);
    }
}
