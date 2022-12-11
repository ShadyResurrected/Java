package com.company.String;

import java.util.ArrayList;
import java.util.Objects;

public class Compare_Version_Numbers {
    public static void main(String[] args) {
        String a = "1.23.45";
        String b = "1.23.456";
        int i = 0; int j = 0;
        while(i < a.length() && j < b.length()){
            int num1 = 0; int num2 = 0;
            while(i < a.length() && a.charAt(i) != '.'){
                num1 = num1 * 10 + (a.charAt(i) - '0');
                i++;
            }
            while(j < b.length() && b.charAt(j) != '.'){
                num2 = num2 * 10 + (b.charAt(j) - '0');
                j++;
            }
            if(num1 > num2) System.out.println(1);
            else if (num2 > num1) System.out.println(-1);
            i++; j++;
        }
        System.out.println(0);
    }
}
