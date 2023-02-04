package com.company.DP;

import java.util.Arrays;

public class Edit_Distance {
    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";
        int[][] dpArr = new int[str1.length()][str2.length()];
        for(int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[str1.length()+1][str2.length()+1];
        int[] prev = new int[str2.length()+1];

//      int MinEditDistance = FindDistance(str1.length()-1,str2.length()-1,str1,str2);
//      int MinEditDistance1 = FindDistance1(str1.length()-1,str2.length()-1,str1,str2,dpArr);
//      int MinEditDistance2 = FindDistance2(str1,str2,tabulated);
        int MinEditDistance3 = FindDistance3(str1,str2,prev);
        System.out.println(MinEditDistance3);
    }

    static int FindDistance(int index1,int index2,String str1,String str2){
        // Base Case
        if(index1 < 0) return index2 + 1;
        if(index2 < 0) return index1 + 1;

        // Now considering the given three possibilities
        // If matched
        if(str1.charAt(index1) == str2.charAt(index2)) return FindDistance(index1-1,index2-1,str1,str2);
        // If not matched

        // We can delete one of the characters to match them
        int deleteChar = 1 + FindDistance(index1-1,index2,str1,str2);
        // We can insert one character
        int insertChar = 1 + FindDistance(index1-1,index2-1,str1,str2);
        // We can replace one character
        int replaceChar = 1 + FindDistance(index1-1,index2-1,str1,str2);

        return Math.min(deleteChar,Math.min(insertChar,replaceChar));
    }

    static int FindDistance1(int index1,int index2,String str1,String str2,int[][] dpArr){
        // Base Case
        if(index1 < 0) return index2 + 1;
        if(index2 < 0) return index1 + 1;

        if(dpArr[index1][index2] != -1) return dpArr[index1][index2];
        // Now considering the given three possibilities
        // If matched
        if(str1.charAt(index1) == str2.charAt(index2)) return FindDistance1(index1-1,index2-1,str1,str2,dpArr);
        // If not matched

        // We can delete one of the characters to match them
        int deleteChar = 1+ FindDistance1(index1-1,index2,str1,str2,dpArr);
        // We can insert one character
        int insertChar = 1 + FindDistance1(index1,index2-1,str1,str2,dpArr);
        // We can replace one character
        int replaceChar = 1 + FindDistance1(index1-1,index2-1,str1,str2,dpArr);

        return dpArr[index1][index2] = Math.min(deleteChar,Math.min(insertChar,replaceChar));
    }

    static int FindDistance2(String str1,String str2,int[][] tabulated){
        // Base Case
        for(int index1 = 0;index1 <= str1.length();index1++) tabulated[index1][0] = index1;
        for(int index2 = 0;index2 <= str2.length();index2++) tabulated[0][index2] = index2;

        // Now traversing using the for loops
        for(int index1 = 1;index1 <= str1.length();index1++){
            for(int index2 = 1;index2 <= str2.length();index2++){
                if(str1.charAt(index1-1) == str2.charAt(index2-1)) tabulated[index1][index2] = tabulated[index1-1][index2-1];
                // If not matched
                // We can delete one of the characters to match them
                else
                {
                    int deleteChar = 1 + tabulated[index1 - 1][index2];
                    // We can insert one character
                    int insertChar = 1 + tabulated[index1][index2 - 1];
                    // We can replace one character
                    int replaceChar = 1 + tabulated[index1 - 1][index2 - 1];
                    tabulated[index1][index2] = Math.min(deleteChar,Math.min(insertChar,replaceChar));
                }
            }
        }
        return tabulated[str1.length()][str2.length()];
    }

    static int FindDistance3(String str1,String str2,int[] prev){
        // Base Case
        for(int index2 = 0;index2 <= str2.length();index2++) prev[index2] = index2;

        // Now traversing using the for loops
        for(int index1 = 1;index1 <= str1.length();index1++){
            int[] current = new int[str2.length()+1];
            current[0] = index1;
            for(int index2 = 1;index2 <= str2.length();index2++){
                if(str1.charAt(index1-1) == str2.charAt(index2-1)) current[index2] = prev[index2-1];
                    // If not matched
                    // We can delete one of the characters to match them
                else
                {
                    int deleteChar = 1 + prev[index2];
                    // We can insert one character
                    int insertChar = 1 + current[index2 - 1];
                    // We can replace one character
                    int replaceChar = 1 + prev[index2 - 1];
                    current[index2] = Math.min(deleteChar,Math.min(insertChar,replaceChar));
                }
            }
            prev = current;
        }
        return prev[str2.length()];
    }
}
