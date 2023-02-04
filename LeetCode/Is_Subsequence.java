package com.company.LeetCode;
//https://leetcode.com/problems/is-subsequence/
public class Is_Subsequence {
    public static void main(String[] args) {
        String s = "ab";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    static boolean isSubsequence(String s,String t){
        int count = 0;
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)){
                    arr[i] = j;
                    if(i == 0){
                        count++;
                        break;
                    }else if(arr[i-1] < arr[i]){
                        count++;
                        break;
                    }
                }
            }
        }
        return count == s.length();
    }
}
