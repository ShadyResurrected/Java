package com.company.Miscellaneous;

public class No_Of_Digits_Using_log {
    public static void main(String[] args) {
        int n = 231243;
        int b = 2;
        int digits = (int)((Math.log(n) / Math.log(b)) + 1);
        System.out.println(digits);
    }
}
