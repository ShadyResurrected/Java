package com.company.CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class SUBARRY {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            int length = in.nextInt();
            int[] arrY = new int[length];
            for (int i = 0;i < length;i++){
                arrY[i] = in.nextInt();
            }
            Arrays.sort(arrY);
            int min = arrY[0] * arrY[1];
            int max = arrY[arrY.length-1] * arrY[arrY.length-1];
            System.out.print(min + " " + max);
            System.out.println();
        }
    }
}
