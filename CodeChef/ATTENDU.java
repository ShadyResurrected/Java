package com.company.CodeChef;

import java.util.Scanner;

public class ATTENDU {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            double N = in.nextDouble();
            in.nextLine();
            String B = in.nextLine();
            double count = 0;
            for(int i = 0; i < N; i++){
                if(B.charAt(i) == '1'){
                    count++;
                }
            }
            double have = (count/120) * 100;
            double rem = ((120 - N)/120) * 100;
            if(rem + have >= 75){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }
}
