package com.company.Miscellaneous;

public class ReverseNumber {
    public static void main(String[] args){
        int num = 23597;
        int rev_number = 0;
        while(num > 0){
            int Digit = num % 10;
            rev_number = (rev_number*10) + Digit;
            num = num / 10;
        }
        System.out.println("The reversed number is " + rev_number);
    }
}
