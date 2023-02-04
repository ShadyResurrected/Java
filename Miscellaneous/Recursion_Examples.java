package com.company.Miscellaneous;

public class Recursion_Examples {
    public static void main(String[] args) {
        System.out.println(addProd(1342));
    }

    static void fun(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        fun(n-1);
    }

    static void funRev(int n){
        if(n == 0){
            return;
        }
        funRev(n-1);
        System.out.println(n);
    }

    static void funBoth(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }

    static int fact(int n){
        if(n <= 1){
            return 1;
        }
        return fact(n-1) * n;
    }
//    Sum of 1 to n numbers
    static int add(int n){
        if(n <= 1){
            return n;
        }
        return add(n-1) + n;
    }

//    Sum of the n digits of a number
    static int addSum(int n){
        if(n == 0){
            return 0;
        }
        return addSum(n/10) + n%10;
    }
//    Product of the n digits
    static int addProd(int n){
        if(n == 0){
            return 1;
        }
        return addProd(n/10) * (n%10);
    }
}
