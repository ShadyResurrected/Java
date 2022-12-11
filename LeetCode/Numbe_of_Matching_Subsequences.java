package com.company.LeetCode;

import java.util.HashMap;

public class Numbe_of_Matching_Subsequences {
    public static void main(String[] args) {
//        String s = "abcde";
        String s = "dsahjpjauf";
//        String[] words = {"a","bb","acd","ace"};
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq(s,words));
    }

    static boolean isSubsequence(String text, String pattern)
    {
        if (pattern.length() > text.length()) return false;

        int i = 0, j = 0;
        while(i < text.length() && j < pattern.length())
        {
            if (text.charAt(i) == pattern.charAt(j)) { i++; j++; }
            else i++;
        }
        if (j == pattern.length()) return true;
        else return false;
    }
    static int numMatchingSubseq(String s, String[] words)
    {
        int ans = 0;
        HashMap<String, Integer>mp = new HashMap<>();
        for (String word : words)
        {
            if (mp.containsKey(word)) { ans += mp.get(word); continue; }

            if (isSubsequence(s, word)) { mp.put(word, 1); ans++; }
            else mp.put(word, 0);
        }
        return ans;

    }
}
