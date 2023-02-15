package com.company.LeetCode;

import java.util.*;

public class Add_Binary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        List<Integer> list = new ArrayList<>();

        String res = "";

        while(i >= 0 || j >= 0 || carry != 0){
            char ch1 = i >= 0 ? a.charAt(i) : '0';
            char ch2 = j >= 0 ? b.charAt(j) : '0';

            int ele = (int)ch1 ^ (int)ch2 ^ carry;

            list.add(ele);

            if((ch1 == '1' && ch2 == '1') || (carry == 1 && ch1 == '1') || (carry == 1 && ch2 == '1')) carry = 1;
            else carry = 0;

            i--; j--;
        }

        for(int k = list.size() - 1; k >= 0; k--){
            res += list.get(k);
        }

        return res;
    }
}
