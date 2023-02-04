package com.company.Miscellaneous;

public class Odd_Or_Even_Binary {
    public static void main(String[] args) {
        int num = 99;
        System.out.println(isOdd(num));
    }

    static boolean isOdd(int num){
        return (num & 1) == 1;
    }
}
