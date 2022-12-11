package com.company.CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class SWAPCW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            int N = in.nextInt();
            in.nextLine();
            String S = in.nextLine();
            char[] ch = S.toCharArray();
            for (int i = 0; i < ch.length/2 ; i++){
                if(ch[i] > ch[ch.length - 1 - i]){
                    swap(ch,i,ch.length - 1 - i);
                }
            }
            System.out.println(Arrays.toString(ch));
            int count = 0;
            for(int i = 0; i < ch.length-1;i++){
                if(ch[i] > ch[i+1]){
                    System.out.println("NO");
                    break;
                }else
                    count++;
            }
            if(count == ch.length-1){
                System.out.println("YES");
            }
        }
    }
    static void swap(char[] ch,int start,int end){
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
    }
}
