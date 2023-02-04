package com.company.Miscellaneous;

import java.util.Scanner;

public class CountingOccurences {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num1 = 1342254854;
        int occur = 4;
        int count = 0;
        while (num1 > 0){
            int lastDigit = num1 % 10;
            if (lastDigit == occur){
                count++;
            }
            num1 = num1 / 10;
        }
        System.out.println("The number of times " + occur + " has occured is " + count);
    }
}
