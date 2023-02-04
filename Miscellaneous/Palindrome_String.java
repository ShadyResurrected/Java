package com.company.Miscellaneous;

import java.util.Arrays;
import java.util.Locale;

public class Palindrome_String {
    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
    }

    static boolean isPalindrome(String str){
        if(str == null || str.length()==0){
            return true;
        }

        str = str.toLowerCase();
        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length()-1-i);

            if(start!=end){
                return false;
            }
        }
        return true;
    }
}
