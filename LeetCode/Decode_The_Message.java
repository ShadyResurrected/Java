package com.company.LeetCode;

import java.util.HashMap;

public class Decode_The_Message {
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
//        key = key.replaceAll("\\s", "");
        char ch = 'a';
        int alpha = 0;
        HashMap<Character,Character> hMap = new HashMap<>();
        for(int i = 0; i < key.length(); i++){
            if(!hMap.containsKey(key.charAt(i)) && key.charAt(i) != ' '){
                hMap.put(key.charAt(i),ch++);
            }
        }
        String ans = "";
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) != ' '){
                ans += hMap.get(message.charAt(i));
            }else
                ans += " ";
        }
        System.out.println(ans);
    }
}
