package com.company.Miscellaneous;

public class MinElementInArray {
    public static void main(String[] args){
        int[] arr = {23,43,54,2,12,42};
//        System.out.println(MinValue(arr));
    }


    static int MinValue(int[] arr){
        int Min = arr[0];
        for(int i: arr){
            if(i < Min){
                Min = i;
            }
        }
        return Min;
    }
}
