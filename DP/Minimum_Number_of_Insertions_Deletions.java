package com.company.DP;

import java.util.Arrays;

public class Minimum_Number_of_Insertions_Deletions {
    public static void main(String[] args) {
        String str = "abcd";
        String ptr = "anc";
        int[][] dpArr = new int[str.length()+1][ptr.length()+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);

//      int maxLength = FindLength(str.length()-1,ptr.length()-1,str,ptr);
        int maxLength1 = FindLength1(str.length()-1,ptr.length()-1,str,ptr,dpArr);
        System.out.println((str.length()-maxLength1 + (ptr.length()-maxLength1)));
    }

    static int FindLength(int index1,int index2,String str,String ptr){
        // Base Case
        if(index1 < 0 || index2 < 0) return 0;
        // Now considering every character of the string or not
        // If the character matches then move both indexes by 1
        if(str.charAt(index1) == ptr.charAt(index2))
            return 1 + FindLength(index1-1,index2-1,str,ptr);
        // If the character does not match then move both of them alternatively
        return Math.max(FindLength(index1-1,index2,str,ptr),FindLength(index1,index2-1,str,ptr));
    }

    static int FindLength1(int index1,int index2,String str,String ptr,int[][] dpArr){
        // Base Case
        if(index1 < 0 || index2 < 0) return 0;
        if(dpArr[index1][index2] != -1) return dpArr[index1][index2];
        // Now considering every character of the string or not
        // If the character matches then move both indexes by 1
        if(str.charAt(index1) == ptr.charAt(index2))
            return 1 + FindLength1(index1-1,index2-1,str,ptr,dpArr);
        // If the character does not match then move both of them alternatively
        return dpArr[index1][index2] = Math.max(FindLength1(index1-1,index2,str,ptr,dpArr),FindLength1(index1,index2-1,str,ptr,dpArr));
    }
}
