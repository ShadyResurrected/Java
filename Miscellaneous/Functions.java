package com.company.Miscellaneous;

import java.util.Scanner;

public class Functions {
    public static void main(String[] args){
//        sum();
//        int result = sum2();
//        System.out.println(result);

//        int result = sum3(32,65);
//        System.out.println(result);
          swap(32,65);
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("The value of a is " + a + " and the value of b is " + b);
    }

    static void sum(){
        int num1,num2,sum;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        num1 = in.nextInt();
        System.out.print("Enter number 2: ");
        num2 = in.nextInt();
        sum = num1 + num2;
        System.out.println("The sum of two numbers is " + sum);
    }

    static int sum2(){
        int num1,num2,sum;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        num1 = in.nextInt();
        System.out.print("Enter number 2: ");
        num2 = in.nextInt();
        sum = num1 + num2;
        return sum;
    }

    static int sum3(int a, int b){
        int sum = a + b;
        return sum;
    }
}

