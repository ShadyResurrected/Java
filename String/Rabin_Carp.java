package com.company.String;

import java.util.ArrayList;

public class Rabin_Carp {
    public static void main(String[] args) {
        String str = "AABAACAADAABAABA";
        String pat = "AABA";
        int N = str.length();
        int M = pat.length();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i <= N-M;i++){
            String midAns = str.substring(i,i+M);
            if(midAns.equals(pat)) list.add(i);
        }
        System.out.println(list);
    }
}
