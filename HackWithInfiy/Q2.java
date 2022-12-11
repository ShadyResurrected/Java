package com.company.HackWithInfiy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int input = in.nextInt();
            list.add(input);
        }
        System.out.println(GoodSeq(N,list));

    }
    static int sum = 0;
    static int GoodSeq(int N, List<Integer> list){
        int count = N;
        for (int j = 0; j < N-1; j++) {
            sum += list.get(j);

            if(sum < 0){
                sum -= list.get(j);
                count--;
            }
        }
        return count;
    }
}
