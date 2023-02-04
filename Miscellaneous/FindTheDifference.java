package com.company.Miscellaneous;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheDifference {
    public static void main(String[] args) {
        String s = "";
        String t = "y";
//        System.out.println(findDiff(s,t));

    }

    static char findDiff(String s, String t){

        for (int i = 0; i < s.length(); i++){
            if(t.charAt(i) != s.charAt(i)){
                return t.charAt(i);
            }
        }
        return t.charAt(t.length()-1);
    }
}
