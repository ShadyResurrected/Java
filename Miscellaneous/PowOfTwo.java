package com.company.Miscellaneous;

public class PowOfTwo {
    public static void main(String[] args) {
        int n = 31; // Exception for 0
        boolean ans = (n & (n-1)) == 0;
        System.out.println(ans);
    }
}
