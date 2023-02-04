package com.company.Miscellaneous;
// https://leetcode.com/problems/richest-customer-wealth/
public class Richest_Customer {
    public static void main(String[] args) {
        int[][] accounts = {
                {1,5},
                {7,3},
                {3,5}
        };

        System.out.println(MaxWealth(accounts));
    }

    public int maximumWealth(int[][] accounts) {
        int MAX = Integer.MIN_VALUE;
        for(int row=0;row<accounts.length;row++){
            int sum = 0;
            for(int col = 0;col<accounts[row].length;col++){
                sum = sum + accounts[row][col];
            }
            if(sum > MAX){
                MAX = sum;
            }
        }

        return MAX;
    }

    static int MaxWealth(int[][] accounts){
        int MAX = Integer.MIN_VALUE;
        for(int row=0;row<accounts.length;row++){
            int sum = 0;
            for(int col = 0;col<accounts[row].length;col++){
                sum = sum + accounts[row][col];
            }
            if(sum > MAX){
                MAX = sum;
            }
        }

        return MAX;
    }
}
