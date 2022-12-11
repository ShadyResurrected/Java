package com.company.Miscellaneous;
import java.util.Scanner;
public class Practice_Problems4 {
    public static void main(String[] args) {
       // int a=10;
        //if(a=11)  //Boolean expression is only used in if statement,Assignment operator cannot be used
          //  System.out.println("a");
        //else
           // System.out.println("b");

        /*int Eng,Mat,Phy;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter marks for English: ");
        Eng=sc.nextInt();
        System.out.print("Enter marks for Maths: ");
        Mat=sc.nextInt();
        System.out.print("Enter marks for Physics: ");
        Phy=sc.nextInt();
        int Total=Eng+Mat+Phy;
        float Per=(float) Total/300*100;
        System.out.println(Total);
        System.out.println(Per);
        if(Per>=40){
                if (Eng >= 33) {
                } else {
                    System.out.println("You are not passed in every subject");
                    return;
                }
                if (Mat >= 33) {
                } else {
                    System.out.println("You are not passed in every subject");
                    return;
                }
                if (Phy >= 33) {
                } else {
                    System.out.println("You are not passed in every subject");
                    return;
                }

            System.out.println("You are promoted to next class");
        }

        else{
            System.out.println("You are fail");
        }

        */

        /*int Eng,Mat,Phy;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter marks for English: ");
        Eng=sc.nextInt();
        System.out.print("Enter marks for Maths: ");
        Mat=sc.nextInt();
        System.out.print("Enter marks for Physics: ");
        Phy=sc.nextInt();
        int Total=Eng+Mat+Phy;
        float Per=(float) Total/300*100;
        System.out.println(Total);
        System.out.println(Per);
        if(Per>=40 && Eng>=33 && Mat>=33 && Phy>=33){
            System.out.println("You are promoted to the next class");
        }
        else{
            System.out.println("You are fail");
        }

         */


        /*
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter income(in Lac): ");
        float income = sc.nextFloat();
        float tax=0;
        if(income<2.5){
            System.out.println("You do not have to pay tax");
            tax=tax+0;
        }
        else if(income>=2.5 && income<5.0){
            System.out.println("You have to pay 5% tax");
            tax=tax+0.05f*(income-2.5f);
            System.out.println(tax);
        }
        else if(income>=5.0 && income<10.0){
            System.out.println("You have to pay 20% tax");
            tax=tax+0.05f*(5.0f-2.5f);
            tax=tax+0.2f*(income-5.0f);
            System.out.println(tax);
        }
        else if(income>=10.0){
            System.out.println("You have to pay 30% tax");
            tax=tax+0.05f*(5.0f-2.5f);
            tax=tax+0.2f*(10.0f-5.0f);
            tax=tax+0.3f*(income-10.0f);
            System.out.println(tax);
        }
        */


        /*
        Scanner sc=new Scanner(System.in);
        int day =sc.nextInt();
        switch (day) {
            case 1 -> System.out.println("The day is Monday");
            case 2 -> System.out.println("The day is Tuesday");
            case 3 -> System.out.println("The day is Wednesday");
            case 4 -> System.out.println("The day is Thursday");
            case 5 -> System.out.println("The day is Friday");
            case 6 -> System.out.println("The day is Saturday");
            case 7 -> System.out.println("The day is Sunday");
            default -> System.out.println("Please enter a valid value");
        }

         */
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the year");
        int year=sc.nextInt();
        if(year%4==0 && year%100!=0 || year%400==0){
            System.out.println("Year is leap year");
        }
        else{
            System.out.println("Year is not leap year");
        }
    }

}
