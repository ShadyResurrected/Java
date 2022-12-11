package com.company.Miscellaneous;

import java.util.Scanner;

public class Find_Unique_using_XOR {
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4};
//        System.out.println(unique(arr));
    }

    static int unique(int[] arr){
        int unique = 0;

        for (int k: arr){
            unique = unique ^ k;
        }


        return unique;
    }
}
