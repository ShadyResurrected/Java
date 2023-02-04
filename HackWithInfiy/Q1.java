package com.company.HackWithInfiy;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        int M = in.nextInt();
        int[] L = new int[M];
        int[] R = new int[M];
        int[] V = new int[M];
        for (int i = 0; i < M; i++) {
            L[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            R[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            V[i] = in.nextInt();
        }
        int P = in.nextInt();

    }
}
