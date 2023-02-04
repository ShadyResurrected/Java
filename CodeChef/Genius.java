package com.company.CodeChef;

import java.util.Scanner;

public class Genius {
    public static void main(String[] args) {
        // your code goes here
        Scanner in = new Scanner(System.in);
        int T = 1;
        for(int i = 0; i < T; i++){
            int N = 5;
            int X = 0;
            int max_marks = N * 3;
            if(X == max_marks){
                System.out.println("YES");
                System.out.println(N + " " + 0 + " " + 0);
            }else if(X == 0){
                System.out.println("YES");
                System.out.println(0 + " " + 0 + " " + N);
            }else
                isNumber(N,X);
        }
    }

    static void isNumber(int N, int X){
        int count = 0;
        int timesPlus = 0;
        int timesMinus = 0;
        while((-1 * timesMinus) + (3 * timesPlus) != X){
            if(count > X){
                count -= 1;
                timesMinus += 1;
            }else{
                count += 3;
                timesPlus += 1;
            }
        }if((timesMinus + timesPlus) > N){
            System.out.println("No");
        }else if(N == (timesPlus + timesMinus)){
            System.out.println("Yes");
            System.out.println(timesPlus + " " + timesMinus + " " + (N - (timesMinus + timesPlus)));
        }

    }
}
