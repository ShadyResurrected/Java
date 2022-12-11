package com.company.String;

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String str = "cbbd";
        int ans = 1;
        String res = "" + str.charAt(0);

        // Brute Force
        for (int i = 0;i < str.length();i++){
            for (int j = i;j < str.length();j++){
                String midString = str.substring(i,j+1);
                int length = midString.length();
                if(ifPalindrome(midString) && length > ans){
                    res = midString;
                    ans = length;
                }
            }
        }

        // Optimised Approach
        String res1 = LongestPalindrome(str);
        System.out.println(res1);
    }

    static String LongestPalindrome(String str){
        if(str.length() <= 1) return str;
        int max_length = 1;
        int start = 0;
        int end = 0;

        // For Odd Length palindrome
        for (int i = 0;i < str.length();i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < str.length()){
                if(str.charAt(left) == str.charAt(right)){
                    left--;
                    right++;
                }else break;
            }
            int length = right - left + 1;
            if(length > max_length){
                max_length = length;
                start = left + 1;
                end = right - 1;
            }
        }

        // For Even Length palindrome
        for (int i = 0;i < str.length();i++){
            int left = i;
            int right = i + 1;
            while(left >= 0 && right < str.length()){
                if(str.charAt(left) == str.charAt(right)){
                    left--;
                    right++;
                }else break;
            }
            int length = right - left + 1;
            if(length > max_length){
                max_length = length;
                start = left + 1;
                end = right - 1;
            }
        }

        return str.substring(start,end+1);
    }

    static boolean ifPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}
