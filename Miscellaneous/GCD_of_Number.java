package com.company.Miscellaneous;

public class GCD_of_Number {
    public static void main(String[] args) {
        System.out.println(gcd(4,3));
    }

    static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }
}
