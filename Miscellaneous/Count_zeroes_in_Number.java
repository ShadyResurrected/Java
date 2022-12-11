package com.company.Miscellaneous;

public class Count_zeroes_in_Number {
    public static void main(String[] args) {
        int n = 30210;
        int count = 0;
        System.out.println(checkZeroes(n,count));
    }

    static int checkZeroes(int n, int count){
        if(n/10 == 0){
            if(n%10 == 0){
                count++;
            }
            return count;
        }
        if(n%10 == 0){
            count++;
        }
        return checkZeroes(n/10,count);
    }
}
