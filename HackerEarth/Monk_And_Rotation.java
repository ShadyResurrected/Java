package com.company.HackerEarth;

import java.util.Scanner;

public class Monk_And_Rotation {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            int length = in.nextInt();
            int rotations = in.nextInt();
            int[] arr = new int[length];
            for(int i = 0;i < length;i++){
                arr[i] = in.nextInt();
            }
            int place = rotations%length;
            for(int i = length-place;i < length;i++){
                System.out.print(arr[i] + " ");
            }
            for(int i = 0;i < length-place;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
