package com.company.DP;

import java.util.Arrays;

public class Shortest_Common_Supersequence {
    public static void main(String[] args) {
        String A = "brute";
        String B = "groot";
        int[][] dpArr = new int[A.length()+1][B.length()+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);

        int maxLengthLcs = FindLength(A.length()-1,B.length()-1,A,B,dpArr);
        System.out.println(A.length()+B.length()-maxLengthLcs);
    }

    static int FindLength(int index1,int index2,String A,String B,int[][] dpArr){
        // Base Case
        if(index1 < 0 || index2 < 0) return 0;
        if(dpArr[index1][index2] != -1) return dpArr[index1][index2];
        // Now considering and not considering alternatively every character of the given strings
        if(A.charAt(index1) == B.charAt(index2))
            return 1 + FindLength(index1-1,index2-1,A,B,dpArr);
        return dpArr[index1][index2] = Math.max(FindLength(index1-1,index2,A,B,dpArr),FindLength(index1,index2-1,A,B,dpArr));
    }
}
