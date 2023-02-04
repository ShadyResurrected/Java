package com.company.Miscellaneous;
import java.util.Random;
import java.util.Scanner;
public class Rock_Paper_scissor {
    public static void main(String[] args) {

        while (true) {
            System.out.println("0 is stone , 1 is paper , 2 is scissor ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your number: ");
            int user = sc.nextInt();
            Random r = new Random();
            int i = r.nextInt(3);
            if(i==0){
                System.out.println("Your opponent has given a stone\n");
            }
            else if(i==1){
                System.out.println("Your opponent has given a paper\n");
            }
            else if(i==2){
                System.out.println("Your opponent has given a scissor\n");
            }
            switch (user) {
                case 0:
                    if (0 == i) {
                        System.out.println("Draw");
                    }
                    else if (1==i) {
                        System.out.println("User lost");
                    }
                    else if(i==2){
                        System.out.println("User wins");
                    }
                    break;
                case 1:
                    if(i==1){
                        System.out.println("Draw");
                    }
                    else if(i==0){
                        System.out.println("User wins");
                    }
                    else if(i==2){
                        System.out.println("User lost");
                    }
                    break;
                case 2:
                    if(i==2){
                        System.out.println("Draw");
                    }
                    else if(i==0){
                        System.out.println("User lost");
                    }
                    else if(i==1){
                        System.out.println("User wins");
                    }
                    break;
                default:
                    System.out.println("Enter a valid entry");

            }

        }
    }

}
