package com.company.Miscellaneous;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String s = "abc";
//        printPermutation("",s);
        System.out.println(printPermutationslist("",s));
    }
    static void printPermutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            printPermutation(first+ch+second,up.substring(1));
        }
    }

    static ArrayList<String> printPermutationslist(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            ans.addAll(printPermutationslist(first+ch+second,up.substring(1)));
        }
        return ans;
    }
}
