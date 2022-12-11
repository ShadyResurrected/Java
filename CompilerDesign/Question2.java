package com.company.CompilerDesign;

public class Question2 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bcd";
        int ans = Scsubstring(s1,s2);
        System.out.println(ans);
    }

    public static int Scsubstring(String s1, String s2) {
        int[] freq = new int[26];
        for(int i = 0;i < s1.length(); i++){
            char ch = s1.charAt(i);
            freq[ch - 'a']++;
        }
        int sum = 0;
        for(int i = 0;i < s2.length(); i++){
            char ch = s2.charAt(i);
            sum += freq[ch - 'a'];
        }
        return sum;
    }
}
