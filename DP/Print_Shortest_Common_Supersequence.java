package com.company.DP;

import java.util.Stack;

public class Print_Shortest_Common_Supersequence {
    public static void main(String[] args) {
        String A = "coding";
        String B = "ninjas";
        int[][] tabulated = new int[A.length()+1][B.length()+1];

        int maxLengthLcs = FindLength(A,B,tabulated);
        Stack<Character> stack = new Stack<>();
        String ans = "";

        int i = A.length();
        int j = B.length();
        while(i > 0 && j > 0){
            if(A.charAt(i-1) == B.charAt(j-1)){
                stack.push(A.charAt(i-1));
                i--; j--;
            }else{
               if(tabulated[i-1][j] > tabulated[i][j-1]){
                   stack.push(A.charAt(i-1));
                   i--;
               }else{
                   stack.push(B.charAt(j-1));
                   j--;
               }
            }
        }
        while(i > 0) stack.push(A.charAt(--i));
        while(j > 0) stack.push(B.charAt(--j));

        while (!stack.isEmpty()) ans += stack.pop();
        System.out.println(ans);
    }

    static int FindLength(String A,String B,int[][] tabulated){
        // Base Case
        for(int index1 = 0;index1 < A.length();index1++) tabulated[index1][0] = 0;
        for(int index2 = 0;index2 < B.length();index2++) tabulated[0][index2] = 0;

        for(int index1 = 1;index1 <= A.length();index1++){
            for(int index2 = 1;index2 <= B.length();index2++){
                if(A.charAt(index1-1) == B.charAt(index2-1)) tabulated[index1][index2] = 1 + tabulated[index1-1][index2-1];
                else tabulated[index1][index2] = Math.max(tabulated[index1-1][index2],tabulated[index1][index2-1]);
            }
        }
        return tabulated[A.length()][B.length()];
    }
}
