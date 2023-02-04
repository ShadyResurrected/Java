package com.company.LeetCode;

import java.util.HashMap;
// Incomplete
public class String_Swap {
    public static void main(String[] args) {
        String s1 = "attack";
        String s2 = "atkact";
        HashMap<Integer,Character> hMap = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            hMap.put(i,s1.charAt(i));
        }
        int count = 2;
        for(int i = 0; i < s2.length(); i++){
            if(hMap.containsValue(s2.charAt(i))){
                if(hMap.get(i) != s2.charAt(i)){
                    count--;
                }
            }else {
                System.out.println(false);
                break;
            }
            if(count == -1) {
                System.out.println(false);
                break;
            }
        }
        System.out.println(true);
    }
}
