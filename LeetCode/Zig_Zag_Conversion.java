package com.company.LeetCode;

import java.util.*;

public class Zig_Zag_Conversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String ans = convert(s,numRows);
        System.out.println(ans);
    }
    static String convert(String s, int numRows) {
        TreeMap<Integer, Character> tMap = new TreeMap<>();

        for(int i = 0;i < s.length(); i++){
            tMap.put(i,s.charAt(i));
        }

        int gap = numRows;
        String res = "";

        for(int i = 0;i < numRows; i++){
            int pos = i;
            while(pos < s.length() && gap > 1){
                if(tMap.containsKey(pos)){
                    res += tMap.get(pos);
                    tMap.remove(pos);
                }
                pos += 2 * (gap-1);
            }
            if(gap > 0) gap--;
            else break;
        }

        //  Get all entries using the entrySet() method
        Set<Map.Entry<Integer, Character> > entries
                = tMap.entrySet();

        // Way 1
        // Using for loops
        for (Map.Entry<Integer, Character> entry : entries) {
            res += entry.getValue();
        }
        return res;
    }
}
