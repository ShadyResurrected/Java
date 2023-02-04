package com.company.DP;

import java.util.Arrays;

public class Distinct_Subsequences {
    public static void main(String[] args) {
        String t = "brootgroot";
        String s = "brt";
        int[][] dpArr = new int[t.length()+1][s.length()+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[t.length()+1][s.length()+1];
        int[] prev = new int[s.length()+1];

//      int countSubsequence = FindCount(t.length()-1,s.length()-1,t,s);
//      int countSubsequence1 = FindCount1(t.length()-1,s.length()-1,t,s,dpArr);
//      int countSubsequence2 = FindCount2(t,s,tabulated);
        int countSubsequence3 = FindCount3(t,s,prev);
        System.out.println(countSubsequence3);
    }

    static int FindCount(int index1,int index2,String t,String s){
        // Base Case
        if(index2 < 0) return 1;
        if(index1 < 0) return 0;
        // Now considering and not considering every character of the string alternatively
        if(t.charAt(index1) == s.charAt(index2))
            return FindCount(index1-1,index2-1,t,s) + FindCount(index1-1,index2,t,s);
        return FindCount(index1-1,index2,t,s);
    }

    static int FindCount1(int index1,int index2,String t,String s,int[][] dpArr){
        // Base Case
        if(index2 < 0) return 1;
        if(index1 < 0) return 0;
        if(dpArr[index1][index2] != -1) return dpArr[index1][index2];
        // Now considering and not considering every character of the string alternatively
        if(t.charAt(index1) == s.charAt(index2))
            return dpArr[index1][index2] = FindCount1(index1-1,index2-1,t,s,dpArr) + FindCount1(index1-1,index2,t,s,dpArr);
        return dpArr[index1][index2] = FindCount1(index1-1,index2,t,s,dpArr);
    }

    static int FindCount2(String t,String s,int[][] tabulated){
        // Initialising with the base condition
        for(int index1 = 0;index1 <= t.length();index1++) tabulated[index1][0] = 1;

        // Now traversing using the two for loops
        for(int index1 = 1;index1 <= t.length();index1++){
            for(int index2 = 1;index2 <= s.length();index2++){
                if(t.charAt(index1-1) == s.charAt(index2-1)) tabulated[index1][index2] = tabulated[index1-1][index2-1] + tabulated[index1-1][index2];
                else tabulated[index1][index2] = tabulated[index1-1][index2];
            }
        }
        return tabulated[t.length()][s.length()];
    }

    static int FindCount3(String t,String s,int[] prev){
        // Initialising with the base condition
        prev[0] = 1;

        // Now traversing using the two for loops
        for(int index1 = 1;index1 <= t.length();index1++){
            int[] current = new int[s.length()+1];
            for(int index2 = 1;index2 <= s.length();index2++){
                if(t.charAt(index1-1) == s.charAt(index2-1)) current[index2] = prev[index2-1] + prev[index2];
                else current[index2] = prev[index2];
            }
            prev = current;
        }
        return prev[s.length()];
    }
}
