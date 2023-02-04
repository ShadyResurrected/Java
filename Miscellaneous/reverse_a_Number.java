package com.company.Miscellaneous;

public class reverse_a_Number {
    static int sum = 0;
    static void reverse(int n){
        if(n==0){
            return;
        }
        int rem = n%10;
        sum = sum*10 + rem;
        reverse(n/10);
    }
    public static void main(String[] args) {
//        reverse(1236);
//        System.out.println(sum);
        System.out.println(reverse2(1874));
    }
    static int reverse2(int n){
        int digits = (int)(Math.log10(n) + 1);
        return anotherOne(n,digits);
    }

    private static int anotherOne(int n, int digits) {
        if(n%10 == n){
            return n;
        }
        return (int)((n%10) * Math.pow(10,digits-1)) + anotherOne(n/10,digits-1);
    }
}
