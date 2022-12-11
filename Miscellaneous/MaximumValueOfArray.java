package com.company.Miscellaneous;

public class MaximumValueOfArray {
    public static void main(String[] args){
        int[] arr = {23, 3, 43, 99, 67, 4};
        MaxValue(arr);
    }
    static void MaxValue(int[] num){
        int Max = num[0];
        for(int a: num){
            if(a > Max){
                Max = a;
            }
        }
        System.out.println("The maximum value in the array is: " + Max);
    }
}
