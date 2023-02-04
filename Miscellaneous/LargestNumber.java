package com.company.Miscellaneous;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        int max = num1;
        if (num2 > max){
            max = num2;
        }
        if (num3 > max){
            max = num3;
        }
        System.out.println("The largest number is " + max);
    }
}
