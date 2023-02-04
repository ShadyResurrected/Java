package com.company.Miscellaneous;
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class Number_of_Steps_to_reduce {
    public static void main(String[] args) {
        int n = 14;
        int count = 0;
//        System.out.println(count(n,count));
    }

//    static int count(int n,int count){
//        if(n == 0){
//            return count;
//        }
//        if(n%2 == 0){
//            return count(n/2,count+1);
//        }else
//            return count(n-1,count+1);
//    }

    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    static int helper(int num, int count){
        if(num == 0){
            return count;
        }
        if(num%2 == 0){
            return helper(num/2,count+1);
        }else
            return helper(num-1,count+1);
    }
}
