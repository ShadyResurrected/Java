package com.company.Miscellaneous;

public class Palindrome_Number {
    public static void main(String[] args) {
        int x = 11;
        if(x < 0){
            System.out.println(false);
        }
        if(x > -1 && x <= 9){
            System.out.println(true);
        }
        int rev = reverse(x);
        if(rev == x){
            System.out.println(true);
        }else
            System.out.println(false);
    }

    static int sum = 0;
    static int reverse(int x){
        if(x == 0){
            return sum;
        }
        int rem = x % 10;
        sum = (sum * 10) + rem;
        return reverse(x/10);
    }
}
