package com.company.DP;

import java.util.Arrays;

public class WIldCard_Pattern_Matching {
    public static void main(String[] args) {
        String pattern = "ab*cd";
        String text = "abdefcd";
        int[][] dpArr = new int[pattern.length()][text.length()];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        boolean[][] tabulated = new boolean[pattern.length()+1][text.length()+1];

//      boolean res = ifPatterMatch(pattern.length()-1,text.length()-1,pattern,text);
//      int res1 = ifPatterMatch1(pattern.length()-1,text.length()-1,pattern,text,dpArr);
        boolean res2 = ifPatterMatch2(pattern,text,tabulated);
        System.out.println(res2);
    }

    static boolean ifPatterMatch(int index1,int index2,String pattern,String text){
        // Base Case
        if(index1 < 0 && index2 < 0) return true;
        if(index1 < 0 && index2 >= 0) return false;
        if(index2 < 0 && index1 >= 0){
            for(int i = 0;i <= index1;i++){
                if(pattern.charAt(i) != '*') return false;
            }
            return true;
        }
        // Considering all the possibilities
        if(pattern.charAt(index1) == text.charAt(index2) || pattern.charAt(index1) == '?'){
            return ifPatterMatch(index1-1,index2-1,pattern,text);
        }
        if(pattern.charAt(index1) == '*'){
            return ifPatterMatch(index1-1,index2,pattern,text) || ifPatterMatch(index1,index2-1,pattern,text);
        }
        return false;
    }

    static int ifPatterMatch1(int index1,int index2,String pattern,String text,int[][] dpArr){
        // Base Case
        if(index1 < 0 && index2 < 0) return 1;
        if(index1 < 0 && index2 >= 0) return 0;
        if(index2 < 0 && index1 >= 0){
            for(int i = 0;i <= index1;i++){
                if(pattern.charAt(i) != '*') return 0;
            }
            return 1;
        }
        if(dpArr[index1][index2] != -1) return dpArr[index1][index2];
        // Considering all the possibilities
        if(pattern.charAt(index1) == text.charAt(index2) || pattern.charAt(index1) == '?'){
            return dpArr[index1][index2] = ifPatterMatch1(index1-1,index2-1,pattern,text,dpArr);
        }else if(pattern.charAt(index1) == '*'){
            return dpArr[index1][index2] = (ifPatterMatch1(index1-1,index2,pattern,text,dpArr) == 1 || ifPatterMatch1(index1,index2-1,pattern,text,dpArr) == 1) ? 1 : 0;
        }
        return 0;
    }

    static boolean ifPatterMatch2(String pattern,String text,boolean[][] tabulated){
        // Base Case
        tabulated[0][0] = true;
        for(int index2 = 1;index2 <= text.length();index2++) tabulated[0][index2] = false;
        for(int index1 = 1;index1 <= pattern.length();index1++){
            boolean flag = true;
            for(int i = 1;i <= index1;i++){
                if(pattern.charAt(i-1) != '*') {
                    flag = false;
                    break;
                }
            }
            tabulated[index1][0] = flag;
        }

        for(int index1 = 1;index1 <= pattern.length();index1++){
            for(int index2 = 1;index2 <= text.length();index2++){
                // Considering all the possibilities
                if(pattern.charAt(index1-1) == text.charAt(index2-1) || pattern.charAt(index1-1) == '?'){
                    tabulated[index1][index2] = tabulated[index1-1][index2-1];
                }else
                if(pattern.charAt(index1-1) == '*'){
                    tabulated[index1][index2] = tabulated[index1-1][index2] || tabulated[index1][index2-1];
                }else
                    tabulated[index1][index2] = false;
            }
        }
        return tabulated[pattern.length()][text.length()];
    }
}
