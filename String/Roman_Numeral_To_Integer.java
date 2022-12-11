package com.company.String;

import java.util.HashMap;

public class Roman_Numeral_To_Integer {
    public static void main(String[] args) {
        String s = "CCCLXXXIX";
        int ans = 0;
        HashMap<Character,Integer> hMap = new HashMap<>();
        hMap.put('I',1);
        hMap.put('V',5);
        hMap.put('X',10);
        hMap.put('L',50);
        hMap.put('C',100);
        hMap.put('D',500);
        hMap.put('M',1000);
        for(int i = 0;i < s.length()-1;i += 1){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(hMap.get(ch1) < hMap.get(ch2)){
                ans -= hMap.get(ch1);
            }else if(hMap.get(ch1) >= hMap.get(ch2)){
                ans += hMap.get(ch1);
            }
        }
        ans += hMap.get(s.charAt(s.length()-1));
        System.out.println(ans);
    }
}
