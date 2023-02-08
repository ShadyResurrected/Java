package com.company.DP;

import java.util.*;

public class Boolean_Evaluation_To_True {
    public static void main(String[] args) {
        System.out.println(evaluateExp("T&T"));
    }

    static int mod = 1000000007;
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        int[][][] dpArr = new int[n+1][n+1][2];
        for(int[][] mat : dpArr) for(int[] row : mat) Arrays.fill(row,-1);
        return HelperFunc(0,n-1,exp,1,dpArr);
    }

    static int HelperFunc(int i,int j,String exp,int isTrue,int[][][] dpArr){
        // Base Case
        if(i > j) return 0;

        if(i == j){
            if(isTrue == 1){
                if(exp.charAt(i) == 'T') return 1;
                return 0;
            }else{
                if(exp.charAt(i) == 'F') return 1;
                return 0;
            }
        }

        if(dpArr[i][j][isTrue] != -1) return dpArr[i][j][isTrue];

        long ways = 0;

        for(int index = i+1; index < j; index += 2){

            long Ltrue = HelperFunc(i,index-1,exp,1,dpArr);
            long Lfalse = HelperFunc(i,index-1,exp,0,dpArr);
            long Rtrue = HelperFunc(index+1,j,exp,1,dpArr);
            long Rfalse = HelperFunc(index+1,j,exp,0,dpArr);

            if(exp.charAt(index) == '&'){
                if(isTrue == 1){
                    ways += (Ltrue * Rtrue)%mod;
                }else{
                    ways += (Lfalse*Rtrue)%mod + (Ltrue*Rfalse)%mod + (Lfalse*Rfalse)%mod;
                }
            }else if(exp.charAt(index) == '|'){
                if(isTrue == 1){
                    ways += (Lfalse*Rtrue)%mod + (Ltrue*Rfalse)%mod + (Ltrue*Rtrue)%mod;
                }else{
                    ways += (Lfalse*Rfalse)%mod;
                }
            }else if(exp.charAt(index) == '^'){
                if(isTrue == 1){
                    ways += (Ltrue*Rfalse)%mod + (Rtrue*Lfalse)%mod;
                }else{
                    ways += (Ltrue*Rtrue)%mod + (Lfalse*Rfalse)%mod;
                }
            }
        }

        return dpArr[i][j][isTrue] = (int)(ways%mod);
    }
}
