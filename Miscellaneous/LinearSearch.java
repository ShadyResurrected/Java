package com.company.Miscellaneous;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = {23,43,54,2,12,42};
        int num = in.nextInt();
        LinearSearch1(arr,num);
    }

    static void LinearSearch1(int[] arr, int num){
        int index = -1;
        for(int i:arr){
            index++;
            if(i == num) {
                System.out.println("The element is found on index " + index);
                return;
            }
            else if(index == (arr.length-1)){
                System.out.println("Element not found");
            }
        }
    }
}
