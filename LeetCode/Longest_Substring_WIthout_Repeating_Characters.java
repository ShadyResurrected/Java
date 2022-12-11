package com.company.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class Longest_Substring_WIthout_Repeating_Characters {
    public static void main(String[] args) {
        String str = "abcabcabb";

        // Need some improvement

//        int maxLength = 0;
//        String ans = "";
//        int recent_pos = 0;
//        HashMap<Character,Integer> hmap = new HashMap<>();
//        for(int i = 0; i < str.length(); i++){
//            char current_char = str.charAt(i);

            //Checking the char in hashmap

//            if(!hmap.containsKey(current_char)){
//                hmap.put(current_char,i);
//                if(recent_pos == 0 || recent_pos+1 == i){
//                    recent_pos = i;
//                    ans += current_char;
//                    maxLength++;
//                }
//            }else
//                continue;
//
//
//        }
//        System.out.println(maxLength);

        // Brute Force approach
        // Generate all the substrings and then traverse them to find the longest substring without repeating characters


        // Better Approach 1
        // Complexity - O(2N) [sometimes the left and right pointer might traverse complete array]


        HashSet<Character> hSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength1 = 1;
        for (int i = 0; i < str.length(); i++){
            if(!hSet.contains(str.charAt(i))){
                int length = right - left + 1;
                if(length > maxLength1){
                    maxLength1 = length;
                }
                hSet.add(str.charAt(i));
                right++;
            }else{
                while(hSet.contains(str.charAt(i))){
                    hSet.remove(str.charAt(left));
                    left++;
                }
                hSet.add(str.charAt(i));
                right++;
            }
        }
        System.out.println(maxLength1);

        // Optimised Approach
        int left1 = 0;
        int right1 = 0;
        int maxLength2 = 1;

        // For Edge cases
        if(str.length() < 2){
            System.out.println(str.length());
        }
        HashMap<Character,Integer> hmap1 = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(!hmap1.containsKey(str.charAt(i))){
                int length = right1 - left1 + 1;
                maxLength2 = Math.max(length,maxLength2);
                hmap1.put(str.charAt(i),i);
                right1++;
            }else{
                int recent_pos1 = hmap1.get(str.charAt(i));
                if(recent_pos1 <= right1 && recent_pos1 >= left1){
                    left1 = recent_pos1 + 1;
                }else{
                    int length = right1 - left1 + 1;
                    maxLength2 = Math.max(length,maxLength2);
                }
                hmap1.put(str.charAt(i),i);
                right1++;
            }
        }
        System.out.println(maxLength2);
    }
}
