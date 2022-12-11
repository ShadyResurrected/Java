package com.company.Miscellaneous;
import java.util.Locale;
import java.util.Scanner;
public class Practice_Problems3 {
    public static void main(String[] args) {
        //System.out.println("Enter the name:");
        //Scanner sc=new Scanner(System.in);
        //String a=sc.nextLine();     //To read whole sentence
        //String result=a.toLowerCase(Locale.ROOT);
        //System.out.println("The name in lower case is " + result);

                          //Replace spaces with underscore
        //String name="         Chandradeep";
        //String result=name.replace(" ","_");
        //System.out.println(result);

                            //Replace <!name!> with actual name
        //Scanner sc=new Scanner(System.in);
        //System.out.println("Enter the name:");
        //String a=sc.nextLine();
        //String letter="letter =\"Dear <!name!>, Thanks a lot\"";
        //System.out.println(letter);
        //String result =letter.replace("<!name!>",a);     1st option to do it
        //System.out.println(result);
        //System.out.println("letter=\"Dear "+a+",Thanks a lot\"");       2nd option to do it

                              //Program to detect double and triple spaces
        //String letter = "  Chandra   Chandardeep";
        //System.out.println(letter.indexOf("  "));
        //System.out.println(letter.indexOf("   "));

        String letter = "Dear \n\tMr.Mathers is killing this shit villanous wit scandals.\nSyllables rip the planet. ";
        System.out.println(letter);
    }
}
