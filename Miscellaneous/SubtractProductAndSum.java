package com.company.Miscellaneous;
//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
public class SubtractProductAndSum {
    public static void main(String[] args) {
        int n = 4421;
        System.out.println(prod(n) - Sum(n));
    }

    public int subtractProductAndSum(int n) {
        return prod(n) - Sum(n);
    }
    static int prod(int num){
        int result = 1;
        while(num > 0){
            result *= num%10;
            num = num/10;
        }
        return result;
    }

    static int Sum(int num){
        int result = 0;
        while(num != 0){
            result += num%10;
            num = num/10;
        }

        return result;
    }
}
