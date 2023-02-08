package com.company.LeetCode;

import java.util.*;

public class Find_All_Anagrams_In_A_String {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int len = p.length();
        char[] check = new char[len];
        for(int i = 0;i < len; i++){
            char ch = p.charAt(i);
            check[i] = ch;
        }
        Arrays.sort(check);

        for(int i = 0;i <= s.length()-len; i++){
            String res = s.substring(i,i+len);
            char[] mid = res.toCharArray();
            Arrays.sort(mid);
            int count = 0;
            for(int j = 0;j < mid.length; j++){
                char ch1 = mid[j];
                char ch2 = check[j];
                count += ch1 ^ ch2;
            }
            if(count == 0) list.add(i);
        }
        return list;
    }
}
