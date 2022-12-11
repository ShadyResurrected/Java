package com.company.AtCoder.Contest244;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        int x = 0;
        int y = 0;
        String current = "+x";
        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i) == 'R'){
                if(current.equals("+x")){
                    current = "-y";
                }else if(current.equals("-y")){
                    current = "-x";
                }else if(current.equals("-x")){
                    current = "+y";
                }else
                    current = "+x";
            }else{
                if(current.equals("+x")){
                    x++;
                }else if(current.equals("-y")){
                    y--;
                }else if(current.equals("-x")){
                    x--;
                }else
                    y++;
            }

        }
        System.out.println(x + " " + y);
    }
}
