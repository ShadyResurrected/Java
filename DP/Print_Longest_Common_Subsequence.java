package com.company.DP;

public class Print_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s1 = "abcdeacv";
        String s2 = "bdgekacv";
        int[][] tabulated = new int[s1.length()+1][s2.length()+1];
        int maxLength2 = FindMaxLength2(s1,s2,tabulated);

        int index = maxLength2-1;
        StringBuilder str = new StringBuilder();
        for (int i = 0;i < maxLength2; i++){
            str.append("8");
        }
        int i = s1.length(); int j = s2.length();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                str.setCharAt(index,s2.charAt(j-1));
                index--;
                i--; j--;
            }else if(tabulated[i-1][j] > tabulated[i][j-1]){
                i--;
            }else j--;
        }
        System.out.println(str);
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
}
