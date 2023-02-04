package com.company.AtCoder.Contest255;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Length = in.nextInt();
        int[] arr1 = new int[Length];
        for (int i = 0; i < Length; i++){
            arr1[i] = in.nextInt();
        }
        Arrays.sort(arr1);
        int minStart = 0;
        for(int i = 0 ; i < arr1.length; i++){
            if(minStart == arr1[i]){
                minStart++;
                i = 0;
            }
            if(i == arr1.length-1 && minStart != arr1[i]){
                System.out.println(minStart);
                break;
            }
        }
    }
}
