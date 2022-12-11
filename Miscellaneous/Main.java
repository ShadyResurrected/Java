package com.company.Miscellaneous;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int Eng,Mat,Phy,Soc,Che;
        Scanner sc=new Scanner(System.in);
        Eng=sc.nextInt();
        Mat=sc.nextInt();
        Phy=sc.nextInt();
        Soc=sc.nextInt();
        Che=sc.nextInt();
        int Total;
        Total = Eng+Mat+Phy+Soc+Che;
        float Per=(float)Total/500*100;
        System.out.print("Percentage is");
        System.out.println(Per);

    }
}
