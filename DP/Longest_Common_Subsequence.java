package com.company.DP;

import java.util.Arrays;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s = "adebc";
        String t = "dcadb";
        int[][] dpArr = new int[s.length()][t.length()];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[s.length()+1][t.length()+1];
        int[] prev = new int[t.length()+1];

//      int maxLength = FindMaxLength(s.length()-1,t.length()-1,s,t);
//      int maxLength1 = FindMaxLength1(s.length()-1,t.length()-1,s,t,dpArr);
//      int maxLength2 = FindMaxLength2(s,t,tabulated);
        int maxLength3 = FindMaxLength3(s,t,prev);
        System.out.println(maxLength3);
    }

    static int FindMaxLength(int indexS,int indexT,String s,String t){
        // Base Case
        if(indexS < 0 || indexT < 0) return 0;
        // Now considering the elements
        // If elements are same we add one to the ans and move both indexes forward
        if(s.charAt(indexS) == t.charAt(indexT))
            return 1 + FindMaxLength(indexS-1,indexT-1,s,t);
        return Math.max(FindMaxLength(indexS-1,indexT,s,t),FindMaxLength(indexS,indexT-1,s,t));
    }


    static int FindMaxLength1(int indexS,int indexT,String s,String t,int[][] dpArr){
        // Base Case
        if(indexS < 0 || indexT < 0) return 0;
        if(dpArr[indexS][indexT] != -1) return dpArr[indexS][indexT];
        // Now considering the elements
        // If elements are same we add one to the ans and move both indexes forward
        if(s.charAt(indexS) == t.charAt(indexT))
            return dpArr[indexS][indexT] = 1 + FindMaxLength1(indexS-1,indexT-1,s,t,dpArr);
        return dpArr[indexS][indexT] = Math.max(FindMaxLength1(indexS-1,indexT,s,t,dpArr),FindMaxLength1(indexS,indexT-1,s,t,dpArr));
    }

    static int FindMaxLength2(String s,String t,int[][] tabulated){
        // Base Case
        for (int i = 0;i < s.length();i++) tabulated[i][0] = 0;
        for (int j = 0;j < t.length();j++) tabulated[0][j] = 0;
        // Now copying the recursive code
        for(int i = 1;i < s.length()+1;i++){
            for(int j = 1;j < t.length()+1;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    tabulated[i][j] = 1 + tabulated[i-1][j-1];
                else tabulated[i][j] = Math.max(tabulated[i-1][j],tabulated[i][j-1]);
            }
        }
        return tabulated[s.length()][t.length()];
    }


    static int FindMaxLength3(String s,String t,int[] prev){
        // Base Case
        for (int i = 0;i < s.length();i++) prev[0] = 0;
        for (int j = 0;j < t.length();j++) prev[j] = 0;
        // Now copying the recursive code
        for(int i = 1;i < s.length()+1;i++){
            int[] current = new int[t.length()+1];
            for(int j = 1;j < t.length()+1;j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    current[j] = 1 + prev[j-1];
                else current[j] = Math.max(prev[j],current[j-1]);
            }
            prev = current;
        }
        return prev[t.length()];
    }
}
