package com.company.DP;

import java.util.Arrays;

public class Minimum_Insertions_To_Make_Palindrome {
    public static void main(String[] args) {
        String str1 = "abcaa";
        String str2 = ReverseString(str1);
        int[][] dpArr = new int[str1.length()+1][str1.length()+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);

//      int maxLength = FindLength(str1.length()-1,str2.length()-1,str1,str2);
        int maxLength1 = FindLength1(str1.length()-1,str2.length()-1,str1,str2,dpArr);
        System.out.println(str1.length()-maxLength1);
    }
    private static int FindLength1(int index1, int index2, String str1, String str2,int[][] dpArr) {
        // Base Case
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        if(dpArr[index1][index2] != -1) return dpArr[index1][index2];
        // Now picking and not picking each element of the string
        if(str1.charAt(index1) == str2.charAt(index2))
            return 1 + FindLength1(index1-1,index2-1,str1,str2,dpArr);
        return dpArr[index1][index2] = Math.max(FindLength1(index1-1,index2,str1,str2,dpArr),FindLength1(index1,index2-1,str1,str2,dpArr));
    }
    static String ReverseString(String str){
        int start = str.length()-1;
        String PalStr = "";
        for (;start >= 0;start--){
            PalStr += str.charAt(start);
        }
        return PalStr;
    }
}
