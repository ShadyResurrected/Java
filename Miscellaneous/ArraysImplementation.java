package com.company.Miscellaneous;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysImplementation {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // First way to take input and print output
//        int[] arr = new int[5];
//        for(int i = 0;i<arr.length;i++){
//            int num = in.nextInt();
//            arr[i] = num;
//        }
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i] + " ");
//        }

        // Second way to take input and print output
//        int[] arr1 = new int[5];
//        for(int i=0;i<arr1.length;i++){
//            int num1 = in.nextInt();
//            arr1[i] = num1;
//        }
//        for(int num: arr1){ // Using a for each loop
//            System.out.println(num);
//        }

        // Third way to take input and print output
//        int[] arr2 = new int[5];
//        for(int i=0;i< arr2.length;i++){
//            int num3 = in.nextInt();
//            arr2[i] = num3;
//        }
//        System.out.println(Arrays.toString(arr2));

        // 2D arrays

        //First Option
        //To take input in an 2D array
        int[][] arr1 = new int[3][3];
        for(int row=0;row<arr1.length;row++){
            // for iteration of every row
            for(int col=0;col<arr1[row].length;col++){
                // for iteration of every column
                int num1 = in.nextInt();
                arr1[row][col] = num1;
            }
        }

        // To print output in an 2D array
//        for(int row=0;row< arr1.length;row++){
//            for(int col=0;col<arr1[row].length;col++){
//                System.out.print(arr1[row][col] + " ");
//            }
//            System.out.println();
//        }

        //Second Option
//        for(int row=0;row<arr1.length;row++){
//            System.out.println(Arrays.toString(arr1[row]));
//        }

        //Third Option
        for(int[] a:arr1){
            System.out.println(Arrays.toString(a));
        }
    }
}
