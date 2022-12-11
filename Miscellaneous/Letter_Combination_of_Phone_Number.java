package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_of_Phone_Number {
    public static void main(String[] args) {
        String s = "2";
//        System.out.println((int)(s.charAt(0) - '0'));
//        combi("",s);
        System.out.println(CombiRet("4"));
    }

    static void combi(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // This will convert '2' to 2
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch = (char)('a' + i);
            combi(p+ch,up.substring(1));
        }
    }
    static String p = "";
    static List<String> CombiRet(String digits){
        if(digits.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();
        int digit = digits.charAt(0) - '0';
        if(digit%2 == 0){
            for (int i = (digit-2)*3; i < digit*2-1; i++){
                char ch = (char)('a' + i);
                p += ch;
                ans.addAll(CombiRet(digits.substring(1)));
                p = p.substring(0,p.length()-1);
            }
        }else{
            for (int i = (digit-2)*3; i < digit*2; i++){
                char ch = (char)('a' + i);
                p += ch;
                ans.addAll(CombiRet(digits.substring(1)));
                p = p.substring(0,p.length()-1);
            }
        }

        return ans;

    }
}
