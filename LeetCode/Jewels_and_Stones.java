package com.company.LeetCode;

import java.util.Hashtable;

public class Jewels_and_Stones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int count = 0;
        Hashtable<Character, Integer> htable = new Hashtable<>();
        for(int i = 0; i < jewels.length() ; i++){
            htable.put(jewels.charAt(i), 0);
        }
        for(int i = 0; i < stones.length(); i++){
            if(htable.containsKey(stones.charAt(i))){
                int countKey = htable.get(stones.charAt(i));
                htable.put(stones.charAt(i), countKey+1);
                count ++;
            }
        }
        System.out.println(htable);
        System.out.println(count);
    }
}
