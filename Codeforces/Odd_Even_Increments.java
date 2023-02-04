package com.company.Codeforces;

import java.util.Scanner;

public class Odd_Even_Increments {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Times = in.nextInt();
        while(Times-- > 0){
            int length = in.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length ; i++){
                arr[i] = in.nextInt();
            }
            int even = 0;
            int odd = 0;
            if(arr[0] % 2 == 0){
                for (int i = 0; i < arr.length ; i += 2){
                    if(arr[i]%2 == 0){
                        even++;
                    }
                }
            }else{
                for (int i = 0; i < arr.length ; i += 2){
                    if(arr[i]%2 != 0){
                        odd++;
                    }
                }
            }
            if(arr[1] % 2 == 0){
                for (int i = 1; i < arr.length ; i += 2){
                    if(arr[i]%2 == 0){
                        even++;
                    }
                }
            }else{
                for (int i = 1; i < arr.length ; i += 2){
                    if(arr[i]%2 != 0){
                        odd++;
                    }
                }
            }

            int sum = odd + even;
            if(sum == arr.length){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }
}
