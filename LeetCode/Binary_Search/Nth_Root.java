package com.company.LeetCode.Binary_Search;

public class Nth_Root {
    public static void main(String[] args) {
        int n = 4;
        long m = 69;
        double start = 1;
        double end = (double)m;
        while((end-start) > Math.pow(10,-10)){
            double diff = end - start;
            double mid = (start + (end-start)/2.0);
            double ans = Math.pow(mid,n);
            if(ans > m){
                end = mid;
            }else
                start = mid;
        }
        System.out.println(start);
        System.out.println(end);
    }
}
