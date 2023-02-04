package com.company.CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class JS {
    public static void main(String[] args) {
        // your code goes here
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            int SizeOfArray = in.nextInt();
            int[] arr = new int[SizeOfArray];
            for(int i = 0 ; i < SizeOfArray ; i++){
                int number = in.nextInt();
                arr[i] = number%2;
            }
            int count = 0;
            int Jump2 = 1;
            int parityFirst;
            if(arr[0]%2 == 0){
                parityFirst = 0;
            }else
                parityFirst = 1;
//            System.out.println(Arrays.toString(arr));
            int start = 0;
            int end = arr.length - 1;
            while(SizeOfArray > 0){
                while(start != end){
                    if(arr[end]%2 == parityFirst){
                        start = end;
                        count++;
                    }else
                        end--;
                }
                SizeOfArray--;
                end = arr.length - 1;
            }
            System.out.println(count);
        }
    }
}
