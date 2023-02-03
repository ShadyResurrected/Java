package com.company.LeetCode;

import java.util.*;

public class Zig_Zag_Conversion {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String ans = convert(s,numRows);
        System.out.println(ans);
    }

    static String convert(String s, int numRows) {

        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        if(numRows == 1 || numRows == s.length()) return s;

        for(int i = 0;i < numRows; i++) list.add(new ArrayList<>());

        int row = 0;
        boolean flip = false;
        for(int i = 0;i < s.length(); i++){
            char ch = s.charAt(i);
            list.get(row).add(ch);

            if(flip) row--;
            else row++;

            if(row == numRows-1 || row == 0){
                flip = !flip;
            }
        }

        String res = "";

        for(ArrayList<Character> ele : list) for(char ch : ele) res += ch;

        return res;
    }
}
