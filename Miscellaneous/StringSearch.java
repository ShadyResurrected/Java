package com.company.Miscellaneous;

import java.util.Scanner;

public class StringSearch {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = "Chandradeep";
        char ch = 'd';
        boolean result = StringSearch2(str,ch);
        System.out.println(result);
    }
    static boolean StringSearch1(String str, char ch){
        if(str.length()==0){
            return false;
        }
        for(int i=0; i<str.length();i++){
            if(ch == str.charAt(i)){
                return true;
            }
        }
        return false;
    }

    static boolean StringSearch2(String str, char ch){
        if(str.length()==0){
            return false;
        }
        for(char ch1:str.toCharArray()){
            if(ch == ch1){
                return true;
            }
        }
        return false;
    }
}