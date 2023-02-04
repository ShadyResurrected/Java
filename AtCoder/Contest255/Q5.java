package com.company.AtCoder.Contest255;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NoChoc = in.nextInt();
        int NoBoxes = in.nextInt();

        int[] ChocLength = new int[NoChoc];
        int[] ChocWidth = new int[NoChoc];
        for (int i = 0; i < NoChoc; i++) {
            ChocLength[i] = in.nextInt();
        }
        for (int i = 0; i < NoChoc; i++) {
            ChocWidth[i] = in.nextInt();
        }

        int[] ChocArea = new int[NoChoc];
        for (int i = 0; i < NoChoc; i++) {
            ChocArea[i] = ChocLength[i] * ChocWidth[i];
        }

        int[] BoxLength = new int[NoBoxes];
        int[] BoxWidth = new int[NoBoxes];
        for (int i = 0; i < NoChoc; i++) {
            BoxLength[i] = in.nextInt();
        }
        for (int i = 0; i < NoChoc; i++) {
            BoxWidth[i] = in.nextInt();
        }
        int[] BoxArea = new int[NoChoc];
        for (int i = 0; i < NoChoc; i++) {
            BoxArea[i] = BoxLength[i] * BoxWidth[i];
        }

        int count = 0;
        for(int i = 0; i < BoxArea.length ; i++){
            for(int j = 0; j < ChocArea.length; j++){
                if(BoxArea[i] >= ChocArea[j]){
                    if(ChocLength[j] <= BoxLength[i] && ChocWidth[j] <= BoxWidth[i]){
                        count++;
                        ChocArea[j] = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
        }
        if(count == NoChoc){
            System.out.println("Yes");
        }else
            System.out.println("No");
    }
}
