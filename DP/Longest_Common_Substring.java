package com.company.DP;

import java.util.Arrays;

public class Longest_Common_Substring {
    public static void main(String[] args) {
        String str1 = "abcjklp";
        String str2 = "acjkp";
        int[][] tabulated = new int[str1.length()+1][str2.length()+1];
        int[][] dpArr = new int[str1.length()+1][str2.length()+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[] prev = new int[str2.length()+1];

//      int maxLength = lcsubstring(str1,str2,str1.length(),str2.length(),0);
//      int maxLength2 = lcsubstring2(str1,str2,str1.length(),str2.length(),0,dpArr);
//      int maxLength1 = FindLength1(str1,str2,tabulated);
        int maxLength3 = FindLength3(str1,str2,prev);
        System.out.println(maxLength3);
    }

    public static int lcsubstring(String s1, String s2, int n, int m, int countOfLCS) {
        if(n == 0 || m == 0) {
            return countOfLCS;
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            countOfLCS = lcsubstring(s1, s2, n - 1, m - 1, countOfLCS + 1);
        }

        int count1 = lcsubstring(s1, s2, n - 1, m, 0);
        int count2 = lcsubstring(s1, s2, n, m - 1, 0);

        return Math.max(countOfLCS, Math.max(count1, count2));
    }

    public static int lcsubstring2(String s1, String s2, int n, int m, int countOfLCS,int[][] dpArr) {
        if(n == 0 || m == 0) {
            return countOfLCS;
        }

        if(dpArr[n][m] != -1) return dpArr[n][m];

        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            countOfLCS = lcsubstring2(s1, s2, n - 1, m - 1, countOfLCS + 1,dpArr);
        }

        int count1 = lcsubstring2(s1, s2, n - 1, m, 0,dpArr);
        int count2 = lcsubstring2(s1, s2, n, m - 1, 0,dpArr);

        return dpArr[n][m] = Math.max(countOfLCS, Math.max(count1, count2));
    }

    static int FindLength1(String str1,String str2,int[][] tabulated){
        // Initialising base case
        for(int index1 = 0;index1 < str1.length();index1++){
            tabulated[index1][0] = 0;
        }
        for(int index2 = 0;index2 < str2.length();index2++){
            tabulated[0][index2] = 0;
        }
        // Now traversing using two for loops
        int maxLength = 0;
        for(int index1 = 1;index1 <= str1.length();index1++){
            for(int index2 = 1;index2 <= str2.length();index2++){
                if(str1.charAt(index1-1) == str2.charAt(index2-1)){
                    tabulated[index1][index2] = 1 + tabulated[index1-1][index2-1];
                    maxLength = Math.max(maxLength,tabulated[index1][index2]);
                }
            }
        }

        return maxLength;
    }

    static int FindLength3(String str1,String str2,int[] prev){
        // Initialising base case
        for(int index1 = 0;index1 < str1.length();index1++){
            prev[0] = 0;
        }
        for(int index2 = 0;index2 < str2.length();index2++){
            prev[index2] = 0;
        }
        // Now traversing using two for loops
        int maxLength = 0;
        for(int index1 = 1;index1 <= str1.length();index1++){
            int[] current = new int[str2.length()+1];
            for(int index2 = 1;index2 <= str2.length();index2++){
                if(str1.charAt(index1-1) == str2.charAt(index2-1)){
                    current[index2] = 1 + prev[index2-1];
                    maxLength = Math.max(maxLength,current[index2]);
                }
            }
            prev = current;
        }

        return maxLength;
    }
}
