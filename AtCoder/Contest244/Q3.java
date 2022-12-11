package com.company.AtCoder.Contest244;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 2*N+1; i++){
            list.add(i);
        }
        Random rand = new Random();
        int Takahashi  = list.get(0);
        System.out.println(Takahashi);
        list.remove((Integer) Takahashi);
        while(list.size() != 0){
            int Aoki = in.nextInt();
            list.remove((Integer) Aoki);
            Takahashi  = list.get(rand.nextInt(list.size()));
            System.out.println(Takahashi);
            list.remove((Integer) Takahashi);
        }
    }
}
