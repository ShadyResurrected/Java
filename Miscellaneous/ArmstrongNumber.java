package com.company.Miscellaneous;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        boolean result = CheckArmstrong(num);
//        System.out.println(result);
        // Prints all three digit Armstrong number
        for(int i = 100; i < 1000; i++){
            if(CheckArmstrong(i)){
                System.out.println(i);
            }
        }
    }

    static boolean CheckArmstrong(int num){
        int length = 0;
        int total = 0;
        int num1 = num;
        int num2 = num;
        while(num != 0){
            int last_Digit = num % 10;
            num = num / 10;
            length++;
        }
        while(num1 != 0){
            int Digit = num1 % 10;
            num1 = num1 / 10;
            total = (int)(total + Math.pow(Digit,length));
        }
        return total == num2; //It will return true or false because a condition check always return value in boolean
    }
}
