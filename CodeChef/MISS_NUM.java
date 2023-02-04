package com.company.CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class MISS_NUM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Times1 = in.nextInt();
        while (Times1-- > 0) {
            int[] arr1 = new int[4];
            for (int i = 0; i < 4; i++) {
                arr1[i] = Math.abs(in.nextInt());
            }
            Arrays.sort(arr1);
            int divArr = arr1[0];
            int diffArr = arr1[1];
            int sumArr = arr1[2];
            int prodArr = arr1[3];

        }
    }
}