package com.company.CodeChef;

import java.util.Scanner;

public class DIET {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            int N = in.nextInt();
            int K = in.nextInt();
            int rem = 0;
            int i = 0;
            int[] arr = new int[N];
            for(int j = 0; j < N; j++){
                arr[j] = in.nextInt();
            }
            for(int j = 0; j < N; j++){
                int A = arr[j];
                A += rem;
                rem = (A-K);
                if(rem >= 0){
                    i++;
                }else
                    break;
            }
            if(i == N){
                System.out.println("YES");
            }else{
                i++;
                System.out.println("NO" +" "+ i);
            }
        }
    }
}
