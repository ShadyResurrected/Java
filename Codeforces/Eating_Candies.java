package com.company.Codeforces;

import java.util.Scanner;

public class Eating_Candies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Times = in.nextInt();
        while(Times-- > 0){
            int length = in.nextInt();
            int[] arr = new int[length];
            for (int i = 0 ; i < arr.length ; i++){
                arr[i] = in.nextInt();
            }
            int start = 0;
            int end = arr.length - 1;
            int count = 0;
            int WeightAlice = 0;
            int WeightBob = 0;
            while(start < end){
                WeightAlice += arr[start];
                count++;

                WeightBob += arr[end];
                count++;
                if(WeightAlice == WeightBob){
                    System.out.println(count);
                    break;
                }
                start++;
                end--;
            }
            if(WeightAlice != WeightBob){
                System.out.println(0);
            }
        }
    }
}
