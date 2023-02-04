package com.company.Miscellaneous;

public class Square_Root {
    public static void main(String[] args) {
        int n = 1234;
        int precision = 3;
        System.out.println(root(n,precision));
    }

    static double root(int n, int p){
        double root = 0.0;
        int start = 0;
        int end = n;
        while(start <= end){
            int mid = start +(end-start)/2;

            if(mid * mid == n){
                return mid;
            }

            if(mid*mid > n){
                end = mid - 1;
            }else
                start = mid + 1;

        }

        // For decimal part of the root
        double increment = 0.1;
        for (int i = 0; i < p; i++) {
            while(root * root <= n){
                root += increment;
            }

            root -= increment;
            increment /= 10;
        }


        return root;
    }
}
