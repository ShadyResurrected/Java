package com.company.Codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Triple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Times = in.nextInt();
        while(Times-- > 0){
            int length = in.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length ; i++){
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            int count = 0;
            int ele = 0;
            for (int i = 0; i < arr.length-1 ; i++){
                if(arr[i] == arr[i+1]){
                    count++;
                }else
                    count = 0;
                if(count == 2){
                    ele = arr[i];
                    break;
                }
            }
            if(count == 2){
                System.out.println(ele);
            }else
                System.out.println(-1);
        }
    }
}
