package com.company.CodeChef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Incomplete
public class L56GAME {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            int N = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                int num = in.nextInt();
                list.add(num);
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(i != j){
                        int num1 = list.get(i);
                        int num2 = list.get(j);
                        int sum = num1 + num2;
                        if((sum)%2 == 0){
                            list.remove((Integer) num1);
                            list.remove((Integer) num2);
                            list.add(sum);
                        }
                    }
                }
            }

            System.out.println(list.size());
        }
    }
}
