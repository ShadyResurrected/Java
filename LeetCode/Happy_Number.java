package com.company.LeetCode;

import java.util.HashMap;

public class Happy_Number {
    public static void main(String[] args) {
        int n = 19;
        HashMap<Long,Integer> hMap = new HashMap<>();
        long num1 = n;
        while(num1 != 1){
            num1 = sumOfDigits(num1);
            if(hMap.containsKey(num1)){
                System.out.println(false);
            }
            hMap.put(num1,n);
        }
        System.out.println(true);
    }

    static long sumOfDigits(long n){
        long num = 0;
        while(n > 0){
            long digit = n % 10;
            num += digit*digit;
            n /= 10;
        }
        return num;
    }
}
