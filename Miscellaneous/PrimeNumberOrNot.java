package com.company.Miscellaneous;

import java.util.Scanner;

public class PrimeNumberOrNot {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the number: ");
//        int a = in.nextInt();
        boolean result = Prime(13);
        System.out.println(result);
    }

    static boolean Prime(int num){
        if (num <= 1) {
            return false;
        }
        int c = 2;
        while(c * c <= num){
            if(num%c == 0){
                return false;
            }
            c++;
        }
        return c * c > num;

//        for(int i = 2; i < num; i++){
//            if(num%i == 0){
//                return false;
//            }
//        }
//        return true;
    }
}
