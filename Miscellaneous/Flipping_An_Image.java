package com.company.Miscellaneous;

import java.util.Arrays;

public class Flipping_An_Image {
    public static void main(String[] args) {
        int[][] image = {{1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };
//        flip the image horizontally, then invert it,
//        flip(arr);
//        for (int row = 0; row < arr.length; row++){
//            for (int col = 0; col < arr[row].length; col++){
////                image flipped horizontally
//                System.out.print(arr[row][col]);
//            }
//            System.out.println("");
//        }


    }
    static int[][] flip(int[][] image){
        for (int row = 0; row < image.length; row++){
            swap(image[row],0,image[row].length-1);
            for (int col = 0; col < image[row].length; col++){
//                image flipped horizontally
                if(image[row][col] == 0){
                    image[row][col] = 1;
                }else
                    image[row][col] = 0;
            }
        }
        return image;
    }
    static void swap(int[] arr,int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
